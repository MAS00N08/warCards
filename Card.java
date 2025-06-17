package cards;

public class Card {
	//order: diamonds, clubs, hearts, spades
	//value is the number of the card. 11 = jack, 12 = queen, 13 = king, 14 = ace
	//Suit is stored as a string, formatted Diamonds, Clubs, Hearts, Spades. Capitalization matters
	//Name is the name of the card, the value and the suit combined ie. 4 of Hearts, King of Clubs, Ace of Diamonds
	private int value;
	private String suit;
	private String name;
	//Creates a card with the given value and suit
	public Card(int v, String s) {
		value = v;
		suit = s;
		name = v + " of " + s;
		switch(v) {
		case 1:
			name = "Ace of "  + s;
			v = 14;
			break;
		case 11:
			name = "Jack of " + s;
			break;
		case 12: 
			name = "Queen of " + s;
			break;
		case 13:
			name = "King of " + s;
			break;
		
		}
	}
	//creates a card with a given value. has different ranges for each suit. 
	public Card(int v) {
		value = v % 14;
		
		
		
		if(v < 14) {
			suit = "Diamonds";
		}
		else if(v < 28) {
			suit = "Clubs";
		}
		else if (v < 43) {
			suit = "Hearts";
		}
		else {
			suit = "Spades";
		}
		name = value + " of " + suit;
		switch(value) {
		case 1:
			name = "Ace of "  + suit;
			value = 14;
			break;
		case 11:
			name = "Jack of " + suit;
			break;
		case 12: 
			name = "Queen of " + suit;
			break;
		case 13:
			name = "King of " + suit;
			break;
		
		}
	}
	//returns the value of the card
	public int getValue() {
		return value;
	}
	//returns the full name of the card
	public String getName() {
		return name;
	}
}
