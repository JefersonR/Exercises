package com.br.jeferson.foods.network;

import com.br.jeferson.foods.util.Consts;

import java.io.IOException;


public class NoConnectivityException extends IOException {
    @Override
    public String getMessage(){
        return Consts.ERROR.NO_INTERNET_CONNECTION;
    }
}
