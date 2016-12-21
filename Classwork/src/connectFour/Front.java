package connectFour;

import java.util.Scanner;

public class Front {
	public static Scanner in;
	private static String[][] board;
	private static boolean userWon = false;
	private static boolean compWon = false;
	public static void main(String[] args){
		board = (makeConnectFourBoard(6,7));
		playConnectFour();
	}
	public static void playConnectFour() {
		in = new Scanner(System.in);
		print2DArr(board);
		boolean inGame = true;
		while(inGame){
			Back.userMove();	
			while(!Back.getMadeChange()){
				System.out.println("Uhhh... that column is full wyd xD");
				Back.userMove();	
			}
			if(userWon){
				print2DArr(board);
				System.out.println("You won!");
				inGame = false;
			}
			else{
				Back.compMove();
				System.out.println("Hmm...\n");
				print2DArr(board);
				if(compWon){
					System.out.println("I won");
					inGame =false;
				}
			}
		}
		
	}
	public static String[][] makeConnectFourBoard(int r, int c) {
		int numCol = (c*2)+1;
		int numRow = r+1;
		String[][] grid = new String[numRow][numCol];
		int lastColHeader = 0;
		for(int i = 0;i< numCol;i++){
			if(i%2==1){
				grid[0][i] = Integer.toString(i-lastColHeader);
				lastColHeader = i-lastColHeader;
			}
		}
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(j%2==0){
					grid[i][j] = "|";
				}
				else{
					if(i!=0)
						grid[i][j] = " ";
				}
			}
		}
		return grid;
	}
	public static void print2DArr(String[][] a){
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[r].length;c++){
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
	}
	public static String[][] getBoard() {
		return board;
	}
	public static void setUserWon(boolean u){
		userWon = u;
	}
	public static void setCompWon(boolean u){
		compWon = u;
	}
}
