package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

/**
 * This represents a "castling move". Castling involves the rook and the king.
 * It can only be done if the king has never moved before, 
 * and if the king is not currently in check
 *
 */
public class Castling implements MultiPieceMove
{
	private boolean isWhite;
	private boolean kingSide;

	public Castling(boolean isWhite, boolean kingSide)
	{
		this.isWhite = isWhite;
		this.kingSide = kingSide;
	}

	@Override
	public boolean isWhite()
	{
		return isWhite;
	}

	@Override
	public void apply(Board board)
	{
		int row = isWhite ? 1 : 8;
		int rcol = kingSide ? 8 : 1;
		int rncol = kingSide ? 6 : 4;
		int kncol = kingSide ? 7 : 3;

		Position kpos = new Position(row, 5);
		Position knpos = new Position(row, kncol);
		Position rpos = new Position(row, rcol);
		Position rnpos = new Position(row, rncol);

		board.move(kpos, knpos);
		board.move(rpos, rnpos);
	}

	@Override
	public boolean isValid(Board board)
	{
		int row = isWhite ? 1 : 8;
		int col = kingSide ? 8 : 1;
		Position kpos = new Position(row, 5);
		Position rpos = new Position(row, col);
		Piece king = board.pieceAt(kpos);
		Piece rook = board.pieceAt(rpos);

		int skipCol = kingSide ? 6 : 4; // The col the king is skipping
		int endCol = kingSide ? 7 : 3; // The col of the king's end pos

		return king != null && rook != null && king.equals(new King(isWhite)) && rook.equals(new Rook(isWhite))
				&& board.clearRowExcept(kpos, rpos, king, rook) && !board.kingMoved(isWhite)
				&& !board.rookMoved(isWhite, kingSide) && !isInCheck(isWhite, kpos, board)
				&& !isInCheck(isWhite, new Position(row, skipCol), board)
				&& !isInCheck(isWhite, new Position(row, endCol), board);
	}

	/**
	 * 
	 * @param isWhite
	 * @param position
	 * @param board
	 * 
	 * @return 	returns true if the king is check or would be in check while skipping positions during castling
	 * 
	 */
	public boolean isInCheck(boolean isWhite, Position position, Board board)
	{

		Board temp = new Board(board); // Create a temporary board to not disturb the current state
		King king = new King(isWhite);
		temp.setPieceAt(position, king); // Place the king in the position

		for (int row = 1; row <= 8; ++row)
		{
			for (int col = 1; col <= 8; ++col)
			{
				Position pos = new Position(row, col);
				Piece p = board.pieceAt(pos);
				if (p != null && p.isWhite() != isWhite && p.isValidMove(pos, position, king, temp))
				{
					return true;	// King is in check
				}
			}
		}
		return false;
	}

	@Override
	public String toString()
	{
		if (kingSide)
		{
			return "O-O";
		} else
		{
			return "O-O-O";
		}
	}
}
