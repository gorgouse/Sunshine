package field;
import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import cell.Cell;
 
public class View extends JPanel {
    //static修饰的属性强调它们只有一个，final修饰的属性表明是一个常数（创建后不能被修改）
//	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 20;  //网格大小
	private Field theField;    
 
	public View(Field field) {
		theField = field;
	} 
 
	@Override
	public void paint(Graphics g) {  //paint是graphics类
 
//		super.paint(g);
		for (int row = 0; row < theField.getHeight(); row++) {
			for (int col = 0; col < theField.getWidth(); col++) {
				Cell cell = theField.get(row, col);//得到每一个cell
				if (cell != null) {
					cell.draw(g, col * GRID_SIZE, row * GRID_SIZE, GRID_SIZE);  //一个格子的大小是50*50
				}
			}
		}
 
	}
 
	
	@Override
      
	public Dimension getPreferredSize() {  //Dimension 类封装单个对象中组件的宽度和高度（精确到整数），Dimension类的高度和宽度值是一个整数，表明有多少个像素点。
		//边框边界的大小，跟图形的贴合  Dimension类相关方法：getSize()和setSize(Dimension size)。分别用来获得和设置方格的大小
		return new Dimension(theField.getWidth() * GRID_SIZE+1, theField.getHeight() * GRID_SIZE+1);
                                    //设置网格的宽度和长度的大小
	}
	
	
//JFrame 类的 add() 方法将 JPanel 面板添加到 JFmme 窗口中
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
		frame.add(view);  //JFrame 类的 add() 方法将 View 类添加到 JFmme 窗口中
		//显示窗口
		frame.pack();//这个函数的作用就是根据窗口里面的布局及组件的preferredSize来确定frame的最佳大小。
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); 
		
	}
 
}

