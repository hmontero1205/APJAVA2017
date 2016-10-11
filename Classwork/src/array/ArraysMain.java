package array;

public class ArraysMain {

	public static void main(String[] args) {
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];
		String[] strings1 = {"","",""};
		String[] strings2 = new String[3];//full of nulls
		
		boolean[] booleans =  new boolean[3];
		//index of data is important to reference.
		for(int index=0;index<booleans.length;index++){
			System.out.println(index+") "+booleans[index]);
		}
		//always goes in order, doesnt go in order
		int index2 = 0;
		for(boolean b:booleans){
			System.out.println(index2+") "+b);
			index2++;
		}
	}

}
