package com.example.mygym.moudle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MyGuide implements Parcelable {
    public int id;
    public String name;
    public int time;
    public String difficulty;
    public String status;
    public int cover;

    public MyGuide(int id, String name, int time, String difficulty, String status, int cover) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.difficulty = difficulty;
        this.status = status;
        this.cover = cover;
    }

    public MyGuide(String name, int time, String difficulty, String status, int cover) {
        this.name = name;
        this.time = time;
        this.difficulty = difficulty;
        this.status = status;
        this.cover = cover;
    }

    protected MyGuide(Parcel in) {
        id = in.readInt();
        name = in.readString();
        time = in.readInt();
        difficulty = in.readString();
        status = in.readString();
        cover = in.readInt();
    }

    public static final Creator<MyGuide> CREATOR = new Creator<MyGuide>() {
        @Override
        public MyGuide createFromParcel(Parcel in) {
            return new MyGuide(in);
        }

        @Override
        public MyGuide[] newArray(int size) {
            return new MyGuide[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(time);
        parcel.writeString(difficulty);
        parcel.writeString(status);
        parcel.writeInt(cover);
    }
}
