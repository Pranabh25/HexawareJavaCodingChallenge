package dao;

import entity.product;
import entity.user;

import java.util.ArrayList;
import java.util.List;

public abstract class OderProcessorImpl implements IOrderManagementRepository {
    // This list will temporarily hold the products. In a real application, you'd use a database.
    private List<product> products = new ArrayList<>();
    private List<user> users = new ArrayList<>(); // Assuming you want to manage users too

    @Override
    public void createOrder(user user, List<product> products) {
        // Implementation logic to create an order for the user
        System.out.println("Order created for user: " + user.getUsername());
    }

    @Override
    public void cancelOrder(int userId, int orderId) {
        // Implementation logic to cancel an order for the user
        System.out.println("Order with ID " + orderId + " canceled for user ID " + userId);
    }

    @Override
    public void createProduct(user user, product product) {
        // Check if user is admin (for example)
        if ("Admin".equalsIgnoreCase(user.getRole())) {
            products.add(product); // Add the product to the list
            System.out.println("Product added: " + product.getProductName());
        } else {
            System.out.println("Only admins can create products.");
        }
    }

    @Override
    public void createUser(user user) {
        // Implementation logic to create a user
        users.add(user); // Add the user to the list
        System.out.println("User created: " + user.getUsername());
    }

    @Override
    public List<product> getAllProducts() {
        // Return the list of products
        return products;
    }

    @Override
    public List<product> getOrderByUser(user user) {
        // Placeholder implementation
        return new ArrayList<>(); // Return an empty list for now
    }
}
