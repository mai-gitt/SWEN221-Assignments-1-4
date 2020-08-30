// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Provides some mechanisms which are common across all moves.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractMove implements Move
{
	/**
	 * Used to check if moves are valid or not
	 *
	 * @param board
	 * 
	 * @return boolean (true if the move is valid, false if not)
	 */
	@Override
	public boolean isValid(Board board)
	{
		// Create copy of the board which reflects the board after the move is played
		Board b = apply(board);
		ActiveTetromino t = b.getActiveTetromino();

		// If the tetromino is out of bounds either on the left or right of the board
		// then the move is not valid
		if (t.getBoundingBox().getMinX() < 0)
		{
			return false;
		}
		if (t.getBoundingBox().getMaxX() + 1 > b.getWidth())
		{
			return false; // Move is not valid
		}
		// If the rotated tetromino would be overlapping on a
		// previously placed tetromino
		// or if the rotated tetromino is out of bounds from the bottom of the board
		if (!board.canPlaceTetromino(t))
		{
			return false; // Move is not valid
		}
		return true;
	}

}
