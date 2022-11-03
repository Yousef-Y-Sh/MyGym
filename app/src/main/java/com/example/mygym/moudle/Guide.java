package com.example.mygym.moudle;

import android.os.Parcel;
import android.os.Parcelable;

public class Guide implements Parcelable {
    public int id;
    public int image;
    public String title;
    public int idParent;
    public String dayTitle;
    public String type;
    public boolean isSelected = false;

    public Guide(int image, String title, String type) {
        this.image = image;
        this.title = title;
        this.type = type;
    }

    public Guide(int image, String title, int idParent, String dayTitle, String type) {
        this.image = image;
        this.title = title;
        this.idParent = idParent;
        this.dayTitle = dayTitle;
        this.type = type;
    }

    public Guide(int id, int image, String title, int idParent, String dayTitle, String type) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.idParent = idParent;
        this.dayTitle = dayTitle;
        this.type = type;
    }

    protected Guide(Parcel in) {
        id = in.readInt();
        image = in.readInt();
        title = in.readString();
        idParent = in.readInt();
        dayTitle = in.readString();
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

    public String getDay() {
        return dayTitle;
    }

    public void setDay(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDayTitle() {
        return dayTitle;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeInt(idParent);
        parcel.writeString(dayTitle);
        parcel.writeString(type);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
