package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.IOrderDao;
import com.solvd.online_shop.dao.impl.IProductDao;
import com.solvd.online_shop.models.Order;
import com.solvd.online_shop.models.Product;

public class OrderService {
    private final IOrderDao orderDao;
    private final IProductDao productDao;

    public OrderService() {
        this.orderDao = new IOrderDao();
        this.productDao = new IProductDao();
    }

    public void addOrder(Order order) throws SQLException {
        orderDao.addOrder(order);
    }

    public Order getOrderById(int id) throws SQLException {
        return orderDao.getOrderById(id);
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderDao.getAllOrders();
    }

    public List<Product> getProductsForOrder(int orderId) throws SQLException {

        return productDao.getAllProducts();
    }

    public void updateOrder(Order order) throws SQLException {
        orderDao.updateOrder(order);
    }

    public void deleteOrder(int id) throws SQLException {
        orderDao.deleteOrder(id);
    }
}
