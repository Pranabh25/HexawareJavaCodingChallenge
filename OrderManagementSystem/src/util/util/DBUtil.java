package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/OrderManagementSystem";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "2024";

    public static Connection getDBConn() throws SQLException {
        Connection connection = null;
        try {
           
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            throw e;
        }
        return connection;
    }

	public static String getConnectionString() {
		// TODO Auto-generated method stub
		return null;
	}

}
