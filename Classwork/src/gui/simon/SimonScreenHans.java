package gui.simon;

import java.awt.Color;
import java.util.ArrayList;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenHans extends ClickableScreen implements Runnable {

	private int roundNum;
	private boolean gameOver;
	private ArrayList<MoveInterfaceHans> moveList;
	private ProgressInterfaceHans progressBox;
	private TextLabel moveBox;
	private boolean playerMove;
	private ButtonInterfaceHans[] butArr;
	private int playerIndex;
	
	public SimonScreenHans(int width, int height) {
		super(width, height);
		roundNum = 0;
		Thread sGame = new Thread(this);
		playerMove = false;
		sGame.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		Color[] colArr = {Color.blue,Color.yellow,Color.cyan,Color.red};
		butArr = new ButtonInterfaceHans[4];
		moveBox = new TextLabel(300,400,400,40,"Get ready to play my son");
		progressBox = getProgressBox();
		for(int i=0;i<butArr.length;i++){
			butArr[i] = getAButton(10, 50+(60*i));
			ButtonInterfaceHans b = butArr[i];
			b.setColor(colArr[i]);
			b.setAction(new Action(){
				@Override
				public void act() {
					if(playerMove){
						Thread blinkThread = new Thread(new Runnable(){
							@Override
							public void run() {
								b.turnOn();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.turnOff();
								
							}
							
						});
					
						blinkThread.start();
						if(playerIndex<moveList.size()-1){
							if(b.getColor() == moveList.get(playerIndex).getButton().getColor()){
								playerIndex++;
							}
							else{
								progressBox.setGameOver();
								playerMove = false;
								System.out.println("game over");
							}
						}
						else{
							Thread sGame = new Thread(SimonScreenHans.this);
							sGame.start();
						}
					}
				}
			});
			viewObjects.add(b);
		}
		moveList = new ArrayList<MoveInterfaceHans>();
		moveList.add(getAMove());
		moveList.add(getAMove());
		viewObjects.add(moveBox);
		viewObjects.add(progressBox);
	}

	public MoveInterfaceHans getAMove(){
		return new HomeMove(butArr[(int)(Math.random()*butArr.length)]);
	}

	public ButtonInterfaceHans getAButton(int i, int j) {
		return new HomeButton(i,j);
	}

	public ProgressInterfaceHans getProgressBox() {
		return new HomeProgress();
	}
	
	

	public void run() {
		playerMove = false;
		moveList.add(getAMove());
		roundNum++;
		progressBox.updateInfo(roundNum,moveList.size());
		changeText("hold up B my turn");
		moveBox.setText("");
		System.out.println(moveList.size());
		blinkSequence();
		changeText("your turn dont mess up ok? xD");
		playerIndex = 0;
		moveBox.setText("");
		playerMove = true;	
		
	}

	public void blinkSequence() {
		for(MoveInterfaceHans m:moveList){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m.getButton().turnOn();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.getButton().turnOff();
		}
	}

	public void changeText(String s) {
		try{
			moveBox.setText(s);
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
