package tv.veer.com.news.modol;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
