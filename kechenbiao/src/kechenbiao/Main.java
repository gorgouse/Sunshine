package kechenbiao;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Main {

	public static void main(String[] args) {
		JFrame frame =new JFrame();
		JTable table = new JTable( new kechenbiao() );

		JScrollPane panel = new JScrollPane(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
	}

}
