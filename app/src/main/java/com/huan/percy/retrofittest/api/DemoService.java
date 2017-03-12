package com.huan.percy.retrofittest.api;

import com.huan.percy.retrofittest.entity.ResponseInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Percy on 2017/3/12.
 */

public interface DemoService {
    @GET("result.txt")
    Call<ResponseInfo> testHttpGet();

    //use replacement blocks, @Path used to replace the {} block
//    @GET("api/{name}")
//    Call<ResponseInfo> testHttpGet(@Path("name") String apiAction);

    //use @Query
//    @GET("api/result.txt")
//    Call<ResponseInfo> testHttpGet(@Query("param") String param);

    //use @ QueryMap
//    @GET("api/result.txt")
//    Call<ResponseInfo> testHttpGet(@QueryMap Map<String, String> params);


    //@POST("result.txt")
    //Call<ResponseInfo> uploadNewUser(@Body User user);

    //use @FormUrlEncoded, upload data in form format
    //also can usr @FiledMap
    @FormUrlEncoded
    @POST
    Call<ResponseInfo> uploadNewUser(@Field("username") String userName, @Field("gender") String gender, @Field("age") int age);
}

