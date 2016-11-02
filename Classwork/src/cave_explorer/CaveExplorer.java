package cave_explorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom caves[][];
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	
	public static void main(String[] args){
		caves = new CaveRoom[5][5];
		for(int r=0; r<caves.length;r++){
			for(int c=0;c<caves[r].length;c++){
				caves[r][c] = new CaveRoom("This cave has coords ("+r+","+c+")!");
			}
		}
		
		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][1].setConnection(CaveRoom.EAST,caves[0][2],new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH,caves[1][2],new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH,caves[2][2],new Door());
		
		startExploring();
	}

	public static void startExploring() {
		while(true){
			System.out.println(currentRoom.getDescription());
			System.out.println("wyd fam xD");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}

}
