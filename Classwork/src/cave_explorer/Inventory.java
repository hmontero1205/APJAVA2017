package cave_explorer;

public class Inventory {
	private boolean hasMap;
	private String map;
	
	public Inventory(){
		hasMap = true;
		updateMap();
	}
	public void updateMap() {
		// TODO Auto-generated method stub
		
	}
	public String getDescription() {
		if(hasMap)
			return map;
		else
			return "There is nothing in your inventory!";
	}

	public void setMap(boolean b) {
		hasMap = b;
	}
}
