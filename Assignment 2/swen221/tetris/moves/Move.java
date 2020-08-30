// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;

/**
 * A move is any move which is permitted by the player during a game. This
 * includes simple moves (where pieces are rotate or moved), to more complex
 * ones (e.g. removing lines from the board).
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public interface Move
{
	/**
	 * Check whether this move is valid or not for a given tetromino on a given
	 * board.
	 *
	 * @param board Board on which Tetromino is being moved.
	 * @return
	 */
	public boolean isValid(Board board);

	/**
	 * Update the board to reflect the board after the move is played.
	 *
	 * @param board Board on which Tetromino is being moved.
	 */
	public Board apply(Board board);

}
