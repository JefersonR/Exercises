package com.br.jeferson.foods.network;


import com.br.jeferson.foods.model.ErrorResponse;

public interface CallBack<T> {
    void onSuccess(T response);
    void notifyError(ErrorResponse response);
}
