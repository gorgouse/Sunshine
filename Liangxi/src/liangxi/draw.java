package liangxi;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;    
    //JFrame – java的GUI程序的基本思路是以JFrame为基础，它是屏幕上window的对象，能够最大化、最小化、关闭。 

//下面代码创建的draw 类继承了 JFrame 类，因此 JFrameDemo 类可以直接使用 JFrame 类的方法
public class draw extends JFrame{  //继承JFrame
	public draw()  //窗口的大小              
	{
		repaint();
		setSize(1000,1500);   //窗口大小
		setDefaultCloseOperation(EXIT_ON_CLOSE); //设置默认关闭窗口
		setLocationRelativeTo(null); //相对于屏幕中间
		setTitle("geography");
		
	}
	
	public void paint(Graphics g)  //paint为库函数,其参数一定是图形Graphics类
	{
		//形状和颜色
		//画线            默认黑色
		g.setColor(Color.green);     //drawLine(100,100,100,100);     //画一个点
		g.drawLine(0,0,100,100);    //在点（0，0）与点（100，100）之间画一条线段。
		//画矩形
		
		
//		g.fillOval(600, 600, 1000, 1000);
		g.fillRect(200, 200, 250, 250);
		g.drawRect(200, 200, 250, 250);
		
		g.drawOval(0, 0, 1000, 1000);//椭圆就是圆
		g.fillOval(0, 0, 1000, 1000);
		
	  
	}
	
	public static void main(String[] args)
	{
		
		new draw().setVisible(true);
	}
}
