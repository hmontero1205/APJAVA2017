package gui.whackAMole;

import gui.components.Action;
import gui.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleInterface {


	private int appearanceTime;

	public Mole(int x,int y) {
		super(x, y, .9, "resources/sampleImages/mole.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAppearanceTime() {
		return appearanceTime;
	}

	@Override
	public void setAppearanceTime(int i) {
		appearanceTime = i;

	}

}
