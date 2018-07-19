package com.sino.base.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class StreamDemo2 {

	/**
	 * 创建stream的两种方法 1.通过Stream接口的静态工厂方法（注意：Java8里接口可以带静态方法）；
	 * 2.通过Collection接口的默认方法（默认方法：Default
	 * method，也是Java8中的一个新特性，就是接口中的一个带有实现的方法，后续文章会有介绍）–stream()，
	 * 把一个Collection对象转换成Stream
	 */

	public static void main(String[] args) {
		
		// 1. of方法：有两个overload方法，一个接受变长参数，一个接口单一值
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		Stream<String> stringStream = Stream.of("taobao");

		// 2. generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier
		//（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）

		Stream.generate(new Supplier<Double>() {

			@Override
			public Double get() {
				return Math.random();
			}
			
		});
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);

		//3. iterate方法：也是生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
		Stream.iterate(3, item -> item + 1).limit(10).forEach(System.out::println);
		//这段代码就是先获取一个无限长度的正整数集合的Stream，然后取出前10个打印。千万记住使用limit方法，不然会无限打印下去。
		
		
		int[] aa ={1,2,3,3,3,4,4,4,55,5};
		int[] distinctArray = getDistinctArray(aa);
		for (int i : distinctArray) {
			
				System.out.print(i+"|");
		}
		
		
		ArrayList<Object> nums = new ArrayList<>();
		nums.add(1);
		nums.add(11);
		nums.add(11);
		nums.add(12);
		nums.add(4);
		nums.add(8);
		
		 List<Object> collect = nums.stream().filter(num -> num != null).distinct().peek(System.out::println).skip(2).limit(4).collect(Collectors.toList());
		 System.out.println("");
		 collect.forEach(System.out::println);

		 List<String> tags = new ArrayList<>();
		 tags.add("enum");
		 tags.add("prograss");
		 
		 
		 Article<String> article = new Article<String>("java program", "tomas", tags);
		 
		 Article<String> article2 = new Article<String>("c++ program", "tomas", tags);
		 Article<String> article3 = new Article<String>("php", "cary", tags);
		 Article<String> article4 = new Article<String>("javascript", "cary", tags);
		 
		 
		ArrayList<Article> articles = new ArrayList<Article>();
		articles.add(article);
		articles.add(article2);
		articles.add(article3);
		articles.add(article4);
		
//		 找到标签中含有的enum的第一个元素
		 
		Optional<Article> findFirst = articles.stream().filter(a->a.getTags().contains("enum")).findFirst();
		 if(findFirst!=null&&findFirst.isPresent()){
			 System.out.println(findFirst.get());
		 }
		 
//		 根据作者来把所有的文章分组
		 Map<String, List<Article>> collect2 = articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
		 collect2.forEach((k,v)->System.out.println(k+" ------ "+v));
		 System.out.println("*********************************");
		 //reduce 操作 Lists 是google 开源框架Guava的集合操作类
		 List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 
		 System.out.println("ints sum is:" + ints.stream().reduce((sum, item) ->sum + item).get());

		 
		 //数组的排序操作
		 List<String> list = new ArrayList<String>();
		 for(int i=0;i<1000000;i++){
		 double d = Math.random()*1000;
		 list.add(d+"");
		 }
		 long start = System.nanoTime();//获取系统开始排序的时间点
		 int count= (int) ((Stream) list.stream().sequential()).sorted().count();
		 long end = System.nanoTime();//获取系统结束排序的时间点
		 System.out.println(TimeUnit.NANOSECONDS.toMillis(end-start)+"ms");
		 
		 List<String> list1 = new ArrayList<String>();
		 for(int i=0;i<1000000;i++){
		 double d = Math.random()*1000;
		 list1.add(d+"");
		 }
		 long start1 = System.nanoTime();//获取系统开始排序的时间点
		 int count1 = (int)((Stream) list1.stream().parallel()).sorted().count();
		 long end1 = System.nanoTime();//获取系统结束排序的时间点
		
		 System.out.println(TimeUnit.NANOSECONDS.toMillis(end1-start1)+"ms");
		 
		 
	}
	
	
	
	
	
	
	
	/**
	 *stream 去重
	 *
	 *
	 */

	public static int[] getDistinctArray(int[] i){
		
		 List<int[]> collect = Stream.of(i).distinct().collect(Collectors.toList());
		 return collect.get(0);
		
		
	}
}
