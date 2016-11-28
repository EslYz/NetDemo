package eslyz.netdemo.bean.result;

import java.io.Serializable;

/**
 * Created by eslyz on 2016/11/26.
 */
public class Result<T>  implements Serializable {
    public boolean success;
    public String code;
    public String errorMsg;
    public T data;
}