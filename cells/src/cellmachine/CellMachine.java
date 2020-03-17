package cellmachine;
 
import javax.swing.JFrame;
import cell.Cell;
import field.Field;
import field.View;
/*
 * ϸ���Զ���
 * 
 * ����:������ŵ��ھ�����<2��>3 ,������
 * ����:���������3���ھӻ���,������
 * ��������򱣳�ԭ��
 */
 
public class CellMachine {
 
	public static void main(String[] args) {
 
		//׼��Field������
		Field field = new Field(30, 30);   //����һ��30*30������
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new Cell()); //��������,����cell
			}
		}
		
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				Cell cell = field.get(row, col);   //�ó�cell
				if (Math.random() < 0.2) {  //�ó�0~1�������
					cell.reborn();   //�����֮һ��cell�����
				}
			}
 
		}
	
		
		//׼��view������
		View view = new View(field);
		JFrame frame = new JFrame();//����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرղ���
		frame.setResizable(false); //���ɸı��С
		frame.setTitle("Cells"); //����Title
		frame.add(view);  //����ոյ�view
		frame.pack();
		frame.setVisible(true);
		
	//��1000��
		for (int i = 0; i < 1000; i++) {
			for (int row = 0; row < field.getHeight(); row++) {
				for (int col = 0; col < field.getWidth(); col++) {
					
					Cell cell = field.get(row, col);//ȡ��field�����ÿһ����Ԫ
					Cell[] neighbour = field.getNeighbour(row, col);//�ҳ�8���ھ�
					int numOfLive = 0;
					for (Cell c : neighbour) {   //֪���Լ��ж��ٸ����ŵ��ھ�����
						if (c.isAlive()) {
							numOfLive++;
						}
					}
					
					System.out.print("[" + row + "][" + col + "]");
					System.out.print(cell.isAlive() ? "live" : "dead");//true ѡlive?falseѡdead?
					System.out.print(":" + numOfLive + "-->");
					
					if (cell.isAlive()) {//������ŵ��ھ�����<2��>3 ,������
						if (numOfLive < 2 || numOfLive > 3) {
							cell.die();
							System.out.print("die");
						}
						
					} else if (numOfLive == 3) {  //���������3���ھӻ���,������
						cell.reborn();
						System.out.print("reborn");
					}
					System.out.println();
				}
			}
			System.out.println("UPDATE........");
			
			frame.repaint();//repaint()���������һ������ˢ��ҳ��Ч���ķ����������Ҫҳ������ػ��Ϳ��Ե���
			try {
				Thread.sleep(200);//ΪʲôҪ��sleep����Ҫ��Ϊ����ͣ��ǰ�̣߳���cpuƬ���ó��������̣߳�������ǰ�̵߳�ִ��
			} catch (InterruptedException e) {   //����쳣
				e.printStackTrace();  //׷��
			}
		}
		field.clear();
		
		
		
 
	}
 
}
