package com.wolf.euchre;

public class Card
{
	private int rank, suit;

	private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
	private static String[] ranks  = { "9", "10", "Jack", "Queen", "King" , "Ace"};


	Card(int suit, int rank)
	{
		this.rank=rank;
		this.suit=suit;
	}

	public @Override String toString()
	{
		return ranks[rank] + " of " + suits[suit];
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

}


