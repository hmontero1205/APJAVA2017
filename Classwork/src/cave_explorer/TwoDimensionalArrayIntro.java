package cave_explorer;

import java.util.Arrays;

public class TwoDimensionalArrayIntro {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7};
	//	System.out.println(Arrays.toString(arr));
		String[][] twoDeeStringArr = new String[4][5];
		print2DArr(twoDeeStringArr);
				
		String[][] arr2D = new String[4][3];
		for(int r=0;r<arr2D.length;r++){
			for(int c=0;c<arr2D[r].length;c++){
				arr2D[r][c] = "("+r+","+c+")";
			}
		}
		
		
		
	}

	public static void print2DArr(String[][] a){
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[r].length;c++){
				System.out.println(a[r][c]);
			}
		}
	}
}
