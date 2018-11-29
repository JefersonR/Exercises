package com.br.jeferson.foods.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.ui.bases.main.activity.BaseActivity;
import com.br.jeferson.foods.ui.bases.main.activity.BaseContract;
import com.br.jeferson.foods.util.ActivityUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    public MainContract.Presenter mainPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return mainPresenter.navigationItemSelecte(item.getItemId());
        }
    };

    @Override
    protected int contentView() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseContract.Presenter mPresenter() {
        return mainPresenter = new MainPresenter(this);
    }

    @Override
    protected void configView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onNextFragment(@NonNull Fragment fragment) {
        new ActivityUtils().replaceFragment(getSupportFragmentManager(), fragment, R.id.container_main);
    }

    @Override
    public void inDevelopment() {
        Toast.makeText(this, R.string.str_wait, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinish() {
        finish();
    }

    @Override
    public void onBackPressed() {
        mainPresenter.onBackPressed();
    }
}
