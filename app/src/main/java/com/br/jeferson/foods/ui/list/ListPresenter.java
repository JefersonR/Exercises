package com.br.jeferson.foods.ui.list;

import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.model.LocationsResponse;
import com.br.jeferson.foods.repository.LocationsRepositoryImpl;
import com.br.jeferson.foods.repository.api.LocationsRepository;
import com.br.jeferson.foods.ui.bases.main.fragment.BasePresenter;


public class ListPresenter extends BasePresenter implements ListContract.Presenter {

    private ListContract.View mView;
    private LocationsRepositoryImpl locationRepositoryImpl;


    public ListPresenter(ListContract.View view) {
        super(view);
        mView = view;
        locationRepositoryImpl = new LocationsRepositoryImpl();
    }

    @Override
    public void init() {

    }

    private LocationsRepository.LocationsCallBack onResponse() {
        return new LocationsRepository.LocationsCallBack() {
            @Override
            public void onSuccess(LocationsResponse response) {
                if (response != null && response.getListLocations() != null && !response.getListLocations().isEmpty()) {
                    mView.locationsResponse(response.getListLocations());
                } else {
                    mView.onEmptyListResponse();
                }
            }
            @Override
            public void notifyError(ErrorResponse response) {
                mView.notifyError(response);
                mView.onEmptyListResponse();
            }
        };
    }


    @Override
    public void getLocations() {
        locationRepositoryImpl.getLocations(onResponse());
    }
}
