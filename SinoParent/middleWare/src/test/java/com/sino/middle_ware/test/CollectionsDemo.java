package com.sino.middle_ware.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsDemo {
   public static void main(String args[]) {
      // create an array of string objs
      String init[] = { "One", "Two", "Three", "One", "Two", "Three" };
      
      // create two lists
      List list1 = new ArrayList(Arrays.asList(init));
      List list2 = new ArrayList(Arrays.asList(init));
      
      HashSet<String> hashSet = new HashSet<>();
      boolean add = hashSet.add("One");
      list1.remove(hashSet);
      
      System.out.println("List1 value: "+list1);
      
      // remove from list2 using singleton
      Set<String> singleton = Collections.singleton("One");
      list2.remove(singleton);		   
      System.out.println("The SingletonList is :"+list2);
   }
}