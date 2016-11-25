package eslyz.netdemo.net;

import rx.Subscriber;

/**
 * Created by eslyz on 2016/11/26.
 */

public abstract class SimpleSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }

}
