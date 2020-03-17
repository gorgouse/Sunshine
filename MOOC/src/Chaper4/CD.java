package Chaper4;

public class CD extends Item {
	
	private String artist;


	public CD(String title, String artist, String years, int playingtime, boolean gotit, String comment) {
		super(title,playingtime,years,gotit,comment);
		
		this.artist = artist;
	}
	
	public void print()
	{
//		System.out.println(title+" "+artist+" "+numberoftracks+" "+playingtime+" "+gotit+" "+comment);
		System.out.print("¸èÃû£º<<");
		
		System.out.print(artist);
		super.print();
	}
	
     public static void main(String[] args) {
		
         
	}


}
