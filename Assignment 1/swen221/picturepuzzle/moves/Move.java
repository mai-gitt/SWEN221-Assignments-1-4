// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for moving a cell from a given position on the board into the
 * "blank" cell. Thus, if we click on a given cell then that cells moves into
 * the blank cell if it cann.
 *
 * @author betty
 *
 */
public class Move implements Operation
{
	private final Location location;

	/**
	 * Construction a move operation to move a given cell into the blank location
	 * (if possible). If the blank location is not "next to" this cell, then nothing
	 * happens.
	 *
	 * @param loc
	 * @param steps
	 */
	public Move(Location loc)
	{
		this.location = loc;
	}

	/**
	 * Move the selected cell into the blank location if possible.
	 *
	 * @param board The board on which the move is applied.
	 *
	 */
	@Override
	public void apply(Board board)
	{
		Location blank = findBlankLocation(board);
		// Only a cell next to the blank cell can be moved.
		if (nextTo(location, blank))
		{
			// Move the selected cell by swapping it with the blank cell.
			board.swap(blank, location);
		}
	}

	/**
	 * Determine the location of the blank cell. This is done by simply sweeping
	 * through every cell location looking for null (which represents the blank
	 * cell).
	 *
	 * @param board
	 * @return
	 */
	private static Location findBlankLocation(Board board)
	{
		for (int x = 0; x < board.getBoardSize(); x++)
		{
			for (int y = 0; y < board.getBoardSize(); y++)
			{
				Location l = new Location(x, y);
				if (board.getCellAt(l) == null)
				{
					// Found it
					return l;
				}
			}
		}
		// NOTE: should be unreachable as every board has a blank cell.
		throw new IllegalArgumentException("cannot find blank cell?");
	}

	/**
	 * Check whether a given location is "next to" another. For example, (0,0) is
	 * next to (0,1). But, (0,0) is not next to (1,1).
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static boolean nextTo(Location l1, Location l2)
	{
		boolean nextTo = false;
		
		//making sure that diagonals are not counted as being next to
		if ((l1.row == l2.row - 1 && l1.col == l2.col) || (l1.row == l2.row + 1 && l1.col == l2.col))
		{
			nextTo = true;
		}
		if ((l1.row == l2.row && l1.col == l2.col - 1) || (l1.row == l2.row && l1.col == l2.col + 1))
		{
			nextTo = true;
		}
		return nextTo;
	}
}
