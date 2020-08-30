package swen221.cards.util;

import java.util.Set;

import java.util.Iterator;

import swen221.cards.core.Card;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 * 
 * @author David J. Pearce
 * 
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer
{

	public SimpleComputerPlayer(Player player)
	{
		super(player);
	}

	/**
	 * If it is possible for the AI player to win the trick win the trick, then it
	 * will play the highest eligible card (leading cards or highest trump),
	 * otherwise it just plays the lowest eligible card.
	 * 
	 * @param trick
	 * @return Card
	 */
	@Override
	public Card getNextCard(Trick trick)
	{
		Card maxCard = null;
		Card minCard = null;
		Card winCard = null;
		Card.Suit trumps = trick.getTrumps();
		Set<Card> leadingCards = null;
		if (trick.getLeadSuit() != null)
		{
			leadingCards = player.getHand().matches(trick.getLeadSuit());
		}
		Iterator<Card> cards = player.getHand().iterator();

		if (trick.getCardsPlayed() != null)
		{
			for (Card card : trick.getCardsPlayed())
			{
				if (card.suit() == trumps || card.suit() == trick.getLeadSuit())
				{
					if (winCard == null)
					{
						winCard = card;
						// Compare with trumps to determine if win is possible
					} else if (card.compareTo(winCard, trumps) > 0)
					{
						winCard = card;
					}
				}
			}
		}
		// If the AI has leading cards
		if (leadingCards != null && leadingCards.size() > 0)
		{
			if (trick.getCardsPlayed().size() == 3)
			{
				maxCard = highestWin(leadingCards, winCard, trumps);
			} else
			{
				maxCard = getHighest(leadingCards, trumps);
			}
			minCard = getLowest(leadingCards, trumps);
		}
		// If the AI has a trump
		else if (player.getHand().matches(trumps).size() > 0)
		{
			if (trick.getCardsPlayed().size() == 3)
			{
				maxCard = highestWin(player.getHand().matches(trumps), winCard, trumps);
			} else
			{
				maxCard = getHighest(player.getHand().matches(trumps), trumps);
			}
			minCard = getLowest(player.getHand().matches(trumps), trumps);
		} else
		{
			// Iterate through the cards
			while (cards.hasNext())
			{
				Card nextCard = cards.next();
				if (minCard == null)
				{
					minCard = nextCard;
				}
				if (maxCard == null)
				{
					maxCard = nextCard;
				}
				// Determining the lowest card
				if (nextCard.compareTo(minCard, null) < 0)
				{
					minCard = nextCard;
				} else if (nextCard.compareTo(minCard, null) == 0 && nextCard.compareTo(minCard, trumps) < 0)
				{
					minCard = nextCard;
				}
				// Determining the highest card
				if (nextCard.compareTo(maxCard, null) > 0)
				{
					maxCard = nextCard;
				} else if (nextCard.compareTo(maxCard, null) == 0 && nextCard.compareTo(maxCard, trumps) > 0)
				{
					maxCard = nextCard;
				}
			}
		}
		if (winCard == null || maxCard.compareTo(winCard, trumps) > 0)
		{
			// The AI player can win the trick
			if (trick.getLeadSuit() == null || maxCard.suit() == trumps || maxCard.suit() == trick.getLeadSuit())
			{
				return maxCard;
			}
		}
		// The AI player cannot win the trick
		return minCard;
	}

	/**
	 * Gets the card with the lowest rank, or suit. With trumps taken into account.
	 * 
	 * @param cards
	 * @param trumps
	 * @return
	 */
	private Card getLowest(Set<Card> cards, Card.Suit trumps)
	{
		Card lowest = null;
		for (Card card : cards)
		{
			if (lowest != null)
			{
				if (card.compareTo(lowest, trumps) < 0)
				{
					lowest = card;
				}
			} else
			{
				lowest = card;
			}
		}
		return lowest;
	}

	/**
	 * Gets the card with the highest rank, or suit. With trumps taken into account.
	 * 
	 * @param cards
	 * @param trumps
	 * @return
	 */
	private Card getHighest(Set<Card> cards, Card.Suit trumps)
	{
		Card highest = null;
		for (Card card : cards)
		{
			if (highest != null)
			{
				if (card.compareTo(highest, trumps) > 0)
				{
					highest = card;
				}
			} else
			{
				highest = card;
			}
		}
		return highest;
	}

	/**
	 * Determines the highest winning card. 
	 * Has to take suits, ranks and also trumps into account.
	 * 
	 * @param cards
	 * @param winning
	 * @param trumps
	 * @return
	 */
	private Card highestWin(Set<Card> cards, Card winning, Card.Suit trumps)
	{
		Card highest = null;
		for (Card card : cards)
		{
			if (highest != null)
			{
				if (card.compareTo(highest, trumps) > 0)
				{
					if (winning == null || highest.compareTo(winning, trumps) <= 0)
					{
						highest = card;
					}
				} else
				{
					if (winning != null && card.compareTo(winning, trumps) > 0)
					{
						highest = card;
					}
				}
			} else
			{
				highest = card;
			}
		}
		return highest;
	}
}
