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

import javax.swing.JFrame;

public class GameFrame extends Frame{

	int titleHight=0;
	int x=100,y=100;
	Image bg=GameUtils.getImage("images/bg.jpg");
	Image myplane1=GameUtils.getImage("images/myplane1.png");
	//GameObject obj=new GameObject(myplane1,100, 100);
	
	public void luanchGameFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("打飞机");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDRH,Constant.GAME_HIGHT);
//		this.setSize(bg.getHeight(null),bg.getWidth(null));
		this.setLocationRelativeTo(null);
		
		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(getContentPane().getSize().height);
//				titleHight=Constant.GAME_HIGHT-getContentPane().getSize().height;
//				JFrame f=new JFrame();
//				f.setBounds(0,0,100,100);
//				setContentPane(f);
				
			}
		});
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()) {
				case KeyEvent.VK_W:
					System.out.println("按下了w键");
					y++;
				break;
				case KeyEvent.VK_S:
					System.out.println("按下了w键");
					y--;
				break;
				case KeyEvent.VK_A:
					System.out.println("按下了w键");
					x--;
				break;
				case KeyEvent.VK_D:
					System.out.println("按下了w键");
					x++;
				break;
				}
				repaint();
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		super.paint(g);
//		g.drawLine(titleHight, 0, 500, 500);
//		g.drawRect(0, 0, 100, 100);
//		g.drawOval(0, 0, 100, 100);
//		Color c=g.getColor();
////		g.setColor(Color.black);
//		g.drawString("fdfdffs", 100, 100);
//		g.fillArc(0, 0, 100, 100, 30, 90);
		g.drawImage(bg,0,0,null );
		g.drawImage(myplane1,x,y,null );
	}
	private Image offScreenImage=null;
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		if(offScreenImage==null) {
			offScreenImage=this.createImage(500, 500);
			Graphics offG=offScreenImage.getGraphics();
			paint(offG);
			g.drawImage(offScreenImage,0,0,null);
			
		} 
		
	}
	class GameMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
				case KeyEvent.VK_W:
					System.out.println("按下了w键");
					y++;
				break;
				case KeyEvent.VK_S:
					System.out.println("按下了w键");
					y--;
				break;
				case KeyEvent.VK_A:
					System.out.println("按下了w键");
					x--;
				break;
				case KeyEvent.VK_D:
					System.out.println("按下了w键");
					x++;
				break;
			}	
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				System.out.println("释放了w键");
			break;
		}
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame gf=new GameFrame();
		gf.luanchGameFrame();
		
	}

}
