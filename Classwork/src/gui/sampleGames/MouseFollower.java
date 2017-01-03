package gui.sampleGames;

import gui.GUIApplication;
import gui.screens.ClickableScreenExample;
import gui.screens.CoordinateScreen;
import gui.screens.SportaflopScreen;
import gui.screens.Stefan;

public class MouseFollower extends GUIApplication {
	
	public static CoordinateScreen cs;
	public static SportaflopScreen myScreen;
	public static Stefan stefanS;
	public static MouseFollower game;
	public static ClickableScreenExample cse;
	
	public MouseFollower(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		cs = new CoordinateScreen(getWidth(),getHeight());
		myScreen = new SportaflopScreen(getWidth(),getHeight());
		stefanS = new Stefan(getWidth(),getHeight());
		cse = new ClickableScreenExample(getWidth(),getHeight());
		setScreen(cs);

	}

	public static void main(String[] args) {
		game = new MouseFollower(800,600);
		Thread app = new Thread(game);
		app.start();
	}

}
