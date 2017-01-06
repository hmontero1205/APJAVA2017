package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Clickable;
import gui.components.ClickableGraphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;
import gui.components.Action;
import gui.components.Button;

public class Stefan extends Screen implements MouseListener, MouseMotionListener{
	private TextArea tArea;
	private TextLabel tLab;
	private ClickableGraphic stefan;
	private Button rottenBut;
	private int count = 0;

	public Stefan(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		tArea = new TextArea(15,40,450,180,"Click on Stefan to donate to Stefan's gofundme");
		tLab = new TextLabel(15,80,450,20,"Money Raised: $0");
		rottenBut = new Button(15,100,250,35,"Back to Robbie Rotten", Color.gray, new Action(){
			public void act(){
				 MouseFollower.game.setScreen(MouseFollower.cs);
			}
		});
		stefan = new ClickableGraphic(100,100,"resources/sampleImages/stefan.png");
		stefan.setAction(new Action(){
			public void act(){
				count++;
				tLab.setText("Money Raised: $"+Integer.toString(count));
			}
		});
		viewObjects.add(stefan);
		viewObjects.add(tArea);
		viewObjects.add(tLab);
		viewObjects.add(rottenBut);
		
	}
	public int getCount(){
		return count;
	}
	
	public void setCount(){
		count++;
	}
	public MouseListener getMouseListener(){
		return this;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(stefan.isHovered(e.getX(),e.getY())){
			stefan.act();
		}
		if(rottenBut.isHovered(e.getX(), e.getY())){
			rottenBut.act();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
