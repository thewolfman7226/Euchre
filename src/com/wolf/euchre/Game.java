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
		dealer = g.nextInt(3);
		lead = (dealer+1)%4;
		players = new Player[4];
		players[0] = new Player();
		players[1] = new Player();
		players[2] = new Player();
		players[3] = new Player();
// 		for(Player p: players){
// 			p = new Player();
// 			
// 		}
		upCard = null;
		deal(dealer);
		sort();
        if(call()){

        }
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
	
	private void sort(){
	    players[0].sortHand();
	    players[1].sortHand();
	    players[2].sortHand();
	    players[3].sortHand();
	}

    public boolean call(){
        boolean called = false;
        int suit = -1;
        int caller = -1;
        int oldSuit = -1;
        for(int i = 0; i <8; i++) {
            suit = players[(dealer+i+1)%4].call(upCard);
            if(suit != -1 || suit != oldSuit) {
                caller = (dealer + i + 1) % 4;
                called = true;
                trump = suit;
                return;
            }
            if(i == 3){
                oldSuit = upCard.getSuit();
                upCard = null;
            }

        }
        return called;
    }
}
