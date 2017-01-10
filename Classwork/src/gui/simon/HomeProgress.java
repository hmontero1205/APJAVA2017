package gui.simon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;

public class HomeProgress extends Component implements ProgressInterfaceHans {
	private int round;
	private int length;
	private boolean gameOver;
	
	public HomeProgress() {
		super(400,40,200,100);
		gameOver = false;
	}

	@Override
	public void updateInfo(int roundNum, int i) {
		this.round = roundNum;
		this.length = i;
		update();
		
	}

	@Override
	public void setGameOver() {
		gameOver = true;
		update();
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
		if(gameOver){
			g.setColor(Color.red);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);	
			g.drawString("lmao you're doneeee",5,35);
			g.drawString("Round: "+round,5,55);
			g.drawString("Sequence Length: "+length,5,75);
		}
		else{
			g.setColor(Color.gray);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);
			
			g.drawString("Round:"+round,5,35);
			g.drawString("Sequence Length:"+length,5,65);
			
		}
		
	}

}
