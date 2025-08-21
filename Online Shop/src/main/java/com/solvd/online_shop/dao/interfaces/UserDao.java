package com.solvd.online_shop.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.models.User;

public interface UserDao {
    void addUser(User user) throws SQLException;

    User getUserByEmail(String email) throws SQLException;

    User getUserById(int id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;
}
