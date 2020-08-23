package ÓÎÏ·ÏîÄ¿;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class Bullet extends GameObject{

	static Image bullet=GameUtils.getImage("images/bullet.png");;

	static final int BULLET_WIDTH=bullet.getWidth(null);
	static final int BULLET_HEIGHT=bullet.getHeight(null);
	enum BULLET_TYPE{
		BOSS,
		ENEMY,
		PLANE
	}
	int speed;
	int status=0;
	boolean right=false,left=false,up=false,down=false;
	public Bullet(int x,int y ,BULLET_TYPE type) {
		this.x=x-BULLET_WIDTH/2;
		this.y=y-BULLET_HEIGHT/2;
		this.width=BULLET_WIDTH;
		this.height=BULLET_HEIGHT;
		this.speed=10;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bullet,x, y, null);
	}
	
	public void move(int planeX,int planeY) {
		// TODO Auto-generated method stub
		if(up) {
			if(this.y-this.speed>=0)this.y-=this.speed;
			else {this.y=planeY-BULLET_HEIGHT/2;this.x=planeX-BULLET_WIDTH/2;}
		}
		if(down) {
			if(this.y+this.speed+this.height<=GameFrame.MAIN_HEIGHT)this.y+=this.speed;
			else {this.y=planeY-BULLET_HEIGHT/2;this.x=planeX-BULLET_WIDTH/2;}
		}
		if(left) {
			if(this.x-this.speed>=0)this.x-=this.speed;
		}
		if(right) {
			if(this.x+this.speed+this.width<=GameFrame.MAIN_WIDTH)this.x+=this.speed;
		}
	}
}
