package dao;
import entity.*;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;

import java.util.List;

public interface IOrderManagementRepository {

	    boolean isAdmin(int userId);

	    void createOrder(user user, List<product> products) throws UserNotFoundException;

	    void cancelOrder(int userId, int orderId) throws UserNotFoundException, OrderNotFoundException;

	    void createProduct(user user, product product) throws UserNotFoundException;

	    void createUser(user user);

	    List<product> getAllProducts();

	    List<product> getOrderByUser(user user);
}
