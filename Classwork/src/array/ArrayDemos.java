package array;

public class ArrayDemos {
	public static void main(String[] args){
		//demo1();
		//demo2();
	    demo3();
		//demo4();
	    //demo5();
	}
	public static void demo1(){
		int[] numsArr = new int[50];
		for(int n=0;n<numsArr.length;n++){
			numsArr[n] = n+1;
			System.out.println("Index "+n+": "+numsArr[n]);
		}
	}
	public static void demo2(){
		int[] randNumsArr =  new int[50];
		for(int m=0;m<randNumsArr.length;m++){
			randNumsArr[m] = ((int)(Math.random()*51));
			System.out.println("Index "+m+": "+randNumsArr[m]);
		}
	}
	public static void demo3(){
		int[] diceRolls = new int[50];
		int[] rollsPossible = new int[11];
		for(int d=0;d<diceRolls.length;d++){
			int roll1 = ((int)(Math.random()*6)+1);
			int roll2 = ((int)(Math.random()*6)+1);
			diceRolls[d] = roll1 +roll2;
			rollsPossible[diceRolls[d]-2]++;
		}
		for(int o =2;o<13;o++){
			System.out.println("Probability of rolling "+o+": "+(((double)diceRolls[o-2]/50))+"%.");//
		}
	}
	public static void helpDemo3(int roll){
		int[] rollsPossible = new int[11];
		rollsPossible[roll-2]++;
	}
	public static void demo4(){
		String[] suits = {"Diamonds","Hearts","Spades","Clubs"};
		String[] deckOfCards = new String[52];
		int cardCount = 0;
		for(int s=0;s<4;s++){
			for(int r=1;r<14;r++){
				String finalRank;
				switch(r){
					case 1: finalRank = "Ace";
					break;
					case 11: finalRank = "Jack";
					break;
					case 12: finalRank = "Queen";
					break;
					case 13: finalRank = "King";
					break;
					default: finalRank = Integer.toString(r);
					break;
				}
				deckOfCards[cardCount] = finalRank+" of "+suits[s];
				System.out.println(deckOfCards[cardCount]);
				cardCount++;
			}
		}
	}
	public static void demo5(){
		String[] swapDemo = {"Item 1","Item 2"};
		String tempHolder = swapDemo[0];
		System.out.println("Before: "+swapDemo[0]+","+swapDemo[1]);
		swapDemo[0] = swapDemo[1];
		swapDemo[1] = tempHolder;
		System.out.println("After: "+swapDemo[0]+","+swapDemo[1]);
	}
}
