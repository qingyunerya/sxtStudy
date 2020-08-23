package ÓÎÏ·ÏîÄ¿;

import java.awt.Graphics;
import java.awt.Image;


public class Enemy extends GameObject3{

	static final int TYPE_MYPLANE=0;
	static final int TYPE_ENEMY1=1;
	int type;
	public Enemy(Image img, int x, int y,int type) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}

	static Image myplane[];
	static Image enemy[];
	static Image enemyboom[][];
	static Image myplane1boom[];
	static Image planeboss;
	static {
		
		for(int i=0;i<3;i++) {
			myplane[i]=GameUtils.getImage("images/myplane"+(i+1)+".png");
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
	
	@Override
	public void drawSelf(Graphics c) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
