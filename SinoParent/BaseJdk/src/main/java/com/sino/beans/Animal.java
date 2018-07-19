package com.sino.beans;

public abstract  class Animal {

    public  String type;
    public  String name ;
    public  String color;

    /**
     * 叫的声音
     * @param barking
     */
    public  abstract void bark(String barking);/**


     * 跑步的方式
     * @param barking
     */
    public  abstract void runnning(String running);


}
