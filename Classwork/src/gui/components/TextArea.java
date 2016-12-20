package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class TextArea extends TextLabel {

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
	}

	public void update(Graphics2D g){
		FontMetrics fm = g.getFontMetrics();
		//g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
		if(getText()!=null){
			String[] wordArr = this.getText().split(" ");
			String toPrint = "";
			int linesPrinted = 1;
			for(int i=0;i<wordArr.length;i++){
				if(fm.stringWidth(toPrint) + fm.stringWidth(wordArr[i]) +fm.stringWidth(" ") < this.getWidth()-5){
					switch(i){
						case 0: toPrint+=wordArr[i]; break;
						default: toPrint+=" "+wordArr[i]; break;
					}
					if(i==wordArr.length-1){
						g.setColor(Color.black);
						System.out.println("Hey!");
						g.drawString(toPrint, 5, linesPrinted * (fm.getAscent() + fm.getDescent()));
					}
				}
				else{
					g.setColor(Color.black);
					System.out.println("Hey");
					g.drawString(toPrint, 5, linesPrinted * (fm.getAscent() + fm.getDescent()));
					linesPrinted++;
					toPrint =wordArr[i];
					
					if((linesPrinted)*(fm.getAscent() + fm.getDescent()) > this.getHeight()){
						break;
					}
				}
			}
		}
	}
}
