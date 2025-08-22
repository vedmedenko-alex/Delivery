package com.solvd.online_shop.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.solvd.online_shop.connection.ConnectionPool;
import com.solvd.online_shop.models.Category;

public class CategoryDao {
    private static final String INSERT_CATEGORY = "INSERT INTO Categories (name, description) VALUES (?, ?)";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM Categories WHERE category_id = ?";
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM Categories";
    private static final String UPDATE_CATEGORY = "UPDATE Categories SET name = ?, description = ? WHERE category_id = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM Categories WHERE category_id = ?";

    public void addCategory(Category category) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT_CATEGORY)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.executeUpdate();
        }
    }

    public Category getCategoryById(int id) throws SQLException {
        Category category = null;
        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(GET_CATEGORY_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description"));
            }
        }
        return category;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(GET_ALL_CATEGORIES)) {
            while (rs.next()) {
                categories
                        .add(new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description")));
            }
        }
        return categories;
    }

    public void updateCategory(Category category) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(UPDATE_CATEGORY)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getCategoryId());
            stmt.executeUpdate();
        }
    }

    public void deleteCategory(int id) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(DELETE_CATEGORY)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
