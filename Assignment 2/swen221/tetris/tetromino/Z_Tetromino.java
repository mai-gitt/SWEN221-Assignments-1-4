// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * The "Z" tetromino.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class Z_Tetromino extends AbstractTetromino
{
	public Z_Tetromino(Orientation orientation, Color color)
	{
		super(orientation, color);
	}

	@Override
	public boolean isWithin(int x, int y)
	{
		return (x == -1 && y == 1) || (x == 0 && y == 1) || (x == 0 && y == 0) || (x == 1 && y == 0);
	}

	@Override
	public Rectangle getBoundingBox()
	{
		return new Rectangle(-1, 1, 1, 0);
	}

	@Override
	public Tetromino rotate(int steps)
	{
		return new Z_Tetromino(orientation.rotate(steps), color);
	}

	@Override
	public String getName()
	{
		return "Z";
	}
}
