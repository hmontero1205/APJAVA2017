package gui.sampleGames;

import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class MyScreen extends Screen {
	private TextLabel tLabel;
	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		tLabel = new TextLabel(30, 30, 250, 300, "This is MyScreen!");
		System.out.println("MyScreen created");
		viewObjects.add(tLabel);

	}

}
