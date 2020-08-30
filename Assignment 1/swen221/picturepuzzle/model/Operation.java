// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.model;

/**
 * An operation is any operation based on a board, for example Move......
 *
 * @author betty
 *
 */
public interface Operation
{

	/**
	 * Apply the operation to the board.
	 *
	 * @param board The board on which the operation is applied.
	 *
	 * @return the changed board.
	 */
	public void apply(Board board);
}
