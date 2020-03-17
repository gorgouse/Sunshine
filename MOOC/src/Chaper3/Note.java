package Chaper3;

import java.util.ArrayList;
//import java.util.HashSet;

class treasure
{
	private int i;
	
	private String s;
	
	public int reset(int i)
	{
		this.i=i;
		return this.i;
	}
	
	public int get()  {return i;}
	
	public String getString()   {return this.s;}
	
	public String gets(int k)
	{
		
			if(k==0)
			this.s=	"刘乘虚 ";
			
			if(k==1)
			this.s=	"杨咪真 ";
			
			if(k==2)
			this.s=	"杨瑞兹 ";
			
			if(k==3)
			this.s=	"老许 ";
			
			if(k==4)
			this.s=	"刘经能 ";
			
			if(k==5)
			this.s=	"泻开 ";
	
		return this.s;
	}
	
	
	public String toString()  //不能有参数否则库函数失效了   可以直接println输出对象
	{

		return ""+i;
	}
	
	
}





public class Note {
	private ArrayList<String> notes = new ArrayList<String>();
	
	
public void add(String s)
	{
		notes.add(s);
	 
	}


 public void add(String s,int position)
 {
	 notes.add(position, s);
 }
 
 

  public int getSize()
  {
	  return notes.size();
  }
  
  
	
	public String getNote(int index)
	{
		return notes.get(index); //获取index位置上的元素
	}
	
	
	
	public void removeNote(int index)
	{
		notes.remove(index);
	}
	
	public String[] list()
	{
		String [] a = new String [notes.size()];
		notes.toArray(a);
		return a;
		
	}

	public static void main(String[] args) {
		
		treasure v =new treasure();
		v.reset(10);
		System.out.println(v); 
		
		
		
		
		
		
//		HashSet<String> a =new HashSet<String>();
//		a.add("许诗雅");
//		a.add("许文强");
//		a.add("老许");
//		a.add("许亚超");
//		a.add("老许");
//		a.add("许文强");
//		System.out.println(a); 
///////////////////////////////////////////////////////////////////		
		
//		treasure [] a = new treasure [6];  //创6对象管理者
//		
//		treasure b = new treasure ();
//		
//		for(int i=0;i<a.length;i++)
//		{
//			a[i]=new treasure();   //开辟对象空间
//			a[i].reset(i);
//		   a[i].gets(i);        //赋值
//		  
//		}
//		
//      for(treasure z:a)
//      
//    	  System.out.println(z.get());  //写成函数调用的形式要不然会变成记录数组数据的地址
// 
//      for(treasure z:a)
//      System.out.println(z.getString());
      
      ////////////////////////////////////////////////
      
//      System.out.println(c);
		
		
   //   "刘晨曦 " "杨明镇 " "杨瑞颖 " "许民涛 " "刘静能 " "谢凯 "
//		Note b =new Note();
//		b.add("刘晨曦 ");
//		b.add("杨明镇 ");
//	    b.add("杨瑞颖 ");
//		b.add("许民涛 ");
//		b.add("刘静能 ");
//		b.add("谢凯 ");
		
//		System.out.println(b.getNote(0));
//		System.out.println(b.getNote(1));
//		System.out.println(b.getNote(2));
//		System.out.println(b.getNote(3));
		
//		b.add("卡哇伊", 1);
//		System.out.println(b.getNote(1));
//		b.removeNote(1);
//		System.out.println(b.getNote(1));
//		System.out.println(b.getSize());
		
//		String[] a = b.list();
//		
//		for(String s : b.list())  //for(String s : a)
//		{
//			System.out.println(s);
//		}
//		
//		
//		System.out.println("一共有"+ b.getSize()+"个沙雕");
//		System.out.println("---------------");
//		
//		
//		String[] c = new String[6];  //对象管理者管理者每一个字符对象
//		b.add("刘晨曦 ");
//		b.add("杨明镇 ");
//	    b.add("杨瑞应 ");
//		b.add("许民涛 ");
//		b.add("刘静能 ");
//		b.add("谢凯 ");
//		c[0]="刘晨曦 ";
//		c[1]="杨明镇  ";
//		c[2]="杨瑞应 ";
//		c[3]="刘静能 ";
//		c[4]="谢凯 ";
//		c[5]="许民涛 ";
//		for(String s :c)
//		{
//			System.out.println(s);
//		}
		
	}

}
