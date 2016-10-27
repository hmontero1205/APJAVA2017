package array;

public class ArrayDemos {
	public static void main(String[] args){
		//populateArray();
		//populateRandArray();
	   // twoDiceRolls();
		//createDeck();
	    //swapDemo();
     	int[] intArr = {1,2,3,4,5};
     	double[] dubArr={2.0,1.0,3.0};
//		int[] subArr = {2,3,5};
//		System.out.println(longestSharedSequence(intArr,subArr));
		//System.out.println(getSubArray(intArr,0,2));
//		if(contains(intArr,subArr))
//			System.out.println("Yup");
//		else
//			System.out.println("Nope");	
     	//getStats(dubArr);
     	testPrimes(50);
	}
	public static void populateArray(){
		int[] numsArr = new int[50];
		for(int n=0;n<numsArr.length;n++){
			numsArr[n] = n+1;
			System.out.println("Index "+n+": "+numsArr[n]);
		}
	}
	public static void populateRandArray(){
		int[] randNumsArr =  new int[50];
		for(int m=0;m<randNumsArr.length;m++){
			randNumsArr[m] = ((int)(Math.random()*51));
			System.out.println("Index "+m+": "+randNumsArr[m]);
		}
	}
	public static void twoDiceRolls(){
		int[] diceRolls = new int[500];
		int[] rollsPossible = new int[11];
		for(int d=0;d<diceRolls.length;d++){
			int roll1 = ((int)(Math.random()*6)+1);
			int roll2 = ((int)(Math.random()*6)+1);
			diceRolls[d] = roll1 +roll2;
			rollsPossible[diceRolls[d]-2]++;
		}
		for(int o=0;o<rollsPossible.length;o++){
			System.out.println("Probability of roll ing "+(o+2)+": "+(((double)rollsPossible[o]/diceRolls.length)*100)+"%");
		}
	}
	public static void createDeck(){
		String[] suits = {"Diamonds","Hearts","Spades","Clubs"};
		String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		String[] deckOfCards = new String[52];
		int cardCount = 0;
		for(int s=0;s<suits.length;s++){
			for(int r=0;r<ranks.length;r++){
				deckOfCards[cardCount] = ranks[r]+" of "+suits[s];
				System.out.println(deckOfCards[cardCount]);
				cardCount++;
			}
		}
	}
	public static void swapDemo(){
		String[] swapDemo = {"Item 1","Item 2"};
		String tempHolder = swapDemo[0];
		System.out.println("Before: "+swapDemo[0]+","+swapDemo[1]);
		swapDemo[0] = swapDemo[1];
		swapDemo[1] = tempHolder;
		System.out.println("After: "+swapDemo[0]+","+swapDemo[1]);
	}
	
	public static int countUnderBound(double[] arr ,double d){
		int numUnder = 0;
		for(int b=0;b<arr.length;b++){
			if(arr[b] < d)
				numUnder++;
		}
		return numUnder;
	}
	
	public static String getSubArray(int[] arr,int start,int end){
//		for(int b:arr){
//			System.out.println(b);
//		}
		//start = 0, end =2
		int[] result = new int[end-start+1];
		for(int s=start;s<end+1;s++){
			result[s-start] = arr[s];
		}
		
		for(int b:result){
			System.out.println(b);
		}
		return result.toString();
	}
	public static boolean contains(int[] arr,int[] subArr){
		for(int i=0; i<arr.length; i++){
			int j = 0;
			while(j<subArr.length){
				if(subArr[j] == arr[i+j]&& j == subArr.length-1){
					return true;
				}
				else if(subArr[j] != arr[i+j]){
					break;
					
				}
				j++;
			}
		}
		return false;		
	}
	
	public static int longestSharedSequence(int[] array1,int[] array2){
		int longestShared = 0;
		int currentShared = 0;
		for(int g=0;g<array1.length;g++){
			for(int h=0;h<array2.length;h++){
				if(array1[g]==array2[h]){
					int counter=1;
					while((g+counter)<array1.length && (h+counter)<array2.length){
						System.out.println("arr1_sub"+(g+counter)+":"+array1[g+counter]+"; arr2_sub"+(h+counter)+":"+array2[h+counter]);
						if(array1[g+counter]==array2[h+counter]){
							System.out.println("shared!");
							currentShared++;
							if(currentShared>longestShared){
								longestShared = currentShared;
								System.out.println("longest:"+longestShared+"; current:"+currentShared);
							}
							counter++;
						}
						else{
							counter=1;
							break;
						}
					}
				}
			}
		}
		return longestShared;
	}
	public static double[] getStats(double[] array){
        /** 
         * This method return a double[] contain a WHOLE BUNCH of stats
         * The double array must keep the following stats about the array parameter:
         * index 0 = the mean
         * index 1 = the max
         * index 2 = the min
         * index 3 = the median
         * index 4 = the number of values greater than or equal to the mean
         * index 5 = the number of values below the mean
         * 1,2,3
         * 2,1,3
         * */
         double max = getMax(array);
         double min = getMin(array);
         double mean = ((double)(max+min)/2);
         double[] stats = {mean,max,min,getMedian(selectionSort(array)),(array.length-(array.length/2)),(array.length/2)};
         for(double d:stats){
        	 System.out.println(d);
         }
         return stats;
    }
    public static double[] selectionSort(double[] array){
        for (int i = 0; i < array.length - 1; i++){
            int tempLowIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[tempLowIndex]){
                    tempLowIndex = j;
                }
            }
           if(tempLowIndex!=i){
                 swap1(array, tempLowIndex, i);
           } 
        }
        return array;
    }
    
    public static double getMedian(double[] sorted){
        if(sorted.length % 2 == 0)
            return (sorted[sorted.length/2] + sorted[(sorted.length/2)+1])/2;
        else
            return sorted[sorted.length/2];
    }
    public static double getMax(double[] arr){
		double maxNum = arr[0];
		for(int m=1;m<arr.length;m++){
			if(arr[m]>maxNum)
				maxNum = arr[m];
		}
		return maxNum;
	}
	
	public static double getMin(double[] arr){
		double minNum = arr[0];
		for(int m=1;m<arr.length;m++){
			if(arr[m]<minNum)
				minNum = arr[m];
		}
		return minNum;
		
	}
	public static void swap1(double[] swapArr, int i, int j) {
 		double placeHolder = swapArr[j];
 		swapArr[j] = swapArr[i];
 		swapArr[i] = placeHolder;
	}
	
	public static int indexOf(int[] arr,int toFind){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==toFind)
				return i;
		}
		return -1;
	}
	public static void classChallenge(int[] arr){
		int[] randArr = new int[arr.length-1];
		for(int r=0;r<randArr.length;r++){
			int toAdd = arr[(int)Math.random()*arr.length];
			while(indexOf(randArr,toAdd) > -1){
				toAdd = arr[(int)Math.random()*arr.length]; 
			}
			randArr[r]=toAdd;
		}
	}
	public static void testPrimes(int numToTest){
		int lastToCheck = (int)(Math.sqrt(numToTest));
		boolean[] theNumbers = new boolean[numToTest];
		for(int i=0;i<numToTest;i++){
			theNumbers[i]=true;
		}
		theNumbers[0] = false;
		theNumbers[1] = false;
		int inc = 2;
		boolean first = true;
		for(int t=2;t<numToTest;t+=inc){
			if(!first){
				theNumbers[t] = false;
			}
			else{
				first = false;
			}
		}
		for(int n=0;n<theNumbers.length;n++){
			if(theNumbers[n]){
				System.out.println(n+" is prime!!!!!!!!!!");
			}
		}
	}
}

