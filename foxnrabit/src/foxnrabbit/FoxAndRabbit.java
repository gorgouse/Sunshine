package foxnrabbit;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import animal.Animal;
import animal.Fox;
import animal.Rabbit;
import cell.Cell;
import field.Field;
import field.Location;
import field.View;

public class FoxAndRabbit {
	private Field theField;
	private View theView;
	JFrame frame;
	
	public FoxAndRabbit(int size) {
		theField = new Field(size, size);
		
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			for ( int col = 0; col<theField.getWidth(); col++ ) {
				double probability = Math.random();
				if ( probability < 0.05 ) {
					theField.place(row, col, new Fox());    //放狐狸进去
				} else if ( probability < 0.15 ) {
					theField.place(row, col, new Rabbit());  //放兔子进去
				} 
			}
		}
		theView = new View(theField);//frame是一个大容器,view相当于一个容器，容器被加到其他的容器中
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(theView);//加入部件，默认加到BorderLayout.CENTER,同种位置组件会被覆盖
		
		JButton btnStep =new JButton("单步");
		frame.add(btnStep,BorderLayout.NORTH);
		
		//匿名类在new对象的时候给出的类的定义形成了匿名类，匿名类可以继承某类，也可以实现接口
		//一旦按钮被安安下去，Actionlistener对象在button里面注册，button会反过来调用 actionlistener对象的函数            
		btnStep.addActionListener(new ActionListener () {
			
			@Override    
			public void actionPerformed(ActionEvent e) {//动作执行 
				System.out.println("按下啦");
				step();
				frame.repaint();
			}
			
		}   );
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public void start(int steps) {
		for ( int i=0; i<steps; i++ ) {  //做一百次
			step();
			theView.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void step() {
		for ( int row = 0; row< theField.getHeight(); row++ ) {
			for ( int col = 0; col < theField.getWidth(); col++ ) {
				//其实这个cell是rabbit或者fox的对象，因为它们实现了cell，一定要有实现cell的类才行
				//（所有实现了cell的类的对象都可以被放到field里头去）
				Cell cell = theField.get(row, col);//其实就是fox/rabbit = theField.get(row, col);
				                                  //也可能什么都没有
				if ( cell != null ) {
					Animal animal = (Animal)cell;  //造型  （只有当cell的实际管理者是Animal才行
					animal.grow();
					if ( animal.isAlive() ) {
						
						//	move
						Location loc = animal.move(theField.getFreeNeighbour(row, col));   
						if ( loc != null ) {            //按一定的概率在空的邻居中移动
							theField.move(row, col, loc);
						}
						
						//	eat
//						animal.eat(theField);
						Cell[] neighbour = theField.getNeighbour(row, col);
						ArrayList<Animal> listRabbit = new ArrayList<Animal>();
						for ( Cell an : neighbour ) {
							if ( an instanceof Rabbit ) {   //判断是不是rabbit的一个对象
								listRabbit.add((Rabbit)an);  //造型
							}
						}
						if ( !listRabbit.isEmpty() ) {
							Animal fed = animal.feed(listRabbit);   //如果是兔子feed(listRabbit)调用父类什么也不干
							if ( fed != null ) {                   //如果是狐狸就调用自身函数，因为狐狸的feed是override
								theField.remove((Cell)fed);    //返回被吃的对象，再移除
							}
						}
						//	breed
						Animal baby = animal.breed();
						if ( baby != null ) {
							theField.placeRandomAdj(row, col, (Cell)baby);  //造型
						}
					} else {
						theField.remove(row, col);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		FoxAndRabbit fnr = new FoxAndRabbit(50);
//		fnr.start(250);
	}

}


