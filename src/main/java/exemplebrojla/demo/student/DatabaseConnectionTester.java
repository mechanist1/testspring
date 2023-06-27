package exemplebrojla.demo.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTester {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true";
        String username = "ilyess";
        String password = "Themechanist1";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
