package liangxi;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;    
    //JFrame �C java��GUI����Ļ���˼·����JFrameΪ������������Ļ��window�Ķ����ܹ���󻯡���С�����رա� 

//������봴����draw ��̳��� JFrame �࣬��� JFrameDemo �����ֱ��ʹ�� JFrame ��ķ���
public class draw extends JFrame{  //�̳�JFrame
	public draw()  //���ڵĴ�С              
	{
		repaint();
		setSize(1000,1500);   //���ڴ�С
		setDefaultCloseOperation(EXIT_ON_CLOSE); //����Ĭ�Ϲرմ���
		setLocationRelativeTo(null); //�������Ļ�м�
		setTitle("geography");
		
	}
	
	public void paint(Graphics g)  //paintΪ�⺯��,�����һ����ͼ��Graphics��
	{
		//��״����ɫ
		//����            Ĭ�Ϻ�ɫ
		g.setColor(Color.green);     //drawLine(100,100,100,100);     //��һ����
		g.drawLine(0,0,100,100);    //�ڵ㣨0��0����㣨100��100��֮�仭һ���߶Ρ�
		//������
		
		
//		g.fillOval(600, 600, 1000, 1000);
		g.fillRect(200, 200, 250, 250);
		g.drawRect(200, 200, 250, 250);
		
		g.drawOval(0, 0, 1000, 1000);//��Բ����Բ
		g.fillOval(0, 0, 1000, 1000);
		
	  
	}
	
	public static void main(String[] args)
	{
		
		new draw().setVisible(true);
	}
}
