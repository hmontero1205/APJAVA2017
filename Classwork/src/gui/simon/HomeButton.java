package gui.simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;

public class HomeButton extends Component implements ButtonInterfaceHans {

	private Action action;
	private Color c;
	private int x;
	private int y;
	private boolean isOn;

	public HomeButton(int x, int y) {
		super(x,y,60,60);
		isOn = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isHovered(int x, int y) {
		return ((x>this.getX() && x<(this.getX()+this.getWidth())) && (y>this.getY() && y<(this.getY()+this.getHeight())));
	}

	@Override
	public void act() {
		this.action.act();

	}

	@Override
	public void setAction(Action a) {
		this.action = a;

	}

	@Override
	public void turnOn() {
		isOn = true;
		update();

	}

	@Override
	public void turnOff() {
		isOn = false;
		update();

	}

	@Override
	public void setColor(Color c) {
		this.c = c;

	}

	@Override
	public Color getColor() {
		return c;
	}

	@Override
	public void setCoords(int x, int y) {
		this.x = x;
		setX(x);
		setY(y);
		this.y = y;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(isOn)
			g.setColor(this.c);
		else
			g.setColor(Color.gray);
		g.fillOval(this.x, this.y, 55, 55);
		g.setColor(Color.black);
		g.drawOval(this.x, this.y, 55, 55);

	}
	

}
