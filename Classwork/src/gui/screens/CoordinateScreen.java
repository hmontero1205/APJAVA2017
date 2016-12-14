package gui.screens;

import java.awt.Color;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class CoordinateScreen extends Screen {
	private Button myButton;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		TextLabel text = new TextLabel(20,200,500,40,"Howdy");
		Button myButton = new Button(50,70,100,30,"Button",Color.red, new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});

		viewObjects.add(text);
		viewObjects.add(myButton);
		
	}

}
