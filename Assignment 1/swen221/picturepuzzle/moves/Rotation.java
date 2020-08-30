// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import java.util.Arrays;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation
{
	private final Location location;
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc
	 * @param steps
	 */
	public Rotation(Location loc, int steps)
	{
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Convert 1D int array to 2D cell array Returns 2D int array
	 * 
	 * @param cell  which needs to be rotated
	 * @param width of image in cell
	 */
	public int[][] convertArray(Cell myCell, int width)
	{
		int[] array1D = myCell.getImage();
		int[][] array2D = new int[width][width];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < width; j++)
			{
				array2D[i][j] = array1D[(i * width) + j];
			}
		}
		return array2D;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param cell  The cell on which the rotation is applied.
	 *
	 * @param steps Number of steps to rotate in clockwise direction.
	 */
	@Override
	public void apply(Board board)
	{
		Cell myCell = board.getCellAt(location);
		if (myCell != null)
		{
			int width = myCell.getWidth();
			int[][] image = convertArray(myCell, width);
			
			// Running the rotate image code as many times as the steps provided
			int steps = this.steps;
			while (steps > 0)
			{
			// Making a temporary array to store the rotated values
			int[][] temp = new int[width][width];
			
				// Rotating the image 90 degrees clockwise
				for (int row = 0; row < width; row++)
				{
					for (int col = 0; col < width; col++)
					{
						temp[row][col] = image[width - col - 1][row];
					}
				}
				image = temp;
				steps--;
			}

			// Setting the new RGB values for the cell image
			for (int i = 0; i < width; i++)
			{
				for (int j = 0; j < width; j++)
				{
					myCell.setRGB(i, j, image[j][i]);
				}
			}
		}
	}
}