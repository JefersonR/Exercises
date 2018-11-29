package com.br.jeferson.foods.model;

import java.util.List;

@SuppressWarnings("unused")
public class GenericResponse<T> {

    private ResultCode resultCode;

    private T resultData;

    private ErrorResponse error;

    private List<ErrorResponse> errors;

    public GenericResponse() {

    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }


}
