package cellmachine;
 
import javax.swing.JFrame;
import cell.Cell;
import field.Field;
import field.View;
/*
 * 细胞自动机
 * 
 * 死亡:如果活着的邻居数量<2或>3 ,则死亡
 * 新生:如果正好有3个邻居活着,则新生
 * 其他情况则保持原样
 */
 
public class CellMachine {
 
	public static void main(String[] args) {
 
		//准备Field的数据
		Field field = new Field(30, 30);   //创造一个30*30的网格
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new Cell()); //遍历网格,放入cell
			}
		}
		
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				Cell cell = field.get(row, col);   //拿出cell
				if (Math.random() < 0.2) {  //拿出0~1的随机数
					cell.reborn();   //让五分之一的cell活过来
				}
			}
 
		}
	
		
		//准备view的数据
		View view = new View(field);
		JFrame frame = new JFrame();//窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭操作
		frame.setResizable(false); //不可改变大小
		frame.setTitle("Cells"); //设置Title
		frame.add(view);  //加入刚刚的view
		frame.pack();
		frame.setVisible(true);
		
	//做1000步
		for (int i = 0; i < 1000; i++) {
			for (int row = 0; row < field.getHeight(); row++) {
				for (int col = 0; col < field.getWidth(); col++) {
					
					Cell cell = field.get(row, col);//取出field里面的每一个单元
					Cell[] neighbour = field.getNeighbour(row, col);//找出8个邻居
					int numOfLive = 0;
					for (Cell c : neighbour) {   //知道自己有多少个活着的邻居数量
						if (c.isAlive()) {
							numOfLive++;
						}
					}
					
					System.out.print("[" + row + "][" + col + "]");
					System.out.print(cell.isAlive() ? "live" : "dead");//true 选live?false选dead?
					System.out.print(":" + numOfLive + "-->");
					
					if (cell.isAlive()) {//如果活着的邻居数量<2或>3 ,则死亡
						if (numOfLive < 2 || numOfLive > 3) {
							cell.die();
							System.out.print("die");
						}
						
					} else if (numOfLive == 3) {  //如果正好有3个邻居活着,则新生
						cell.reborn();
						System.out.print("reborn");
					}
					System.out.println();
				}
			}
			System.out.println("UPDATE........");
			
			frame.repaint();//repaint()这个方法是一个具有刷新页面效果的方法，如果你要页面进行重画就可以调用
			try {
				Thread.sleep(200);//为什么要用sleep，主要是为了暂停当前线程，把cpu片段让出给其他线程，减缓当前线程的执行
			} catch (InterruptedException e) {   //打断异常
				e.printStackTrace();  //追踪
			}
		}
		field.clear();
		
		
		
 
	}
 
}
