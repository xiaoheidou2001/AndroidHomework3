package com.example.chapter3.homework;

public class FriendData {
    private int portraitID;
    private String name;
    private String message;

    public FriendData(String name,String message,int portraitID){
        this.name = name;
        this.message = message;
        this.portraitID = portraitID;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getPortraitID() {
        return portraitID;
    }
}
