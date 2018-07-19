package com.sino.base.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *lambda表达式
 *函数式编程
 */
public class Java8Tester {
	   final static String salutation = " final String! ";

	   public static void main(String args[]){
		   Java8Tester tester = new Java8Tester();
			
	      //with type declaration
	      MathOperation addition = (int a,int b)->(a+b);
			
	      //with out type declaration
	      MathOperation subtraction = (a,b)->a-b;
			
	      //with return statement along with curly braces
	      MathOperation multiplication = (a,b)->{return a*b;};
			
	      //without return statement and without curly braces
	      MathOperation division = (a,b)->a/b;
	      
	      
	      MathOperation compare = (a,b)->
	      {
	    	  return a-b>0?a:b;
	    	  
	      };
	      
//			
//	      Function<T, R>：将 T 作为输入，返回 R 作为输出，他还包含了和其他函数组合的默认方法。
//	      Predicate<T> ：将 T 作为输入，返回一个布尔值作为输出，该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（与、或、非）。
//	      Consumer<T> ：将 T 作为输入，不返回任何内容，表示在单个参数上的操作。
	      Consumer<String> ouput = (String param)->{System.out.print("Consumer interface:"+param);};
	      ouput.accept("123");
	      System.out.println();
	      System.out.println("__________________________________________________");
	      Predicate<String> predicate = param->{
	    	  return param.contains("a");
	    	  };
	      
	      boolean equals = predicate.test("aaa");
	      System.out.println(equals);//true
	      System.out.println(predicate.test("23"));//false
	      System.out.println(predicate.test("2a3"));//true
	      
	      
	      
	      
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	      System.out.println("(10 , 5) bigger one is: " + tester.operate(10, 5, compare));
			
	      //with parenthesis
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      //without parenthesis
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
			
	      greetService1.sayMessage("Mahesh");
	      greetService2.sayMessage("Suresh");
	     
	      /**
		    * 修改final 修饰的变量
		    * @author dongyulo
		    *
		    */
	      GreetingService modifyFinalVarilable = param->System.out.println(salutation+""+param);
	      
	      modifyFinalVarilable.sayMessage("hahhha");
	      System.out.println("salutation:"+salutation);
	   
	   }
		
	   //声明一个函数式接口 @FunctionalInterface可省略  
	   @FunctionalInterface
	   interface MathOperation {
	       int operation(int a, int b);
	   }
	   
	   /**
	    * 
	    * @author dongyulo
	    * 这个接口接收一个参数
	    * 此时使用lambda 表达式可以省去()
	    */
	   interface GreetingService {
	      void sayMessage(String message);
	   }
	   
	   
	   
		
	  private int operate(int a, int b, MathOperation mathOperation){

	      return mathOperation.operation(a, b);
	   }
	  
	  
	  
	  
	  
	  
	}