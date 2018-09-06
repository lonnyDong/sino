package com.sino.base.lambda;

public class SubDefaultFunClass implements DefaultFunInterface {

	@Override
	public void say() {
		System.out.println("自己实现...");
	}

	public static void main(String[] args) {
		SubDefaultFunClass subDefaultFunClass = new SubDefaultFunClass();
		subDefaultFunClass.sing();//调用接口中的方法
		int int1 = subDefaultFunClass.getInt();
		System.out.println(int1);
		subDefaultFunClass.say();//借口默认返回
		DefaultFunInterface.laugh();
	}
	
}
