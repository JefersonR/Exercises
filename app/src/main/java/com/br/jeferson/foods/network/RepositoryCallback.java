package com.br.jeferson.foods.network;

import android.support.annotation.NonNull;

import com.br.jeferson.foods.model.ErrorResponse;


public interface RepositoryCallback<T> {
    void onSuccess(T data);

    void onError(@NonNull ErrorResponse error);
}
