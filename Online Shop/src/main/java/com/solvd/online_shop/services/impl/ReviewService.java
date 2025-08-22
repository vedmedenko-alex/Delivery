package com.solvd.online_shop.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.solvd.online_shop.dao.impl.ReviewDao;
import com.solvd.online_shop.models.Review;

public class ReviewService {
    private ReviewDao reviewDao;

    public ReviewService() {
        reviewDao = new ReviewDao();
    }

    public void addReview(Review review) throws SQLException {
        reviewDao.addReview(review);
    }

    public Review getReviewById(int id) throws SQLException {
        return reviewDao.getReviewById(id);
    }

    public List<Review> getReviewsForProduct(int productId) throws SQLException {
        return reviewDao.getAllReviews();
    }

    public void updateReview(Review review) throws SQLException {
        reviewDao.updateReview(review);
    }

    public void deleteReview(int id) throws SQLException {
        reviewDao.deleteReview(id);
    }
}
