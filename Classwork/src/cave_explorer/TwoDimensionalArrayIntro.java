package cave_explorer;

import java.util.Arrays;

public class TwoDimensionalArrayIntro {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7};
	//	System.out.println(Arrays.toString(arr));
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
