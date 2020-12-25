import db.DatabaseHelper;
import model.Seller;

import java.util.ArrayList;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tipee";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";
    public static void main(String[] args) throws Exception {
        DatabaseHelper db = new DatabaseHelper(DB_URL, DB_USERNAME, DB_PASSWORD);
        ArrayList<Seller> sellers = new ArrayList<>();
        CrawlerHelper crawlerHelper = new CrawlerHelper();

        crawlerHelper.setListener(product ->{
            db.insertProduct(product);
        });
    }
}
