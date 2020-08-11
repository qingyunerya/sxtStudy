package 问答2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoverCoordinator{
	static final int RECT_WIDTH=40;
	private Map<Integer,Rover> roverMap;
	private int maxX;
	private int maxY;
	public RoverCoordinator() {
		roverMap =new HashMap<Integer, Rover>();
		
	}
	public void addRover(Rover rover) {
		roverMap.put(rover.getId(),rover);
		checkOutOfRange();
	}
	public void action(int id ,String commandSequence) {
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(int i=0;i<commandSequence.length();i++) {
							System.out.println(roverMap.get(id).getX()+" "+roverMap.get(id).getY()+" "+roverMap.get(id).getDirection()+" "+String.valueOf(commandSequence.charAt(i)));
							roverMap.get(id).action(commandSequence.charAt(i));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				).start();
		
	}
	private void checkOutOfRange() {
		for (Integer key: roverMap.keySet()) {
			Rover rover=roverMap.get(key);
			if(rover.getX()>this.maxX||rover.getY()>this.getMaxY()||rover.getX()<1||rover.getY()<1) {
				throw new RuntimeException("越界异常");
			}
		}
	}
	public void draw(Graphics g) {
		int startX=Main.MAIN_WIDTH/2-this.getMaxX()*(RECT_WIDTH+5)/2;
		int startY=Main.MAIN_HEIGHT/2-this.getMaxY()*(RECT_WIDTH+5)/2;
		for(int i=0;i<this.maxY;i++) {
			for(int j=0;j<this.maxX;j++) {
				Color c=g.getColor();
				g.setColor(Color.yellow);
				g.fillRect(startX+i*(RECT_WIDTH+5),startY+j*(RECT_WIDTH+5), RECT_WIDTH, RECT_WIDTH);
				g.setColor(Color.black);
				g.drawString("("+(i+1)+","+(j+1)+")",startX+i*(RECT_WIDTH+5)+RECT_WIDTH/4 ,startY+j*(RECT_WIDTH+5)+RECT_WIDTH/2);
				g.setColor(c);
				
			}
		}
		Color c=g.getColor();
		for (Integer key: roverMap.keySet()) {
			Rover rover=roverMap.get(key);
			g.setColor(Color.red);
			//g.fillArc(rover.getX()*(RECT_WIDTH+5)+startX,rover.getY()*(RECT_WIDTH+5)+startY, 100, 100, 60, 60);
			g.fillRect((rover.getX()-1)*(RECT_WIDTH+5)+startX,(rover.getY()-1)*(RECT_WIDTH+5)+startY, RECT_WIDTH, RECT_WIDTH);
			g.setColor(Color.black);
			g.drawString("("+rover.getDirection()+rover.getId()+")",startX+(rover.getX()-1)*(RECT_WIDTH+5)+RECT_WIDTH/4 ,startY+(rover.getY()-1)*(RECT_WIDTH+5)+RECT_WIDTH/2);
		}
		g.setColor(c);
	}
	public Map<Integer, Rover> getRoverMap() {
		return roverMap;
	}
	public void setRoverMap(Map<Integer, Rover> roverMap) {
		this.roverMap = roverMap;
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	
}
