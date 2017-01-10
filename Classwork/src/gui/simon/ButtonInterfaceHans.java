package gui.simon;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceHans extends Clickable {
	public void setAction(Action a);

	public void turnOn();

	public void turnOff();

	public void setColor(Color c);

	public Color getColor();

	public void setCoords(int i, int j);
}
