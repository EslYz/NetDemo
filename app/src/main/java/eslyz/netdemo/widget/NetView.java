package eslyz.netdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import eslyz.netdemo.R;

/**
 * Created by eslyz on 2016/11/26.
 */
public class NetView extends LinearLayout {

    //错误布局
    private TextView errorMsgText;
    private ImageView errorImg;
    private Button errorBtn;
    private LinearLayout errorView;

    //第一次网络请求
    private LinearLayout progressView;

    //页面中转圈布局，不覆盖后面的View
    private LinearLayout progress;

    public NetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NetView(Context context) {
        super(context);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.net_view,null);
        errorView = (LinearLayout) view.findViewById(R.id.loading_error_view);
        errorMsgText = (TextView) view.findViewById(R.id.loading_error_msg_text);
        errorBtn = (Button) view.findViewById(R.id.loading_error_btn);
        errorImg = (ImageView) view.findViewById(R.id.loading_error_img);

        progressView = (LinearLayout) view.findViewById(R.id.progressView);
        progress = (LinearLayout) view.findViewById(R.id.progress);

        addView(view);

    }

    public NetView setErrorMsgText(String errorMsgText) {
        this.errorMsgText.setText(errorMsgText);
        return this;
    }

    public NetView setErrorBtnText(String btnText){
        this.errorBtn.setText(btnText);
        return this;
    }

    public NetView setErrorImgRes(int res){
        this.errorImg.setImageResource(res);
        return this;
    }

    public NetView setErrorBtnVisibility(int visibility){
        this.errorBtn.setVisibility(visibility);
        return this;
    }

    public NetView setErrorViewVisibility(int visibility){
        this.errorView.setVisibility(visibility);
        this.errorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        this.progress.setVisibility(GONE);
        this.progressView.setVisibility(GONE);
        return this;
    }

    public NetView setErrorMsgTextVisibility(int visibility){
        this.errorMsgText.setVisibility(visibility);
        return this;
    }



    public NetView setErrorBtnClickListener(View.OnClickListener l){
        this.errorBtn.setVisibility(VISIBLE);
        this.errorBtn.setOnClickListener(l);
        return this;
    }

    public NetView setProgressVisibility(int visibility){
        this.progress.setVisibility(visibility);
        return this;
    }

    public NetView setLoadingViewVisibility(int visibility){
        this.progressView.setVisibility(visibility);
        return this;
    }

    public NetView dismissProgress(){
        return setProgressVisibility(GONE).setLoadingViewVisibility(GONE);
    }

}