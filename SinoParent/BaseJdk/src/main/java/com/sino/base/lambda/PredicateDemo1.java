package com.sino.base.lambda;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PredicateDemo1 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		/**
		 * Java 8为Collection集合新增了一些需要Predicate参数的方法，
		 * 这些方法可以对集合元素进行过滤,程序可使用Lambda表达式构建Predicate对象。
		 */
        // 创建books集合、为books集合添加元素的代码与前一个程序相同。  
         HashSet books = new  HashSet();  
        books.add(new String("轻量级Java EE企业应用实战"));  
        books.add(new String("疯狂Java讲义"));  
        books.add(new String("疯狂iOS讲义"));  
        books.add(new String("疯狂Ajax讲义"));  
        books.add(new String("疯狂Android讲义"));  
        
        
        // 统计书名包含“疯狂”子串的图书数量  
        System.out.println(calAll(books , ele->((String)ele).contains("疯狂")));  
        // 统计书名包含“Java”子串的图书数量  
        System.out.println(calAll(books , ele->((String)ele).contains("Java")));  
        // 统计书名字符串长度大于10的图书数量  
        System.out.println(calAll(books , ele->((String)ele).length() > 10));  
          
        // 使用Lambda表达式（目标类型是Predicate）过滤集合  
        books.removeIf(ele -> ((String)ele).length() < 10);  
       
        
        System.out.println(books);  
		
		
		
		
		
		
		
	}
	
	//数量统计
	public static int calAll(Collection books , Predicate p)  
    {  
        int total = 0;  
        for (Object obj : books)  
        {  
            // 使用Predicate的test()方法判断该对象是否满足Predicate指定的条件  
            if (p.test(obj))  
            {  
                total ++;  
            }  
        }  
        return total;  
    }  
}
