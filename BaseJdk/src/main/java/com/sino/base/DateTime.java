package com.sino.base;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

import org.springframework.util.Assert;

public class DateTime {

	static Long millisecond = Instant.now().toEpochMilli(); // 精确到毫秒
	Long second = Instant.now().getEpochSecond();// 精确到秒

	/**
	 * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static String convertTimeToString(Long time) {
		Assert.notNull(time, "time is null");
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
	}

	/**
	 * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static Long convertTimeToLong(String time) {
		Assert.notNull(time, "time is null");
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime parse = LocalDateTime.parse("2018-05-29 13:52:50", ftf);
		return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public static void main(String[] args) {
		System.out.println(millisecond);
		String convertTimeToString = convertTimeToString(millisecond);
		System.out.println(convertTimeToString);
		
		
		LocalDate today = LocalDate.now();
		// 本月的第一天
		// LocalDate firstday = LocalDate.of(today.getYear(), today.getMonth(), 1);
		// 本月的最后一天
		LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
		LocalDate firstday = today.with(TemporalAdjusters.firstDayOfMonth());

		System.out.println("本月的第一天" + firstday);
		System.out.println("本月的最后一天" + lastDay);
	}

	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * 返回当前的日期
	 * 
	 * @return
	 */
	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	/**
	 * 返回当前日期时间
	 * 
	 * @return
	 */
	public static LocalDateTime getCurrentLocalDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * 返回当前日期字符串 yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		return LocalDate.now().format(DATE_FORMATTER);
	}

	/**
	 * 返回当前日期时间字符串 yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeStr() {
		return LocalDateTime.now().format(DATETIME_FORMATTER);
	}

	public static LocalDate parseLocalDate(String dateStr, String pattern) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
		return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 日期相隔天数
	 * 
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 */
	public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getDays();
	}

	/**
	 * 日期相隔小时
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toHours();
	}

	/**
	 * 日期相隔分钟
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMinutes();
	}

	/**
	 * 日期相隔毫秒数
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMillis();
	}

	/**
	 * 是否当天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(LocalDate date) {
		return getCurrentLocalDate().equals(date);
	}

	/**
	 * 获取本月的第一天
	 * 
	 * @return
	 */
	public static String getFirstDayOfThisMonth() {
		return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
	}

	/**
	 * 获取本月的最后一天
	 * 
	 * @return
	 */
	public static String getLastDayOfThisMonth() {
		return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
	}

	/**
	 * 获取2017-01的第一个周一
	 * 
	 * @return
	 */
	public static String getFirstMonday() {
		return LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
				.format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的后两周
	 * 
	 * @return
	 */
	public static String getCurDateAfterTwoWeek() {
		return getCurrentLocalDate().plus(2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的6个月后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterSixMonth() {
		return getCurrentLocalDate().plus(6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的5年后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterFiveYear() {
		return getCurrentLocalDate().plus(5, ChronoUnit.YEARS).format(DATE_FORMATTER);
	}

	/**
	 * 获取当前日期的20年后的日期
	 * 
	 * @return
	 */
	public static String getCurDateAfterTwentyYear() {
		return getCurrentLocalDate().plus(2, ChronoUnit.DECADES).format(DATE_FORMATTER);
	}

}
