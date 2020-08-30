// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import swen221.tetris.logic.Game;
import swen221.tetris.moves.*;
import swen221.tetris.tetromino.*;

/**
 * Tetris Define a Gui allowing to play. This code is quite advanced and uses
 * features that you will learn in the later part of Swen221; do no worry if
 * there are certain parts that you can not understand.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
@SuppressWarnings("serial")
public class Tetris extends JFrame
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() ->
		{
			Tetris frame = new Tetris();
			Game game = new Game(new TetrominoList(), 10, 20);
			//
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.getRootPane().setLayout(new BorderLayout());
			JPanel display = createDisplayCanvas(game);
			JPanel next = createNextTetrominoPanel(game);
			JPanel panel = createInfoPanel(game, next);
			frame.getRootPane().add(display, BorderLayout.CENTER);
			frame.getRootPane().add(panel, BorderLayout.EAST);
			frame.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowOpened(WindowEvent e)
				{
					display.requestFocus();
				}
			});
			frame.pack();
			frame.setVisible(true);
			// to make the cells update their color
			display.revalidate();
			next.revalidate();
			// Construct the "clock"
			ClockThread clock = new ClockThread(game, frame, display, next);
			// Start the clock
			clock.start();
		});
	}

	public static JPanel createDisplayCanvas(Game g)
	{
		// Initialise the game
		// Create the display itself
		JPanel display = new JPanel();
		display.setLayout(new GridLayout(20, 10, 1, 1));
		for (int row = 0; row < 20; row += 1)
		{
			for (int col = 0; col < 10; col += 1)
			{
				display.add(cell(col, 19 - row, g));
			}
		}
		display.setFocusable(true);
		// Add key listeners
		display.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				// NOTE: Multiple threads invoke on the game (Clock Thread and
				// AWT Threads). Hence, need to synchronise here.
				synchronized (g)
				{
					// Check whether active tetromino exists which we can control
					if (g.getActiveBoard().getActiveTetromino() != null)
					{
						switch (e.getKeyCode())
						{
						case KeyEvent.VK_UP:
							g.apply(new ClockwiseRotation());
							break;
						case KeyEvent.VK_DOWN:
							g.apply(new MoveDown());
							break;
						case KeyEvent.VK_LEFT:
							g.apply(new MoveLeft());
							break;
						case KeyEvent.VK_RIGHT:
							g.apply(new MoveRight());
							break;
						case KeyEvent.VK_SPACE:
							g.apply(new DropMove());
							break;
						}
						display.revalidate();
						display.repaint();
					}
				}
			}
		});
		// Done
		return display;
	}

	public static JPanel createInfoPanel(Game g, JPanel nextTetrominoPanel)
	{
		JPanel panel = new JPanel();
		// Set padding to make it look nicer
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		// Create score information
		Component[] bits =
		{ nextTetrominoPanel, Box.createVerticalGlue(), new JLabel("Score"), new JLabel()
		{
			@Override
			public String getText()
			{
				return String.format("%04d", g.getScore());
			}
		}, Box.createVerticalGlue(), new JLabel("Level"), new JLabel()
		{
			@Override
			public String getText()
			{
				return String.format("%04d", g.getLines() / 10);
			}
		}, Box.createVerticalGlue(), new JLabel("Lines"), new JLabel()
		{
			@Override
			public String getText()
			{
				return String.format("%04d", g.getLines());
			}
		}, };
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//
		for (Component c : bits)
		{
			panel.add(c);
			if (c instanceof JLabel)
			{
				JLabel l = (JLabel) c;
				// center labels
				l.setAlignmentX(Component.CENTER_ALIGNMENT);
				// increase size of label fonts
				Font f = l.getFont();
				l.setFont(new Font(f.getName(), Font.BOLD, 24));
			}
		}
		//
		return panel;
	}

	public static JPanel createNextTetrominoPanel(Game g)
	{
		// Initialise the game
		// Create the display itself
		JPanel display = new JPanel();
		// Add border
		display.setBorder(new LineBorder(Color.BLACK, 5));
		//
		display.setLayout(new GridLayout(4, 5, 1, 1));
		for (int row = 2; row >= -1; row -= 1)
		{
			for (int col = -2; col < 3; col += 1)
			{
				display.add(nextCell(col, row, g));
			}
		}
		//
		display.setVisible(true);
		//
		return display;
	}

	/**
	 * Create cells in the Tetris visualization. They use the Game to chose their
	 * color.
	 */
	public static JPanel cell(int col, int row, Game g)
	{
		return new JPanel()
		{
			{
				this.setLayout(null);
			}

			@Override
			public void validate()
			{
				synchronized (g)
				{
					Tetromino t = g.getActiveBoard().getTetrominoAt(col, row);
					this.setBackground(toAwtColor(t));
					super.validate();
				}
			}

			@Override
			public Dimension getPreferredSize()
			{
				return new Dimension(30, 30);
			}
		};
	}

	/**
	 * Create cells in the Tetris visualization. They use the Game to chose their
	 * color.
	 */
	public static JPanel nextCell(int col, int row, Game g)
	{
		return new JPanel()
		{
			{
				this.setLayout(null);
			}

			@Override
			public void validate()
			{
				synchronized (g)
				{
					Tetromino t = g.getNextTetromino();
					Color c = t.isWithin(col, row) ? toAwtColor(t) : Color.white;
					this.setBackground(c);
					super.validate();
				}
			}

			@Override
			public Dimension getPreferredSize()
			{
				return new Dimension(30, 30);
			}
		};
	}

	/**
	 * Convert a TetrominoColor to an AWT color.
	 *
	 * @param color
	 * @return
	 */
	private static Color toAwtColor(Tetromino tetromino)
	{
		if (tetromino == null)
		{
			return java.awt.Color.WHITE;
		} else
		{
			switch (tetromino.getColor())
			{
			case RED:
				return java.awt.Color.RED;
			case ORANGE:
				return java.awt.Color.ORANGE;
			case YELLOW:
				return java.awt.Color.YELLOW;
			case GREEN:
				return java.awt.Color.GREEN;
			case BLUE:
				return java.awt.Color.BLUE;
			case MAGENTA:
				return java.awt.Color.MAGENTA;
			case DARK_GRAY:
			default:
				return java.awt.Color.DARK_GRAY;
			}
		}
	}

	private static class TetrominoList implements Iterator<Tetromino>
	{
		private Random random = new Random(System.currentTimeMillis());

		@Override
		public boolean hasNext()
		{
			// This is an infinite stream
			return true;
		}

		@Override
		public Tetromino next()
		{
			Tetromino.Color[] colors = Tetromino.Color.values();
			int tetromino = random.nextInt(7);
			// NOTE: -1 here because BLACK is reserved for being stuck.
			int color = random.nextInt(colors.length - 1);
			switch (tetromino)
			{
			case 0:
				return new Z_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 1:
				return new S_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 2:
				return new T_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 3:
				return new J_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 4:
				return new L_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			case 5:
				return new O_Tetromino(colors[color]);
			case 6:
				return new I_Tetromino(Tetromino.Orientation.NORTH, colors[color]);
			default:
				throw new IllegalArgumentException("invalid tetromino");
			}
		}
	}

	/**
	 * The Clock Thread is responsible for producing a consistent "pulse" which is
	 * used to fire a downwards move to the game on every cycle.
	 *
	 * @author David J. Pearce
	 *
	 */
	private static class ClockThread extends Thread
	{
		private final Game game;
		private final JFrame frame;
		private final JPanel[] panels;
		private volatile int delayMillis; // delay between ticks in ms

		public ClockThread(Game game, JFrame frame, JPanel... panels)
		{
			this.game = game;
			this.frame = frame;
			this.panels = panels;
		}

		@Override
		public void run()
		{
			while (1 == 1)
			{
				// Loop forever
				try
				{
					Thread.sleep(delayMillis);
					//
					boolean gameOver = false;
					int lines;
					// NOTE: multiple threads invoke on the game (Clock Thread and
					// AWT Threads). Hence, need to synchronise here.
					synchronized (game)
					{
						// apply gravity, etc.
						game.clock();
						// check whether reached game over state
						gameOver = game.isGameOver();
						//
						lines = game.getLines();
					}
					// NOTE: cannot invoke gameOver() inside synchronised block as this can cause a
					// deadlock with an AWT thread.
					if (gameOver)
					{
						gameOver();
					} else
					{
						this.delayMillis = calculateDelayMillis(lines);
					}
					// update the display
					for (JPanel p : panels)
					{
						p.revalidate();
					}
					frame.repaint();
				} catch (InterruptedException e)
				{
					// If we get here, then something wierd happened. It doesn't matter, we can just
					// ignore this and continue.
				}
			}
		}

		/**
		 * Handle a game over event.
		 */
		private void gameOver()
		{
			int choice = JOptionPane.showConfirmDialog(null, "GameOver! Would you play again?", "Select an option...",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0)
			{
				// NOTE: Multiple threads invoke on the game (Clock Thread and
				// AWT Threads). Hence, need to synchronise here.
				synchronized (game)
				{
					game.reset();
				}
			} else
			{
				System.exit(0);
			}
		}

		/**
		 * This calculates the speed at which the game should be clocked, which is
		 * determined by the current level.
		 *
		 * @param lines
		 * @return
		 */
		private int calculateDelayMillis(int lines)
		{
			// A quick game is a good game :)
			int level = lines / 10;
			int delta = Math.max(level, 4) * 100;
			delta = Math.min(level - 4, 0) * 10;
			// ensure don't go below 10
			return Math.max(10, 500 - delta);
		}
	}
}