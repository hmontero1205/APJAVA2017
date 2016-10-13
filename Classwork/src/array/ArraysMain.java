package array;

public class ArraysMain {

	public static void main(String[] args) {
		//timing how quickly a computer processes.
		long startTime = System.currentTimeMillis();
		//arrayIntroMethod();
		String[] someStrings = new String[100];
		populateArray(someStrings);
		changeString(someStrings[99]);
		printArray(someStrings);
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in..."+(endTime-startTime)+"ms!!");
	}
	private static void printArray(String[] b) {
		for(String strB: b){
			System.out.println(strB);
		}
		
	}
	private static void changeString(String s){
		s ="This strng has been changed!";
	}
	private static void populateArray(String[] a) {
		for(int h=0; h<a.length;h++){
			a[h] = "Value "+(h+1);
		}
		
	}
	public static void arrayIntroMethod(){
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];
		String[] strings1 = {"","",""};
		String[] strings2 = new String[3];//full of nulls
//		strings2[0] = "Value 1";
//		strings2[1] = "Value 2";
//		strings2[2] = "Value 3";
		
		for(int g=0; g<strings2.length;g++){
			strings2[g] = "Value "+(g+1);
		}
		
		for(String s1: strings1){
			System.out.println(s1);
		}
		for(String s2: strings2){
			System.out.println(s2);
		}
		
		/*boolean[] booleans =  new boolean[3];
		//index of data is important to reference.
		for(int index=0;index<booleans.length;index++){
			System.out.println(index+") "+booleans[index]);
		}
		//always goes in order, doesnt go in order
		int index2 = 0;
		for(boolean b:booleans){
			System.out.println(index2+") "+b);
			index2++;
		}*/
	}
}
