package chatbox;

public interface Topic {
	public void talk();
	public boolean isTriggered(String userInput);
}
