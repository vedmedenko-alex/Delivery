package com.solvd.online_shop.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.models.Discount;

public interface IDiscountDao {
    void addDiscount(Discount discount) throws SQLException;

    Discount getDiscountById(int id) throws SQLException;

    List<Discount> getAllDiscounts() throws SQLException;

    void updateDiscount(Discount discount) throws SQLException;

    void deleteDiscount(int id) throws SQLException;

    void deleteDiscountsByProductId(int productId) throws SQLException;
}
