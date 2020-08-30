package swen221.chessview.pieces;

import swen221.chessview.*;

/**
 * Represents a Rook piece. Rooks can only move in straight lines along rows and cols for any distance
 * as long as there are no other pieces in the way. They can also move in any direction.
 * 
 */
public class Rook extends PieceImpl implements Piece {
	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (board.clearColumnExcept(oldPosition, newPosition, p, t) || board
						.clearRowExcept(oldPosition, newPosition, p, t));
	}

	@Override
	public String toString() {
		if(isWhite) {
			return "R";
		} else {
			return "r";
		}
	}
}
