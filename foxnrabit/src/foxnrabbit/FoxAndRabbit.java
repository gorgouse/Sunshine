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
					theField.place(row, col, new Fox());    //�ź����ȥ
				} else if ( probability < 0.15 ) {
					theField.place(row, col, new Rabbit());  //�����ӽ�ȥ
				} 
			}
		}
		theView = new View(theField);//frame��һ��������,view�൱��һ���������������ӵ�������������
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(theView);//���벿����Ĭ�ϼӵ�BorderLayout.CENTER,ͬ��λ������ᱻ����
		
		JButton btnStep =new JButton("����");
		frame.add(btnStep,BorderLayout.NORTH);
		
		//��������new�����ʱ���������Ķ����γ��������࣬��������Լ̳�ĳ�࣬Ҳ����ʵ�ֽӿ�
		//һ����ť��������ȥ��Actionlistener������button����ע�ᣬbutton�ᷴ�������� actionlistener����ĺ���            
		btnStep.addActionListener(new ActionListener () {
			
			@Override    
			public void actionPerformed(ActionEvent e) {//����ִ�� 
				System.out.println("������");
				step();
				frame.repaint();
			}
			
		}   );
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public void start(int steps) {
		for ( int i=0; i<steps; i++ ) {  //��һ�ٴ�
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
				//��ʵ���cell��rabbit����fox�Ķ�����Ϊ����ʵ����cell��һ��Ҫ��ʵ��cell�������
				//������ʵ����cell����Ķ��󶼿��Ա��ŵ�field��ͷȥ��
				Cell cell = theField.get(row, col);//��ʵ����fox/rabbit = theField.get(row, col);
				                                  //Ҳ����ʲô��û��
				if ( cell != null ) {
					Animal animal = (Animal)cell;  //����  ��ֻ�е�cell��ʵ�ʹ�������Animal����
					animal.grow();
					if ( animal.isAlive() ) {
						
						//	move
						Location loc = animal.move(theField.getFreeNeighbour(row, col));   
						if ( loc != null ) {            //��һ���ĸ����ڿյ��ھ����ƶ�
							theField.move(row, col, loc);
						}
						
						//	eat
//						animal.eat(theField);
						Cell[] neighbour = theField.getNeighbour(row, col);
						ArrayList<Animal> listRabbit = new ArrayList<Animal>();
						for ( Cell an : neighbour ) {
							if ( an instanceof Rabbit ) {   //�ж��ǲ���rabbit��һ������
								listRabbit.add((Rabbit)an);  //����
							}
						}
						if ( !listRabbit.isEmpty() ) {
							Animal fed = animal.feed(listRabbit);   //���������feed(listRabbit)���ø���ʲôҲ����
							if ( fed != null ) {                   //����Ǻ���͵�������������Ϊ�����feed��override
								theField.remove((Cell)fed);    //���ر��ԵĶ������Ƴ�
							}
						}
						//	breed
						Animal baby = animal.breed();
						if ( baby != null ) {
							theField.placeRandomAdj(row, col, (Cell)baby);  //����
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


