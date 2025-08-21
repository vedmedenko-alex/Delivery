package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.IDiscountDao;
import com.solvd.online_shop.models.Discount;

public class DiscountService {
    private final IDiscountDao discountDao;

    public DiscountService() {
        this.discountDao = new IDiscountDao();
    }

    public void addDiscount(Discount discount) throws SQLException {
        discountDao.addDiscount(discount);
    }

    public List<Discount> getAllDiscounts() throws SQLException {
        return discountDao.getAllDiscounts();
    }

    public void updateDiscount(Discount discount) throws SQLException {
        discountDao.updateDiscount(discount);
    }

    public void deleteDiscount(int id) throws SQLException {
        discountDao.deleteDiscount(id);
    }
}
