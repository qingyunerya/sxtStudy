package ÓÎÏ·ÏîÄ¿;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class GameObject{

	int x;
	int y;
	int width;
	int height;
	Image img;
	public GameObject(Image img,int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img=img;
	}
	public GameObject() {
		super();
	}
	public void drawSelf(Graphics g) {
		
	}
	public void keyUp(KeyEvent e) {
		
	}
	public void keyDown(KeyEvent e) {
		
	}
	public void move() {
		
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
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
}
