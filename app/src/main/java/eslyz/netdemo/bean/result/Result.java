package eslyz.netdemo.bean.result;

/**
 * Created by eslyz on 2016/11/26.
 */

public class Result<T> {
    public String code;
    public String errorMsg;
    public boolean success;

    public T data;
}
