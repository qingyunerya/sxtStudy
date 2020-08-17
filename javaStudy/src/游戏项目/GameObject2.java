package ÓÎÏ·ÏîÄ¿;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class GameObject2{

	int x;
	int y;
	int width;
	int height;
	
	public GameObject2(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void drawSelf(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		g.setColor(c);
	}
	public void ObjectMove(KeyEvent e) {
//		if(e.getKeyCode()==KeyEvent.VK_UP) {
//			x++;
//		}
//		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
//			y
//		}
//		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
//			
//		}
//		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
//			
//		}
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			y--;
		break;
		case KeyEvent.VK_S:
			y++;
		break;
		case KeyEvent.VK_A:
			x--;
		break;
		case KeyEvent.VK_D:
			x++;
		break;
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
}
