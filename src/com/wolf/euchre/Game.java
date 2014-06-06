package com.wolf.euchre;

import java.util.Random;

public class Game {
	protected Deck deck;
	protected int redScore, blackScore;
	protected int dealer;
	protected Player[] players;
	protected int trump;
	protected Card upCard;
	protected Card[] trick;
	protected int maker;
	protected int lead;
	
	
	public Game(){
		deck = new Deck();
		redScore = 0;
		blackScore = 0;
		Random g = new Random();
		dealer = g.nextInt()%4;
		lead = (dealer+1)%4;
		players = new Player[4];
		for(Player p: players){
			p = new Player();
		}
		upCard = null;
		deal(dealer);
	}
	
	public void deal(int d){
		players[(d + 1) % 4].addCard(deck.drawFromDeck());
		players[(d + 1) % 4].addCard(deck.drawFromDeck());
		players[(d + 2) % 4].addCard(deck.drawFromDeck());
		players[(d + 2) % 4].addCard(deck.drawFromDeck());
		players[(d + 2) % 4].addCard(deck.drawFromDeck());
		players[(d + 3) % 4].addCard(deck.drawFromDeck());
		players[(d + 3) % 4].addCard(deck.drawFromDeck());
		players[d].addCard(deck.drawFromDeck());
		players[d].addCard(deck.drawFromDeck());
		players[d].addCard(deck.drawFromDeck());
		players[(d + 1) % 4].addCard(deck.drawFromDeck());
		players[(d + 1) % 4].addCard(deck.drawFromDeck());
		players[(d + 1) % 4].addCard(deck.drawFromDeck());
		players[(d + 2) % 4].addCard(deck.drawFromDeck());
		players[(d + 2) % 4].addCard(deck.drawFromDeck());
		players[(d + 3) % 4].addCard(deck.drawFromDeck());
		players[(d + 3) % 4].addCard(deck.drawFromDeck());
		players[(d + 3) % 4].addCard(deck.drawFromDeck());
		players[d].addCard(deck.drawFromDeck());
		players[d].addCard(deck.drawFromDeck());
		upCard = deck.drawFromDeck();			
	}
	
	public void setTrump(int t){
		trump = t;
	}
	
	
		
	
}
