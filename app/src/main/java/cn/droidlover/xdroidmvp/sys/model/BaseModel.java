package cn.droidlover.xdroidmvp.sys.model;

/**
 * Created by ronaldo on 2017/4/24.
 */

public class BaseModel {
    protected String message;
    protected boolean success;
    protected Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
