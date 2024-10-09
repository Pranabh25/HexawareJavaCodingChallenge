package dao;
import entity.*;
import exception.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class OrderProcessor implements IOrderManagementRepository
{
	private Map<Integer, user> userDatabase = new HashMap<>();
    private Map<Integer, List<product>> orderDatabase = new HashMap<>();
    private int userIdCounter = 1;
    private int orderIdCounter = 1; 

    @Override
    public void createOrder(user user, List<product> products) throws UserNotFoundException {
        
        if (!userDatabase.containsKey(user.getUserId())) {
           
            createUser(user);
        
        
        orderDatabase.put(orderIdCounter++, products);

        System.out.println("Order created for user: " + user.getUsername() + " with Order ID: " + (orderIdCounter - 1));
    }
    }
    @Override
    public void cancelOrder(int userId, int orderId) throws UserNotFoundException, OrderNotFoundException {
        if (!userDatabase.containsKey(userId)) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        if (!orderDatabase.containsKey(orderId)) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }

        orderDatabase.remove(orderId);
        System.out.println("Order ID " + orderId + " canceled for User ID: " + userId);
    }

    @Override
    public void createProduct(user user, product product) throws UserNotFoundException {
       
        if (!userDatabase.containsKey(user.getUserId()) || !user.getRole().equals("Admin")) {
            throw new UserNotFoundException("Admin user not found: " + user.getUsername());
        }

        System.out.println("Product created: " + product.getProductName());
    }

    @Override
    public void createUser(user user) {
        user.setUserId(userIdCounter++); 
        userDatabase.put(user.getUserId(), user); 
        System.out.println("User created: " + user.getUsername());
    }

    @Override
    public List<product> getAllProducts() {
        return new ArrayList<>(); 
    }

    @Override
    public List<product> getOrderByUser(user user) {
        return new ArrayList<>();
    }

}
