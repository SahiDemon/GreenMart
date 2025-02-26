package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void openConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?sslmode=require";
        String username = "postgres.tgeqywutejnsmawlarju";  // Full username from Supabase
        String password = "Sahiya@448866"; // Update password if it contains @

        Class.forName("org.postgresql.Driver");
        System.out.println("Database class logged");

        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connected");
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}
