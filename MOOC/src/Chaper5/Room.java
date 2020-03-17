package Chaper5;

import java.util.HashMap;

public class Room {
	private HashMap<String,Room> exits =new HashMap<String,Room> ();
	private String description;
	public Room(String description)  //�������������
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
	
	public String getExitDesc()  //�ӿ�һ���������ڣ������ڲ�Ϊ������StringBuffer��������,���ҷ���
	{
		StringBuffer sb = new StringBuffer();  //���úܶิ�ӵ��ַ�������
		 for(String dir : exits.keySet())  //keyset���ж�keyΪ��Ϊ�գ���Ϊ�վ�append
		 {
			 sb.append(dir);
			 sb.append(" ");
		 }
		return sb.toString();  
	}
	
	public Room getExit(String direction)  //�ӿڶ������ݽ��ܷ��򷵻س���
	{
		return exits.get(direction);
	}
	
 }	
