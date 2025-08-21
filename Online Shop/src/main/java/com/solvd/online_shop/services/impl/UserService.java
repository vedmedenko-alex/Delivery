package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.ICartItemDao;
import com.solvd.online_shop.dao.impl.IOrderDao;
import com.solvd.online_shop.dao.impl.IReviewDao;
import com.solvd.online_shop.dao.impl.IUserDao;
import com.solvd.online_shop.dao.interfaces.OrderDao;
import com.solvd.online_shop.dao.interfaces.ReviewDao;
import com.solvd.online_shop.dao.interfaces.UserDao;
import com.solvd.online_shop.models.User;

public class UserService {
    private final IUserDao userDao;
    private final IOrderDao orderDao;
    private final ICartItemDao cartItemDao;
    private final IReviewDao reviewDao;

    public UserService() {
        this.userDao = new IUserDao();
        this.orderDao = new IOrderDao();
        this.cartItemDao = new ICartItemDao();
        this.reviewDao = new IReviewDao();
    }

    public void addUser(User user) throws SQLException {
        if (userDao.getUserByEmail(user.getEmail()) != null) {
            throw new SQLException("User with email " + user.getEmail() + " already exists.");
        }
        userDao.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        orderDao.deleteOrdersByUserId(id);
        cartItemDao.deleteCartItemsByUserId(id);
        reviewDao.deleteReviewsByUserId(id);
        userDao.deleteUser(id);
    }
}
