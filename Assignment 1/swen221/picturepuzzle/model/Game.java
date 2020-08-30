// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import swen221.picturepuzzle.moves.Rotation;

/**
 *
 * A Game instance represents a running game of PicturePuzzle. It accepts game
 * operations and updates the board accordingly. Likewise, it provides an API to
 * access the board itself. Finally, it determines when the game is over.
 *
 * @author betty
 *
 */
public class Game
{
	/**
	 * The game board
	 */
	private Board board;

	/**
	 * Create a game from a given image and generate board with corresponding number
	 * of cells
	 *
	 * @param file     The selected image
	 * @param numCells Number of cells on the board
	 */
	public Game(File file, int numCells)
	{
		board = loadImage(file, numCells);
	}

	/**
	 * Get the board of current game
	 *
	 * @return
	 */
	public Board getBoard()
	{
		return board;
	}

	/**
	 * Load an image to create the board.
	 *
	 * @param file     The selected image.
	 * @param numCells Number of cells.
	 * @return the created board.
	 */
	public Board loadImage(File file, int numCells)
	{
		BufferedImage buf = null;
		try
		{
			buf = ImageIO.read(file);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		int ImageWidth = buf.getWidth();
		int ImageHeight = buf.getHeight();

		int[] img = new int[ImageWidth * ImageHeight];

		for (int i = 0; i < ImageWidth; i++)
		{
			for (int j = 0; j < ImageHeight; j++)
			{
				Color c = new Color(buf.getRGB(j, i));
				img[i * ImageWidth + j] = c.getRGB();
			}
		}
		Board board = new Board(img, (int) Math.sqrt(img.length), numCells);

		return board;
	}

	/**
	 * Start a game by shuffling the board.
	 */
	public void start()
	{
		Random random = new Random(System.currentTimeMillis());
		//
		for (int x = 0; x < board.getBoardSize() - 1; ++x)
		{
			for (int y = 0; y < board.getBoardSize() - 1; ++y)
			{
				int steps = random.nextInt(4);
				board.apply(new Rotation(new Location(x, y), steps));
			}
		}
		// Randomly shuffle position of cells in board. This is a bit awkward as we want
		// to reuse the Collections.shuffle method which only works for arrays.
		Cell[] cells = board.getCells();
		List<Cell> l = Arrays.asList(cells);
		Collections.shuffle(l);
		for (int i = 0; i != l.size(); ++i)
		{
			cells[i] = l.get(i);
		}
	}
}
