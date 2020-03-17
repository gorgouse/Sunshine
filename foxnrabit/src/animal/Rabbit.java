package animal;

import java.awt.Color;
import java.awt.Graphics;

import cell.Cell;

public class Rabbit extends Animal implements Cell {
	public Rabbit() {
		super(10,2);
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int size) {    //红色->狐狸
		int alpha = (int)((1-getAgePercent())*255);  //颜色的变化参数，渐渐变浅
		g.setColor(new Color(255, 0, 0, alpha));  //红色的参数
		g.fillRect(x, y, size, size);
	}

	@Override
	public Animal breed() {
		Animal ret = null;
		if ( isBreedable() && Math.random() < 0.12 ) {
			ret = new Rabbit();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return "Rabbit:"+super.toString();
	}
}
