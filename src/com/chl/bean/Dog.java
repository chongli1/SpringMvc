package com.chl.bean;

public class Dog {
    private int dogId;
    private String dogSex;

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogSex() {
        return dogSex;
    }

    public void setDogSex(String dogSex) {
        this.dogSex = dogSex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", dogSex='" + dogSex + '\'' +
                '}';
    }
}
