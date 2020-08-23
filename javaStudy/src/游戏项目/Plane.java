package 游戏项目;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import 游戏项目.Bullet.BULLET_TYPE;


public class Plane extends GameObject{

	static Image[] myplane=new Image[3];
	static Image enemy[]=new Image[4];
	static Image enemyboom[][]=new Image[4][6];
	static Image myplane1boom[]=new Image[9];
	static Image planeboss;
	Bullet[] bullets;
	enum PLANE_TYPE{
		BOSS,
		ENEMY,
		PLANE,
		ENEMY_BOOM,
		MYPLANE_BOOM
	}
//	int[] a=new int[3];
//	int[] b=new int[] {1,2,3};
//	int[] c= {1,2,3};
	static {
//		myplane[0]=GameUtils.getImage("images/bg.jpg");
		
		for(int i=0;i<3;i++) {
			myplane[i]=GameUtils.getImage("images/myplane"+(i+1)+".png");
//			myplane[i]=GameUtils.getImage("images/bg.jpg");
			
//		System.out.println(myplane[i]);
		}
		for(int i=0;i<9;i++) {
			myplane1boom[i]=GameUtils.getImage("images/myplane1boom"+(i+1)+".png");
		}
		for(int i=0;i<4;i++) {
			enemy[i]=GameUtils.getImage("images/enemy"+(i+1)+".png");
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<6;j++) {
				enemyboom[i][j]=GameUtils.getImage("images/enemy"+(i+1)+"boom"+(j+1)+".png");
			}	
		}
		planeboss=GameUtils.getImage("images/planeboss.png");	
	}
	
	int PlANE_WIDTH;
	int PlANE_HEIGHT;
	int type;
	int speed;
	int status=0;
	PLANE_TYPE planeType;
//	LogicThread logicThread;
	int paintIndex=0;
	int shootIndex=0;
	int index=0;
	Timer timer=new Timer();
	boolean right=false,left=false,up=false,down=false;
	public Plane(PLANE_TYPE planeType,int type) {
		this.type=type;
		this.planeType=planeType;
		switch (planeType) {
			case PLANE:
				this.speed=20;
				bullets=new Bullet[10];
				PlANE_WIDTH=myplane[0].getWidth(null);
				PlANE_HEIGHT=myplane[0].getHeight(null);
				this.x=GameFrame.MAIN_WIDTH/2-PlANE_WIDTH/2;
				this.y=GameFrame.MAIN_HEIGHT-PlANE_HEIGHT*2;
			break;
			case ENEMY:
				bullets=new Bullet[1];
				PlANE_WIDTH=enemy[0].getWidth(null);
				PlANE_HEIGHT=enemy[0].getHeight(null);
				randomMove();
			break;
			case BOSS:
				bullets=new Bullet[5];
				PlANE_WIDTH=planeboss.getWidth(null);
				PlANE_HEIGHT=planeboss.getHeight(null);
				randomMove();
			break;
			default:
				bullets=new Bullet[10];
				PlANE_WIDTH=myplane[0].getWidth(null);
				PlANE_HEIGHT=myplane[0].getHeight(null);
				this.x=GameFrame.MAIN_WIDTH/2-PlANE_WIDTH/2;
				this.y=GameFrame.MAIN_HEIGHT-PlANE_HEIGHT*2;
			break;
		}
		this.width=PlANE_WIDTH;
		this.height=PlANE_HEIGHT;
//		logicThread=new LogicThread();
//		logicThread.start();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
//				index++;
//				paintIndex=index;
			}
		}, 0, 500);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				shoot();
			}
		}, 0, 1000);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawSelf(Graphics g) {
		// TODO Auto-generated method stub
		move();
		for(int i=0;i<bullets.length;i++) {
			if(bullets[i]!=null) {
				bullets[i].drawSelf(g);	
				bullets[i].move(this.x+this.width/2, this.y+this.height/2);

			}
		}
		switch(planeType) {
		case PLANE:
			switch(type) {
			case 0:
				g.drawImage(myplane[0],x, y, null);
			break;
			case 1:
				g.drawImage(myplane[1],x, y, null);
			break;
			case 2:
				g.drawImage(myplane[2],x, y, null);
			break;
			}
		break;
		case ENEMY:
			switch(type) {
			case 0:
				g.drawImage(enemy[0],x, y, null);
			break;
			case 1:
				g.drawImage(enemy[1],x, y, null);
			break;
			case 2:
				g.drawImage(enemy[2],x, y, null);
			break;
			case 3:
				g.drawImage(enemy[3],x, y, null);
			break;
			}
		break;
		case BOSS:
			g.drawImage(planeboss,x, y, null);
		break;
		case ENEMY_BOOM:
			switch(type) {
			case 0:
				if(paintIndex<6) {
				g.drawImage(enemyboom[0][paintIndex],x, y, null);
				}
			break;
			case 1:
				if(paintIndex<6) {
					g.drawImage(enemyboom[1][paintIndex],x, y, null);
					}
			break;
			case 2:
				if(paintIndex<6) {
					g.drawImage(enemyboom[2][paintIndex],x, y, null);
					}
			break;
			case 3:
				if(paintIndex<6) {
					g.drawImage(enemyboom[3][paintIndex],x, y, null);
					}
			break;
			}
		break;	
		case MYPLANE_BOOM:
			if(paintIndex<9) {
				g.drawImage(myplane1boom[paintIndex],x, y, null);
				}
		break;	
		}
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(this.status==0) {
				switch (planeType) {
				case PLANE:
					if(up) {
						if(this.y-this.speed>=0)this.y-=this.speed;
					}
					if(down) {
						if(this.y+this.speed+this.height<=GameFrame.MAIN_HEIGHT)this.y+=this.speed;
					}
					if(left) {
						if(this.x-this.speed>=0)this.x-=this.speed;
					}
					if(right) {
						if(this.x+this.speed+this.width<=GameFrame.MAIN_WIDTH)this.x+=this.speed;
					}
				break;
				case ENEMY:
					if(up) {
						if(this.y-this.speed>=0)this.y-=this.speed;
					}
					if(down) {
						if(this.y+this.speed+this.height<=GameFrame.MAIN_HEIGHT)this.y+=this.speed;
						else this.y=0;
					}
					if(left) {
						if(this.x-this.speed>=0)this.x-=this.speed;
					}
					if(right) {
						if(this.x+this.speed+this.width<=GameFrame.MAIN_WIDTH)this.x+=this.speed;
					}
				break;
				case BOSS:
				break;
				default:
					if(up) {
						if(this.y-this.speed>=0)this.y-=this.speed;
					}
					if(down) {
						if(this.y+this.speed+this.height<=GameFrame.MAIN_HEIGHT)this.y+=this.speed;
					}
					if(left) {
						if(this.x-this.speed>=0)this.x-=this.speed;
					}
					if(right) {
						if(this.x+this.speed+this.width<=GameFrame.MAIN_WIDTH)this.x+=this.speed;
					}
				break;
			}
		}
		
	}
	@Override
	public void keyDown(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			right=true;
		}
	}
	@Override
	public void keyUp(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			right=false;
		}
	}
//	class LogicThread extends Thread{
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			Timer timer=new Timer();
//			timer.schedule(new TimerTask() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					shoot();
//				}
//			}, 0, 1000);
//		}
//	}
	public void shoot() {
		if(this.status==0) {
			for(int i=0;i<bullets.length;i++) {
				if(bullets[i]==null) {
					bullets[i]=new Bullet(x+width/2, y+height/2,BULLET_TYPE.PLANE);
					break;
				}
			}
			for(int i=0;i<bullets.length;i++) {
				if(bullets[i]!=null) {
					switch (planeType) {
					case PLANE:
						bullets[i].up=true;
					break;
					case ENEMY:
						bullets[i].down=true;
					break;
					case BOSS:
						bullets[i].down=true;
					break;
					default:
					break;
					}
					
				}
			}
		}
	}
	public void collision(Plane plane) {
		if(this.status==0) {
			if(this.getRect().intersects(plane.getRect())) {
				this.status=1;
			}
			for(int i=0;i<plane.bullets.length;i++) {
				System.out.println(plane.bullets.length);
				if(plane.bullets[i]!=null) {
					if(this.getRect().intersects(plane.bullets[i].getRect())){
						this.status=1;
					}
				}
			}
		}
		if(this.status==1) {
			switch (planeType) {
			case PLANE:
				if(paintIndex>=9) {paintIndex=0;this.x=GameFrame.MAIN_WIDTH/2-PlANE_WIDTH/2;
				this.y=GameFrame.MAIN_HEIGHT-PlANE_HEIGHT*2;this.planeType=PLANE_TYPE.PLANE;this.status=0;}
				else {paintIndex++;this.planeType=PLANE_TYPE.MYPLANE_BOOM;}
			break;
			case ENEMY:
				if(paintIndex>=6) {paintIndex=0;this.y=0;
				this.planeType=PLANE_TYPE.ENEMY;this.status=0;}
				else {paintIndex++;this.planeType=PLANE_TYPE.ENEMY_BOOM;
}
			break;
			case BOSS:
			break;
			default:
			break;
			}
		}
	}
	public void randomMove() {
		if(this.status==0) {
		this.down=true;
			Random rand=new Random();
			y=0;
			speed=3;
			x=rand.nextInt(GameFrame.MAIN_WIDTH-PlANE_WIDTH);
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(rand.nextInt()%2==0) {left=true;right=false;}
					else {right=true;left=false;}
				}
			}, 0,2000);
		}
	}
}
