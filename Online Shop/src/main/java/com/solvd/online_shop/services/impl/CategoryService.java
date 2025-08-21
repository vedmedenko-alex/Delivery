package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.ICategoryDao;
import com.solvd.online_shop.dao.impl.IProductDao;
import com.solvd.online_shop.models.Category;
import com.solvd.online_shop.models.Product;

public class CategoryService {
    private final ICategoryDao categoryDao;
    private final IProductDao productDao;

    public CategoryService() {
        this.categoryDao = new ICategoryDao();
        this.productDao = new IProductDao();
    }

    public void addCategory(Category category) throws SQLException {
        categoryDao.addCategory(category);
    }

    public Category getCategoryById(int id) throws SQLException {
        return categoryDao.getCategoryById(id);
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDao.getAllCategories();
    }

    public List<Product> getProductsByCategory(int categoryId) throws SQLException {

        return productDao.getAllProducts();
    }

    public void updateCategory(Category category) throws SQLException {
        categoryDao.updateCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
        categoryDao.deleteCategory(id);
    }
}
