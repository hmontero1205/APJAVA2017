package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener {
	private Button myButton;
	private TextLabel text;
	private TextArea textArea;
	private Graphic robbieRotten;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(10,545,500,40,"Howdy");
		textArea = new TextArea(20,30,500,800,"Now listen closely. Here's a little lesson in trickery. This is going down in history. If you wanna be a villian number one, you'll have to chase a superhero on the run.");
//		myButton = new Button(50,70,100,30,"Button button button button",Color.red, new Action(){
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		robbieRotten = new Graphic(30,30,"resources/sampleImages/robbierotten.png");
		viewObjects.add(text);
		viewObjects.add(textArea);
		viewObjects.add(robbieRotten);
		//viewObjects.add(myButton);
		
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
