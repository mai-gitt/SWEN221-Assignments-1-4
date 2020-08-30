package swen221.chessview.pieces;

import swen221.chessview.*;

/**
 * Represents a Bishop piece. Bishops can only move in straight lines and diagonally for any 
 * distance as long as there are no other pieces in the way. They can also move in any direction.
 * 
 */
public class Bishop extends PieceImpl implements Piece {
	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& board.clearDiaganolExcept(oldPosition, newPosition, p, t);
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "B";
		} else {
			return "b";
		}
	}
}
