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
			this.s=	"������ ";
			
			if(k==1)
			this.s=	"������ ";
			
			if(k==2)
			this.s=	"������ ";
			
			if(k==3)
			this.s=	"���� ";
			
			if(k==4)
			this.s=	"������ ";
			
			if(k==5)
			this.s=	"к�� ";
	
		return this.s;
	}
	
	
	public String toString()  //�����в�������⺯��ʧЧ��   ����ֱ��println�������
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
		return notes.get(index); //��ȡindexλ���ϵ�Ԫ��
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
//		a.add("��ʫ��");
//		a.add("����ǿ");
//		a.add("����");
//		a.add("���ǳ�");
//		a.add("����");
//		a.add("����ǿ");
//		System.out.println(a); 
///////////////////////////////////////////////////////////////////		
		
//		treasure [] a = new treasure [6];  //��6���������
//		
//		treasure b = new treasure ();
//		
//		for(int i=0;i<a.length;i++)
//		{
//			a[i]=new treasure();   //���ٶ���ռ�
//			a[i].reset(i);
//		   a[i].gets(i);        //��ֵ
//		  
//		}
//		
//      for(treasure z:a)
//      
//    	  System.out.println(z.get());  //д�ɺ������õ���ʽҪ��Ȼ���ɼ�¼�������ݵĵ�ַ
// 
//      for(treasure z:a)
//      System.out.println(z.getString());
      
      ////////////////////////////////////////////////
      
//      System.out.println(c);
		
		
   //   "������ " "������ " "����ӱ " "������ " "������ " "л�� "
//		Note b =new Note();
//		b.add("������ ");
//		b.add("������ ");
//	    b.add("����ӱ ");
//		b.add("������ ");
//		b.add("������ ");
//		b.add("л�� ");
		
//		System.out.println(b.getNote(0));
//		System.out.println(b.getNote(1));
//		System.out.println(b.getNote(2));
//		System.out.println(b.getNote(3));
		
//		b.add("������", 1);
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
//		System.out.println("һ����"+ b.getSize()+"��ɳ��");
//		System.out.println("---------------");
//		
//		
//		String[] c = new String[6];  //��������߹�����ÿһ���ַ�����
//		b.add("������ ");
//		b.add("������ ");
//	    b.add("����Ӧ ");
//		b.add("������ ");
//		b.add("������ ");
//		b.add("л�� ");
//		c[0]="������ ";
//		c[1]="������  ";
//		c[2]="����Ӧ ";
//		c[3]="������ ";
//		c[4]="л�� ";
//		c[5]="������ ";
//		for(String s :c)
//		{
//			System.out.println(s);
//		}
		
	}

}
