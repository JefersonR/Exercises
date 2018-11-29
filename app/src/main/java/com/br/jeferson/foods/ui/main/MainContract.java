package com.br.jeferson.foods.ui.main;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.br.jeferson.foods.ui.bases.main.activity.BaseContract;

public interface MainContract {

    interface View extends BaseContract.View {
        void onNextFragment(@NonNull Fragment fragment);

        void inDevelopment();

        void onFinish();

    }

    interface Presenter extends BaseContract.Presenter {
        boolean navigationItemSelecte(int itemID);

        void onBackPressed();

        void setItemID(int itemID);
    }

}
