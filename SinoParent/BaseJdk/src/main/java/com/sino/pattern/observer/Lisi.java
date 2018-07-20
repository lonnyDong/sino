package com.sino.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 李四监听韩非子
 */
public class Lisi implements Observer {


    @Override
    public void update(Observable o, Object arg) {
    	
    	boolean hasChanged = o.hasChanged();
    	System.out.println("输出韩非子是否发生了变化："+ hasChanged);
        System.out.println("收到消息了："+arg);
        
    }



}
