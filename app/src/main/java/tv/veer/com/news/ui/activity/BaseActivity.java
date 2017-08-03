package tv.veer.com.news.ui.activity;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    public Context context;
    public Activity activity;

    public BaseActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getArgs(this.getIntent().getExtras());
        this.setContentView(this.setView());
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        this.activity = this;
        this.context = this;
        this.setting();
        this.initView();
        this.setListener();
    }

    public abstract void getArgs(Bundle var1);

    public abstract int setView();

    public abstract void initView();

    public abstract void setting();

    public abstract void setListener();
}
