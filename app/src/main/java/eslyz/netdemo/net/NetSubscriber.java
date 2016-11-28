package eslyz.netdemo.net;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;

import eslyz.netdemo.widget.NetView;

/**
 * Created by eslyz on 2016/11/26.
 */

public class NetSubscriber<T> extends SimpleSubscriber<T> {

    private NetworkCallback callback;
    private RelativeLayout contentView;//主要操作的布局

    private WeakReference<Context> weakReference;

    private NetView netView;

    private boolean isFirstLoad = true;

    private boolean isFragment = false;

    private FrameLayout decorView;

    private boolean canDissmissWhenComplete = true;

    public NetSubscriber(Context context, boolean isFirstLoad, NetworkCallback callback){
        weakReference = new WeakReference<>(context);
        this.callback = callback;
        netView = new NetView(context);
        this.isFirstLoad = isFirstLoad;
        Window window = ((Activity) context).getWindow();

        View view = window.getDecorView();
        decorView = (FrameLayout) view.findViewById(android.R.id.content);
        //FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);

        decorView.addView(netView);
        isFragment = false;
    }

    /*public NetSubscriber(Fragment fragment, boolean isFirstLoad, NetworkCallback callback){
        this(fragment,isFirstLoad,callback, R.id.container);
    }*/

    public NetSubscriber(Fragment fragment,boolean isFirstLoad,NetworkCallback callback,int parentId){
        weakReference = new WeakReference<>(fragment.getContext());
        this.callback = callback;
        this.isFirstLoad = isFirstLoad;
        netView = new NetView(weakReference.get());

        View view = fragment.getView();
        //默认fragment中布局最外层为LinearLayout(id 为 container_layout(这个不重要));嵌套一层 RelativeLayout(id 为 container);
        contentView = (RelativeLayout) view.findViewById(parentId);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        contentView.addView(netView,params);
        isFragment = true;
    }



    @Override
    public void onNext(T result) {
        callback.onSuccess(result, netView);
        //netView可以多次使用
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailed(e, netView);
    }

    public void setFirstLoad(boolean b){
        this.isFirstLoad = b;
    }

    @Override
    public void onStart() {
        if (isFirstLoad){
            netView.setProgressVisibility(View.GONE);
            netView.setLoadingViewVisibility(View.VISIBLE);
        }else {
            netView.setLoadingViewVisibility(View.GONE);
            netView.setProgressVisibility(View.VISIBLE);
        }
    }

    public void canDissmissWhenCompleted(boolean canDissmiss){
        this.canDissmissWhenComplete = canDissmiss;
    }

    @Override
    public void onCompleted() {
        if (isFirstLoad){
            isFirstLoad = false;
        }
        if (canDissmissWhenComplete){
            netView.dismissProgress();
        }

    }

    public void destroy(){
        if (isFragment) {
            contentView.removeView(netView);
        }else {
            decorView.removeView(netView);
        }
        weakReference.clear();
    }

}
