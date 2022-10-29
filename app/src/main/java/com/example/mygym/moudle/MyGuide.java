package com.example.mygym.moudle;

public class MyGuide {
    public String name;
    public int time;
    public int timeOfTadreeb;
    public String difficulty;
    public String status;
    public int cover;

    public MyGuide(String name, int time, int timeOfTadreeb, String difficulty, String status, int cover) {
        this.name = name;
        this.time = time;
        this.timeOfTadreeb = timeOfTadreeb;
        this.difficulty = difficulty;
        this.status = status;
        this.cover = cover;
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

    public int getTimeOfTadreeb() {
        return timeOfTadreeb;
    }

    public void setTimeOfTadreeb(int timeOfTadreeb) {
        this.timeOfTadreeb = timeOfTadreeb;
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
}
