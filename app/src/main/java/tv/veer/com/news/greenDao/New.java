package tv.veer.com.news.greenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------
@Entity
public class New implements Serializable{
    /**
     * id : 1
     * title : 易评机：智能音箱在国外香饽饽，国内依然鸡肋
     * category : 音箱
     * thumb_url : http://cms-bucket.nosdn.127.net/44ce9222dc994aeca239c56135d4e8f520170802074719.jpeg?imageView&thumbnail=190y120
     * page_url : http://digi.163.com/17/0802/00/CQPV1FQQ001680P9.html
     */

    private int id;
    private String title;
    private String category;
    private String thumb_url;
    private String page_url;

    @Generated(hash = 492517567)
    public New(int id, String title, String category, String thumb_url, String page_url) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.thumb_url = thumb_url;
        this.page_url = page_url;
    }

    @Generated(hash = 19456684)
    public New() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }
}
