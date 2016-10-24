package array;

public class SampleElement {
	private int number;
	
	public SampleElement(int value){
		number = value;
	}
	public int getNumber(){
		return number;
	}
	public void increase(){
		number++;
	}
	
	public static void main(String[] args){
		int[] intArr = {3,4,56,3};
		//reverseOrder(intArr);
//		if(checkHalfway(intArr,56,0,intArr.length-1)){
//			System.out.println("The number youre searching for is less than the value in the middle");
//		}
//		else{
//			System.out.println("The number youre searching for is greater than or equal to the value in the middle");
//		}
		swap(intArr,0,intArr.length-1);
	}
	public static void swap(int[] swapArr, int i, int j) {
		int placeHolder = swapArr[j];
		swapArr[j] = swapArr[i];
		swapArr[i] = placeHolder;
	}
	
	public static void shuffle(int[] shuffleArr){
		for(int s=0;s<shuffleArr.length;s++){
			int random = (int)(Math.random()*shuffleArr.length);
			swap(shuffleArr,s,random);
		}
	}
	/**
	 * returns true if searchValue is less than the element halfway between beginning and end
	 * @param intArr - to be searched
	 * @param searchValue
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean checkHalfway(int[] intArr, int searchValue, int begin, int end) {
		return searchValue < intArr[(begin+end+1)/2];
		
	}
	
	public static void cycleThrough(int[] array, int n){
//		{0,1,2,3,4,5}
//		1,0,2,3,4,5
//		1,2,0,3,4,5
//		1,2,3,0,4,5
//		1,2,3,4,0,5
//		1,2,3,4,5,0
//		{1,2,3,4,5,0}
//		{2,3,4,5,0,1}
		
	}
	public static void reverseOrder(int[] array){
        /**
         * this method reverses the order of the array passed to it.
         * Not that this method does not have a return type. You do not need to copy the array first
         * Furthermore, note that the array is not necessarily in any *particular* order. It may be 
         * in a random order, though you still need to reverse whatever order it is in
         * 
         * Example:
         * array = {5, 1, 9, 10, 16, -6}
         * after calling this method
         * array = {-6, 16, 10, 9, 1, 5}
         * 
         * */
		for(int b: array)
			System.out.println(b);
        for(int r=0;r<(array.length/2);r++){
			int toSwitch = array[r];
			int beingSwitched = array[array.length-r-1];
			array[r] = beingSwitched;
			array[array.length-r-1] = toSwitch;
		}
        for(int c: array)
			System.out.println(c);
    }
	
	
}
