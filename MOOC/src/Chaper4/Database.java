package Chaper4;

import java.util.ArrayList;

public class Database {

	ArrayList<Item> listItem = new ArrayList<Item>();
	
	
//	public void add(CD cd) // CD一个 cd的对象来接受CD构造的参数
//	{
//		listCD.add(cd);
//	}

	public void add(Item iten)
	{
		listItem.add(iten);
	}
	
	public void list()
	{
		for(Item item:listItem)  //对于每个CD 或者DVD
		{
			item.print();   //同名函数调用优先自身类的函数
		}	
	}
	
	
	public static void main(String[] args) {
		
		Database db = new Database();
		db.add(new CD("杨瑞颖 ","左手指月","年龄为 ",21,true,"你给我个giao giao"));
		db.add(new CD("刘大炮 ","野狼Disco","年龄为",20,true,"我说不清楚"));
		db.add(new CD("杨明镇 ","茂名","年龄为",21,true," giao"));
		db.list();

	}

}
