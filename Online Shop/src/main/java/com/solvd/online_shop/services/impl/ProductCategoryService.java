package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.ICategoryDao;
import com.solvd.online_shop.dao.impl.IProductDao;
import com.solvd.online_shop.models.Category;
import com.solvd.online_shop.models.Product;

public class ProductCategoryService {
    private final IProductDao productDao;
    private final ICategoryDao categoryDao;

    public ProductCategoryService() {
        this.productDao = new IProductDao();
        this.categoryDao = new ICategoryDao();
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
