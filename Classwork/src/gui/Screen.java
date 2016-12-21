package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Visible;

public abstract class Screen {
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	public Screen(int width,int height){
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width,height);
	}
	public void initImage(int width, int height) {
		image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		update();
		
	}
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(204,204,255));
		g.fillRect(0,0,image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		for(int i = 0; i<viewObjects.size(); i++){
//			
//		}
		for(Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
		
	}
	public abstract void initObjects(ArrayList<Visible> viewObjects);
	public int getWidth(){
		return image.getWidth();
	}
	public int getHeight(){
		return image.getHeight();
	}
	public BufferedImage getImage(){
		return image;
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	public MouseListener getMouseListener(){
		return null;
	}

}
