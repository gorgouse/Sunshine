package Chaper4;

public class Item {//继承就是有子类的就用子类的，没有就用父类的
	private String title;
	private int playingtime;
	private String years;
//	private int numberoftracks;//发行数量
	private boolean gotit=false;
	private String comment;
	
	public Item()  //如果super() 参数为空的话，那么父类必须有一个无参数的构造函数
	{
		
	}
	  
	public Item(String title, int playingtime, String years, boolean gotit, String comment) {
		super();
		this.title = title;
		this.playingtime = playingtime;
		this.years=years;
//		this.numberoftracks = numberoftracks;
		this.gotit = gotit;
		this.comment = comment;
	}
	
	
	public void print()
	{
		System.out.print(">> "+title);
		System.out.println(years+" "+playingtime+" "+gotit+" "+comment);

	}
	public static void main(String[] args) {	// TODO Auto-generated method stub
	}

}
