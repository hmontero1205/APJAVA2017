package gui.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class TextArea extends TextLabel {

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
	}

	public void update(Graphics2D g){
		FontMetrics fm = g.getFontMetrics();
		if(getText()!=null){
			String[] wordArr = this.getText().split(" ");
			String toPrint = "";
			int linesPrinted = 1;
			for(String s : wordArr){
				if(fm.stringWidth(toPrint) + fm.stringWidth(s) +fm.stringWidth(" ") < this.getWidth()){
					toPrint+=" "+s;
				}
				else{
					g.setColor(Color.black);
					System.out.println("Hey");
					g.drawString(toPrint, 4, linesPrinted * (fm.getAscent() + fm.getDescent()));
					linesPrinted++;
					toPrint = s;
					
					if((linesPrinted)*(fm.getAscent() + fm.getDescent()) > this.getHeight()){
						break;
					}
				}
			}
		}
	}
}
