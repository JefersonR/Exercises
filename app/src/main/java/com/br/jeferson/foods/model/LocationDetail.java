
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LocationDetail implements Parcelable
{

    private int id;
    private String name;
    private float review;
    private String type;
    private String about;
    private String phone;
    private String adress;
    private List<Schedule> schedule = null;
    public final static Creator<LocationDetail> CREATOR = new Creator<LocationDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LocationDetail createFromParcel(Parcel in) {
            return new LocationDetail(in);
        }

        public LocationDetail[] newArray(int size) {
            return (new LocationDetail[size]);
        }

    }
    ;

    protected LocationDetail(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.review = ((float) in.readValue((float.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.about = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.adress = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.schedule, (Schedule.class.getClassLoader()));
    }

    public LocationDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(review);
        dest.writeValue(type);
        dest.writeValue(about);
        dest.writeValue(phone);
        dest.writeValue(adress);
        dest.writeList(schedule);
    }

    public int describeContents() {
        return  0;
    }

}
