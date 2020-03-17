package Chaper4;

public class DVD extends Item {
	private String director;
	
	public DVD(String title, String director, int playingtime, String years,boolean gotit, String comment) {
		
		super(title,playingtime,years,gotit,comment);
		
		this.director = director;
	}

	public void print()
	{
//		System.out.println(title+" "+director+" "+playingtime+" "+gotit+" "+comment);
		System.out.println(director);
		super.print();
	}
	
	@Override
	public String toString() {
		return "DVD [director=" + director + ", toString()=" + super.toString() + "]";
	}
    
	@Override
	public boolean equals(Object obj) {   //传进来之后只是单纯的一个对象而已，需要转化
	   
		DVD dvd =(DVD)obj;  //把obj看成一个DVD的对象
	                              //向下造型？
		return director.equals(dvd.director);
	}

	public static void main(String[] args) {
	  DVD dvd =new DVD("q","q",2020,"2020",true,"***");
	  DVD dvd1 =new DVD("q","q",111,"2020",true,"***");
	  
	  dvd.print();
	  String s = "" +dvd;
	  System.out.println(s);
  System.out.println(dvd.equals(dvd1));

	}

}
