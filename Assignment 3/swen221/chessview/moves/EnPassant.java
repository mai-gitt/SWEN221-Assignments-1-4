package swen221.chessview.moves;

import swen221.chessview.*;
import swen221.chessview.pieces.*;

/**
 * This represents an "en passant move" ---
 * http://en.wikipedia.org/wiki/En_passant.
 *
 * @author djp
 *
 */
public class EnPassant extends SinglePieceTake
{
	SinglePieceMove move;

	public EnPassant(SinglePieceMove move)
	{
		super(move.piece(), new Pawn(!move.piece().isWhite()), move.oldPosition(), move.newPosition());
		this.move = move;
	}

	@Override
	public boolean isValid(Board board)
	{
		// Finally, check piece being taken did the double step
		Position takePosition = getTakenPosition();
		Piece takenPiece = board.pieceAt(takePosition);
		if (this.checkValidPieceTaken(board) && this.checkValidPositions())
		{
			if (((Pawn) takenPiece).wasDoubleStep())
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void apply(Board board)
	{
		board.move(oldPosition, newPosition);
		board.setPieceAt(getTakenPosition(), null);
	}

	/**
	 * Check that a valid piece is taken (i.e. it's a pawn, it's the right colour,
	 * etc)
	 *
	 * @param board
	 * @return
	 */
	private boolean checkValidPieceTaken(Board board)
	{
		if (board.pieceAt(newPosition) != null)
		{
			// Cannot have piece at position we're moving to
			return false;
		} else
		{
			Position takePosition = getTakenPosition();
			Piece takenPiece = board.pieceAt(takePosition);
			if (takenPiece == null || takenPiece.isWhite() == piece.isWhite() || !(takenPiece instanceof Pawn))
			{
				// we're not taking a valid piece
				return false;
			}
		}
		return true;
	}

	/**
	 * Check new and old positions are valid
	 *
	 * @return
	 */
	private boolean checkValidPositions()
	{
		int dir = piece.isWhite() ? 1 : -1;
		int finalRow = piece.isWhite() ? 6 : 3;
		if (newPosition.row() != finalRow)
		{
			// Invalid final position
			return false;
		} else if (newPosition.row() != (oldPosition.row() + dir))
		{
			// Invalid new position row
			return false;
		} else if (newPosition.column() != (oldPosition.column() + 1)
				&& newPosition.column() != (oldPosition.column() - 1))
		{
			// Invalid new position column
			return false;
		}
		//
		return true;
	}

	/**
	 * Calculate position of piece being taken
	 */
	private Position getTakenPosition()
	{
		int dir = piece.isWhite() ? -1 : 1;
		return new Position(newPosition.row() + dir, newPosition.column());
	}

	@Override
	public String toString()
	{
		return move.toString() + "ep";
	}
}
