package gui.whackAMole;

import java.util.ArrayList;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;

public class WhackAMoleScreen extends ClickableScreen implements Runnable {

	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
    private TextLabel timeLabel;
	private double timeLeft;
	 
	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		
		label = new TextLabel(370, 270, 100, 50, "");
		timeLabel =  new TextLabel(30,30,100,50,"30.0");
		viewObjects.add(player);
		viewObjects.add(label);
		viewObjects.add(timeLabel);

	}
	
	/**
	*to implement later, after Character Team implements PlayerInterface
	*/
	private PlayerInterface getAPlayer() {
		return new Player();
	}

	/**
	*to implement later, after EnemyTeam implements MoleInterface
	*/
	private MoleInterface getAMole() {
		return new Mole((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
	}

	@Override
	public void run() {
		changeText("Ready...");
		changeText("Set...");
		changeText("Go!!!");
		changeText("");
		while(timeLeft>0){
			updateTimer();
			updateAllMoles();
			appearNewMole();
		}
	}

	public void appearNewMole() {
		double chance = (.1)*((60-timeLeft)/60);
		if(Math.random()<chance){
			final MoleInterface mole = getAMole();
			mole.setAppearanceTime((int)(500+Math.random()*2000));
			mole.setAction(new Action(){

				@Override
				public void act() {
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
					
				}
				
				
			});
			addObject(mole);
			moles.add(mole);
		}
		
	}

	public void updateAllMoles() {
		for(int i=moles.size()-1;i>-1;i--){
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime();
			m.setAppearanceTime(screenTime-100);
			if(m.getAppearanceTime()<=0){
				remove(m);
				moles.remove(m);
			}
		}
		
	}

	public void updateTimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeLeft-=.1;
		timeLabel.setText(""+(int)(timeLeft*10)/10.0);
				
		
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
