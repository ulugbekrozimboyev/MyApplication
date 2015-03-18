package com.example.ulugbek.myapplication.entities;

/**
 * Created by Ulugbek on 05.03.2015.
 */
public class Message {

    private String messBody;
    private User from;
    private User to;
    // send time from user
    private String sendTime;

    // message status:
    // 0 - not send yet
    // 1 - get to server
    // 2 - get to user
    private int messageStatus;
}
