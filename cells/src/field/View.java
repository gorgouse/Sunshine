package field;
import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import cell.Cell;
 
public class View extends JPanel {
    //static���ε�����ǿ������ֻ��һ����final���ε����Ա�����һ���������������ܱ��޸ģ�
//	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 20;  //�����С
	private Field theField;    
 
	public View(Field field) {
		theField = field;
	} 
 
	@Override
	public void paint(Graphics g) {  //paint��graphics��
 
//		super.paint(g);
		for (int row = 0; row < theField.getHeight(); row++) {
			for (int col = 0; col < theField.getWidth(); col++) {
				Cell cell = theField.get(row, col);//�õ�ÿһ��cell
				if (cell != null) {
					cell.draw(g, col * GRID_SIZE, row * GRID_SIZE, GRID_SIZE);  //һ�����ӵĴ�С��50*50
				}
			}
		}
 
	}
 
	
	@Override
      
	public Dimension getPreferredSize() {  //Dimension ���װ��������������Ŀ�Ⱥ͸߶ȣ���ȷ����������Dimension��ĸ߶ȺͿ��ֵ��һ�������������ж��ٸ����ص㡣
		//�߿�߽�Ĵ�С����ͼ�ε�����  Dimension����ط�����getSize()��setSize(Dimension size)���ֱ�������ú����÷���Ĵ�С
		return new Dimension(theField.getWidth() * GRID_SIZE+1, theField.getHeight() * GRID_SIZE+1);
                                    //��������Ŀ�Ⱥͳ��ȵĴ�С
	}
	
	
//JFrame ��� add() ������ JPanel �����ӵ� JFmme ������
	public static void main(String[] args) {
		
		Field field = new Field(20, 20);
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new Cell());
			}
		}
		
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);  //JFrame ��� add() ������ View ����ӵ� JFmme ������
		//��ʾ����
		frame.pack();//������������þ��Ǹ��ݴ�������Ĳ��ּ������preferredSize��ȷ��frame����Ѵ�С��
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); 
		
	}
 
}

