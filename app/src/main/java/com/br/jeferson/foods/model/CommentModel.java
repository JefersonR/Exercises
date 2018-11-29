
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CommentModel implements Parcelable
{

    private String title;
    private int photo;
    private float review;
    private String comment;
    private String place;
    public final static Creator<CommentModel> CREATOR = new Creator<CommentModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CommentModel createFromParcel(Parcel in) {
            return new CommentModel(in);
        }

        public CommentModel[] newArray(int size) {
            return (new CommentModel[size]);
        }

    }
    ;

    public CommentModel(String title, float review, String comment, String place) {
        this.title = title;
        this.review = review;
        this.comment = comment;
        this.place = place;
    }

    protected CommentModel(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((int) in.readValue((int.class.getClassLoader())));
        this.review = ((float) in.readValue((float.class.getClassLoader())));
        this.comment = ((String) in.readValue((String.class.getClassLoader())));
        this.place = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CommentModel() {
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(photo);
        dest.writeValue(review);
        dest.writeValue(comment);
        dest.writeValue(place);
    }

    public int describeContents() {
        return  0;
    }

}
