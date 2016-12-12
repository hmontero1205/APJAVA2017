package gui;
import java.awt.Graphics;
import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame{
	
	private Screen currentScreen;
	
	public GUIApplication(int width, int height) {
		super();
		setBounds(20,20,width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initScreen();
		setVisible(true);
	}

	public abstract void initScreen();
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(),0,0,null);
	}

	public void setScreen(Screen s){
		currentScreen = s;
	}
//	public static void main(String[] args){
//		new GUIApplication(800,600);
//	}
}
