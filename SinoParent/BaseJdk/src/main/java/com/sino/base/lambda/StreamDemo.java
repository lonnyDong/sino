package com.sino.base.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class StreamDemo {

	public static void main(String[] args) {
		
		//内部内在实例化的时候需要先实例化外部内
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person =  new StreamDemo().new Person("lisi", 45);
		Person person2 =  new StreamDemo().new Person("zhansan",12);
		Person person3 =  new StreamDemo().new Person("zhansan",52);
		Person person4 =  new StreamDemo().new Person("zhansan",42);
		persons.add(person);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		List<Person> collect = persons.stream().filter(p->p.getAge()>18).collect(Collectors.toList());
		
		collect.forEach(s->System.out.print(s));
		//将数据转化为Stream
		
		// 1. Individual values
		Stream stream = Stream.of("a", "b", "c");
		// 2. Arrays
		String [] strArray = new String[] {"a", "b", "c"};
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();
		
//		IntStream、LongStream、DoubleStream。当然我们也可以用 Stream<Integer>、Stream<Long> >、Stream<Double>，
//		但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
		IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
		
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println("");
		IntStream.rangeClosed(1, 20).forEach(System.out::print);
		System.out.println("");
		
		testPerformance();
		
		/**
		 * 过滤掉person 年纪大于18的人
		 * 
		 */
		long count = persons.stream().filter(param->param.age>18).count();
		
		long count2 = Stream.of(persons).filter(param->param.get(0).age>18).count();
		//这里Stream.of(persons) 并不等价于 persons.stream() 
		//Stream.of(persons) 的变量只有一个那就是persons
		//而person.stream()的变量是其中的每一个person
		
		System.out.println("过滤："+count +" : "+count2);
		
		
		
		
		
		
		
		
	}
	
	
	static void testPerformance(){
		long t0 = System.nanoTime();

        //初始化一个范围1000万整数流,求能被2整除的数字，toArray（）是终点方法

        int a[]=IntStream.range(0, 10000000).filter(p -> p % 2==0).toArray();

        long t1 = System.nanoTime();

        //和上面功能一样，这里是用并行流来计算

        int b[]=IntStream.range(0, 10000000).parallel().filter(p -> p % 2==0).toArray();

        long t2 = System.nanoTime();

        //serial: 0.11s, parallel 0.09s

        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

    
	}
	
	
	
	/**
	 *Person 类
	 */
	class Person{
		String name;
		int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public Person() {
			super();
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		} 
		
		
	}
	
	
	
	
}
