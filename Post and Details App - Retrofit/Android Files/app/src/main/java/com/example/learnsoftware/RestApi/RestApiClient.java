package com.example.learnsoftware.RestApi;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private RestApi mRestApi;

    public RestApiClient(String restApiServiceUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .callTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .readTimeout(20, TimeUnit.SECONDS) //30, TimeUnit.SECONDS
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRestApi = retrofit.create(RestApi.class);

    }

    public RestApi getRestApi() {
        return mRestApi;
    }

}


