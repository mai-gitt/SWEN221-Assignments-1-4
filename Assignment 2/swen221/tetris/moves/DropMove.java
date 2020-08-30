// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;

import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a "hard drop". That is, when the tetromino is immediately dropped
 * all the way down as far as it can go.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
/**
 * @author Mai
 *
 */
public class DropMove implements Move
{
	/**
	 * Used to check if moves are valid or not
	 *
	 * @param Board board
	 * 
	 * @return boolean (true if the move is valid, false if not)
	 */
	@Override
	public boolean isValid(Board board)
	{
		// Making a temporary tetromino moved down one unit
		ActiveTetromino t = board.getActiveTetromino().translate(0, -1);
		// If the rotated tetromino would be overlapping on a
		// previously placed tetromino
		// or if the rotated tetromino is out of bounds from the bottom of the board
		if (!board.canPlaceTetromino(t))
		{
			return false; // Move is not valid
		}
		return true;
	}

	/**
	 * Drops the active tetromino to the base of the board
	 *
	 * @param board
	 * 
	 * @return board after the rotation has taken place
	 */
	@Override
	public Board apply(Board board)
	{
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		ActiveTetromino t = null;

		// While the move is valid
		while (isValid(board))
		{
			// Apply gravity (stops when move is no longer valid)
			t = board.getActiveTetromino().translate(0, -1);
			board.setActiveTetromino(t);
		}
		return board;
	}

	@Override
	public String toString()
	{
		return "drop";
	}
}
