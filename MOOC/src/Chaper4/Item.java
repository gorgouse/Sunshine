package Chaper4;

public class Item {//�̳о���������ľ�������ģ�û�о��ø����
	private String title;
	private int playingtime;
	private String years;
//	private int numberoftracks;//��������
	private boolean gotit=false;
	private String comment;
	
	public Item()  //���super() ����Ϊ�յĻ�����ô���������һ���޲����Ĺ��캯��
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
