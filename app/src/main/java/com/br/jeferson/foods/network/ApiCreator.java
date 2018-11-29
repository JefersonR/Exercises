package com.br.jeferson.foods.network;

import com.br.jeferson.foods.BuildConfig;
import com.br.jeferson.foods.util.ArrayAdapterFactory;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCreator {

    private static final OkHttpClient httpClient = NetworkSetup.getClient();

    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .registerTypeAdapterFactory(new ArrayAdapterFactory()
              ).create()));



    public <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
