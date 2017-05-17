package com.ybxcc.testinysx.mytestapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ybxcc.testinysx.mytestapp.R;
import com.ybxcc.testinysx.mytestapp.base.BaseActivity;
import com.ybxcc.testinysx.mytestapp.networkapi.TestRetrofitApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    }

    @OnClick({R.id.tv_getservice, R.id.tv_showresult, R.id.btn_get})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_getservice:

                break;
            case R.id.tv_showresult:
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
                .build();

        TestRetrofitApi api = retrofit.create(TestRetrofitApi.class);

        api.getDate(Integer.parseInt(tvGetservice.getText().toString())).enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                tvShowresult.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                tvShowresult.setText(t.getMessage());
                Log.e("response",t.getMessage());
            }
        });
    }

}
