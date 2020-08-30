// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import swen221.picturepuzzle.moves.Rotation;

/**
 * A Board instance represents a board configuration for a game of
 * PicturePuzzle. It is represented as an image and divided into an array of
 * Cells.
 *
 * @author betty
 *
 */
public class Board
{
	private final int width; // Width of the image (in pixels).
	private final int dimension; // Number of cells in each direction (e.g. 3x3)
	private Cell[] cells; // The cells on the board.
	private static Cell[] originalImage;

	/**
	 * Construct a new board with the specific image, width and number of cells. The
	 * last cell of the board is set to blank.
	 *
	 * @param image      The image on the board. *********The image is represented
	 *                   by hexadecimal color, high 8 bits for red, middle 8 bits
	 *                   for green, low 8 bits for blue.
	 *
	 * @param width      Width of the image.
	 *
	 * @param dimensions Number of cells in each direction.
	 *
	 * @throws NullPointerException     if the image is null.
	 *
	 * @throws IllegalArgumentException if the image is empty or, if cells.length is
	 *                                  not a non-null positive integer or, if the
	 *                                  image is not divisible by width or, if the
	 *                                  number of cells is larger than the number of
	 *                                  pixels or, if the image is not square or, if
	 *                                  the number of cells is not a perfect square
	 *                                  number.
	 */
	public Board(int[] image, int width, int dimension)
	{

		if (image == null)
		{
			throw new NullPointerException("The image is null.");
		}
		if (image.length < 1)
		{
			throw new IllegalArgumentException("The image is empty.");
		}
		if (width <= 0)
		{
			throw new IllegalArgumentException("Width must be positive");
		}
		if (dimension < 1)
		{
			throw new IllegalArgumentException("The number of cells is not a non-null positive integer.");
		}
		if (image.length % width != 0)
		{
			throw new IllegalArgumentException("Image is not divisible by width.");
		}
		if (image.length != (width * width))
		{
			throw new IllegalArgumentException("The image is not square.");
		}
		this.width = width;
		this.dimension = dimension;
		this.cells = divideUpImage(image, width, dimension);
	}

	/**
	 * Get size of this board.
	 *
	 * @return
	 */
	public int getBoardSize()
	{
		return dimension;
	}

	/**
	 * Get all cells on this board.
	 *
	 * @return
	 */
	public Cell[] getCells()
	{
		return cells;
	}

	/**
	 * Get a cell at given location.
	 *
	 * @param loc A location on a board.
	 *
	 * @return the cell at the given position.
	 */
	public Cell getCellAt(Location loc)
	{
		return cells[(loc.row * dimension) + loc.col];
	}

	/**
	 * Check whether the board is actually completed or not.
	 *
	 * @return
	 */
	public boolean isFinished()
	{
		boolean finished = false;

		// Finding the blank cell
		for (int x = 0; x < dimension; x++)
		{
			for (int y = 0; y < dimension; y++)
			{
				Location l = new Location(x, y);
				if (getCellAt(l) == null)
				{
					// Making the cell with the same location as the blank cell in the original
					// image array also blank
					originalImage[(l.row * dimension) + l.col] = null;
				}
			}
		}
		// Checking if all the cells in the original image array and the cells array are
		// the same
		for (int i = 0; i < cells.length; i++)
		{
			if (cells[i] == originalImage[i])
			{
				finished = true;
			}
			// If there is a cell that is not the same, the game continues and the code
			// exits the loop
			else
			{
				finished = false;
				break;
			}

		}

		return finished;
	}

	/**
	 * Apply a given operation to this board.
	 *
	 * @param operation
	 */
	public void apply(Operation operation)
	{
		// double dispatch on this board
		operation.apply(this);
	}

	/**
	 * Swap the cells with given location on the board.
	 *
	 * @param l1 Location of the first cell.
	 * @param l2 Location of the second cell.
	 */
	public void swap(Location l1, Location l2)
	{
		int id1 = (l1.row * dimension) + l1.col;
		int id2 = (l2.row * dimension) + l2.col;

		Cell temp = cells[id1];
		cells[id1] = cells[id2];
		cells[id2] = temp;
	}

	@Override
	public String toString()
	{
		StringBuilder res = new StringBuilder();
		//
		int cellWidth = width / dimension;
		res.append(makeHorizontalBars() + '\n');
		for (int y = 0; y < dimension; y++)
		{ // For each row of Cells
			for (int cy = 0; cy < cellWidth; cy++)
			{ // For each row of pixels within a Cell
				for (int x = 0; x < dimension; x++)
				{ // For each column of Cells
					res.append("|");
					Cell cell = cells[(y * dimension) + x];
					for (int cx = 0; cx < cellWidth; cx++)
					{ // For each column of pixels within a Cell
						if (cell != null)
						{
							// hash followed by the 6 bits representing the hexadecimal pixels
							res.append(String.format(" #%06X ", cell.getRGB(cx, cy)));
						} else
						{
							// Blank cell: 9 space character for the blank cell (6 for pixels, 1 for hash,
							// 2 for surrounding space)
							res.append(String.format("%9s", ""));
						}
					}
				}
				res.append("|\n");
			}
			res.append(makeHorizontalBars() + '\n');
		}
		return res.toString();
	}

	/**
	 * Create a horizontal bar of appropriate width
	 *
	 * @return
	 */
	private String makeHorizontalBars()
	{
		StringBuilder res = new StringBuilder();
		int cellWidth = width / dimension;
		for (int i = 0; i < dimension; i++)
		{
			res.append("+");
			for (int j = 0; j < cellWidth; j++)
			{
				// 9 dash (6 for pixels, 1 for hash, 2 for surrounding space)
				res.append("---------");
			}
		}
		res.append("+");
		return res.toString();
	}

	/**
	 * Divide the board into a square array of cells arranged such that the first
	 * row of cells comes first, then the second row, etc.
	 *
	 * @return an array of Cells.
	 */
	private static Cell[] divideUpImage(int[] image, int width, int dimension)
	{
		Cell[] result = new Cell[dimension * dimension];

		for (int y = 0; y < dimension; y++)
		{
			for (int x = 0; x < dimension; x++)
			{
				int index = (y * dimension) + x;
				result[index] = carveOutCell(image, width, dimension, x, y);
			}
		}
		// Throw away last cell
		result[result.length - 1] = null;

		// Defining the original image to use to determine whether the game is finished
		// later on
		originalImage = result.clone();
		return result;
	}

	/**
	 * Given the complete image, construct a new cell at a given cell position on
	 * the board. To do this, we need to copy the relevant image data from the image
	 * into the cell itself.
	 *
	 * @param image     --- Image being carved up into cells
	 * @param width     --- Width of the image
	 * @param dimension --- Number of cells in horizontal and vertical direction
	 * @param cx        --- X coordinate for cell to carve out
	 * @param cy        --- Y coordinate for cell to carve out
	 * @return
	 */
	private static Cell carveOutCell(int[] image, int width, int dimension, int cx, int cy)
	{
		int cellWidth = width / dimension;
		int[] part = new int[cellWidth * cellWidth]; // Part of the image attribute to a Cell

		for (int x = 0; x < cellWidth; x++)
		{
			int px = (cx * cellWidth) + x;
			for (int y = 0; y < cellWidth; y++)
			{
				int py = (cy * cellWidth) + y;
				part[x + (cellWidth * y)] = image[(py * width) + px];
			}
		}
		return new Cell(part, cellWidth);
	}
}
