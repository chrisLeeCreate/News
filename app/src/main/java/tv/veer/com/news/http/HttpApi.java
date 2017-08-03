package tv.veer.com.news.http;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import retrofit2.Call;
import retrofit2.http.GET;
import tv.veer.com.news.modol.NewsResult;

public interface HttpApi {

    //http://mingke.veervr.tv:1920/
    @GET("test")
    Call<NewsResult> getNewsList();

}
