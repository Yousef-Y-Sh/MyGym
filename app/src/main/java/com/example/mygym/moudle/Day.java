package com.example.mygym.moudle;

import android.os.Parcel;
import android.os.Parcelable;

public class Day implements Parcelable {
    int id;
    int idParent;
    String title;
    public boolean isOpen = false;

    public Day(String title, int idParent) {
        this.title = title;
        this.idParent = idParent;
    }

    public Day(int id, int idParent, String title) {
        this.id = id;
        this.title = title;
        this.idParent = idParent;
    }


    protected Day(Parcel in) {
        id = in.readInt();
        idParent = in.readInt();
        title = in.readString();
        isOpen = in.readByte() != 0;
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(idParent);
        parcel.writeString(title);
        parcel.writeByte((byte) (isOpen ? 1 : 0));
    }
}
