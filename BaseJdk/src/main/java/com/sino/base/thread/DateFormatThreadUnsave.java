package com.sino.base.thread;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat 线程安全性问题
 * @author lonny
 *
 */
public class DateFormatThreadUnsave extends Thread {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String name;
    private String dateStr;
    private boolean sleep;

    public DateFormatThreadUnsave(String name, String dateStr, boolean sleep) {
        this.name = name;
        this.dateStr = dateStr;
        this.sleep = sleep;
    }

    @Override
    public void run() {

        Date date = null;

        if (sleep) {
            try {
               // TimeUnit.MILLISECONDS.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(name + " : date: " + date);
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        // A 会sleep 2s 后开始执行sdf.parse()
        executor.execute(new DateFormatThreadUnsave("A", "1991-09-13", true));
        // B 打了断点,会卡在方法中间
        executor.execute(new DateFormatThreadUnsave("B", "2013-09-13", false));

        executor.shutdown();
    }
}