package MyFrames;

import java.sql.*;

public class DBConnection { 
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/libms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "KxE13#lYM9";
    private static Connection connection;

    public static Connection openConnection() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.");
        }
    }
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            
            throw new RuntimeException("Error closing the database connection.");
        }
    }

    
}