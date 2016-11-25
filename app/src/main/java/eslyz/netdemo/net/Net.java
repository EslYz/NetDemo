package eslyz.netdemo.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eslyz on 2016/11/25.
 * 仅用于创建retrofit
 */

public class Net {
    private static OkHttpClient okHttpClient;
    private static final String HOST_NAME = "";//
    private static final String BASE_URL = "";

    public static <T> T getApi(Class<T> cls) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        okHttpClient = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(cls);
    }

}
