package com.sino.base.lambda;

public interface DefaultFunInterface {

	void say();

	default void sing() {

		System.out.println("我是借口中的默认实现方法...");
	}

	default int getInt() {
		return 1;
	}
	//接口中的静态方法
	public static void  laugh() {
		System.out.println("hahha....");
	}
	
}
