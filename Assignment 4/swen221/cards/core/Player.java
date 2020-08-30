package swen221.cards.core;

import java.io.Serializable;

/**
 * Represents a player on the board, which can be either a computer player or a
 * human. Every player has a direction (North, East, South, West) and a hand of
 * cards which they are currently playing.
 * 
 * @author David J. Pearce
 * 
 */
public class Player implements Serializable
{
	/**
	 * Represents one of the four position on the table (North, East, South and
	 * West).
	 * 
	 * @author David J. Pearce
	 * 
	 */
	public enum Direction
	{
		NORTH, EAST, SOUTH, WEST;

		/**
		 * Returns the next direction to play after this one (i.e. following a clockwise
		 * rotation).
		 * 
		 * @return
		 */
		public Direction next()
		{
			if (this.equals(NORTH))
				return EAST;
			if (this.equals(EAST))
				return SOUTH;
			if (this.equals(SOUTH))
				return WEST;
			return NORTH;
		}
		
		public Direction previous() {
            if (this.equals(NORTH))
                return WEST;
            if (this.equals(EAST))
                return NORTH;
            if (this.equals(SOUTH))
                return EAST;
            return SOUTH;
        }
	}

	public final Direction direction;
	public final Hand hand;

	public Player(Direction direction)
	{
		this.direction = direction;
		this.hand = new Hand();
	}

	/**
	 * Get the position in which this player is sitting.
	 * 
	 * @return
	 */
	public Direction getDirection()
	{
		return direction;
	}

	/**
	 * Get the current hand of this player.
	 * 
	 * @return
	 */
	public Hand getHand()
	{
		return hand;
	}
}
