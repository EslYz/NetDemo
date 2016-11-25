package eslyz.netdemo.net;

import eslyz.netdemo.widget.NetView;

/**
 * Created by eslyz on 2016/11/26.
 */

public class NetSubscriber<T> extends SimpleSubscriber<T> {
    private NetworkCallback callback;
    private NetView netView;



    @Override
    public void onStart() {

    }

    @Override
    public void onNext(T t) {
        callback.onSuccess(t,netView);
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailed(e,netView);
    }

    @Override
    public void onCompleted() {

    }
}
