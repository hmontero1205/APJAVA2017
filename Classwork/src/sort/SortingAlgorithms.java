package sort;

import java.util.Arrays;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] arrayToSort={133,0,-5,31,12,12,2};
		System.out.println("- - - INSERTION SORT - - -");
		System.out.println(Arrays.toString(arrayToSort));
		insertionSort(copy(arrayToSort));
	}

	public static int[] copy(int[] arr){
		int[] copy = new int[arr.length];
		for(int i = 0; i < copy.length; i++){
			copy[i]=arr[i];
		}
		return copy;
	}

	public static void swap(int[] arr, int i, int j){
		System.out.println("Swapping "+arr[i]+" and "+arr[j]);
		int placeHolder=arr[j];
		arr[j]=arr[i];
		arr[i]=placeHolder;
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arrayToSort){
		//search the array for the smallest value...
		int minIndex=0;
		int minimum=arrayToSort[0];
		for(int i=0;i<arrayToSort.length;i++){
			//first, you assume the element you are currently
			//looking at IS the smallest value...
			minIndex=i;
			minimum=arrayToSort[i];
			for(int j=i;j<arrayToSort.length;j++){
				//and if you find a smaller value,
				//re-assign the minimum
				if(arrayToSort[j]<minimum){
					minimum=arrayToSort[j];
					minIndex=j;
				}
			}
			//then swap the new minimum so that it
			//is in the earliest position in the array
			swap(arrayToSort, i, minIndex);
			//now find the NEXT smallest element...
		}
	}

	public static void insertionSort(int[] arrayToSort){
		//this algorithm takes one element at a time to 
		//add in sorted order...
		//start at 1 since the element at zero is
		//already in "sorted order" (since it is alone)
		for (int i = 1; i < arrayToSort.length; i++) {
			//with each element, i, go BACKWARDS from i, 
			//until you find a value that is smaller
			//swap as you go
			int j=i;
			while(j>0 && arrayToSort[j] < arrayToSort[j-1]){
				swap(arrayToSort,j,j-1);
				j--;
			}
		}
	}


	public static void bubbleSort(int[] arrayToSort){
		//go forward in the array
		for(int i=0; i < arrayToSort.length-1; i++){
			//swap pairs that are out of order
			for(int j=1; j < arrayToSort.length-i; j++){
				if(arrayToSort[j-1] > arrayToSort[j]){
					swap(arrayToSort,j-1,j);
				}
			}
			//keep doing that repeatedly, eventually the largest values will "float" to the top
		}
	}
	
	public static int[] mergeSort(int[] arr){
		if(arr.length <= 1){
			return arr;
		}
		else{
			int[] split1 = new int[(int) Math.ceil(arr.length/2)];
			int[] split2 = new int[(int) Math.floor(arr.length/2)];
			
			for(int i=0;i<(int) Math.ceil(arr.length/2);i++){
				
			}
		}
		
		return new int[0];
	}
}