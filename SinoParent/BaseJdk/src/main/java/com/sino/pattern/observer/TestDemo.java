package com.sino.pattern.observer;

public class TestDemo {

    public static void main(String[] args) {

        HanFeizi hanFeizi = new HanFeizi();
        Lisi lisi = new Lisi();
        Wangwu wangwu = new Wangwu();

        hanFeizi.addObserver(wangwu);
        hanFeizi.addObserver(lisi);
        hanFeizi.sing();

    }
}
