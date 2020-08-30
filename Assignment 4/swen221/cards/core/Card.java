package swen221.cards.core;

import java.io.Serializable;

public class Card implements Comparable<Card>, Serializable
{

	/**
	 * Represents a card suit.
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Suit
	{
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}

	/**
	 * Represents the different card "numbers".
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Rank
	{
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	}

	// =======================================================
	// Card stuff
	// =======================================================

	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)

	/**
	 * Construct a card in the given suit, with a given number
	 * 
	 * @param suit   --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number)
	{
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 * 
	 * @return
	 */
	public Suit suit()
	{
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 * 
	 * @return
	 */
	public Rank rank()
	{
		return rank;
	}

	private static String[] suits =
	{ "Hearts", "Clubs", "Diamonds", "Spades" };
	private static String[] ranks =
	{ "2 of ", "3 of ", "4 of ", "5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ", "Queen of ",
			"King of ", "Ace of " };

	public String toString()
	{
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}

	/**
	 * Sorts cards by their suit and rank, such that Hearts < Clubs < Diamonds <
	 * Spades and Ace > King > Queen > Jack > 10.
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Card o)
	{
		if (this.suit() == o.suit())
		{
			return rank().ordinal() - o.rank().ordinal();
		} else
		{
			return suit().ordinal() - o.suit().ordinal();
		}
	}

	/**
	 * Uses a prime number to generate a hashcode for a card
	 */
	@Override
	public int hashCode()
	{
		final int prime = 7;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	/**
	 * Determines whether the the current card another card
	 * 
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card o = (Card) obj;
		if (rank != o.rank)
			return false;
		if (suit != o.suit)
			return false;
		return true;
	}

	/**
	 * Compares two cards with trumps. If the trumps parameter is null, or if the
	 * suits are the same it will compare by rank instead.
	 *
	 * @param o
	 * @param trumps
	 * @return
	 */
	public int compareTo(Card o, Card.Suit trumps)
	{
		if (suit() == o.suit() || trumps == null)
		{
			return rank().ordinal() - o.rank().ordinal();
		} else
		{
			if (suit() == trumps)
			{
				return 1;
			} else if (o.suit() == trumps)
			{
				return -1;
			}
			return suit().ordinal() - o.suit().ordinal();
		}
	}
}
