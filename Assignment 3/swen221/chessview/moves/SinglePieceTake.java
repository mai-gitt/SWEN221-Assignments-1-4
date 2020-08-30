package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.Piece;

/**
 * Represents a move where a piece captures another 
 * piece using a single piece move.
 */
public class SinglePieceTake extends SinglePieceMove {
	private Piece isTaken;

	public SinglePieceTake(Piece piece, Piece isTaken, Position oldPosition, Position newPosition) {
		super(piece,oldPosition,newPosition);
		this.isTaken = isTaken;
	}

	@Override
	public boolean isValid(Board board) {
		return piece.isValidMove(oldPosition, newPosition, isTaken, board);
	}

	@Override
	public String toString() {
		return pieceChar(piece) + oldPosition + "x" + pieceChar(isTaken) + newPosition;
	}
}
