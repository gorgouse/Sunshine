package Chaper3;

import java.util.HashMap;
import java.util.Scanner;

public class money {             //所有都得是对象， 其他数据类型如int,double都不行
    HashMap<Integer,String> container = new HashMap<Integer,String>();
                                                                                          
   public money()
   {
	   container.put(1,"penny");
	   container.put(10, "dime");
	   container.put(25, "quarter");
	   container.put(50,"half-dolar");
	   container.put(50, "五毛");  //相同的key值以最后一个为准
	   
	   System.out.println("展示keyset()的值="+container.keySet());
	   
	   System.out.println("计算key的唯一keyset()的个数="+container.keySet().size());//keyset是所有key的集合的函数，统计有多少个不重复的key
	                                                 //size()函数统计个数
	   System.out.println("展示 container="+container);
	   
	   for(Integer a : container.keySet() )
		   System.out.println("拿出所有的key = "+a);    //拿出所有的key
	   
	   for(Integer a : container.keySet() )
	   {
		   String b = container.get(a);
		   System.out.println("拿出所有的value = "+b);        //拿出所有的value
	   }
	   
   }
   public String backName(int a)
   {
	   return container.get(a);   //根据key的值返回对应的value,a为传进去的key值
	                              //如果key的值为空返回null

   }
	
   
	public static void main(String[] args) {

       @SuppressWarnings("resource")
	Scanner input =new Scanner(System.in);
       int amount = input.nextInt();
       
       money sum = new money();
       
//       String a ="";
       String a = sum.backName(amount);
       System.out.println(a);
		
		
	}

}
