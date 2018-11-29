package com.br.jeferson.foods.ui.main;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.ui.bases.main.activity.BasePresenter;
import com.br.jeferson.foods.ui.profile.ProfileFragment;
import com.br.jeferson.foods.ui.list.ListFragment;


public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private int itemID;
    private ListFragment listFragment;
    private ProfileFragment profileFragment;

    MainPresenter(MainContract.View view) {
        super(view);
        mView = view;
    }

    @Override
    public void init() {
        itemID = R.id.navigation_home;
        ListFragmentRoute();
    }

    @Override
    public boolean navigationItemSelecte(int rcItemID) {
        if (itemID != rcItemID) {
            this.itemID = rcItemID;
            switch (itemID) {
                case R.id.navigation_home:
                    ListFragmentRoute();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragmentRoute();
                    return true;
                case R.id.navigation_maps:
                    mView.inDevelopment();
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        switch (itemID) {
            case R.id.navigation_home:
                mView.onFinish();
                break;
            case R.id.navigation_profile:
            case R.id.navigation_maps:
            default:
                itemID = R.id.navigation_home;
                ListFragmentRoute();
                break;
        }
    }

    @Override
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }


    private void ListFragmentRoute() {
        if (listFragment == null)
            listFragment = ListFragment.newInstance();
        mView.onNextFragment(listFragment, itemID);
    }

    private void ProfileFragmentRoute() {
        if (profileFragment == null)
            profileFragment = ProfileFragment.newInstance();
        mView.onNextFragment(profileFragment, itemID);
    }
}
