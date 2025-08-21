package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.ICartItemDao;
import com.solvd.online_shop.dao.impl.IDiscountDao;
import com.solvd.online_shop.dao.impl.IOrderItemDao;
import com.solvd.online_shop.dao.impl.IProductDao;
import com.solvd.online_shop.dao.interfaces.CartItemDao;
import com.solvd.online_shop.dao.interfaces.DiscountDao;
import com.solvd.online_shop.dao.interfaces.ProductDao;
import com.solvd.online_shop.models.Product;

public class ProductService {
    private final IProductDao productDao;
    private final IOrderItemDao orderItemDao;
    private final ICartItemDao cartItemDao;
    private final IDiscountDao discountDao;

    public ProductService() {
        this.productDao = new IProductDao();
        this.orderItemDao = new IOrderItemDao();
        this.cartItemDao = new ICartItemDao();
        this.discountDao = new IDiscountDao();
    }

    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    public Product getProductById(int id) throws SQLException {
        return productDao.getProductById(id);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDao.getAllProducts();
    }

    public void updateProduct(Product product) throws SQLException {
        productDao.updateProduct(product);
    }

    public void deleteProduct(int id) throws SQLException {
        orderItemDao.deleteOrderItemsByProductId(id);
        cartItemDao.deleteCartItemsByProductId(id);
        discountDao.deleteDiscountsByProductId(id);
        productDao.deleteProduct(id);
    }
}
