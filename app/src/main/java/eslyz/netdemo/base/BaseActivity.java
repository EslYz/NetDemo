package eslyz.netdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import eslyz.netdemo.annotation.ExtraInject;
import eslyz.netdemo.utils.ActivityManager;

/**
 * Created by eslyz on 2016/11/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity thisActivity;

    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        //应用程序在后台时，activity可能被回收，
        if (savedInstanceState != null){
            savedInstanceState.remove("android:support:fragments");
        }
        super.onCreate(savedInstanceState, persistentState);
        thisActivity = this;
        mContext = this;
        setContentView(getContentLayout());

        ActivityManager.saveThisActivity(this);
        ButterKnife.bind(this);
        ExtraInject.bind(this);

    }

    protected abstract int getContentLayout();

}
