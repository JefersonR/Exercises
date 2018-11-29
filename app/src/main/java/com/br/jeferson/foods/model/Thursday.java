
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Thursday implements Parcelable
{

    private String open;
    private String close;
    public final static Creator<Thursday> CREATOR = new Creator<Thursday>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thursday createFromParcel(Parcel in) {
            return new Thursday(in);
        }

        public Thursday[] newArray(int size) {
            return (new Thursday[size]);
        }

    }
    ;

    protected Thursday(Parcel in) {
        this.open = ((String) in.readValue((String.class.getClassLoader())));
        this.close = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Thursday() {
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
