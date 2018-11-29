package com.br.jeferson.foods.model;

import com.br.jeferson.foods.util.Consts;
import com.google.gson.annotations.Expose;

import retrofit2.Call;
import retrofit2.Callback;

@SuppressWarnings("unused")
public class ErrorResponse {

    @Expose
    private String code;
    @Expose
    private String description;
    @Expose
    private String message;
    @Expose
    private String statusCode;
    @Expose
    private int httpCode;
    @Expose
    private Call call;
    @Expose
    private Callback callback;


    public ErrorResponse() {
    }

    public ErrorResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }


    public ErrorResponse getTimeOutError() {
        return new ErrorResponse(Consts.ERROR.TIMEOUT, Consts.ERROR.TIMEOUT_MESSAGE);
    }

    public ErrorResponse getExceptionError() {
        return new ErrorResponse(Consts.ERROR.ERROR_500, Consts.ERROR.ERROR_500_MESSAGE);
    }

    public ErrorResponse getNetworkExceptionError() {
        return new ErrorResponse(Consts.ERROR.NO_INTERNET_CONNECTION, Consts.ERROR.NO_INTERNET_CONNECTION_MESSAGE);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
