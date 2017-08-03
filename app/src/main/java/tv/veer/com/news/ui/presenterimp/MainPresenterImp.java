package tv.veer.com.news.ui.presenterimp;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.veer.com.news.http.HttpApi;
import tv.veer.com.news.http.RetrofitAdapter;
import tv.veer.com.news.modol.NewsResult;
import tv.veer.com.news.ui.presenter.MainPresenter;
import tv.veer.com.news.ui.view.MainViewCallBack;


public class MainPresenterImp implements MainPresenter {

    private MainViewCallBack mainViewCallBack;

    public MainPresenterImp(MainViewCallBack mainViewCallBack) {
        this.mainViewCallBack = mainViewCallBack;
    }

    @Override
    public void getNews() {
        HttpApi httpApi = RetrofitAdapter.getNewsInstance().create(HttpApi.class);
        Call<NewsResult> newsList = httpApi.getNewsList();
        newsList.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                if (response.body().getMessage().equals("ok")) {
                    mainViewCallBack.getNewsSuccess(response.body());
                } else {
                    mainViewCallBack.getNewsError();
                }
                Log.e("success", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                mainViewCallBack.getNewsError();
                Log.e("error", String.valueOf(t.getMessage()));

            }
        });

    }
}
