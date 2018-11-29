package com.br.jeferson.foods.network;

import android.support.annotation.NonNull;

import com.br.jeferson.foods.model.ErrorResponse;
import com.br.jeferson.foods.model.GenericResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RestCallback<T> implements Callback<T> {

    public abstract void onSuccess(T response);

    public abstract void onError(GenericResponse<ErrorResponse> error);

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        try {
            if (response.isSuccessful()) {
                onSuccess(response.body());
            } else {
                final JsonParser parser = new JsonParser();
                JsonElement errorJson = parser.parse(Objects.requireNonNull(response.errorBody()).string());

                Type listType = new TypeToken<GenericResponse<ErrorResponse>>() {
                }.getType();
                GenericResponse<ErrorResponse> error = new Gson().fromJson(errorJson, listType);
                if (error.getError() == null && error.getErrors() == null) {
                    onError(exceptionError(call));
                } else if (error.getError() != null) {
                    error.getError().setHttpCode(response.code());
                    error.getError().setCallback(this);
                    error.getError().setCall(call.clone());
                    onError(error);
                } else {
                    onError(error);
                }
            }
        } catch (IllegalStateException illEx) {
            GenericResponse<ErrorResponse> errorResponse = exceptionError(call);
            errorResponse.getError().setHttpCode(500);
            onError(errorResponse);
        } catch (Exception e) {
            onError(exceptionError(call));
        }

    }


    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if (t instanceof NoConnectivityException) {
            onError(exceptionNetworkError(call));
        } else if (t instanceof SocketTimeoutException) {
            onError(exceptionTimeOut(call));
        } else {
            onError(exceptionError(call));
        }
    }

    private GenericResponse<ErrorResponse> exceptionTimeOut(Call call) {
        GenericResponse<ErrorResponse> error = new GenericResponse<>();
        error.setError(new ErrorResponse().getTimeOutError());
        error.getError().setCallback(this);
        error.getError().setCall(call.clone());
        return error;
    }

    private GenericResponse<ErrorResponse> exceptionError(Call call) {
        GenericResponse<ErrorResponse> error = new GenericResponse<>();
        error.setError(new ErrorResponse().getExceptionError());
        error.getError().setCallback(this);
        error.getError().setCall(call.clone());

        return error;
    }

    private GenericResponse<ErrorResponse> exceptionNetworkError(Call call) {
        GenericResponse<ErrorResponse> error = new GenericResponse<>();
        error.setError(new ErrorResponse().getNetworkExceptionError());
        error.getError().setCallback(this);
        error.getError().setCall(call.clone());

        return error;
    }

}
