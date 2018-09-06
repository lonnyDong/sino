package com.sino.base.lambda;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * java.time包中的类是不可变且线程安全的
 * Instant——它代表的是时间戳
 * LocalDate——不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
 * LocalTime——它代表的是不含日期的时间 LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。
 * ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
 * 如果要在数据库中使用 mysql-connector-java版本不低于5.1.37，数据库的驱动版本不低于4.2 
 * mybatis 版本不低于3.4 并且不要引入typeHandle
 * 
 * @author dongyulo
 *
 */
public class TimeDemo {
	public static void main(String[] args) {

		//Instant  获取时间戳
		System.out.println("Instant.MIN: "+Instant.now());
		System.out.println("Instant.EPOCH"+Instant.EPOCH);
		System.out.println("Instant.MAX"+Instant.MAX);
		System.out.println("Instant.MIN "+Instant.MIN);
		System.out.println("Instant.MIN "+Instant.now(Clock.systemUTC()));  //2017-05-26T02:40:23.734Z
		
		//获取当前的日期
		LocalDate now = LocalDate.now();
		System.out.println(now);											//2017-05-26
		//返回指定的日期
		LocalDate of = LocalDate.of(2016, 12, 21);
		System.out.println(of);												//2016-12-21
		LocalDate of2 = LocalDate.of(2016, Month.DECEMBER, 21);
		System.out.println(of2);											//2016-12-21
		System.out.println(now.getYear());									//2017
		Month month = now.getMonth();
		System.out.println(month);											//MAY
		System.out.println(now.getDayOfMonth());							//26
		System.out.println(now.getDayOfYear());								///146
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		System.out.println(dayOfWeek);										//FRIDAY
		
		
		//检查两个日期是否相等
		LocalDate data1 = LocalDate.of(2016, 12, 21);
		LocalDate data2 = LocalDate.of(2016, Month.DECEMBER, 21);
		LocalDate data3 = LocalDate.of(2016, Month.APRIL, 21);

		System.out.println(data1.equals(data2));							//true
		//比较时间先后
		System.out.println(data1.isAfter(data3));							//true
		
		
		//在Java 8中如何检查重复事件，比如说生日
		//1.指定生日12.21
		LocalDate birthday = LocalDate.of(2016, 2, 29);
		//2.转化为MonthDay
		MonthDay monthDay = MonthDay.from(birthday);
		System.out.println(monthDay);										//--12-21
		
		
		
		for (int year_ = 1991; year_ < 2017; year_++) {
			
			for (int month_i = 1; month_i <= 12; month_i++) {
				
				LocalDate date = LocalDate.of(year_, month_i, 1);
				//每月有多少天
				int lengthOfMonth = date.lengthOfMonth();
				for (int day_ = 1;  day_<= lengthOfMonth; day_++) {
					LocalDate dates = LocalDate.of(year_, month_i, day_);
				
					MonthDay from = MonthDay.from(dates);
					if(monthDay.equals(from)){ 
					  //  System.out.println(dates+"Many Many happy returns of the day !!"); 
					}else{ 
					   
					} 
				}
				
			}
			
		}
		
		/**
		 * 时间类 LocalTime
		 */
		LocalTime currentTime = LocalTime.now();
		System.out.println("currentTime:"+currentTime);						//12:50:07.410 hour, minutes, seconds, nano seconds
		
		//添加30 分钟
		LocalTime plusMinutes = currentTime.plusMinutes(30);
		System.out.println(plusMinutes);									//13:23:14.976
		//添加1小时
		LocalTime plusHours = currentTime.plusHours(2);
		System.out.println(plusHours);										//14:54:57.515
		//添加2周后的日期  同样可以添加任何其他单位的时间
		LocalDate plus = now.plus(2, ChronoUnit.WEEKS);
		System.out.println(plus);											//2017-06-09
		
		
		//一年前的那一天
		LocalDate minus = now.minus(1,ChronoUnit.YEARS);
		System.out.println(minus);											//2016-05-26
		
		
		/**
		 * 时钟类 Clock
		 * 可以用它来获取某个时区下当前的瞬时时间，日期或者时间。可以用Clock来替代System.currentTimeInMillis()与
		 * TimeZone.getDefault()方法。
		 */
		System.out.println(Clock.systemUTC());								//SystemClock[Z]
		System.out.println(Clock.systemDefaultZone());						//SystemClock[Asia/Shanghai]
		
		
		/**
		 * 处理时区 ZonedDateTime 
		 * 现在已经有好几组与时区相关的类了，比如ZonId代表的是某个特定的时区，而ZonedDateTime代表的是带时区的时间。它等同于Java
		 * 8以前的GregorianCalendar类
		 * 
		 */
		ZonedDateTime now2 = ZonedDateTime.now();
		System.out.println("zone:"+now2);									//zone:2017-05-26T13:41:01.629+08:00[Asia/Shanghai]
		System.out.println("LocalDateTime "+LocalDateTime.now() ); //LocalDateTime 2017-05-26T13:41:51.431
		ZoneId america = ZoneId.of("America/New_York");
		ZoneId shanghai = ZoneId.of("Asia/Shanghai");
		System.out.println("shanghai:"+america);							//shanghai:America/New_York
		System.out.println("shanghai:"+shanghai);							//shanghai:Asia/Shanghai
		//ZoneId wh = ZoneId.of("Asia/Wuhan");
		//System.out.println("wh"+wh);										//Unknown time-zone ID: Asia/Wuhan
		
		Instant instant = new Date().toInstant();
		System.out.println(instant);
		
		
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
		
		//两个日期之间包含多少天，多少个月
		LocalDate java8Release = LocalDate.of(2016, Month.DECEMBER, 21); 
		Period periodBetween = Period.between(now, java8Release); 
		System.out.println(periodBetween);									//P-5M-5D
		System.out.println(periodBetween.getDays());									//-5
		System.out.println(periodBetween.getMonths());									//-5
		System.out.println(periodBetween.getYears());									//0
		
		/**
		 * LocalDateTime 日期 时间
		 */
		//带时区偏移量的日期与时间
		LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30); 
		ZoneOffset offset = ZoneOffset.of("+05:30");									//偏移5：30
		OffsetDateTime date = OffsetDateTime.of(datetime, offset); 
		System.out.println("Date and Time with timezone offset in Java : " + date); 
		
		/**
		 * 预定义的格式器来对日期进行解析/格式化
		 */
		String dayAfterTommorrow = "20140116"; 
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE); 
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted); 
		
		LocalDateTime arrivalDate = LocalDateTime.now(); 
		try { 
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a"); 
		    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm:ss"); 
		    
		    
		    String landing = arrivalDate.format(format); 
		    System.out.printf("Arriving at : %s %n", landing); //Arriving at : May 26 2017 01:37 PM 
		    System.out.println(arrivalDate.format(format2));//May 26 2017 01:38:30
		    } catch (DateTimeException ex) { 
		    System.out.printf("%s can't be formatted!%n", arrivalDate); 
		    ex.printStackTrace(); 
		} 
		
		
		
		
		
	}

}
