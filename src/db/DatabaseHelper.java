package db;

import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private String url;
    private String username;
    private String password;

    public DatabaseHelper(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void testConnection(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Java JDBC PostgreSQL Example");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(""));
            }

        } catch (Exception e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product){

    }
}
