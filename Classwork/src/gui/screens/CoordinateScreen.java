package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen implements MouseListener, MouseMotionListener {
	private Button myButton;
	private TextLabel text;
	private TextArea textArea;
	private Graphic robbieRotten;
	private Button stefanButton;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(10,545,500,40,"Mouse @ (???.???)");
		textArea = new TextArea(10,40,780,800,"Hey! We are Number One Hey! We are Number One! Now listen closely... Here\'s a little lesson in trickery. This is going down in history. If you wanna be a Villain Number One, you'll have to chase a superhero on the run. Just follow my moves, and sneak around. Be careful not to make a sound! Shh! No, don\'t touch that! We are Number One Hey! We are Number One Ha ha ha! Now look at this net, that I have found. When I say go, be ready to throw. Go! Throw it on him, not me! Ugh, let\'s try something else. Now watch and learn, here\'s the deal. He\'ll slip and slide on this banana peel. Ha ha ha, gasp! What are you doing!? ba-ba-biddly-ba-ba-ba-ba, ba-ba-ba-ba-ba-ba-ba We are Number One Hey! ba-ba-biddly-ba-ba-ba-ba, ba-ba-ba-ba-ba-ba-ba We are Number One Hey! ba-ba-biddly-ba-ba-ba-ba, ba-ba-ba-ba-ba-ba-ba We are Number One Hey! ba-ba-biddly-ba-ba-ba-ba, ba-ba-ba-ba-ba-ba-ba We are Number One Hey! Hey!");
		myButton = new Button(15,525,165,35,"Don't click here",Color.gray, new Action(){
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
			
		});
		stefanButton = new Button(450,525,265,35,"Click here for Stefan :)", Color.gray, new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.stefanS);
			}
		});
		robbieRotten = new Graphic(170,10,.8,"resources/sampleImages/robbierotten.png");
		viewObjects.add(text);
		viewObjects.add(textArea);
		viewObjects.add(robbieRotten);
		viewObjects.add(myButton);
		viewObjects.add(stefanButton);
		
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		text.setText("Mouse @ ("+mx+","+my+")");
		
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(myButton.isHovered(e.getX(), e.getY())){
			myButton.act();
		}
		if(stefanButton.isHovered(e.getX(), e.getY())){
			stefanButton.act();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
