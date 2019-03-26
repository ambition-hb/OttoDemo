package com.haobi.ottodemo;

import com.squareup.otto.Bus;

/**
 * Created by 15739 on 2019/3/26.
 */

public class OttoBus extends Bus {
    //otto的Bus类相当于EventBus中的EventBus类，它封装了otto的主要功能。
    //但它不是一个单例，其每次都要用new创建出来，因此我们使用单例模式将他封装起来。
    private volatile static OttoBus bus;

    private OttoBus(){

    }

    public static OttoBus getInstance(){
        if (bus == null){
            synchronized (OttoBus.class){
                if (bus == null){
                    bus = new OttoBus();
                }
            }
        }
        return bus;
    }
}
