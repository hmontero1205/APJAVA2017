package cave_explorer;

public class EventRoom extends CaveRoom {
	
	private Event event;
	private boolean eventOccurred;
	
	public EventRoom(String description,Event e) {
		super(description);
		eventOccurred = false;
		this.event = e;
	}
	
	public void enter(){
		super.enter();
		if(!eventOccurred){
			eventOccurred = true;
			event.play();
		}
	}

}
