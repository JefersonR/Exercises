package com.br.jeferson.foods.network.api;


import com.br.jeferson.foods.BuildConfig;
import com.br.jeferson.foods.model.LocationDetail;
import com.br.jeferson.foods.model.LocationsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET(BuildConfig.LOCATIONS)
    Call<LocationsResponse> getLocations();

    @GET(BuildConfig.LOCATIONS + "/{id}")
    Call<LocationDetail> getLocationsByID(@Path("id") int id);


}
