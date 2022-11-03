package com.example.mygym.moudle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class GuideIntent implements Parcelable {
    List<Guide> list;

    public GuideIntent(List<Guide> list) {
        this.list = list;
    }

    protected GuideIntent(Parcel in) {
        list = in.createTypedArrayList(Guide.CREATOR);
    }

    public static final Creator<GuideIntent> CREATOR = new Creator<GuideIntent>() {
        @Override
        public GuideIntent createFromParcel(Parcel in) {
            return new GuideIntent(in);
        }

        @Override
        public GuideIntent[] newArray(int size) {
            return new GuideIntent[size];
        }
    };

    public List<Guide> getList() {
        return list;
    }

    public void setList(List<Guide> list) {
        this.list = list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(list);
    }
}
