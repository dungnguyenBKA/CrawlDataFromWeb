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
import java.util.List;

public class CrawlerHelper {
    interface OnDataResponseListener {
        void onResponse(Product product) throws IOException;
    }

    public void setListener(OnDataResponseListener listener) {
        this.listener = listener;
    }





    private OnDataResponseListener listener;
    private ArrayList<String> categoriesUrl = new ArrayList<>();


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
        service.getProduct(productId).enqueue(new Callback<>() {
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

    public void crawlProducts() throws IOException {
        for (String category : categoriesUrl) {
            ArrayList<String> urls = getALlProductIdFromAnCategory(category);
            loadAllProductDetailFromIds(urls);
        }
    }
}
