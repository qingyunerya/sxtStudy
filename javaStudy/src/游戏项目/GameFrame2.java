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

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;


public class GameFrame2 extends JPanel implements KeyListener{

	static Image bg=GameUtils.getImage("images/bg.jpg");
	static final int MAIN_WIDTH=bg.getWidth(null);
	static final int MAIN_HEIGHT=bg.getHeight(null);
	int x=100,y=100;
	
	Image myplane1=GameUtils.getImage("images/myplane1.png");
	//GameObject3 obj=new GameObject3(myplane1,100, 100);
//	GameObject ga2=new GameObject(100, 100, 20, 20);
	public GameFrame2() {
		// TODO Auto-generated constructor stub
		//this.setTitle("打飞机");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDRH,Constant.GAME_HIGHT);
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
		new PaintThread().start();
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
//		ga2.drawSelf(g);
		
//		g.drawImage(myplane1,x,y,null );
	}
	private Image offScreenImage=null;
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
//		update(getGraphics());
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		System.out.println("按下了sdfsdw键");
		if(offScreenImage==null) {
			offScreenImage=this.createImage(1000, 1000);
			Graphics offG=offScreenImage.getGraphics();
			paint(offG);
			offG.dispose();
			g.drawImage(offScreenImage,0,0,this);
			System.out.println("按下了sdfsdw键");
		} 
	}
	class GameMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class PaintThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
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
		// TODO Auto-generated method stub
		GameFrame2 gf=new GameFrame2();
		
//		JFrame ff=new JFrame();
//		ff.setContentPane(gf);
//		ff.setVisible(true);
//		ff.setBounds(0, 0, 1000, 1000);
//		ff.addKeyListener(gf);
//		gf.setFocusable(true);
		//System.out.println(MAIN_WIDTH+""+MAIN_HEIGHT+""+(MAIN_HEIGHT+f.getInsets().top));
//		Main roverMap=new Main();
//		f.setContentPane(roverMap);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setLocationRelativeTo(null);
		
		JFrame f=new JFrame("打飞机");
		f.setVisible(true);
		f.setSize(MAIN_WIDTH, MAIN_HEIGHT+f.getInsets().top);
		f.setContentPane(gf);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.addKeyListener(gf);

	
		
		
//		Class zz = null;
//		try {
//			zz = Class.forName("游戏项目.GameFrame$GameMonitor");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(zz);
//		for (Method string : zz.getMethods()) {
//			System.out.println(string.getName());
//		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		ga2.ObjectMove(e);
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
