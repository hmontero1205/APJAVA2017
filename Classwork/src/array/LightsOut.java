package array;

public class LightsOut {

	public static void main(String[] args){
		boolean[][] boolArr = new boolean[3][3]; 
		printBool(boolArr);
	}
	
	public static void printBool(boolean[][] arr){
		for(boolean[] a:arr){
			for(boolean b:a){
				System.out.print((b) ? "O":"X");
			}
			System.out.print("\n");
		}
	}

}
