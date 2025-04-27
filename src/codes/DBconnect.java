
package codes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBconnect {

    public static Connection connect() {
        Connection conn = null;
        
        try {
            // Load MySQL JDBC Driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Attempt to connect to the MySQL database on port 3307 with the database name "Project123"
             conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/Project123", "root", "");

            // Check if the connection was successful
            if (conn != null) {
                System.out.println("Connection Successful!");
            }
            
        } catch (Exception e) {
            // Show error message if connection fails
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace(); // Print detailed stack trace for debugging
        }
        
        return conn;
    }
    
}