package com.br.jeferson.foods.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.adapter.CommentAdapter;
import com.br.jeferson.foods.adapter.PhotoAdapter;
import com.br.jeferson.foods.model.CommentModel;
import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseFragment;
import com.br.jeferson.foods.util.Consts;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailFragment extends BaseFragment implements DetailContract.View {

    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapseToolbar;
    @BindView(R.id.bgheader)
    ImageView bgheader;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_review)
    TextView tvReview;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.rv_photos)
    RecyclerView rvPhotos;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_place)
    TextView tvPlace;
    @BindView(R.id.tv_nothing)
    TextView tvNothing;
    @BindView(R.id.tv_nothing_photo)
    TextView tvNothingPhoto;
    @BindView(R.id.rv_comments)
    RecyclerView rvComments;
    @BindView(R.id.tv_reviews)
    TextView tvReviews;
    @BindView(R.id.ll_data)
    LinearLayout llData;
    @BindView(R.id.shimmer_frameLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    private DetailContract.Presenter mPresenter;

    public static DetailFragment newInstance(ListLocation mItem) {
        Bundle args = new Bundle();
        args.putParcelable(Consts.EXTRA.ITEM, mItem);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Override
    protected BaseContract.Presenter mPresenter() {
        return mPresenter = new DetailPresenter(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() != 0)
                    getFragmentManager().popBackStack();
                return true;
            case R.id.action_share:
                if (mPresenter.getmItem() != null) {
                    Intent iShare = new Intent(Intent.ACTION_SEND);
                    iShare.setType("text/*");
                    iShare.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.str_is_good), mPresenter.getmItem().getName()));
                    startActivity(Intent.createChooser(iShare, getString(R.string.str_choose_app)));
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_more, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void notifyError(ErrorResponse error) {
        super.notifyError(error);
        if (getActivity() != null)
            llData.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        shimmerFrameLayout.stopShimmerAnimation();
    }

    @Override
    protected int getResourceView() {
        return R.layout.activity_detail;
    }

    @Override
    protected void setupView() {
        setHasOptionsMenu(true);
        shimmerFrameLayout.startShimmerAnimation();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void fillData(LocationDetail locationDetail) {
        tvTitle.setText(locationDetail.getName());
        collapseToolbar.setTitle(locationDetail.getName());
        tvReview.setText(String.valueOf(locationDetail.getReview()));
        ratingBar.setRating(locationDetail.getReview());
        tvAbout.setText(locationDetail.getAbout());
        tvPhone.setText(locationDetail.getPhone());
        tvPlace.setText(locationDetail.getAddress());
        if (getActivity() != null)
            llData.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        shimmerFrameLayout.stopShimmerAnimation();
    }

    @Override
    public void scheduleDays(String schedule) {
        tvTime.setText(schedule);
    }

    @Override
    public void getComments(List<CommentModel> comments) {
        fillLists(rvComments, new CommentAdapter(comments), tvNothing, LinearLayoutManager.VERTICAL);
    }

    @Override
    public void getPhotos(List<Integer> photosMock) {
        fillLists(rvPhotos, new PhotoAdapter(photosMock), tvNothingPhoto, LinearLayoutManager.HORIZONTAL);
    }

    private void fillLists(RecyclerView recyclerView, RecyclerView.Adapter adapter, TextView tvNothing, @RecyclerView.Orientation int orientation) {
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(orientation);
        recyclerView.setLayoutManager(llm);
        tvNothing.setVisibility(View.GONE);

    }

    @OnClick(R.id.tv_reviews)
    void reviewsButton(View view) {
        Toast.makeText(getActivity(), R.string.str_wait, Toast.LENGTH_SHORT).show();
    }


}
