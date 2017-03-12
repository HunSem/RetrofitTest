package com.huan.percy.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huan.percy.retrofittest.api.DemoService;
import com.huan.percy.retrofittest.entity.ResponseInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{
    //local host
    private static final String URL = "http://192.168.1.105:8080/";
    private static final String TAG = "RetrofitTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRetrofitHttpGet();
    }

    private void testRetrofitHttpGet() {
        //Step 1: Apply for a retrofit class that contains base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                //this converter could convert ResponseBody that response from Okhttp into Java bean
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Step 2: Create service which was be packaged from Http API into interface
        DemoService service = retrofit.create(DemoService.class);

        //Step 3: Create call with method of service interface
        Call<ResponseInfo> call  = service.testHttpGet();

        //step 4: Make the call
        call.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                Log.d(TAG, response.body().result);
            }

            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
