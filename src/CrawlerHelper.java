import api.RetrofitHelper;
import api.TipeeService;
import model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlerHelper {
    interface OnDataResponseListener {
        void onResponse(Product product) throws IOException;
    }

    private OnDataResponseListener listener;
    private ArrayList<String> categoriesUrl = new ArrayList<>();

    public CrawlerHelper(ArrayList<String> categoriesUrl, OnDataResponseListener listener) {
        this.categoriesUrl = categoriesUrl;
        this.listener = listener;
    }

    private ArrayList<String> getALlProductIdFromAnCategory(String url) throws IOException {
        ArrayList<String> listId = new ArrayList<>();
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByTag("a");
        elements.forEach(element -> {
            if (element.hasAttr("data-id")) {
                listId.add(element.attr("data-id"));
            }
        });
        return listId;
    }

    public void loadAllProductDetailFromIds(ArrayList<String> listId) throws IOException {
        for (String productId : listId) {
            loadAllProductDetailFromAnId(productId);
        }
    }

    public void loadAllProductDetailFromAnId(String productId) {
        TipeeService service = RetrofitHelper.getInstance().create(TipeeService.class);
        service.getProduct(productId).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.body() != null) {
                    try {
                        listener.onResponse(response.body());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable throwable) {

            }
        });
    }

    public ArrayList<Product> crawlProducts() throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        for (String category : categoriesUrl) {
            ArrayList<String> urls = getALlProductIdFromAnCategory(category);
            loadAllProductDetailFromIds(urls);
        }
        return products;
    }
}
