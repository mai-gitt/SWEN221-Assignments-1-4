// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import swen221.tetris.moves.DropMove;
import swen221.tetris.moves.Move;
import swen221.tetris.moves.ClockwiseRotation;
import swen221.tetris.moves.AbstractTranslation;
import swen221.tetris.tetromino.*;

/**
 * A Game instance represents a running game of Tetris. It accepts game moves
 * and updates the board accordingly. Likewise, it provides an API to access the
 * board itself. Finally, it determines when the game is over (i.e. because the
 * board is full).
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Game
{
	/**
	 * An (infinite) sequence of tetrominos to be used to determine the next
	 * tetromino.
	 */
	private final Iterator<Tetromino> tetrominoSequence;

	/**
	 * The next tetromnino to be issued. This is useful, amongst other things, for
	 * showing the user what is coming next.
	 */
	private ActiveTetromino nextTetromino;

	/**
	 * The current state of the game board.
	 */
	private Board board;

	/**
	 * Records the number of lines which have been removed.
	 */
	private int lines;
	/**
	 * Records the current score which is determined as a function of the number of
	 * lines removed.
	 */
	private int score;

	public Game(Iterator<Tetromino> sequence, int width, int height)
	{
		this.tetrominoSequence = sequence;
		// Initial boards list with an empty board.
		this.board = new Board(sequence, width, height);
		// Initialise next tetromino
		this.nextTetromino = nextActiveTetromino();
	}

	/**
	 * Get number of lines removed
	 *
	 * @return
	 */
	public int getLines()
	{
		return lines;
	}

	/**
	 * Get the current score.
	 *
	 * @return
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * Get the current board being acted upon.
	 *
	 * @return
	 */
	public Board getActiveBoard()
	{
		return board;
	}

	/**
	 * Get the next tetromino which will be issued.
	 *
	 * @return
	 */
	public Tetromino getNextTetromino()
	{
		return nextTetromino.getUnderlyingTetromino();
	}

	/**
	 * Check whether the game is over. This happens when we can no longer place the
	 * next tetromino.
	 *
	 * @return
	 */
	public boolean isGameOver()
	{
		// Game is over when can no longer place next tetromino
		return !board.canPlaceTetromino(nextTetromino);
	}

	/**
	 * Reset the game so another can be played.
	 */
	public void reset()
	{
		// reset the line count
		this.lines = 0;
		// reset the score
		this.score = 0;
		// reset the board
		this.board = new Board(tetrominoSequence, board.getWidth(), board.getHeight());
	}

	/**
	 * Apply a given move to the board. This will update the board if the move is
	 * valid, otherwise it will be ignored.
	 *
	 * @param move
	 */
	public boolean apply(Move move)
	{
		ActiveTetromino t = board.getActiveTetromino();
		if (t != null)
		{
			// Check whether the move was valid as, if not, then it's ignored.
			if (move.isValid(board))
			{
				// Yes, move is valid therefore apply it for real.
				board = move.apply(board);
				return true;
			} else
			{
				// This move was ignored.
				return false;
			}
		}
		return false;
	}

	/**
	 * Clock the game for another cycle. This will apply gravity to the board and
	 * check whether or not the active tetromino has landed. If the piece has
	 * landed, then we will remove full rows, etc.
	 */
	public void clock()
	{
		ActiveTetromino activeTetromino = board.getActiveTetromino();
		// Check whether it has landed
		if (activeTetromino != null)
		{
			// apply gravity
			activeTetromino = activeTetromino.translate(0, -1);
			if (!board.canPlaceTetromino(activeTetromino))
			{
				// Move up 1 unit
				activeTetromino = activeTetromino.translate(0, 1);
				// Placing tetromino and setting the active tetromino to null
				board.placeTetromino(activeTetromino);
				activeTetromino = null;
				// Remove rows that are full
				this.fullRows(board);

			}
		} else if (tetrominoSequence.hasNext() && board.canPlaceTetromino(nextTetromino))
		{
			// promote next tetromino to be active
			activeTetromino = nextTetromino;
			// select the next one in sequence
			nextTetromino = nextActiveTetromino();
		} else
		{
			// indicates game over status
		}
		board.setActiveTetromino(activeTetromino);
	}

	/**
	 * Checks if the any rows are full. Calls removeLines method, passing the y
	 * coordinate of the full rows
	 * 
	 * @param board
	 * 
	 */
	public void fullRows(Board board)
	{
		// Iterating through each row to check if row is full
		for (int y = 0; y < board.getHeight(); y++)
		{
			boolean fullRow = true;
			for (int x = 0; x < board.getWidth(); x++)
			{
				if (board.getCells()[(y * board.getWidth()) + x] == null)
				{
					// If any cell is null, the row is not full
					fullRow = false;
				}
			}
			if (fullRow)
			{
				this.removeLines(y);
				y--;
			}
		}
	}

	/**
	 * Removes full rows
	 * 
	 * @param int y coordinate of the row which is going to be removed
	 * 
	 */
	public void removeLines(int y)
	{
		// Iterating through each row and column to remove rows that are full
		for (int i = y; i < board.getHeight(); i++)
		{
			for (int j = board.getWidth() - 1; j >= 0; j--)
			{
				if (i == board.getHeight() - 1)
				{
					// If its the top row, every cell is made null
					board.getCells()[(i * board.getWidth()) + j] = null;

				} else
				{
					// Every cell is made into the cell above it
					board.getCells()[(i * board.getWidth()) + j] = board.getCells()[((i + 1) * board.getWidth()) + j];
				}
			}
		}
		lines++;
	}

	// ======================================================================
	// Helper methods
	// ======================================================================

	/**
	 * Determine the next active tetromino for the board.
	 *
	 * @return
	 */
	private ActiveTetromino nextActiveTetromino()
	{
		// Determine center for next tetromino
		int cx = board.getWidth() / 2;
		int cy = board.getHeight() - 2;
		// set next tetromino
		return new ActiveTetromino(cx, cy, tetrominoSequence.next());
	}
}
