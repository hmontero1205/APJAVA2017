package datatypes;

public class DeckOfCards {

	public static void main(String[] args) {
		String[] cardSuits = {"Clubs","Spades","Hearts","Diamonds"};
		int cardSuit = (int)(Math.random()*4);
		int cardRankPick = (int)(Math.random()*13)+1;
		String cardRank = "";
		
		switch(cardRankPick){
			case 1: cardRank = "Ace";
					break;
			case 11: cardRank = "Jack";
					break;
			case 12: cardRank = "Queen";
					break;
			case 13: cardRank = "King";
					break;
			default: cardRank = Integer.toString(cardRankPick);
					break;
		
		}
		
		System.out.println("You pulled a "+cardRank+" of "+cardSuits[cardSuit]+"!");

	}

}
