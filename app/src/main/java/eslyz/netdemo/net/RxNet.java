package eslyz.netdemo.net;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eslyz on 2016/11/26.
 */

public class RxNet {

    public static void toSubscriber(Observable observable,SimpleSubscriber subscriber){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
