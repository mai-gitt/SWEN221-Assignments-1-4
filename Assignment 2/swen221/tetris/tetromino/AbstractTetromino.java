// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tetromino;

/**
 * Provides a base implementation from which all concrete tetromino's extend.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractTetromino implements Tetromino
{

	/**
	 * The orientation of this Tetromino.
	 */
	protected Orientation orientation;

	/**
	 * color of the Tetromino cells
	 */
	protected Color color;

	AbstractTetromino(Orientation orientation, Color color)
	{
		this.orientation = orientation;
		this.color = color;
	}

	@Override
	public Color getColor()
	{
		return color;
	}

	@Override
	public Orientation getOrientation()
	{
		return orientation;
	}

	public abstract String getName();

	@Override
	public String toString()
	{
		return "(" + getName() + ";" + orientation + ";" + color.toString() + ")";
	}
}
