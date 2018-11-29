
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;

public class ListLocation implements Parcelable
{

    private String name;
    private float review;
    private String type;
    private int id;
    private @ColorRes
    int color;
    public final static Creator<ListLocation> CREATOR = new Creator<ListLocation>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ListLocation createFromParcel(Parcel in) {
            return new ListLocation(in);
        }

        public ListLocation[] newArray(int size) {
            return (new ListLocation[size]);
        }

    }
    ;

    protected ListLocation(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.review = ((float) in.readValue((float.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.color = ((int) in.readValue((int.class.getClassLoader())));
    }

    public ListLocation() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @ColorRes int getColor() {
        return color;
    }

    public void setColor( @ColorRes int color) {
        this.color = color;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(review);
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(color);
    }

    public int describeContents() {
        return  0;
    }

}
