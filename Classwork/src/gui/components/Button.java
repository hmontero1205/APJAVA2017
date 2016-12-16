package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable {

	private Color color;
	private Action action;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.color = color;
		this.action = action;
		update();
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setColor(Color c){
		this.color = c;
		update();
	}
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(),getHeight(), 25, 35);
		g.setColor(color.black);
		g.drawRoundRect(0, 0, getWidth(), getHeight()-1, 25, 35);
		super.update(g);
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		return ((x>this.getX() && x<(this.getX()+this.getWidth())) && (y>this.getY() && y<(this.getY()+this.getHeight())));
	}

	@Override
	public void act() {
		this.action.act();
	}
}
