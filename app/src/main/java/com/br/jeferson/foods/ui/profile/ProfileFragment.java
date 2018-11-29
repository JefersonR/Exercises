package com.br.jeferson.foods.ui.profile;

import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseFragment;
import com.br.jeferson.foods.util.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileFragment extends BaseFragment implements ProfileContract.View {

    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_place)
    TextView tvPlace;

    private ProfileContract.Presenter mPresenter;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    protected BaseContract.Presenter mPresenter() {
        return mPresenter = new ProfilePresenter(this);
    }


    @Override
    protected int getResourceView() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void setupView() {
        mPresenter.getUserInformation();

    }

    @Override
    public void userInformation(@DrawableRes int photo, String name, String email, String phone, String place) {
        Picasso.with(getActivity()).load(photo)
                .transform(new CircleTransform()).into(ivPhoto);
        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvPlace.setText(place);

    }

    @OnClick(R.id.bt_follow)
    void submitButton(View view) {
        Toast.makeText(getActivity(), R.string.str_wait, Toast.LENGTH_SHORT).show();
    }
}
