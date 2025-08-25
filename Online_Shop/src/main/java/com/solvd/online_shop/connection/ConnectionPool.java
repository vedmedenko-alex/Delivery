package com.solvd.online_shop.connection;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static int POOL_SIZE;

    private static final List<Connection> pool = new ArrayList<>();
    private static ConnectionPool instance;

    static {
        Properties p = new Properties();
        try (InputStream in = ConnectionPool.class
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (in == null) {
                throw new IllegalStateException("database.properties not found");
            }
            p.load(in);

            URL = p.getProperty("db.url");
            USER = p.getProperty("db.user");
            PASSWORD = p.getProperty("db.password");
            POOL_SIZE = Integer.parseInt(p.getProperty("db.pool.size", "5"));

            for (int i = 0; i < POOL_SIZE; i++) {
                pool.add(createProxyConnection(DriverManager.getConnection(URL, USER, PASSWORD)));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error initializing connection pool", e);
        }
    }

    private ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (pool.isEmpty()) {
            return createProxyConnection(DriverManager.getConnection(URL, USER, PASSWORD));
        }
        return pool.remove(pool.size() - 1);
    }

    private static Connection createProxyConnection(Connection realConn) {
        return (Connection) Proxy.newProxyInstance(
                ConnectionPool.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("close")) {
                        releaseConnection(realConn);
                        return null;
                    }
                    return method.invoke(realConn, args);
                });
    }

    public static synchronized void releaseConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                pool.add(c);
            }
        } catch (SQLException ignored) {
        }
    }

    public static synchronized void shutdown() {
        for (Connection c : pool) {
            try {
                if (c != null && !c.isClosed()) {
                    c.close();
                }
            } catch (SQLException ignored) {
            }
        }
        pool.clear();
    }
}
