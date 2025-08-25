package com.solvd.online_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.solvd.online_shop.connection.ConnectionPool;
import com.solvd.online_shop.dao.interfaces.IOrderItemDao;

public class OrderItemDao implements IOrderItemDao {

    private static final String DELETE_ORDER_ITEMS_BY_ORDER_ID = "DELETE FROM OrderItems WHERE order_id = ?";
    private static final String DELETE_ORDER_ITEMS_BY_PRODUCT_ID = "DELETE FROM OrderItems WHERE product_id = ?";

    @Override
    public void deleteOrderItemsByOrderId(int orderId) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEMS_BY_ORDER_ID)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteOrderItemsByProductId(int productId) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEMS_BY_PRODUCT_ID)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }
}
