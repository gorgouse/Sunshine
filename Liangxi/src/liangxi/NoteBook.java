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
		b.add("Îé¼Îºã",1);
		b.add("Áõ³¿êØ",2);
		b.add("ĞíÃñÌÎ",3);
		b.add("ÑîÈğÓ±",4);
		System.out.println(b.getNote(0));

	}

}
