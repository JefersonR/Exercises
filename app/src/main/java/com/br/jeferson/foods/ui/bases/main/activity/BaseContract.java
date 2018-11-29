package com.br.jeferson.foods.ui.bases.main.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.br.jeferson.foods.ui.bases.BaseView;


public interface BaseContract{
    interface View  extends BaseView {

        void updateToolbar(Toolbar toolbar, TextView toolbarTitle, String title, boolean displayHomeAsUp);

    }

    interface Presenter {
        void init(Bundle extras);

        Bundle getExtras();

        void setExtras(Bundle extras);
    }

}
