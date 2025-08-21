package com.solvd.online_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solvd.online_shop.connection.ConnectionPool;
import com.solvd.online_shop.dao.interfaces.OrderItemDao;
import com.solvd.online_shop.models.OrderItem;

public class IOrderItemDao implements OrderItemDao {

    // private static final String INSERT_ORDER_ITEM = "INSERT INTO OrderItems (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
    // private static final String GET_ORDER_ITEM_BY_ID = "SELECT * FROM OrderItems WHERE order_item_id = ?";
    // private static final String GET_ALL_ORDER_ITEMS = "SELECT * FROM OrderItems";
    // private static final String UPDATE_ORDER_ITEM = "UPDATE OrderItems SET order_id = ?, product_id = ?, quantity = ?, price = ? WHERE order_item_id = ?";
    // private static final String DELETE_ORDER_ITEM = "DELETE FROM OrderItems WHERE order_item_id = ?";
    private static final String DELETE_ORDER_ITEMS_BY_ORDER_ID = "DELETE FROM OrderItems WHERE order_id = ?";
    private static final String DELETE_ORDER_ITEMS_BY_PRODUCT_ID = "DELETE FROM OrderItems WHERE product_id = ?";

    // @Override
    // public void addOrderItem(OrderItem orderItem) throws SQLException {
    //     try (Connection conn = ConnectionPool.getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER_ITEM)) {
    //         stmt.setInt(1, orderItem.getOrderId());
    //         stmt.setInt(2, orderItem.getProductId());
    //         stmt.setInt(3, orderItem.getQuantity());
    //         stmt.setDouble(4, orderItem.getPrice());
    //         stmt.executeUpdate();
    //     }
    // }

    // @Override
    // public OrderItem getOrderItemById(int id) throws SQLException {
    //     OrderItem orderItem = null;
    //     try (Connection conn = ConnectionPool.getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(GET_ORDER_ITEM_BY_ID)) {
    //         stmt.setInt(1, id);
    //         ResultSet rs = stmt.executeQuery();
    //         if (rs.next()) {
    //             orderItem = new OrderItem(
    //                     rs.getInt("order_item_id"),
    //                     rs.getInt("order_id"),
    //                     rs.getInt("product_id"),
    //                     rs.getInt("quantity"),
    //                     rs.getDouble("price")
    //             );
    //         }
    //     }
    //     return orderItem;
    // }

    // @Override
    // public List<OrderItem> getAllOrderItems() throws SQLException {
    //     List<OrderItem> orderItems = new ArrayList<>();
    //     try (Connection conn = ConnectionPool.getConnection();
    //          Statement stmt = conn.createStatement();
    //          ResultSet rs = stmt.executeQuery(GET_ALL_ORDER_ITEMS)) {
    //         while (rs.next()) {
    //             orderItems.add(new OrderItem(
    //                     rs.getInt("order_item_id"),
    //                     rs.getInt("order_id"),
    //                     rs.getInt("product_id"),
    //                     rs.getInt("quantity"),
    //                     rs.getDouble("price")
    //             ));
    //         }
    //     }
    //     return orderItems;
    // }

    // @Override
    // public void updateOrderItem(OrderItem orderItem) throws SQLException {
    //     try (Connection conn = ConnectionPool.getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER_ITEM)) {
    //         stmt.setInt(1, orderItem.getOrderId());
    //         stmt.setInt(2, orderItem.getProductId());
    //         stmt.setInt(3, orderItem.getQuantity());
    //         stmt.setDouble(4, orderItem.getPrice());
    //         stmt.setInt(5, orderItem.getOrderItemId());
    //         stmt.executeUpdate();
    //     }
    // }

    // @Override
    // public void deleteOrderItem(int id) throws SQLException {
    //     try (Connection conn = ConnectionPool.getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEM)) {
    //         stmt.setInt(1, id);
    //         stmt.executeUpdate();
    //     }
    // }

    @Override
    public void deleteOrderItemsByOrderId(int orderId) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEMS_BY_ORDER_ID)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteOrderItemsByProductId(int productId) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEMS_BY_PRODUCT_ID)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }
}
