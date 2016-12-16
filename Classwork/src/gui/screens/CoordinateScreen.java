package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener {
	private Button myButton;
	private TextLabel text;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20,200,500,40,"Howdy");
		myButton = new Button(50,70,100,30,"Button button button button",Color.red, new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});

		viewObjects.add(text);
		viewObjects.add(myButton);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		text.setText("Mouse @ ("+mx+","+my+")");
		
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

}
