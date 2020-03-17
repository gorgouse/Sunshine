package liangxi;

import java.util.ArrayList;

public class NoteBook {
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
		return notes.get(index);
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

		NoteBook b =new NoteBook();
		b.add("��κ�",1);
		b.add("������",2);
		b.add("������",3);
		b.add("����ӱ",4);
		System.out.println(b.getNote(0));

	}

}
