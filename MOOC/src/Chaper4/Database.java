package Chaper4;

import java.util.ArrayList;

public class Database {

	ArrayList<Item> listItem = new ArrayList<Item>();
	
	
//	public void add(CD cd) // CDһ�� cd�Ķ���������CD����Ĳ���
//	{
//		listCD.add(cd);
//	}

	public void add(Item iten)
	{
		listItem.add(iten);
	}
	
	public void list()
	{
		for(Item item:listItem)  //����ÿ��CD ����DVD
		{
			item.print();   //ͬ��������������������ĺ���
		}	
	}
	
	
	public static void main(String[] args) {
		
		Database db = new Database();
		db.add(new CD("����ӱ ","����ָ��","����Ϊ ",21,true,"����Ҹ�giao giao"));
		db.add(new CD("������ ","Ұ��Disco","����Ϊ",20,true,"��˵�����"));
		db.add(new CD("������ ","ï��","����Ϊ",21,true," giao"));
		db.list();

	}

}
