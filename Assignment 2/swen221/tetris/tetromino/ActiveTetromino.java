// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * Represents a tetromino which has not yet been placed on the board. That is, a
 * tetromino which is "in flight" and has a center position on the board. Once a
 * tetrmino has been placed, it loses the concept of a center position as this
 * no longer makes sense.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class ActiveTetromino implements Tetromino
{
	/**
	 * The tetromino underlying this active tetromino. This determins the shape,
	 * color and orientation of this tetromino.
	 */
	private final Tetromino tetromino;

	/**
	 * Column coordinate of the center of the Tetromino
	 */
	protected final int x;

	/**
	 * Row coordinate of the center of the Tetromino
	 */
	protected final int y;

	public ActiveTetromino(int x, int y, Tetromino tetromino)
	{
		if (tetromino == null)
		{
			throw new IllegalArgumentException("invalid tetromino!");
		}
		this.x = x;
		this.y = y;
		this.tetromino = tetromino;
	}

	@Override
	public Color getColor()
	{
		return tetromino.getColor();
	}

	@Override
	public Orientation getOrientation()
	{
		return tetromino.getOrientation();
	}

	/**
	 * Get the abstract tetromino underlying this active tetromino.
	 *
	 * @return
	 */
	public Tetromino getUnderlyingTetromino()
	{
		return tetromino;
	}

	@Override
	public boolean isWithin(int x, int y)
	{
		int dx = x - this.x;
		int dy = y - this.y;
		//
		switch (tetromino.getOrientation())
		{
		case NORTH:
			return tetromino.isWithin(dx, dy);
		case SOUTH:
			return tetromino.isWithin(-dx, -dy);
		case EAST:
			return tetromino.isWithin(-dy, dx);
		case WEST:
		default:
			return tetromino.isWithin(dy, -dx);
		}
	}

	@Override
	public Rectangle getBoundingBox()
	{
		Rectangle box = tetromino.getBoundingBox();
		switch (tetromino.getOrientation())
		{
		case WEST:
			box = box.rotateClockwise();
		case SOUTH:
			box = box.rotateClockwise();
		case EAST:
			box = box.rotateClockwise();
		}
		return box.translate(x, y);
	}

	/**
	 * Move this Tetromino by a given amount in the x and/or y direction.
	 *
	 * @param dx The amount to move in the x direction.
	 * @param dy The amount to move in the y direction.
	 * @return
	 */
	public ActiveTetromino translate(int dx, int dy)
	{
		return new ActiveTetromino(x + dx, y + dy, tetromino);
	}

	@Override
	public ActiveTetromino rotate(int steps)
	{
		return new ActiveTetromino(x, y, tetromino.rotate(steps));
	}

	@Override
	public String toString()
	{
		return tetromino.toString();
	}

	@Override
	public String getName()
	{
		return tetromino.getName();
	}
}
