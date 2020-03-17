package Chaper8;

public class ArrayIndex {
	
	public static void f()
	{
		int[] a=new int [10];
		a[10]=10;
		System.out.println("hello");
	
	}
	
	public static void g() {
		f();
	}
  
	public static void h() {
		int i=10;
		if(i<100) {
			g();
		}
	}
	
	public static void k() {
		try {
			h();
		}catch(NullPointerException e) {
             System.out.println("k()");
		}
	}
	
	public static void main(String[] args) {
		try {
			k();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("caugth");
		}
		System.out.println("main");
	}

}
