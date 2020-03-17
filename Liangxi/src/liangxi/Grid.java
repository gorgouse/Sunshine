package liangxi;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Grid extends JPanel {  //getPreferredSize(),
	
	private int x,y,size;
	
	private static final int GRID_SIZE = 30;
	
	Grid(int x,int y,int size1)
	{
		this.x=x;
		this.y=y;
		this.size=size1;
	}
	
	
	@Override
	public Dimension getPreferredSize() {  //��ȡ������С
		return new Dimension(x*GRID_SIZE+1, y*GRID_SIZE+1);  
		//���᳤��*grid_size�����᳤��*grid_size  //չ�ֳ����ı߽��С
	}
	
	@Override
	public void paint(Graphics g) {
	
		for ( int row = 0; row<10; row++ ) {
			for ( int col = 0; col<10; col++ ) {
				   
					Grid.drawgraphics(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
					//grid_sizeΪ��̬
				}
			}
		}
	
	public static void drawgraphics(Graphics g, int a, int b, int z) {  //��������ֱ�ӵ���
		g.drawRect(a, b, z, z);
		if ( a==b ) {
			g.fillRect(a, b ,z, z);
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Grid b =new Grid(15,15,40);
		
     	JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);//���������۴�С
		frame.setTitle("draw");
		frame.add(b);
		frame.pack();
		frame.setVisible(true);
	}
}