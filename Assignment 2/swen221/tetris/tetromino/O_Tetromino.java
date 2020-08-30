// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * The "O" tetromino.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class O_Tetromino extends AbstractTetromino
{
	public O_Tetromino(Color color)
	{
		// NOTE: orientation fixed for this tetromino
		super(Orientation.NORTH, color);
	}

	@Override
	public boolean isWithin(int x, int y)
	{
		return x >= 0 && x < 2 && y >= 0 && y <= 1;
	}

	@Override
	public Rectangle getBoundingBox()
	{
		return new Rectangle(0, 1, 1, 0);
	}

	@Override
	public Tetromino rotate(int steps)
	{
		return this;
	}

	@Override
	public String getName()
	{
		return "O";
	}
}
