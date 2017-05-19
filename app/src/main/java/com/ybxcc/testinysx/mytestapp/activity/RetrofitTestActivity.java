package com.ybxcc.testinysx.mytestapp.activity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ybxcc.testinysx.mytestapp.R;
import com.ybxcc.testinysx.mytestapp.base.BaseActivity;
import com.ybxcc.testinysx.mytestapp.bean.RetrofitTestBean;
import com.ybxcc.testinysx.mytestapp.networkapi.TestRetrofitApi;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
//import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ybx on 2017/5/16.
 */

public class RetrofitTestActivity extends BaseActivity {

    @BindView(R.id.tv_getservice)
    EditText tvGetservice;
    @BindView(R.id.tv_showresult)
    TextView tvShowresult;
    @BindView(R.id.btn_get)
    Button btnGet;


    @Override
    protected int getContentViewResId() {
        return R.layout.activity_retrofit_test;
    }

    @Override
    protected void initViews() {
        tvShowresult.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @OnClick({R.id.tv_getservice, R.id.btn_get})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_getservice:

                break;
            case R.id.btn_get:
                getDateFromService();
                break;
            default:
                break;
        }
    }

    private void getDateFromService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TestRetrofitApi api = retrofit.create(TestRetrofitApi.class);

        Observable<RetrofitTestBean> call = api.getDate(tvGetservice.getText().toString());

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RetrofitTestBean>() {
                    @Override
                    public void onCompleted() {
                        showToast("Get Top Movie Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvShowresult.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(RetrofitTestBean retrofitTestBean) {
                        String errorTest = retrofitTestBean.getErrorTest();

                        showToast(errorTest + "/");

                        RetrofitTestBean.ResultsBean bean = retrofitTestBean.getResults().get(0);
                        tvShowresult.setText(
                                "_id:" + bean.get_id() + "\n"
                                        + "createdAt：" + bean.getCreatedAt() + "\n"
                                        + "desc：" + bean.getDesc() + "\n"
                                        + "images:" + bean.getImages() + "\n"
                                        + "publishedAt:" + bean.getPublishedAt() + "\n"
                                        + "source" + bean.getSource() + "\n"
                                        + "type:" + bean.getType() + "\n"
                                        + "url: " + bean.getUrl() + "\n"
                                        + "who:" + bean.getWho());
                    }
                });

    }

}
