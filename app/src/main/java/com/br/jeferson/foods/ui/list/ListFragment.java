package com.br.jeferson.foods.ui.list;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.br.jeferson.foods.R;
import com.br.jeferson.foods.adapter.LocationsAdapter;
import com.br.jeferson.foods.model.ListLocation;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseContract;
import com.br.jeferson.foods.ui.bases.main.fragment.BaseFragment;
import com.br.jeferson.foods.ui.main.MainActivity;
import com.br.jeferson.foods.util.ActivityUtils;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;


public class ListFragment extends BaseFragment implements ListContract.View, LocationsAdapter.OnItemClick {

    @BindView(R.id.rv_itens)
    RecyclerView rvItens;

    @BindView(R.id.shimmer_frameLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ListContract.Presenter mPresenter;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    protected BaseContract.Presenter mPresenter() {
        return mPresenter = new ListPresenter(this);
    }


    @Override
    protected int getResourceView() {
        return R.layout.fragment_list;
    }

    @Override
    protected void setupView() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                activity.getSupportActionBar().setTitle(R.string.title_home);
            }
        }

        shimmerFrameLayout.startShimmerAnimation();
        mPresenter.getLocations();
    }


    private void fillLists(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        if (getActivity() != null) {
            recyclerView.setAdapter(adapter);
            int columnCount = 2;
            StaggeredGridLayoutManager sglm =
                    new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(sglm);
            recyclerView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorBackground));
            shimmerFrameLayout.stopShimmerAnimation();
            tvEmpty.setVisibility(View.GONE);

        }
    }

    @Override
    public void locationsResponse(List<ListLocation> itens) {
        fillLists(rvItens, new LocationsAdapter(itens, this));
    }

    @Override
    public void onEmptyListResponse() {
        rvItens.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.colorBackground));
        shimmerFrameLayout.stopShimmerAnimation();
        tvEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClic(Fragment fragment) {
        if (getActivity() != null)
            ((MainActivity) getActivity()).mainPresenter.setItemID(0);
            new ActivityUtils().replaceFragment(getActivity().getSupportFragmentManager(), fragment, R.id.container_main);
    }
}
