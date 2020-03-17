package Chaper5;
import java.util.HashMap;
import java.util.*;

public class Game {
	
	private Room currentRoom;
	private HashMap<String,Handler> handlers= new HashMap <String,Handler>();

	public Game() {
		handlers.put("help", new HandlerHelp(this)); //ע�⣬thisָ����Ķ�����thisָ�����ַ�help,go,bye
		handlers.put("go",new HandlerGo(this));       //�����Game��һ�����󴫽�ȥ
		handlers.put("bye",new HandlerBye(this));
  		createRooms();
 	}

	public void createRooms() {
  		Room outside,lobby,pub,study,bedroom;
  
  		//���췿��
  		outside = new Room("�Ǳ���");
  		lobby = new Room("����");
  		pub = new Room("С�ư�");
  		study = new Room("�鷿");
 	 	bedroom = new Room("����");
  
  		// ��ʼ������ĳ���
  		outside.setExits("east",lobby);
  		outside.setExits("south",study);
  		outside.setExits("west",pub);
  		lobby.setExits("west",outside);
  		pub.setExits("east",outside);
  		study.setExits("north",outside);
  		study.setExits("east",bedroom);
  		bedroom.setExits("west",study);
  		lobby.setExits("up", pub);
        pub.setExits("down", lobby);
  		currentRoom = outside;        //�ӳǱ����⿪ʼ
 	}
	

	public void printWelcome()      //��ӡ
 	{
  		System.out.println();
  		System.out.println("��ӭ�����Ǳ�!");
  		System.out.println("����һ���������ĵ���Ϸ��");
  		System.out.println("�����Ҫ������������'help'");
  		showprompt();
 	}
 	
	public void goRoom(String direction){                 //���뷿��
		Room nextRoom = currentRoom.getExit(direction);
  		
  		
  		//if else
  
  		if(nextRoom == null){
   			System.out.println("����û���ţ�");
  		}
  		else{
   			currentRoom = nextRoom;
   			showprompt();
  		    }
  		
  		}
	
	
	public void showprompt()                                      //��ʾ��ǰ�ķ���λ����Ϣ
		{
			System.out.println("��������"+ currentRoom);
			System.out.println("�����У�");
			System.out.println(currentRoom.getExitDesc());
 	    }
	
	
	public void play()                            //��ʼ��Ϸ
	{
		Scanner in = new Scanner(System.in);
		while (true){
   			String line = in.nextLine();
   			String[] words = line.split(" ");  //�ָ��������ַ�
   			Handler handler = handlers.get(words[0]);
   			
   			String value="";
   			if(words.length>1)
   				value=words[1];
   			
   			if(handler!=null)
   			{
   				handler.doCmd(value);//words.length������1����ȥ��valueΪ��ֵ
   				if(handler.isBye() )
   					break;
   			}
 
		}
		in.close();
 	}

	
	public static void main(String[] args) {
 
  		Game game = new Game();
  		game.printWelcome();
        game.play();
  		
  
  		System.out.println("��л���Ĺ��١��ټ���");
  		
 }
}