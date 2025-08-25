package com.solvd.online_shop.dao.interfaces;

import java.sql.SQLException;

public interface IOrderItemDao {
    // void addOrderItem(OrderItem orderItem) throws SQLException;
    // OrderItem getOrderItemById(int id) throws SQLException;
    // List<OrderItem> getAllOrderItems() throws SQLException; 
    // void updateOrderItem(OrderItem orderItem) throws SQLException; 
    // void deleteOrderItem(int id) throws SQLException;
    void deleteOrderItemsByOrderId(int orderId) throws SQLException; 
    void deleteOrderItemsByProductId(int productId) throws SQLException; 
}
