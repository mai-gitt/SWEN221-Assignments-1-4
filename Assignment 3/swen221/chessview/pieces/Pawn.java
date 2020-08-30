package swen221.chessview.pieces;

import swen221.chessview.*;

/**
 * Represents a Pawn piece. Pawn can only move forward by one step.
 * If the pawn has not been moved before, it is able to take two steps (only once).
 * Only when the pawn is capturing a piece, it can move diagonally one step.
 * If the pawn has another piece directly in front of it, it is unable to move, 
 * unless it is capturing another piece.
 * 
 */
public class Pawn extends PieceImpl implements Piece {
	private boolean wasDoubleStep; // remember whether took double step or not.

	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		int dir = isWhite ? 1 : -1;
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);

		// this logic is more complex than for other pieces, since there is a
		// difference between a take and non-take move for pawns.

		if (isTaken != null) {
			return this.equals(p) && isTaken.equals(t)
					&& (oldCol == (newCol + 1) || oldCol == (newCol - 1))
					&& (oldRow + dir) == newRow;
		} else if ((oldRow + dir) == newRow && oldCol == newCol) {
			return this.equals(p) && t == null;
		} else if ((oldRow + dir + dir) == newRow && oldCol == newCol) {
			return ((dir == 1 && oldRow == 2) || (dir == -1 && oldRow == 7))
					&& board.pieceAt(new Position(oldRow + dir, oldCol)) == null
					&& t == null && this.equals(p);
		}
		return false;
	}

	/**
	 * Return true if the last move made by this piece was a double step.
	 *
	 * @return
	 */
	public boolean wasDoubleStep() {
		return wasDoubleStep;
	}

	public void setDoubleStep(boolean flag) {
		wasDoubleStep = flag;
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "P";
		} else {
			return "p";
		}
	}
}
