package com.br.jeferson.foods.repository.api;

import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.model.LocationsResponse;
import com.br.jeferson.foods.network.CallBack;



public interface LocationsRepository {


    void getLocations(LocationsCallBack callBack);

    interface LocationsCallBack extends CallBack<LocationsResponse> {}



    void getLocationsByID(int id, LocationsByIDCallBack callBack);

    interface LocationsByIDCallBack extends CallBack<LocationDetail> {}


}
