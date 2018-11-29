package com.br.jeferson.foods.model;

import android.support.annotation.DrawableRes;

public class ProfileModelResponse {

    private @DrawableRes int photo;
    private String name;
    private String email;
    private String phone;
    private String place;

    public ProfileModelResponse(@DrawableRes int photo, String name, String email, String phone, String place) {
        this.photo = photo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.place = place;
    }

    public @DrawableRes int getPhoto() {
        return photo;
    }

    public void setPhoto(@DrawableRes int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
