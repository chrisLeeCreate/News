package tv.veer.com.news;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;

import tv.veer.com.news.greenDao.DaoMaster;
import tv.veer.com.news.greenDao.DaoSession;

public class AppApplication extends Application {
    public static Context context = null;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        context = this;
        setUpDataBase();
    }

    private void setUpDataBase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "new.db", null);
        SQLiteDatabase sqLiteDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

}
