package eslyz.netdemo.net;

import eslyz.netdemo.widget.NetView;

/**
 * Created by eslyz on 2016/11/26.
 */

public abstract class NetworkCallback<T>  {

    public void onSuccess(T t, NetView netView){

    }

    public void onFailed(Throwable e,NetView netView){

    }

    public void onSuccess(T t){

    }

    public void onFailed(Throwable e){

    }


}
