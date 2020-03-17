package Chaper5;

public class Handler {
	protected Game game; //这里需要game主要是handlerGo要调用goRoom()函数，调用之前必须得有Game的成员变量
	
	public Handler(Game game)
	{
		this.game=game;
	}

	public void doCmd(String word) {} //做管理，命令

	public boolean isBye() {return false;}

}

