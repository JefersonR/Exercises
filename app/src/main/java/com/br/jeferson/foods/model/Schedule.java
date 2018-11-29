
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Schedule implements Parcelable
{

    private Sunday sunday;
    private Monday monday;
    private Tuesday tuesday;
    private Wednesday wednesday;
    private Thursday thursday;
    private Friday friday;
    private Saturday saturday;
    public final static Creator<Schedule> CREATOR = new Creator<Schedule>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
        }

        public Schedule[] newArray(int size) {
            return (new Schedule[size]);
        }

    }
    ;

    protected Schedule(Parcel in) {
        this.sunday = ((Sunday) in.readValue((Sunday.class.getClassLoader())));
        this.monday = ((Monday) in.readValue((Monday.class.getClassLoader())));
        this.tuesday = ((Tuesday) in.readValue((Tuesday.class.getClassLoader())));
        this.wednesday = ((Wednesday) in.readValue((Wednesday.class.getClassLoader())));
        this.thursday = ((Thursday) in.readValue((Thursday.class.getClassLoader())));
        this.friday = ((Friday) in.readValue((Friday.class.getClassLoader())));
        this.saturday = ((Saturday) in.readValue((Saturday.class.getClassLoader())));
    }

    public Schedule() {
    }

    public Sunday getSunday() {
        return sunday;
    }

    public void setSunday(Sunday sunday) {
        this.sunday = sunday;
    }

    public Monday getMonday() {
        return monday;
    }

    public void setMonday(Monday monday) {
        this.monday = monday;
    }

    public Tuesday getTuesday() {
        return tuesday;
    }

    public void setTuesday(Tuesday tuesday) {
        this.tuesday = tuesday;
    }

    public Wednesday getWednesday() {
        return wednesday;
    }

    public void setWednesday(Wednesday wednesday) {
        this.wednesday = wednesday;
    }

    public Thursday getThursday() {
        return thursday;
    }

    public void setThursday(Thursday thursday) {
        this.thursday = thursday;
    }

    public Friday getFriday() {
        return friday;
    }

    public void setFriday(Friday friday) {
        this.friday = friday;
    }

    public Saturday getSaturday() {
        return saturday;
    }

    public void setSaturday(Saturday saturday) {
        this.saturday = saturday;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sunday);
        dest.writeValue(monday);
        dest.writeValue(tuesday);
        dest.writeValue(wednesday);
        dest.writeValue(thursday);
        dest.writeValue(friday);
        dest.writeValue(saturday);
    }

    public int describeContents() {
        return  0;
    }

}
