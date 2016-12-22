package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;
import gui.components.Component;
import gui.components.Graphic;

public class SportaflopScreen extends Screen implements MouseListener, MouseMotionListener {
	private TextLabel tLabel;
	private Button myBut2;
	private Graphic sportaflop;
	public SportaflopScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		tLabel = new TextLabel(20,30,500,40, "Oh NOoOooooo it is sportaflop!");
		sportaflop = new Graphic(100,100,"resources/sampleImages/sportaflop.png");
		myBut2 = new Button(15,525,300,35,"Go back to Robbie Rotten PLS",Color.gray, new Action(){

			@Override
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.cs);
			}
			
		});
		viewObjects.add(tLabel);
		viewObjects.add(myBut2);
		viewObjects.add(sportaflop);

	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
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
		if(myBut2.isHovered(e.getX(), e.getY())){
			myBut2.act();
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
