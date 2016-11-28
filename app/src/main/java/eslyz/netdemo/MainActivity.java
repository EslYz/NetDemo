package eslyz.netdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eslyz.netdemo.api.TestApi;
import eslyz.netdemo.bean.StoreInfo;
import eslyz.netdemo.bean.result.Result;
import eslyz.netdemo.net.Net;
import eslyz.netdemo.net.NetSubscriber;
import eslyz.netdemo.net.NetworkCallback;
import eslyz.netdemo.net.RxNet;
import eslyz.netdemo.widget.NetView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView textView;

    private NetSubscriber netSubscriber;

    @OnClick({R.id.btn_start,R.id.btn_error})
    void OnClickListener(View v){
        switch (v.getId()){
            case R.id.btn_error:
                storeId = 90L;
                loadingAgain();
                break;
            case R.id.btn_start:
                initData();
                break;
        }
    }

    private boolean isFirstLoad = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    private Long storeId = 1000L;

    private void initData(){
        netSubscriber = new NetSubscriber(this, isFirstLoad, new NetworkCallback<Result<StoreInfo>>() {
            @Override
            public void onSuccess(Result<StoreInfo> result, NetView netView) {
                if (result.success){
                    if (result.data != null){
                        textView.setText(result.data.toString());
                    }else {
                        netView.setErrorViewVisibility(View.VISIBLE)
                                .setErrorMsgText("数据为空")
                                .setErrorBtnText("关闭")
                                .setErrorBtnClickListener(view -> finish());
                    }
                }else {

                    netView.setErrorViewVisibility(View.VISIBLE)
                            .setErrorMsgText(result.errorMsg)
                            .setErrorBtnText("再试试")
                            .setErrorBtnClickListener(view -> {
                                storeId = 1000L;
                                loadingAgain();
                            });
                }
            }

            @Override
            public void onFailed(Throwable e, NetView netView) {
                netView.setErrorViewVisibility(View.VISIBLE)
                        .setErrorViewVisibility(View.VISIBLE)
                        .setErrorMsgText(e.getMessage())
                        .setErrorBtnText("再试试")
                        .setErrorBtnClickListener(view -> {
                            storeId = 1000L;
                            loadingAgain();
                        }
                );
            }
        });

        RxNet.toSubscriber(Net.getApi(TestApi.class).queryStoreById(storeId), netSubscriber);
        isFirstLoad = false;
    }

    private void loadingAgain(){
        isFirstLoad = true;
        if (netSubscriber != null){
            netSubscriber.destroy();
        }
        initData();
    }


}
