package Chaper5;

import java.util.HashMap;

public class Room {
	private HashMap<String,Room> exits =new HashMap<String,Room> ();
	private String description;
	public Room(String description)  //房间的中文名称
 	{
  		this.description = description;
 	}

	@Override
 	public String toString()
 	{
  		return description;
 	}
	
	public void setExits(String description,Room room)
	{
		 exits.put(description, room);
	}
	
	public String getExitDesc()  //接口一，描述出口，若出口不为空则让StringBuffer加上他们,并且返回
	{
		StringBuffer sb = new StringBuffer();  //采用很多复杂的字符串操作
		 for(String dir : exits.keySet())  //keyset先判断key为不为空，不为空就append
		 {
			 sb.append(dir);
			 sb.append(" ");
		 }
		return sb.toString();  
	}
	
	public Room getExit(String direction)  //接口二，根据接受方向返回出口
	{
		return exits.get(direction);
	}
	
 }	
