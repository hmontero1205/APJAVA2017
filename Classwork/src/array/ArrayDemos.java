package array;

public class ArrayDemos {
	public static void main(String[] args){
		//populateArray();
		//populateRandArray();
	    twoDiceRolls();
		//createDeck();
	    //swapDemo();
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
}
