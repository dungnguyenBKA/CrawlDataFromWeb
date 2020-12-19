package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private RetrofitHelper(){

    }
    private static final String BASE_API = "https://tiki.vn/api/v2/";
    public static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
