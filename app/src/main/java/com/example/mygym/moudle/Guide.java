package com.example.mygym.moudle;

import android.os.Parcelable;

public class Guide {
    public int id;
    public int image;
    public String title;
    public int idParent;
    public int day;
    public boolean isSelected = false;

    public Guide(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Guide(int image, String title, int idParent, int day) {
        this.image = image;
        this.title = title;
        this.idParent = idParent;
        this.day = day;
    }

    public Guide(int id, int image, String title, int idParent, int day) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.idParent = idParent;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
}
