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
		g.drawRect(x, y, size, size); //绘制矩形长和宽，每点坐标   矩形一定画，填不填充就看细胞是否存活！
		if (alive) {
			g.fillRect(x, y, size, size); //填充
			g.setColor(Color.pink);  //才知道颜色是graphics类   颜色形状
		}
	}
 
}
 
 
