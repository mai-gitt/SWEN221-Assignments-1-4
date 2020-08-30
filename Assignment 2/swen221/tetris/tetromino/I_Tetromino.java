// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.Tetromino.Orientation;

/**
 * I is the 'bar'.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class I_Tetromino extends AbstractTetromino
{
	public I_Tetromino(Orientation orientation, Color color)
	{
		super(orientation, color);
	}

	@Override
	public boolean isWithin(int x, int y)
	{
		return x >= -1 && x <= 2 && y == 0;
	}

	@Override
	public Rectangle getBoundingBox()
	{
		return new Rectangle(-1, 0, 2, 0);
	}

	@Override
	public Tetromino rotate(int steps)
	{
		return new I_Tetromino(orientation.rotate(steps), color);
	}

	@Override
	public String getName()
	{
		return "I";
	}
}
