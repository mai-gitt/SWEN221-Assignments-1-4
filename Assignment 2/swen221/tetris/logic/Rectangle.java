// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.logic;

/**
 * Represents a rectangle of cells on the Tetris board.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class Rectangle
{
	private final int minX;
	private final int minY;
	private final int maxX;
	private final int maxY;

	/**
	 * Construct a new rectangle at a given position with a given width and height.
	 *
	 * @param ulx The x-coordinate of the upper left-hand corner.
	 * @param uly The y-coordinate of the upper left-hand corner.
	 * @param brx The x-coordinate of the bottom right-hand corner.
	 * @param bry the y-coordinate of the bottom right-hand corner;
	 */
	public Rectangle(int ulx, int uly, int brx, int bry)
	{
		this.minX = ulx;
		this.maxY = uly;
		this.maxX = brx;
		this.minY = bry;
		if (minX > maxX || minY > maxY)
		{
			throw new IllegalArgumentException("Invalid Rectangle " + this);
		}
	}

	/**
	 * Get the x-coordinate of the left-hand side of the rectangle.
	 *
	 * @return x-coordinate.
	 */
	public int getMinX()
	{
		return minX;
	}

	/**
	 * Get the x-coordinate of the right-hand side of the rectangle.
	 *
	 * @return x-coordinate.
	 */
	public int getMaxX()
	{
		return maxX;
	}

	/**
	 * Get the y-coordinate of the upper side of the rectangle.
	 *
	 * @return y-coordinate.
	 */
	public int getMaxY()
	{
		return maxY;
	}

	/**
	 * Get the y-coordinate of the lower side of the rectangle.
	 *
	 * @return y-coordinate.
	 */
	public int getMinY()
	{
		return minY;
	}

	/**
	 * Translate a given rectangle by a give horizontal and vertical amount.
	 *
	 * @param dx The horizontal amount to translate.
	 * @param dy The vertical amount to translate.
	 * @return
	 */
	public Rectangle translate(int dx, int dy)
	{
		return new Rectangle(minX + dx, maxY + dy, maxX + dx, minY + dy);
	}

	/**
	 * Rotate a give rectangle about the origin (i.e. coordinate "0,0"). As a simple
	 * example consider this:
	 *
	 * <pre>
	 * 5|
	 * 4|  +-+
	 * 3|  | |
	 * 2|  | |
	 * 1|  +-+
	 * 0+--------
	 *  012345678
	 * </pre>
	 *
	 * Here, we have a rectangle defined by <code>(3,4)-(5,1)</code>. After a single
	 * clockwise rotation, this looks like so:
	 *
	 * <pre>
	 *   012345678
	 *  0+--------
	 * -1|
	 * -2|
	 * -3|+--+
	 * -4||  |
	 * -5|+--+
	 * </pre>
	 *
	 * The resulting rectangle is now defined by <code>(1,-3)-(4,-5)</code>.
	 *
	 * @return
	 */
	public Rectangle rotateClockwise()
	{
		return new Rectangle(minY, -minX, maxY, -maxX);
	}

	@Override
	public String toString()
	{
		return "(" + getMinX() + "," + getMaxY() + ")-(" + getMaxX() + "," + getMinY() + ")";
	}
}
