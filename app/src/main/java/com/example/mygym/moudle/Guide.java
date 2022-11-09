package com.example.mygym.moudle;

import android.os.Parcel;
import android.os.Parcelable;

public class Guide implements Parcelable {
    public int id;
    public String image;
    public String title;
    public int idDayParent;
    public String type;
    public boolean isSelected;

    //constructor for static list
    public Guide(String image, String title, String type, boolean isSelected) {
        this.image = image;
        this.title = title;
        this.type = type;
        this.isSelected = isSelected;
    }

    //constructor for insert To data base
    public Guide(String image, String title, int idParent, String type) {
        this.image = image;
        this.title = title;
        this.idDayParent = idParent;
        this.type = type;
    }

    //constructor for get all data
    public Guide(int id, String image, String title, int idParent, String type) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.idDayParent = idParent;
        this.type = type;
    }

    protected Guide(Parcel in) {
        id = in.readInt();
        image = in.readString();
        title = in.readString();
        idDayParent = in.readInt();
        type = in.readString();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<Guide> CREATOR = new Creator<Guide>() {
        @Override
        public Guide createFromParcel(Parcel in) {
            return new Guide(in);
        }

        @Override
        public Guide[] newArray(int size) {
            return new Guide[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdDayParent() {
        return idDayParent;
    }

    public void setIdDayParent(int idDayParent) {
        this.idDayParent = idDayParent;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(image);
        parcel.writeString(title);
        parcel.writeInt(idDayParent);
        parcel.writeString(type);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
