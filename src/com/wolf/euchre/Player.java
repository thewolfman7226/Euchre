package com.wolf.euchre;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	public ArrayList<Card> hand;
	private int[] suits;  // number of cards in each suit
	private boolean[] hasBauer;
    public int tricks;
	public boolean madeIt;
	
	public Player(){
		hand = new ArrayList<Card>();
		suits = new int[4];
        hasBauer = new boolean[4]
	}
	
	public void sortHand(){
		Collections.sort(hand);
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void addCard(Card c){
		hand.add(c);
		suits[c.getSuit()] ++;
        if(c.getRank() == 2){
            hasBauer[c.getSuit()] = true;
        }
		/** for Ai eventually */
//		int s = c.getSuit();
//		int r = c.getRank();
//		suits[s] = suits[s]+r;
//		if(r == 2){
//			suits[s] +=5;
//			suits[(s+2)%4] += 4;
//		}
	}
	
	public boolean discard(int i){
		if(i != 5){
			hand.remove(i);
			sortHand();
			return true;
		}
		return false;
	}
	
	/**
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
	*/
	
//	public int call(Card upCard, boolean dealer){
//		if(dealer){
//			if(upCard.getRank() == 2){
//				suits[upCard.getSuit()] += 5;
//				suits[(upCard.getSuit()+2)%4] += 4;
//			} else {
//				suits[upCard.getSuit()] += upCard.getRank();
//			}
//		}
//		if(suits[upCard.getSuit()]>14){
//			return upCard.getSuit();
//		} else{
//			return -1;	
//		}
//	}
	
	/** still need to limit cards when jack is played */
	public Card play(int i, Card c){
		Card newCard = hand.get(i);
        if(c == null){
            hand.remove(i);
            suits[newCard.getSuit()] --;
            return newCard;
        } else if(c.getSuit() == newCard.getSuit()){
			hand.remove(i);
            suits[newCard.getSuit()] --;
			return newCard;
		} else if(suits[c.getSuit()] == 0){
			hand.remove(i);
            suits[newCard.getSuit()] --;
            return newCard;
		}
		return null;
	}
	
	public void gotTrick(){
		tricks++;
	}
}
