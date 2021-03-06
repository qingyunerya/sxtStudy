package 游戏项目;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import 游戏项目.Plane.PLANE_TYPE;


public class GameFrame extends JPanel implements KeyListener{

	static Image bg=GameUtils.getImage("images/bg.jpg");
	static final int MAIN_WIDTH=bg.getWidth(null);
	static final int MAIN_HEIGHT=bg.getHeight(null);
	Plane plane=new Plane(PLANE_TYPE.PLANE,0);
	Plane enemy=new Plane(PLANE_TYPE.ENEMY,0);
	public GameFrame() {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		this.setSize(MAIN_WIDTH,MAIN_HEIGHT);
//		this.setSize(bg.getHeight(null),bg.getWidth(null));
		//this.setLocationRelativeTo(null);
		
		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		this.addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				//System.out.println(getContentPane().getSize().height);
////				titleHight=Constant.GAME_HIGHT-getContentPane().getSize().height;
////				JFrame f=new JFrame();
////				f.setBounds(0,0,100,100);
////				setContentPane(f);
//				
//			}
//		});
	//	this.addKeyListener(new GameMonitor());
//		new PaintThread().start();
		Timer timer =new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				repaint();
			}
		}, 0, 40);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				plane.collision(enemy);
				enemy.collision(plane);
			}
		}, 0, 500);
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		g.drawLine(titleHight, 0, 500, 500);
		//g.drawRect(0, 0, 500,500);
//		g.drawOval(0, 0, 100, 100);
//		Color c=g.getColor();
////		g.setColor(Color.black);
//		g.drawString("fdfdffs", 100, 100);
	//	g.fillArc(0, 0, 100, 100, 30, 90);
		g.drawImage(bg,0,0,null );
		plane.drawSelf(g);
		enemy.drawSelf(g);
		
		
//		g.drawImage(myplane1,x,y,null );
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
//		update(getGraphics());
	}
	
//	class PaintThread extends Thread{
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			super.run();
//			while(true) {
//				repaint();
//				try {
//					Thread.sleep(40);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		}
//	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame gf=new GameFrame();
		JFrame f=new JFrame("打飞机");
		f.setVisible(true);
		f.setSize(MAIN_WIDTH+f.getInsets().left+f.getInsets().right, MAIN_HEIGHT+f.getInsets().top+f.getInsets().bottom);
		f.setContentPane(gf);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.addKeyListener(gf);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		plane.keyDown(e);
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		plane.keyUp(e);
	}

}
