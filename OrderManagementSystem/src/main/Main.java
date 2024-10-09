package main;

import entity.*;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static OrderProcessorImpl orderProcessor = new OrderProcessorImpl(); 
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) throws UserNotFoundException, OrderNotFoundException {
    	 Scanner scanner = new Scanner(System.in);
         user user = new user(1, "admin", "admin_password", "admin");
         String propertyFileName = "db.properties"; // Ensure this file exists with proper DB config
         String connectionString = DBUtil.getConnectionString();
        while (true) {
            displayMenu(); 
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createProduct();
                    break;
                case 3:
                    cancelOrder();
                    break;
                case 4:
                    getAllProducts();
                    break;
                case 5:
                    getOrderByUser();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close(); 
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  
    private static void displayMenu() {
        System.out.println("\n=== Order Management System ===");
        System.out.println("1. Create User");
        System.out.println("2. Create Product");
        System.out.println("3. Cancel Order");
        System.out.println("4. Get All Products");
        System.out.println("5. Get Orders by User");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

   
    private static void createUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role (Admin/User): ");
        String role = scanner.nextLine();

        user user = new user(userId, username, password, role);
        orderProcessor.createUser(user); 
    }

   
    private static void createProduct() throws UserNotFoundException {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity in Stock: ");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Product Type (Electronics/Clothing): ");
        String type = scanner.nextLine();

        product product = new product(productId, productName, description, price, quantityInStock, type);
        
        user adminUser = new user(1, "admin", "adminPass", "Admin");
        orderProcessor.createProduct(adminUser, product); 
    }

    // Method to cancel an order
    private static void cancelOrder() throws UserNotFoundException, OrderNotFoundException {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        orderProcessor.cancelOrder(userId, orderId); 
    }


    private static void getAllProducts() {
        List<product> products = orderProcessor.getAllProducts(); 
        System.out.println("All Products:");
        for (product product : products) {
            System.out.println(product.getProductName() + " - Price: " + product.getPrice());
        }
    }

   
    private static void getOrderByUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        user user = new user(userId, "username", "password", "User"); 
        List<product> userOrders = orderProcessor.getOrderByUser(user); 

        System.out.println("Orders for User ID " + userId + ":");
        for (product product : userOrders) {
            System.out.println(product.getProductName() + " - Price: " + product.getPrice());
        }
    }
}
