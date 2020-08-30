package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

/**
 * This represents a "pawn promotion move". When a pawn reaches 
 * the opposite side of the board, it can be promoted to either a
 * Knight, Bishop, Rook or Queen.
 * The pawn cannot be promoted to King or Pawn.
 *
 */
public class PawnPromotion implements MultiPieceMove {
	private Piece promotion;
	private SinglePieceMove move;

	public PawnPromotion(SinglePieceMove move, Piece promotion) {
		this.move = move;
		this.promotion = promotion;
	}

	@Override
	public boolean isWhite() {
		return move.isWhite();
	}

	@Override
	public boolean isValid(Board board) {
		int row = isWhite() ? 8 : 1;
		if (promotion instanceof King || promotion instanceof Pawn) {
			return false;
		}
		return move.isValid(board) && move.piece() instanceof Pawn
				&& move.newPosition.row() == row;
	}

	@Override
	public void apply(Board board) {
		move.apply(board);
		board.setPieceAt(move.newPosition(), promotion);
	}

	@Override
	public String toString() {
		return move.toString() + "=" + SinglePieceMove.pieceChar(promotion);
	}
}
