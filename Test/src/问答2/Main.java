package ÎÊ´ð2;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	static final int MAIN_WIDTH=500;
	static final int MAIN_HEIGHT=500;
	RoverCoordinator roverCoordinator=new RoverCoordinator();
	Rover rover1=new Rover(1, 1, 2,"N");
	Rover rover2=new Rover(2, 3, 3,"E");
	public Main() {
		
		roverCoordinator.setMaxX(5);
		roverCoordinator.setMaxY(5);
		roverCoordinator.addRover(rover1);
		roverCoordinator.addRover(rover2);
		roverCoordinator.action(rover1.getId(),"LMLMLMLMM");
		roverCoordinator.action(rover2.getId(),"MMRMMRMRRM");
		System.out.println(rover1);
		System.out.println(rover2);
		this.setVisible(true);
		new Mythread().start();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		roverCoordinator.draw(g);
	}
	class Mythread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		JFrame f=new JFrame("»ðÐÇ³µ");
		f.setSize(MAIN_WIDTH, MAIN_HEIGHT);
		Main roverMap=new Main();
		f.setContentPane(roverMap);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		
	}
}
