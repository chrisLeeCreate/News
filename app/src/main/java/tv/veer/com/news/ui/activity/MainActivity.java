package tv.veer.com.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import tv.veer.com.news.AppApplication;
import tv.veer.com.news.R;
import tv.veer.com.news.adapter.NewsAdapter;
import tv.veer.com.news.greenDao.New;
import tv.veer.com.news.modol.NewsResult;
import tv.veer.com.news.ui.presenter.MainPresenter;
import tv.veer.com.news.ui.presenterimp.MainPresenterImp;
import tv.veer.com.news.ui.view.MainViewCallBack;


public class MainActivity extends BaseActivity implements MainViewCallBack {


    @BindView(R.id.easy_recycleview)
    EasyRecyclerView easyRecycleview;
    @BindView(R.id.fab_one)
    FloatingActionButton fabOne;

    private MainPresenter presenter;
    private NewsAdapter newsAdapter;
    private ArrayList<New> mNews;


    @Override
    public void getArgs(Bundle var1) {

    }

    @Override
    public int setView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        presenter = new MainPresenterImp(this);
        presenter.getNews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        easyRecycleview.setLayoutManager(linearLayoutManager);
        easyRecycleview.setAdapterWithProgress(newsAdapter = new NewsAdapter(context));
    }


    @Override
    public void setting() {

    }

    @Override
    public void setListener() {
        newsAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                New aNew = mNews.get(position);
                String page_url = aNew.getPage_url();
                Intent intent = new Intent();
                intent.setClass(AppApplication.context, WebViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url_page", page_url);
                bundle.putSerializable("positon_news", aNew);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        fabOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AppApplication.context, CollectActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void getNewsSuccess(NewsResult body) {
        Log.e("news", body.toString());
        this.mNews = body.getData();
        newsAdapter.addAll(body.getData());
    }

    @Override
    public void getNewsError() {
        Toast.makeText(this, "请求网络失败", Toast.LENGTH_LONG).show();
    }

}
