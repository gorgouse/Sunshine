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
	public boolean equals(Object obj) {   //������֮��ֻ�ǵ�����һ��������ѣ���Ҫת��
	   
		DVD dvd =(DVD)obj;  //��obj����һ��DVD�Ķ���
	                              //�������ͣ�
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
