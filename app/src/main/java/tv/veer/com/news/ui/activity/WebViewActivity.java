package tv.veer.com.news.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.BindView;
import tv.veer.com.news.AppApplication;
import tv.veer.com.news.R;
import tv.veer.com.news.greenDao.New;
import tv.veer.com.news.greenDao.NewDao;

public class WebViewActivity extends BaseActivity {


    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private String url_page = "";
    private New positon_news;
    private NewDao newDao;

    @Override
    public void getArgs(Bundle bundle) {
        if (bundle != null) {
            url_page = bundle.getString("url_page");
            positon_news = (New) bundle.getSerializable("positon_news");
        }
    }

    @Override
    public int setView() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView() {
        webView.getSettings().setJavaScriptEnabled(true);//支持js
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//支持js打开新窗口
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.requestFocus();
        webView.setWebViewClient(new ClassWebView());
        webView.loadUrl(url_page);
        newDao = AppApplication.getDaoSession().getNewDao();

    }

    @Override
    public void setting() {

    }

    @Override
    public void setListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AppApplication.context, "收藏成功", Toast.LENGTH_LONG).show();
                if (newDao != null) {
                    newDao.insertOrReplace(positon_news);
                }
            }
        });
    }


    class ClassWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);


        }
    }
}
