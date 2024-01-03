package wow.startup.ci.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RectrofilClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private  static Retrofit retrofit;

    public RectrofilClient() {
    }

    public static Retrofit getInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
