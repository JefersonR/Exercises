package com.br.jeferson.foods.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class NetworkSetup {


    public static OkHttpClient getClient() {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(getLoggingCapableHttpClient())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }


    private static HttpLoggingInterceptor getLoggingCapableHttpClient() {
        HttpLoggingInterceptor mLogging = new HttpLoggingInterceptor();
        mLogging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return mLogging;
    }


}
