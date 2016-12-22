package gui.components;

import java.awt.image.BufferedImage;

import gui.components.Action;

public class ClickableGraphic extends Graphic implements Clickable {
	
	private BufferedImage image;
	private boolean loadedImages;
	private int x;
	private int y;
	private Action action;
	
	public ClickableGraphic(int x, int y, String imageLocation, Action action) {
		super(x, y, imageLocation);
		setAction(action);
	}

	public ClickableGraphic(int x, int y, int w, int h, String imageLocation, Action action) {
		super(x, y, w, h, imageLocation);
		setAction(action);	
	}

	public ClickableGraphic(int x, int y, double scale, String imageLocation, Action action) {
		super(x, y, scale, imageLocation);
		setAction(action);
	}


	@Override
	public boolean isHovered(int x, int y) {
		return ((x>this.getX() && x<(this.getX()+this.getWidth())) && (y>this.getY() && y<(this.getY()+this.getHeight())));

	}

	@Override
	public void act() {
		if(this.action!=null)
			this.action.act();

	}
	
	public void setAction(Action a){
		this.action = a;
	}

}
