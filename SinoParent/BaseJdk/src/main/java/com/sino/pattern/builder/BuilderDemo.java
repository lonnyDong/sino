package com.sino.pattern.builder;

import com.sino.beans.Tesla;
import com.sino.beans.Tesla.Builder;

/**
 * 建造者模式
 * 依然使用汽车为例
 *
 */
public class BuilderDemo {
	
	
	public static void main(String[] args) {
		Builder builder = new Tesla.Builder().builder("enginee", "bwm enginee");
		Tesla build = builder.build();
		System.out.println(build.toString());
		
		
		Tesla build2 = new Tesla.Builder().builder("energy", "engineType", 2, true).build();
		System.out.println(build2);
		
		
	}



}
