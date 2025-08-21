package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.IOrderDao;
import com.solvd.online_shop.dao.impl.IProductDao;
import com.solvd.online_shop.models.Order;
import com.solvd.online_shop.models.Product;

public class OrderItemService {
    private final IOrderDao orderDao;
    private final IProductDao productDao;

    public OrderItemService() {
        this.orderDao = new IOrderDao();
        this.productDao = new IProductDao();
    }

    public void addOrderItem(Order order, Product product) throws SQLException {
        orderDao.addOrder(order);
        productDao.addProduct(product);
    }

    public List<Product> getProductsInOrder(int orderId) throws SQLException {
        return productDao.getAllProducts();
    }

}
