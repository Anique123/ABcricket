package com.exam.ab.model;

public class Training {
    private int trainingID;
    private int date;
    private int startTime;
    private int endTime;

    public Training(){

    }

    public Training (int trainingID, int date, int startTime, int endTime){
        this.trainingID = trainingID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public int getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(int trainingID) {
        this.trainingID = trainingID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
