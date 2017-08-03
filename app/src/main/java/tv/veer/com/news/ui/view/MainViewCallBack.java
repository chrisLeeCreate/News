package tv.veer.com.news.ui.view;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import tv.veer.com.news.modol.NewsResult;

public interface MainViewCallBack {
    void getNewsSuccess(NewsResult body);
    void getNewsError();
}
