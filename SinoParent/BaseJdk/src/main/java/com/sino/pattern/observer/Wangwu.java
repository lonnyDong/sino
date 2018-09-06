package com.sino.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 王五也在监听韩非子
 */
public class Wangwu  implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("wangwu 收到消息了："+arg);
    }
    


}
