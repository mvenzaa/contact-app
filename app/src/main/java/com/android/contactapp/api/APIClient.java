package com.android.contactapp.api;

import com.android.contactapp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android.contactapp.controller.ControllerClass.getLoggingInterceptor;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getAPI() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(getLoggingInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
