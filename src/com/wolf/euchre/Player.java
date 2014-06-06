package com.wolf.euchre;

import java.util.ArrayList;

public class Player {
	public ArrayList<Card> hand;
	private int[] suits;
	public int tricks;
	
	public Player(){
		hand = new ArrayList<Card>();
		suits = new int[4];
		
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void addCard(Card c){
		hand.add(c);
	
	}
	
	public Card playCard(int i){
		return hand.get(i);
	}
	
	public int bestSuit(){
		
		for(Card c : hand ){
			if(c.getSuit() == 0){
				suits[0] += c.getRank(); 
				if(c.getRank() == 2){
					suits[0] += 5;
					suits[2] += 4;
				}
			}
			if(c.getSuit() == 1){
				suits[1] += c.getRank(); 
				if(c.getRank() == 2){
					suits[1] += 5;
					suits[3] += 4;
				}
			}
			if(c.getSuit() == 2){
				suits[2] += c.getRank(); 
				if(c.getRank() == 2){
					suits[2] += 5;
					suits[0] += 4;
				}
			}
			if(c.getSuit() == 3){
				suits[3] += c.getRank(); 
				if(c.getRank() == 2){
					suits[3] += 5;
					suits[1] += 4;
				}
			}
		}
		int max = 0;
		int j = -1;
		for (int i=0;i<4;i++){
			if(suits[i]>max){
				max = suits[i];
				j=i;
			} 
		}
		return j;
	}
	
	public int call(Card upCard, boolean dealer){
		if(dealer){
			if(upCard.getRank() == 2){
				suits[upCard.getSuit()] += 5;
				suits[(upCard.getSuit()+2)%4] += 4;
			} else {
				suits[upCard.getSuit()] += upCard.getRank();
			}
		}
		if(suits[upCard.getSuit()]>14){
			return upCard.getSuit();
		} else{
			return -1;	
		}
	}
	
	public int call(boolean dealer){
		return -1;
	}
	
	public boolean discard(){
		
		return true;
	}
	
	public void gotTrick(){
		tricks++;
	}
}
