// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a rotation move which is either clockwise or anti-clockwise.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class ClockwiseRotation extends AbstractMove implements Move
{

	/**
	 * Applies the clockwise rotation
	 *
	 * @param Board board
	 * 
	 * @return board after the rotation has taken place
	 */
	@Override
	public Board apply(Board board)
	{
		if (isValid(board))
		{
			// Create copy of the board to prevent modifying its previous state.
			board = new Board(board);
			// Create a copy of this board which will be updated.

			ActiveTetromino tetromino = board.getActiveTetromino().rotate(1);
			// Apply the move to the new board, rather than to this board.
			board.setActiveTetromino(tetromino);
		}
		// Return updated version of this board.
		return board;
	}

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
		// Making a temporary rotated tetromino
		ActiveTetromino t = board.getActiveTetromino().rotate(1);

		// If the rotated tetromino is out of bounds either on the left or right of the
		// board
		// then the move is not valid
		if (t.getBoundingBox().getMinX() < 0)
		{
			return false;
		}
		if (t.getBoundingBox().getMaxX() + 1 > board.getWidth())
		{
			return false;
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
