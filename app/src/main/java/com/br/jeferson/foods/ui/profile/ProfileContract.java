package com.br.jeferson.foods.ui.profile;


import android.support.annotation.DrawableRes;

import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;

public interface ProfileContract {

    interface View extends BaseContract.View {
       void  userInformation(@DrawableRes int  photo, String name, String email, String phone, String place);
    }

    interface Presenter extends BaseContract.Presenter {
       void getUserInformation();
    }

}
