package com.br.jeferson.foods;


import com.br.jeferson.foods.network.ApiCreator;

public class Application extends android.app.Application {

    private static Application mInstance;
    private ApiCreator mApiCreator;


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mApiCreator = new ApiCreator();

    }

    public static Application getInstance() {
        if (mInstance == null) {
            synchronized (Application.class) {
                if (mInstance == null) {
                    mInstance = new Application();
                }
            }
        }

        return mInstance;
    }

    public ApiCreator getApiCreator() {
        return mApiCreator;
    }
}
