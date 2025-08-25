package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.CategoryDao;
import com.solvd.online_shop.dao.impl.ProductDao;
import com.solvd.online_shop.models.Category;
import com.solvd.online_shop.models.Product;

public class ProductCategoryService {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    public ProductCategoryService() {
        this.productDao = new ProductDao();
        this.categoryDao = new CategoryDao();
    }

    public void addProductToCategory(Product product, Category category) throws SQLException {
        categoryDao.addCategory(category);
        product.setCategoryId(category.getCategoryId());
        productDao.addProduct(product);
    }

    public List<Product> getProductsByCategory(int categoryId) throws SQLException {
        return productDao.getAllProducts();
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDao.getAllCategories();
    }
}
