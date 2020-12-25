package db;

import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseHelper {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseHelper(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        try {
            PreparedStatement pre = connection.prepareStatement(insert_product_query);
            pre.setString(1, product.getId());
            pre.setString(2, product.getName());
            pre.setString(3, product.getUrl_key());
            pre.setString(4, product.getShort_description());
            pre.setString(5, product.getThumbnail_url());
            pre.setString(6, product.getProductset_group_name());
            pre.setString(7, product.getCategory().getId());
            pre.setInt(8, product.getQuantityProduct().getMin_sale_qty());
            pre.setInt(9, product.getQuantityProduct().getMax_sale_qty());
            pre.setInt(10, product.getQuantityProduct().getQty());
            pre.setInt(11, product.getPrice());
            pre.setInt(12, product.getList_price());
            pre.setInt(13, product.getDiscount_rate());
            pre.setInt(14, 0);
            pre.setInt(15, 0);
            pre.setString(16, product.getDescription());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String insert_product_query = "INSERT INTO `Tipee`.`Product` " +
            "(`id`," +
            "`name`," +
            "`url_key`," +
            "`short_description`," +
            "`thumbnail_url`," +
            "`productset_group_name`," +
            "`categories_id`," +
            "`min_qty`," +
            "`max_qty`," +
            "`quantity`," +
            "`price`," +
            "`list_price`," +
            "`discount_rate`," +
            "`rating_count`," +
            "`rating_total`," +
            "`description`)" +
            " VALUES " +
            "( ? ," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?," +
            " ?)";

    String insert_category_query = "INSERT INTO `Tipee`.`Category` " +
            "(`idCategory`," +
            "`name`)" +
            " VALUES " +
            "(?," +
            "?);";

    public void insertCategory(Product product) {
        try {
            PreparedStatement pre = connection.prepareStatement(insert_category_query);
            pre.setString(1, product.getCategory().getId());
            pre.setString(2, product.getCategory().getName());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String insert_seller_query = "INSERT INTO `Tipee`.`Seller`\n" +
            "(`store_id`,\n" +
            "`name`,\n" +
            "`logo`)\n" +
            "VALUES\n" +
            "(?,\n" +
            "?,\n" +
            "?);";


    public void insertSeller(Product product){
        try {
            PreparedStatement pre = connection.prepareStatement(insert_seller_query);
            pre.setString(1, product.getSeller().getStore_id());
            pre.setString(2, product.getSeller().getName());
            pre.setString(3, product.getSeller().getLogo());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String sell_info_query = "INSERT INTO `Tipee`.`sell`\n" +
            "(`product_id`,\n" +
            "`seller_id`)\n" +
            "VALUES\n" +
            "(?,\n" +
            "?);";


    public void insertSellInfo(Product product){
        try {
            PreparedStatement pre = connection.prepareStatement(sell_info_query);
            pre.setString(1, product.getId());
            pre.setString(2, product.getSeller().getStore_id());
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
