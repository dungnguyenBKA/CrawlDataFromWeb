import db.DatabaseHelper;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Tipee";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";
    public static void main(String[] args) throws Exception {
//        ArrayList<String> listCategoriesUrl = new ArrayList<>();
//        listCategoriesUrl.add("https://tiki.vn/dien-thoai-may-tinh-bang");
//        listCategoriesUrl.add("https://tiki.vn/thiet-bi-kts-phu-kien-so/");
//        BufferedWriter writer = new BufferedWriter(new FileWriter("listProductId.txt"));
//        ArrayList<String> ids = new ArrayList<>();
//
//        CrawlerHelper crawlerHelper = new CrawlerHelper(listCategoriesUrl, new CrawlerHelper.OnDataResponseListener() {
//            @Override
//            public void onResponse(Product product) {
//                try{
//                    writer.append(product.getId()).append("\n");
//                    System.out.println(product.getId());
//                    if(Integer.parseInt(product.getId()) > 8000000){
//                        writer.close();
//                    }
//                } catch (Exception e){
//
//                }
//            }
//        });
//
//        for (int i = 0; i < 10000000; i++) {
//            crawlerHelper.loadAllProductDetailFromAnId(String.valueOf(i));
//        }
        DatabaseHelper db = new DatabaseHelper(DB_URL, DB_USERNAME, DB_PASSWORD);
        db.testConnection();
    }
}
