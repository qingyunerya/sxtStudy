package ������;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SmallTool extends JFrame{

	public SmallTool() {
		this.setTitle("С����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setVisible(true);
		
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) throws Exception {
		SmallTool tool=new SmallTool();
	}

}
