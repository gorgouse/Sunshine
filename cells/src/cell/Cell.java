package cell; 

import java.awt.Color;
import java.awt.Graphics;
 
public class Cell {
	private boolean alive = false;
 
	public void die() {
		alive = false;
	}
 
	public void reborn() {
		alive = true;
	}
 
	public boolean isAlive() {
		return alive;
	}
 
	public void draw(Graphics g, int x, int y, int size) {
		g.drawRect(x, y, size, size); //���ƾ��γ��Ϳ�ÿ������   ����һ����������Ϳ�ϸ���Ƿ��
		if (alive) {
			g.fillRect(x, y, size, size); //���
			g.setColor(Color.pink);  //��֪����ɫ��graphics��   ��ɫ��״
		}
	}
 
}
 
 
