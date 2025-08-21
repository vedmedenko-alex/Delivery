package com.solvd.online_shop.dao.interfaces;

import java.util.List;

import com.solvd.online_shop.models.Category;

public interface CategoryDao {
    void addCategory(Category category);

    Category getCategoryById(int id);

    List<Category> getAllCategories();

    void updateCategory(Category category);

    void deleteCategory(int id);
}
