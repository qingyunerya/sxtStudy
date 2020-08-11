package ÎÊ´ð2;

import java.awt.Color;
import java.awt.Graphics;

public class Rover{
	private int id ;
	private int x;
	private int y;
	private String direction;
	
	public Rover(int id, int x, int y, String direction) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public void action(char command) 
	{
		switch(command) {
			case 'L':
				switch(this.direction) {
				case "N":
					this.direction="W";
				break;
				case "S":
					this.direction="E";
				break;	
				case "W":
					this.direction="S";
				break;
				case "E":
					this.direction="N";
				break;
				}
			break;
			case 'R':
				switch(this.direction) {
				case "N":
					this.direction="E";
				break;
				case "S":
					this.direction="W";
				break;	
				case "W":
					this.direction="N";
				break;
				case "E":
					this.direction="S";
				break;
				}
			break;	
			case 'M':
				switch(this.direction) {
				case "N":
					this.y--;
				break;
				case "S":
					this.y++;
				break;	
				case "W":
					this.x--;
				break;
				case "E":
					this.x++;
				break;
				}
			break;
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
