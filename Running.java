package cards;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Running {
	public static void main(String[] args) { 	
		
		Deck deck = new Deck();
		
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		ArrayList<Card> computerHand = new ArrayList<Card>();
		
		//distributing decks
		while(deck.cardsLeft() > 0) {
			if(deck.cardsLeft() % 2 == 0) {
				playerHand.add(deck.pullCard());
			}
			else {
				computerHand.add(deck.pullCard());
			}
		}
		System.out.println("Decks Distributed");
		System.out.println("Starting game of War");
		
		//application window
		JFrame frame = new JFrame("War!");
		frame.setLayout(new BorderLayout(0,0));
		frame.setSize(600, 400);
		frame.setLocation(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		frame.add(panel);
		GridBagConstraints g = new GridBagConstraints();
		
		JLabel outputPlayer = new JLabel("Player Text");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 2;
		panel.add(outputPlayer, g);
		
		JLabel outputNeutral = new JLabel("Hello");
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		panel.add(outputNeutral, g);
		
		
		
		JLabel outputComputer = new JLabel("Computer Text");
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 2;
		panel.add(outputComputer, g);
		
		frame.setVisible(true);
		//playing war
		while(playerHand.size() > 0 && computerHand.size() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Card p = playerHand.get(0);
			Card c = computerHand.get(0);
			outputPlayer.setText(p.getName() + " Cards left: " + playerHand.size());
			outputComputer.setText(c.getName() + " Cards left: " + computerHand.size());
			
			
			System.out.println("Player's " + p.getName() + " vs. Computer's " + c.getName());
			if(c.getValue() == p.getValue()) {
				System.out.println("War!");
				outputNeutral.setText("War!");
				if(playerHand.size() < 5) {
					System.out.println("Player does not have enough cards for war! Computer wins!");
					outputNeutral.setText("Player does not have enough cards for war! Computer wins!");
					while(playerHand.size() != 0) {
						computerHand.add(playerHand.remove(0));
					}
				}
				else if(computerHand.size() < 5) {
					System.out.println("Computer does not have enough card for war! Player wins!");
					outputNeutral.setText("Computer does not have enough card for war! Player wins!");
					while(computerHand.size() != 0) {
						playerHand.add(computerHand.remove(0));
					}
				}
				else {
					Card pWar = playerHand.get(4);
					Card cWar = computerHand.get(4);
					if(cWar.getValue() == pWar.getValue()) {
						outputNeutral.setText("Double War! Draw.");
						for(int i = 0; i < 5; i ++) {
							playerHand.add(playerHand.remove(0));
							computerHand.add(computerHand.remove(0));
						}
					}
					else if(pWar.getValue() > cWar.getValue()) {
						System.out.println("Player's " + pWar.getName() + " beats Computer's " + cWar.getName());
						System.out.println("Player wins 5 cards from Computer!");
						outputNeutral.setText("Player's " + pWar.getName() + " beats Computer's " + cWar.getName());
						for(int i = 0; i < 5; i ++) {
							playerHand.add(playerHand.remove(0));
							playerHand.add(computerHand.remove(0));
						}
					}
					else {
						System.out.println("Computer's " + cWar.getName() + " beats Player's " + pWar.getName());
						System.out.println("Computer wins 5 cards from Player!");
						for(int i = 0; i < 5; i++) {
							computerHand.add(computerHand.remove(0));
							computerHand.add(playerHand.remove(0));
						}
						
					}
				}
			}
			else if(p.getValue() > c.getValue()) {
				System.out.println("Player's " + p.getName() + " beats Computer's " + c.getName());
				outputNeutral.setText("Player's " + p.getName() + " beats Computer's " + c.getName());
				playerHand.add(playerHand.remove(0));
				playerHand.add(computerHand.remove(0));
			}
			else {
				System.out.println("Computer's " + c.getName() + " beats Players's " + p.getName());
				outputNeutral.setText("Computer's " + c.getName() + " beats Players's " + p.getName());
				computerHand.add(computerHand.remove(0));
				computerHand.add(playerHand.remove(0));
			}
		}
		if(playerHand.size() == 0) {
			System.out.println("Computer wins War!");
			outputNeutral.setText("Computer wins War!");
		}
		if(computerHand.size() == 0) {
			System.out.println("Player wins War!");
			outputNeutral.setText("Player wins War!");
		}
		frame.setVisible(true);
	}
}
