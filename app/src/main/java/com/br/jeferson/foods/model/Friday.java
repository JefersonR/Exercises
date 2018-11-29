
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Friday implements Parcelable
{

    private String open;
    private String close;
    public final static Creator<Friday> CREATOR = new Creator<Friday>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Friday createFromParcel(Parcel in) {
            return new Friday(in);
        }

        public Friday[] newArray(int size) {
            return (new Friday[size]);
        }

    }
    ;

    protected Friday(Parcel in) {
        this.open = ((String) in.readValue((String.class.getClassLoader())));
        this.close = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Friday() {
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(open);
        dest.writeValue(close);
    }

    public int describeContents() {
        return  0;
    }

}
