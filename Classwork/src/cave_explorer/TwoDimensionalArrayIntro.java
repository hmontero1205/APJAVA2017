package cave_explorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalArrayIntro {
	
	public static String[][]arr2D;
	public static String[][] pic;
	public static int i;
	public static int j;
	public static Scanner in;

	public static void main(String[] args) {
		//makeCoolPic();
//		boolean[][] mines = new boolean[6][6];
//		createMines(mines,10);
//		String[][] field = new String[mines.length][mines[0].length];
//		matchValues(field,mines);
//		print2DArr(field);
		makeGrid(100,72);
		
		arr2D = new String[5][4];
		pic = new String[5][4];
		
		for(int r=0;r<arr2D.length;r++){
			for(int c=0;c<arr2D[r].length;c++){
				arr2D[r][c] = "("+r+","+c+")";
			}
		}
		i=2;
		j=3;
		in = new Scanner(System.in);		
		
		//startExploring();
		
	}
	private static void startExploring() {
		while(true){
			//printPic(pic);
			System.out.println("You are in room "+arr2D[i][j]);
			System.out.println("wyd fam");
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("Please enter w, a, s, or d!!!!!");
				input = in.nextLine();
			}
			interpretInput(input.toLowerCase());
		}
		
	}
	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;
		if(input.equals("w") && i > 0)
			i--;
		if(input.equals("a") && j>0)
			j--;
		if(input.equals("s") && i+1 > arr2D.length)
			i++;
		if(input.equals("d") && j+1> arr2D[0].length)
			j++;
		
		if(iOrig == i && jOrig == j){
			System.out.println("chill");
		}
	}
	private static boolean isValid(String input){
		String lc = input.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc))
				return true;
		}
		return false;
		
	}
	public static void makeGrid(int l, int w){
		int lastSideIndex = -1;
		boolean changeSideIndex = false;
		int toChangeTo = 0;
		for(int i = 0;i<l;i++){
			for(int j = 0;j<w+1;j++){	
				if(i==0){
					if(j==0 || j%4==0){
						System.out.print(" ");
					}
					else{
						System.out.print("__");
					}
				}
				else{
					if(j==0 || j%4==0){
						if(j!=0 && j!=w && (i-lastSideIndex == 3) && Math.random() > .8){
							System.out.print("/");
							changeSideIndex = true;
							toChangeTo = i;
						}
						else{
							System.out.print("|");
						}
					}
					else{
						if(i%3==0){
							if(j%2==0 && Math.random() > .8)
								System.out.print("/ ");
							else
								System.out.print("__");
						}
						else{
							System.out.print("  ");
						}
						
					}
				}
				

			}
			if(changeSideIndex){
				lastSideIndex = toChangeTo;
				changeSideIndex = false;
			}
			System.out.println("");
		}
	}
	public static void matchValues(String[][] f, boolean[][] m){
		for(int r=0;r<f.length;r++){
			for(int c=0;c<f[0].length;c++){
				if(m[r][c])
					f[r][c]="X";
				else{
					f[r][c] = countAdj(m,r,c);
				}
			}
		}
	}
	public static String countAdj(boolean[][] m, int row, int col){
		int count = 0;
		//fast af boi
//		for(int r=row-1;r<=row+1;r++){
//			for(int c=col-1;c<=col+1;c++){
//				if(r!=row && c!=col){
//					if(row>=0 && row<m.length && col>=0 && col<m[r].length){
//						
//					}
//				}
//			}
//		}
		
		//not fast af boi
//		for(int r=0;r<m.length;r++){
//			for(int c=0;c<m[r].length;c++){
//				if((Math.abs(r-row)+Math.abs(c-col))==1 && m[r][c]){
//					count++;
//				}
//			}
//		}
		count+=validAndTrue(m,row-1,col);
		count+=validAndTrue(m,row+1,col);
		count+=validAndTrue(m,row,col-1);
		count+=validAndTrue(m,row,col+1);
		return count+"";
	}
	private static int validAndTrue(boolean[][] m, int i, int j) {
		if(i>=0 && i<m.length && j>=0 && j<m[i].length && m[i][j])
			return 1;
		else
			return 0;
	}
	public static void createMines(boolean[][] m, int numMines){
		while(numMines > 0){
			int r = (int)(Math.random()*m.length);
			int c = (int)(Math.random()*m[0].length);
			if(!m[r][c]){
				m[r][c] = true;
				numMines--;
			}
		}
	}
	
	public static void makeCoolPic(){
		String[][] pic = new String[10][12];
		
		
		String[][] arr2D = new String[4][3];
		for(int r=0;r<arr2D.length;r++){
			for(int c=0;c<arr2D[r].length;c++){
				arr2D[r][c] = "("+r+","+c+")";
			}
		}
		
		for(int r=0;r<pic.length;r++){
			for(int c=0;c<pic[r].length;c++){
				pic[r][c] = " ";
			}
		}
		for(int r=8;r<pic.length-1;r++){
			for(int c=0;c<pic[r].length;c++){
				pic[r][c] = "M";
			}
		}
		for(int c=0;c<pic[0].length;c++){
			pic[0][c] = "_";
		}
		for(int c=0;c<pic[0].length;c++){
			pic[pic.length-1][c] = "_";
		}
		for(int r=1;r<pic.length;r++){
			pic[r][0] = "|";
		}
		for(int r=1;r<pic.length;r++){
			pic[r][11] = "|";
		}
		
		pic[2][2] = "O";
		pic[1][2] = "|";
		pic[3][2] = "|";
		pic[2][1] = "-";
		pic[2][3] = "-";
		pic[1][1] = "\\";
		pic[3][3] = "\\";
		pic[1][3] = "/";
		pic[3][1] = "/";
		
//		pic[1][8] = "/";
//		pic[1][9] = "V";
//		pic[1][10] = "\\";
		
		for(int c=1;c<pic[7].length-1;c++){
			if(Math.random() > .8){
				pic[7][c] = "|";
				pic[6][c] = "o";
			}
				
		}
		
		for(int r=0;r<6;r++){
			for(int c=1;c<pic[r].length-1;c++){
				if(pic[r][c].equals(" ") && pic[r][c-1].equals(" ") && pic[r][c+1].equals(" ") && Math.random() >.95){
					pic[r][c] = "V";
					pic[r][c-1] = "/";
					pic[r][c+1] = "\\";
							
				}
			}
		}
		
		print2DArr(pic);
	}

	public static void print2DArr(String[][] a){
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[r].length;c++){
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
	}
}
