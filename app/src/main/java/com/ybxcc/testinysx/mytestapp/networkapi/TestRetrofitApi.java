package com.ybxcc.testinysx.mytestapp.networkapi;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ybx on 2017/5/17.
 */

public interface TestRetrofitApi {
    @GET("api/data/Android/10/{page}")
    Call<RequestBody> getDate(@Path("page") int page);
}
