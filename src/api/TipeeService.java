package api;

import model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TipeeService {
    @GET("products/{productId}")
    Call<Product> getProduct(@Path("productId") String id);
}
