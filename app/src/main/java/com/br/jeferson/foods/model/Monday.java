
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Monday implements Parcelable
{

    private String open;
    private String close;
    public final static Creator<Monday> CREATOR = new Creator<Monday>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Monday createFromParcel(Parcel in) {
            return new Monday(in);
        }

        public Monday[] newArray(int size) {
            return (new Monday[size]);
        }

    }
    ;

    protected Monday(Parcel in) {
        this.open = ((String) in.readValue((String.class.getClassLoader())));
        this.close = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Monday() {
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
