package tv.veer.com.news.http;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     fujiuhong
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static Retrofit newsInstance = null;
    private static OkHttpClient client;

    public static Retrofit getNewsInstance() {
        if (client == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
        }

        if (newsInstance == null) {
            newsInstance = new Retrofit.Builder().baseUrl("http://mingke.veervr.tv:1920/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return newsInstance;
    }
}
