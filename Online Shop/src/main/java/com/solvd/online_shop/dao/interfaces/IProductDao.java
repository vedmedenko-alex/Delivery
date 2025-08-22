package com.solvd.online_shop.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.models.Product;

public interface IProductDao {
    void addProduct(Product product) throws SQLException;

    Product getProductById(int id) throws SQLException;

    List<Product> getAllProducts() throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct(int id) throws SQLException;
}
