package com.haobi.ottodemo;

/**
 * Created by 15739 on 2019/3/26.
 */

public class BusData {//定义消息类

    public String message;

    public BusData(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
