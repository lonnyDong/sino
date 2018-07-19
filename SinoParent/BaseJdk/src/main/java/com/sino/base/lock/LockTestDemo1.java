package com.sino.base.lock;

import java.util.HashMap;


/**
 * synchronized and  ReentrantLock
 *
 * @author lonny
 */
public class LockTestDemo1 {

    public static void main(String[] args) {

        withReentLock();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        
//		withoutLock();
//		withSync();
    }

    private  static void   saveMoney(){
        for (int i = 0; i < 100; i++) {
            Account3 account3 = new Account3();
            account3.saveMoeny(Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void withReentLock() {

        Thread thread = new Thread(LockTestDemo1::saveMoney);
        thread.start();

        Thread thread2 = new Thread(LockTestDemo1::saveMoney);
        thread2.start();


    }


    public static void withSync() {
        Account2 account2 = new Account2();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    account2.saveMoeny(Thread.currentThread().getName());
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Runnable runnable2 = new Runnable() {

            @Override
            public void run() {


            }
        };

        new Thread(runnable2).start();

    }


    public static void withoutLock() {

        Account account = new Account();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    account.saveMoeny(Thread.currentThread().getName());
                }

            }
        };

        Runnable runnable2 = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    account.getMoney(Thread.currentThread().getName());
                }

            }
        };

        new Thread(runnable).start();
        new Thread(runnable2).start();

    }







}
