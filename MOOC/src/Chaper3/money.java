package Chaper3;

import java.util.HashMap;
import java.util.Scanner;

public class money {             //���ж����Ƕ��� ��������������int,double������
    HashMap<Integer,String> container = new HashMap<Integer,String>();
                                                                                          
   public money()
   {
	   container.put(1,"penny");
	   container.put(10, "dime");
	   container.put(25, "quarter");
	   container.put(50,"half-dolar");
	   container.put(50, "��ë");  //��ͬ��keyֵ�����һ��Ϊ׼
	   
	   System.out.println("չʾkeyset()��ֵ="+container.keySet());
	   
	   System.out.println("����key��Ψһkeyset()�ĸ���="+container.keySet().size());//keyset������key�ļ��ϵĺ�����ͳ���ж��ٸ����ظ���key
	                                                 //size()����ͳ�Ƹ���
	   System.out.println("չʾ container="+container);
	   
	   for(Integer a : container.keySet() )
		   System.out.println("�ó����е�key = "+a);    //�ó����е�key
	   
	   for(Integer a : container.keySet() )
	   {
		   String b = container.get(a);
		   System.out.println("�ó����е�value = "+b);        //�ó����е�value
	   }
	   
   }
   public String backName(int a)
   {
	   return container.get(a);   //����key��ֵ���ض�Ӧ��value,aΪ����ȥ��keyֵ
	                              //���key��ֵΪ�շ���null

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
