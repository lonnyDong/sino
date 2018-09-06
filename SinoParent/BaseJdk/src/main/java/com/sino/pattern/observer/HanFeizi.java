package com.sino.pattern.observer;


import java.util.Observable;

/**
 * 被监听者韩非子
 */
public class HanFeizi extends Observable {

    public HanFeizi() {

    	
    }

    public void sing(){

        System.out.println("hangfeizi singing");
        super.setChanged();
        this.notifyObservers("hangfeizi start singing");
        
        
    }






}
