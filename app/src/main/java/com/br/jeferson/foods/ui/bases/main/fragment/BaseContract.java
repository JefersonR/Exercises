package com.br.jeferson.foods.ui.bases.main.fragment;

import android.os.Bundle;

import com.br.jeferson.foods.ui.bases.BaseView;


public interface BaseContract {
    interface View extends BaseView{ }

    interface Presenter {
        void init(Bundle extras);

        Bundle getExtras();

        void setExtras(Bundle extras);

    }

}
