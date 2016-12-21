package connectFour;

public class Back {
	private static boolean madeChange;
	private static int[] nextMove = new int[2];
	private static boolean useAI;
	public static void userMove(){
		String[][] arr = Front.getBoard();
		System.out.println("Make a move, chump.");
		String userIn = Front.in.nextLine();
		while(!isValid(userIn,arr[0].length-1)){
			System.out.println("chill with that man enter a valid input");
			userIn = Front.in.nextLine();
		}
		int columnChosen = indexOf(arr[0],userIn);
		madeChange = false;
		for(int i=arr.length-1;i>0;i--){
			if(arr[i][columnChosen].equals(" ")){
				arr[i][columnChosen] = "O";
				madeChange = true;
				checkWinner(i,columnChosen,"O");
				break;
			}
		}
	}
	public static int indexOf(String[] arr, String key){
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(key)){
				return i;
			}
		}
		return -1;
	}
	public static boolean getMadeChange(){
		return madeChange;
	}
	public static boolean isValid(String input, int max){
		try{
			int num = Integer.parseInt(input);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		int num = Integer.parseInt(input);
		if(num < 1 || num > max){
			return false;
		}
		return true;
	}
	public static void compMove() {
		String[][] arr = Front.getBoard();
		if(useAI){
			int nextMoveR =nextMove[0];
			int nextMoveC = nextMove[1];
			arr[nextMoveR-1][nextMoveC]="X";
			checkWinner(nextMoveR-1,nextMoveC,"X");	
			useAI = false;
		}
		else{
			int randCol = (int)(Math.random()*7)+1;
			int corrCol = indexOf(arr[0],Integer.toString(randCol));
			while(arr[1][corrCol].equals("X")||arr[1][corrCol].equals("O")){
				randCol = (int)(Math.random()*7)+1;
				corrCol = indexOf(arr[0],Integer.toString(randCol));
			}
			for(int i=arr.length-1;i>0;i--){
				if(arr[i][corrCol].equals(" ")){
					arr[i][corrCol] = "X";
					checkWinner(i,corrCol,"X");
					break;
				}
			}
		}
			
	}
	public static void checkWinner(int r, int c, String player){
		int horizCount = 1;
		int vertCount = 1;
		int diagLeft = 1;
		int diagRight = 1;
		
		horizCount += checkHoriz(r,c,player);
		vertCount+= checkVert(r,c,player);
		diagLeft+= checkDiagLeft(r,c,player);
		diagRight+= checkDiagRight(r,c,player);
		//System.out.println("h:"+horizCount+" v:"+vertCount+" dl:"+diagLeft+" dr:"+diagRight);
		
		if(horizCount==4||vertCount==4||diagLeft==4||diagRight==4){
			switch(player){
				case "X":System.out.println("Good looks I won my dude.");
						Front.setCompWon(true);
						break;
				case "O":System.out.println("Good looks you won my dude.");
						Front.setUserWon(true);
						break;
			}
		}
		else{
			if(player.equals("O")&&vertCount==3&&r!=1){
				useAI = true;
				nextMove[0]= r;
				nextMove[1]= c;
			}
		}
	}
	public static int checkDiagRight(int r, int c,String p){
		String[][] arr = Front.getBoard();
		//check bottom right
		int row = r+1;
		int col = c+2;
		int count = 0;
		while(row<arr.length && col<arr[r].length){
			if(arr[row][col].equals(p))
				count++;
			else
				break;
			row++;
			col+=2;
		}
		//check top left
		row = r-1;
		col = c-1;
		while(row>0 && col>-1){
			if(arr[row][col].equals(p))
				count++;
			else
				break;
			row--;
			col-=2;
		}
		return count;
	}
	public static int checkDiagLeft(int r,int c,String p){
		String[][] arr = Front.getBoard();
		//check bottom left
		int row = r+1;
		int col = c-2;
		int count = 0;
		while(row<arr.length && col>-1){
			if(arr[row][col].equals(p))
				count++;
			else
				break;
			row++;
			col-=2;
		}
		//check top right
		row = r-1;
		col = c+2;
		while(row>0 && col<arr[r].length){
			if(arr[row][col].equals(p))
				count++;
			else
				break;
			row--;
			col+=2;
		}
		return count;
	}
	public static int checkVert(int r, int c, String p) {
		int count = 0;
		for(int row = r-1;row>0;row--){//up
			if(Front.getBoard()[row][c].equals(p))
				count++;
			else
				break;
		}
		for(int row = r+1;row<Front.getBoard().length;row++){//down
			if(Front.getBoard()[row][c].equals(p))
				count++;
			else
				break;
		}
		return count;
	}
	public static int checkHoriz(int r, int c,String p) {
		int count=0;
		for(int col = c-2;col>-1;col-=2){//left
			if(Front.getBoard()[r][col].equals(p))
				count++;
			else
				break;
		}
		for(int col = c+2;col<Front.getBoard()[0].length;col+=2){//right
			if(Front.getBoard()[r][col].equals(p))
				count++;
			else
				break;
		}
		return count;
	}
}
