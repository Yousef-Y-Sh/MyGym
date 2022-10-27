package com.example.mygym.moudle;

import android.os.Parcelable;

public class Guide  {
    public int image;
    public String title;

    public Guide(int image, String title) {
        this.image = image;
        this.title = title;
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
