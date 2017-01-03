package gui.screens;

import java.awt.Color;
import java.util.ArrayList;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class ClickableScreenExample extends ClickableScreen {
	private TextLabel tLabel3;
	private Button myBut3;
	public ClickableScreenExample(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> obList) {
		tLabel3= new TextLabel(10,50, 900, 20, "This is a Screen that extends the ClickableScreen class.");
		myBut3 = new Button(10,70,250,30,"Return to Robbie Rotten",Color.gray, new Action(){

			@Override
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.cs);
			}
			
			});
		obList.add(tLabel3);
		obList.add(myBut3);

	}

}
