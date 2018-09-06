package com.sino.base.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Lambda 表达式
 * 
 * @author dongyulo
 * 
 *         对于函数式接口来说：接口中的抽象方法是怎样定义的，就必须按照其给定规则实现， 比如 UnaryOperator
 *         内部接受一个参数，并返回该参数，那么实现就是 param->{return param;}
 *
 */
public class LambdaExpress1 {

	public static void main(String[] args) {

		recommendTest();

		String[] names = new String[] { "java", "ruby", "c", "php" };
		Arrays.sort(names, (x, y) -> Integer.compare(x.length(), y.length())); // 静态方法引用
		Arrays.sort(names, String::compareToIgnoreCase);// 类型上的实例方法引用
		Arrays.sort(names, (x, y) -> x.compareToIgnoreCase(y));

		Stream.of(names).forEach(param -> System.out.println("param:" + param));
		Stream.of(names).forEach(System.out::println);

		// arrayList 遍历
		ArrayList<Object> list = new ArrayList<>();
		ArrayList<Object> list2 = new ArrayList<>();

		int i = 0;
		list.add("zhan");
		list.add("zhuo");
		list.add("wang");
		list.add("li");
		list.add("yuwen");
		list.add("dan");
		list.forEach((param) -> {
			list2.add(param);
		});

		for (Object object : list2) {
			System.out.print("|" + object + "" + i++);

		}

		outPutNum();
		outPutNum_Lam();

	}

	public static void outPutNum() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("11");
			}
		}).start();
	}

	public static void outPutNum_Lam() {

		new Thread(() -> {
			System.out.println("123");
		}

		).start();
	}

	/**
	 * 对一个String的list进行排序 - 使用老方法
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void oldSort() {

		ArrayList list = new ArrayList();
		list.add(1);
		list.add("aa");
		list.add(true);
		// 排序
		Collections.sort(list, new Comparator<String>() {
			// 使用新的排序规则 根据第二个字符进行逆序排
			@Override
			public int compare(String a, String b) {
				if (a.charAt(1) <= b.charAt(1)) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}

	public static void recommendTest() {
		// 1.静态方法引用
		MathMethd sum = (x, y) -> Integer.sum(x, y);
		int operation = sum.operation(12, 23);
		System.out.println("result:" + operation);

		// 2.实例上的实例方法引用
		Student s1 = new Student("zhangsan", 28);
		updateSStatus(s1, st -> st.age >= 15);

		Student s = updateSStatus(s1, st -> st.getAge() > 15, ss -> ss.status = "accept2");
		System.out.println(s);
		UnaryOperator<Student> ss = sss -> sss;
		Student apply = ss.apply(s1);
		System.out.println("apply:" + apply);
		Student student2 = (Student) UnaryOperator.identity().apply(new Student("aa",34));
		System.out.println(student2);

	}

	static void updateSStatus(Student s, Predicate<Student> pre) {

		if (pre.test(s)) {
			s.setStatus("accept");
		}
		System.out.println(s);

	}

	static Student updateSStatus(Student s, Predicate<Student> pre, Consumer<Student> consumer) {
		// test()方法进行某些逻辑判断并返回一个boolean值
		if (pre.test(s)) {
			// accept()接受并改变某个对象的内部值
			consumer.accept(s);
		}
		return s;
	}

	static Student accept(UnaryOperator<Student> s) {
		return (Student) UnaryOperator.identity().apply(s);
	}

	// 定义一个函数式接口
	@FunctionalInterface
	interface MathMethd {
		// 接受两个参数
		int operation(int c, int d);
	}

}
