package com.ybxcc.testinysx.mytestapp.networkapi;

import com.ybxcc.testinysx.mytestapp.bean.RetrofitTestBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Ybx on 2017/5/17.
 */

public interface TestRetrofitApi {
    @GET("api/data/Android/10/{page}")
    Observable<RetrofitTestBean> getDate(@Path("page") String page);
}
