package ÓÎÏ·ÏîÄ¿;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class GameObject{

	static final int OBJECT_SPEED=0;
	static final int OBJECT_WIDTH=0;
	static final int OBJECT_HEIGHT=0;
	static final int OBJECT_DEGREE=0;
	int x;
	int y;
	int width;
	int height;
	int speed;
	int degree;
	Image img;
	boolean left=false,right=false,up=false,down=false;
	public GameObject(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.width = OBJECT_WIDTH;
		this.height = OBJECT_HEIGHT;
		this.speed = OBJECT_SPEED;
		this.degree=OBJECT_DEGREE;
	}
	public GameObject(int x, int y, int width, int height, int speed,int degree) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.degree=degree;
	}
	public GameObject(Image img,int x, int y) {
		super();
		this.img=img;
		this.x = x;
		this.y = y;
		this.width = OBJECT_WIDTH;
		this.height = OBJECT_HEIGHT;
		this.speed = OBJECT_SPEED;
		this.degree=OBJECT_DEGREE;
	}
	public GameObject(Image img,int x, int y, int width, int height, int speed,int degree) {
		super();
		this.img=img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.degree=degree;
	}
	public GameObject(Image img,int x, int y,int speed,int degree) {
		super();
		this.img=img;
		this.x = x;
		this.y = y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.speed=speed;
		this.degree=degree;
	}
	public void drawSelf(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval(x, y, OBJECT_WIDTH, OBJECT_HEIGHT);
		g.setColor(c);
	}
	public void ObjectMove(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
		}
	}
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
}
