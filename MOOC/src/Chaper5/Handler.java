package Chaper5;

public class Handler {
	protected Game game; //������Ҫgame��Ҫ��handlerGoҪ����goRoom()����������֮ǰ�������Game�ĳ�Ա����
	
	public Handler(Game game)
	{
		this.game=game;
	}

	public void doCmd(String word) {} //����������

	public boolean isBye() {return false;}

}

