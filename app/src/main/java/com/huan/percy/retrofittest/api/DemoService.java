package com.huan.percy.retrofittest.api;

import com.huan.percy.retrofittest.entity.ResponseInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Percy on 2017/3/12.
 */

public interface DemoService {
    @GET("result.txt")
    Call<ResponseInfo> testHttpGet();
}

