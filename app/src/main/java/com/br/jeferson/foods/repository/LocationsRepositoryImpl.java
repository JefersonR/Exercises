package com.br.jeferson.foods.repository;


import com.br.jeferson.foods.Application;
import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.model.GenericResponse;
import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.model.LocationsResponse;
import com.br.jeferson.foods.network.RestCallback;
import com.br.jeferson.foods.network.api.Api;
import com.br.jeferson.foods.repository.api.LocationsRepository;

public class LocationsRepositoryImpl implements LocationsRepository {

    @Override
    public void getLocations( final LocationsRepositoryImpl.LocationsCallBack callBack) {
        Application.getInstance().getApiCreator().createService(Api.class)
                .getLocations()
                .enqueue(new RestCallback<LocationsResponse>() {
                    @Override
                    public void onSuccess(LocationsResponse response) {
                        callBack.onSuccess(response);
                    }

                    @Override
                    public void onError(GenericResponse<ErrorResponse> error) {
                        callBack.notifyError(error.getError());
                    }
                });
    }

    @Override
    public void getLocationsByID(int id, final LocationsRepositoryImpl.LocationsByIDCallBack callBack) {
        Application.getInstance().getApiCreator().createService(Api.class)
                .getLocationsByID(id)
                .enqueue(new RestCallback<LocationDetail>() {
                    @Override
                    public void onSuccess(LocationDetail response) {
                        callBack.onSuccess(response);
                    }

                    @Override
                    public void onError(GenericResponse<ErrorResponse> error) {
                        callBack.notifyError(error.getError());
                    }
                });
    }

}
