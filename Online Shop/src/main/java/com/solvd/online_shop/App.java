package com.solvd.online_shop;


import com.solvd.online_shop.models.*;
import com.solvd.online_shop.services.impl.*;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        UserService userService = new UserService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CategoryService categoryService = new CategoryService();
        ReviewService reviewService = new ReviewService();
        DiscountService discountService = new DiscountService();

        logger.info("---- Testing UserService ----");
        try {
            // Add a new user
            User user = new User(0, "Tony Stark", "tony.stark@starkindustries.com", "password123");
            userService.addUser(user);
            logger.info("Added User: " + user.getName());

            // Get user by ID
            User retrievedUser = userService.getUserById(1);
            logger.info("User Retrieved: " + retrievedUser);

            // Get all users
            List<User> users = userService.getAllUsers();
            logger.info("All Users: " + users);

            // Update user
            retrievedUser.setName("Tony Stark Updated");
            userService.updateUser(retrievedUser);
            logger.info("Updated User: " + retrievedUser.getName());

            // Delete user
            userService.deleteUser(1);
            logger.info("Deleted User with ID: 1");

        } catch (SQLException e) {
            logger.severe("Error in UserService: " + e.getMessage());
        }

        logger.info("---- Testing ProductService ----");
        try {
            // Add new product
            Product product = new Product(0, 1, "Superhero suit", "High-quality superhero suit", 1500.00, 50);
            productService.addProduct(product);
            logger.info("Added Product: " + product.getName());

            // Get product by ID
            Product retrievedProduct = productService.getProductById(1);
            logger.info("Product Retrieved: " + retrievedProduct);

            // Get all products
            List<Product> products = productService.getAllProducts();
            logger.info("All Products: " + products);

            // Update product
            retrievedProduct.setPrice(1450.00);
            productService.updateProduct(retrievedProduct);
            logger.info("Updated Product Price: " + retrievedProduct.getPrice());

            // // Delete product
            // productService.deleteProduct(1);
            // logger.info("Deleted Product with ID: 1");

        } catch (SQLException e) {
            logger.severe("Error in ProductService: " + e.getMessage());
        }

        logger.info("---- Testing OrderService ----");
        try {
            // Add new order
            Order order = new Order(0, 1, null, "Pending", 1500.00);
            orderService.addOrder(order);
            logger.info("Added Order: " + order.getOrderId());

            // Get order by ID
            Order retrievedOrder = orderService.getOrderById(1);
            logger.info("Order Retrieved: " + retrievedOrder);

            // Get all orders
            List<Order> orders = orderService.getAllOrders();
            logger.info("All Orders: " + orders);

            // Update order
            retrievedOrder.setStatus("Shipped");
            orderService.updateOrder(retrievedOrder);
            logger.info("Updated Order Status: " + retrievedOrder.getStatus());

            // // Delete order
            // orderService.deleteOrder(1);
            // logger.info("Deleted Order with ID: 1");

        } catch (SQLException e) {
            logger.severe("Error in OrderService: " + e.getMessage());
        }

        logger.info("---- Testing CategoryService ----");
        try {
            // Add new category
            Category category = new Category(0, "Suits", "Suits for superheroes");
            categoryService.addCategory(category);
            logger.info("Added Category: " + category.getName());

            // Get category by ID
            Category retrievedCategory = categoryService.getCategoryById(1);
            logger.info("Category Retrieved: " + retrievedCategory);

            // Get all categories
            List<Category> categories = categoryService.getAllCategories();
            logger.info("All Categories: " + categories);

            // Update category
            retrievedCategory.setDescription("Amazing Suits for superheroes");
            categoryService.updateCategory(retrievedCategory);
            logger.info("Updated Category: " + retrievedCategory.getDescription());

            // // Delete category
            // categoryService.deleteCategory(1);
            // logger.info("Deleted Category with ID: 1");

        } catch (SQLException e) {
            logger.severe("Error in CategoryService: " + e.getMessage());
        }

        logger.info("---- Testing ReviewService ----");
         try {
            // Add a new review
            Review review = new Review(0, 1, 1, 5, "Amazing suit, I feel like Iron Man!", null);
            reviewService.addReview(review);
            logger.info("Added Review: " + review.getComment());

            // Get review by ID
            Review retrievedReview = reviewService.getReviewById(1);

            // Check if the review was found
            if (retrievedReview != null) {
                logger.info("Review Retrieved: " + retrievedReview);

                // Update the review rating if found
                retrievedReview.setRating(4);
                reviewService.updateReview(retrievedReview);
                logger.info("Updated Review Rating: " + retrievedReview.getRating());
            } else {
                // When no review was found
                logger.warning("Review with ID 1 not found.");
            }

            // Delete the review
            reviewService.deleteReview(1);
            logger.info("Deleted Review with ID: 1");

        } catch (SQLException e) {
            // Log the exception if any error occurs
            logger.severe("Error in ReviewService: " + e.getMessage());
        }

        logger.info("---- Testing DiscountService ----");
        try {
            // Add new discount
            Discount discount = new Discount(0, 1, 10.0, java.sql.Date.valueOf("2023-01-01"), java.sql.Date.valueOf("2023-12-31"));
            discountService.addDiscount(discount);
            logger.info("Added Discount: " + discount.getPercentage() + "%");

            // Get all discounts
            List<Discount> discounts = discountService.getAllDiscounts();
            logger.info("All Discounts: " + discounts);

            // Delete discount
            discountService.deleteDiscount(1);
            logger.info("Deleted Discount with ID: 1");

        } catch (SQLException e) {
            logger.severe("Error in DiscountService: " + e.getMessage());
        }
    }
}



