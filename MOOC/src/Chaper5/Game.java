package Chaper5;
import java.util.HashMap;
import java.util.*;

public class Game {
	
	private Room currentRoom;
	private HashMap<String,Handler> handlers= new HashMap <String,Handler>();

	public Game() {
		handlers.put("help", new HandlerHelp(this)); //注意，this指该类的对象本身，this指的是字符help,go,bye
		handlers.put("go",new HandlerGo(this));       //这里把Game的一个对象传进去
		handlers.put("bye",new HandlerBye(this));
  		createRooms();
 	}

	public void createRooms() {
  		Room outside,lobby,pub,study,bedroom;
  
  		//创造房间
  		outside = new Room("城堡外");
  		lobby = new Room("大堂");
  		pub = new Room("小酒吧");
  		study = new Room("书房");
 	 	bedroom = new Room("卧室");
  
  		// 初始化房间的出口
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
  		currentRoom = outside;        //从城堡门外开始
 	}
	

	public void printWelcome()      //打印
 	{
  		System.out.println();
  		System.out.println("欢迎来到城堡!");
  		System.out.println("这是一个超级无聊的游戏。");
  		System.out.println("如果需要帮助，请输入'help'");
  		showprompt();
 	}
 	
	public void goRoom(String direction){                 //进入房间
		Room nextRoom = currentRoom.getExit(direction);
  		
  		
  		//if else
  
  		if(nextRoom == null){
   			System.out.println("那里没有门！");
  		}
  		else{
   			currentRoom = nextRoom;
   			showprompt();
  		    }
  		
  		}
	
	
	public void showprompt()                                      //显示当前的房间位置信息
		{
			System.out.println("现在你在"+ currentRoom);
			System.out.println("出口有：");
			System.out.println(currentRoom.getExitDesc());
 	    }
	
	
	public void play()                            //开始游戏
	{
		Scanner in = new Scanner(System.in);
		while (true){
   			String line = in.nextLine();
   			String[] words = line.split(" ");  //分隔开两个字符
   			Handler handler = handlers.get(words[0]);
   			
   			String value="";
   			if(words.length>1)
   				value=words[1];
   			
   			if(handler!=null)
   			{
   				handler.doCmd(value);//words.length不大于1传进去的value为空值
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
  		
  
  		System.out.println("感谢您的光临。再见！");
  		
 }
}