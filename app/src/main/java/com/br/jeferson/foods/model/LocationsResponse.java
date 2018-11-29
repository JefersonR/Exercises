
package com.br.jeferson.foods.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class LocationsResponse implements Parcelable
{

    private List<ListLocation> listLocations = new ArrayList<ListLocation>();
    public final static Creator<LocationsResponse> CREATOR = new Creator<LocationsResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LocationsResponse createFromParcel(Parcel in) {
            return new LocationsResponse(in);
        }

        public LocationsResponse[] newArray(int size) {
            return (new LocationsResponse[size]);
        }

    }
    ;

    protected LocationsResponse(Parcel in) {
        in.readList(this.listLocations, (ListLocation.class.getClassLoader()));
    }

    public LocationsResponse() {
    }

    public List<ListLocation> getListLocations() {
        return listLocations;
    }

    public void setListLocations(List<ListLocation> listLocations) {
        this.listLocations = listLocations;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(listLocations);
    }

    public int describeContents() {
        return  0;
    }

}
