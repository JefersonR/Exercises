package com.br.jeferson.foods.ui.profile;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.model.ProfileModelResponse;
import com.br.jeferson.foods.ui.bases.main.fragment.BasePresenter;


public class ProfilePresenter extends BasePresenter implements ProfileContract.Presenter {

    private ProfileContract.View mView;


    ProfilePresenter(ProfileContract.View view) {
        super(view);
        mView = view;
    }

    @Override
    public void init() {

    }

    @Override
    public void getUserInformation() {
        ProfileModelResponse profileModel = generateMock();
         mView.userInformation(profileModel.getPhoto(),profileModel.getName(), profileModel.getEmail(), profileModel.getPhone(),profileModel.getPlace());
    }

    //Mock user
    private ProfileModelResponse generateMock(){
        return new ProfileModelResponse(R.drawable.user,"Jeferson Rodrigues","jerf21@gmail.com","+55 37 99122 3089","Belo Horizonte - MG");
    }
}
