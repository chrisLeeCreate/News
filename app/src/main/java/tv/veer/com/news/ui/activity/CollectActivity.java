package tv.veer.com.news.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import butterknife.BindView;
import tv.veer.com.news.AppApplication;
import tv.veer.com.news.R;
import tv.veer.com.news.adapter.NewsAdapter;
import tv.veer.com.news.greenDao.New;

public class CollectActivity extends BaseActivity {

    @BindView(R.id.easy_recycleview_collection)
    EasyRecyclerView easyRecycleviewCollection;
    @BindView(R.id.tv_collcetion)
    TextView tvCollcetion;
    private NewsAdapter newsAdapter;

    @Override
    public void getArgs(Bundle var1) {

    }

    @Override
    public int setView() {
        return R.layout.activity_collect;
    }

    @Override
    public void initView() {

        List<New> news = AppApplication.getDaoSession().getNewDao().loadAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        easyRecycleviewCollection.setLayoutManager(linearLayoutManager);
        easyRecycleviewCollection.setAdapterWithProgress(newsAdapter = new NewsAdapter(context));
        newsAdapter.setHeader(true);
        if (news.size() != 0) {
            newsAdapter.addAll(news);
            tvCollcetion.setVisibility(View.GONE);
            easyRecycleviewCollection.setVisibility(View.VISIBLE);
        } else {
            tvCollcetion.setVisibility(View.VISIBLE);
            easyRecycleviewCollection.setVisibility(View.GONE);
        }
    }

    @Override
    public void setting() {

    }

    @Override
    public void setListener() {

    }

}
