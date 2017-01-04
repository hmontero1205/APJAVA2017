package gui.whackAMole;

import gui.GUIApplication;

public class WhackAMoleGame extends GUIApplication {

	public static WhackAMoleGame moleGame;
	public static WhackAMoleScreen moleScreen;
	
	public WhackAMoleGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		moleScreen =  new WhackAMoleScreen(getWidth(),getHeight());
		setScreen(moleScreen);

	}

	public static void main(String[] args) {
		moleGame = new WhackAMoleGame(800,600);
		Thread app = new Thread(moleGame);
		app.start();

	}
	
	

}
