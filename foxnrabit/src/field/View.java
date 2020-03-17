package field;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import cell.Cell;

public class View extends JPanel {
	private static final long serialVersionUID = -2417015700213488315L;
	private static final int GRID_SIZE = 16;
	private Field theField;
	
	public View(Field field) {
		theField = field;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GRAY);
		//通过横和竖来画网格线                                high为x，width为y
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			g.drawLine(0, row*GRID_SIZE, theField.getHeight()*GRID_SIZE, row*GRID_SIZE); //x2不变
		}              //(x1,y1,x2,y2) x1-x2  y1-y2
		
		for ( int col = 0; col<theField.getWidth(); col++ ) {
			g.drawLine(col*GRID_SIZE, 0, col*GRID_SIZE, theField.getWidth()*GRID_SIZE);
		}
		///////////
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			for ( int col = 0; col<theField.getWidth(); col++ ) {
				Cell cell = theField.get(row, col);
				
				if ( cell != null ) {
					cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);   
					//cell为实现cell的狐狸和兔子的类的对象
				}
			}
		}
		
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}
}
