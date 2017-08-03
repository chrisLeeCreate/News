package tv.veer.com.news.modol;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import java.io.Serializable;
import java.util.ArrayList;

import tv.veer.com.news.greenDao.New;

public class NewsResult implements Serializable {
    private int code;
    private String message;
    private ArrayList<New> data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<New> getData() {
        return data;
    }

    public void setData(ArrayList<New> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"message\":\"" + message + '\"' +
                ", \"data\":" + data +
                '}';
    }
}
