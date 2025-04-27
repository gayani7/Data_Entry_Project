import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/your_database";
        String user = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}