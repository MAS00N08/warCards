package cards;

import java.util.ArrayList;

public class Deck {
	//list to hold all cards in deck
	private ArrayList<Card> deck = new ArrayList<Card>();
	//initializes the deck with 52 cards, in order 2 to ace, for each suit, in the order of diamond, club, heart, spade
	public Deck() {
		for(int i = 1; deck.size() != 52; i++) {
			if(i % 14 != 0) {
				deck.add(new Card(i));
			}
		}
	}
	//prints all the cards in the deck
	public void printDeck() {
		for(int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i).getName());
		}
	}
	//pulls a random card from the deck and removes it from the deck
	public Card pullCard() {
		int number = (int) (Math.random() * (deck.size()));
		return deck.remove(number);
	}
	//returns how many cards are in the deck
	public int cardsLeft() {
		return deck.size();
	}

}
