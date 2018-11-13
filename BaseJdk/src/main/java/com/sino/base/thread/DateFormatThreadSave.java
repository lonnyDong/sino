/*
 */
package com.sino.base.thread;
 
import java.text.ParseException;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 

/**
 * DateFormat 线程安全问题解决方案之-ThreadLocal
 * @author lonny
 *这里每个线程都有以 Thread 为key的 Map表，而这个表又以pattern 为key，每一个 pattern 都有一个唯一的 SimpleDateFormat 对象。
 */
public class DateFormatThreadSave {
 
	/** 存放不同的日期模板格式的sdf的Map */
	private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap = new ThreadLocal<Map<String, SimpleDateFormat>>() {
		@Override
		protected Map<String, SimpleDateFormat> initialValue() {
			System.out.println(Thread.currentThread().getName()	+ " init pattern: " + Thread.currentThread());
			return new HashMap<String, SimpleDateFormat>();
		}
	};
 
	/**
	 * 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf
	 * 
	 * @param pattern
	 * @return
	 */
	private static SimpleDateFormat getSdf(final String pattern) {
		Map<String, SimpleDateFormat> tl = sdfMap.get();
		SimpleDateFormat sdf = tl.get(pattern);
		if (sdf == null) {
			System.out.println(Thread.currentThread().getName()+" put new sdf of pattern " + pattern + " to map");
			sdf = new SimpleDateFormat(pattern);
			tl.put(pattern, sdf);
		}
		return sdf;
	}
 
	/**
	 * 这样每个线程只会有一个SimpleDateFormat
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		return getSdf(pattern).format(date);
	}
 
	public static Date parse(String dateStr, String pattern)
			throws ParseException {
		return getSdf(pattern).parse(dateStr);
	}
 
}
