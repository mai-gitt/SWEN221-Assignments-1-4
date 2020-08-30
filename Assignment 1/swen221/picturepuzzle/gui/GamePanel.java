// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Game;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.moves.Move;
import swen221.picturepuzzle.moves.Rotation;

/**
 * GamePanel defines a panel to show the game.
 *
 * @author betty
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	/**
	 * Create the game panel based on the given game
	 *
	 * @param game
	 *            Current game
	 */
	public GamePanel(Game game) {

		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc = new GridBagConstraints();

		for (int row = 0; row < game.getBoard().getBoardSize(); row++) {
			for (int col = 0; col < game.getBoard().getBoardSize(); col++) {
				Location loc = new Location(col, row);
				gbc.gridx = col;
				gbc.gridy = row;
				JButton cell = cell(loc, game);
				this.add(cell, gbc);
			}
		}

		this.revalidate();
		this.setFocusable(true);

	}

	/**
	 * Create cells in the game panel.
	 *
	 * @param loc
	 *            The location of cells on the board.
	 * @param g
	 *            Current game.
	 *
	 * @return Visualized cells
	 */
	public static JButton cell(Location loc, Game g) {
		JButton cell = new JButton();

		Cell c = g.getBoard().getCellAt(loc);
		if (c != null) {
			BufferedImage cellImage = new BufferedImage(c.getWidth(), c.getWidth(), BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < c.getWidth(); i++) {
				for (int j = 0; j < c.getWidth(); j++) {
					cellImage.setRGB(i, j, c.getRGB(i, j));
				}
			}
			ImageIcon icon = new ImageIcon(cellImage);
			cell.setSize(c.getWidth(), c.getWidth());
			cell.setIcon(icon);
			cell.setContentAreaFilled(false);
			cell.setMargin(new Insets(0, 0, 0, 0));
		} else {
			cell.setBackground(Color.white);
			cell.setPreferredSize(new Dimension());

		}

		cell.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean lb = SwingUtilities.isLeftMouseButton(e);
				clickCell(cell, loc, lb, g);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});

		return cell;

	}

	/**
	 * Mouse Listener of clicking a cell button.
	 *
	 * @param cell
	 *            The selected cell button.
	 * @param loc
	 *            The location of the selected cell.
	 * @param leftButton
	 *            Whether this click is a left click.
	 * @param game
	 *            Current running game.
	 */
	public static void clickCell(JButton cell, Location loc, boolean leftButton, Game game) {
		if (leftButton) {
			game.getBoard().apply(new Move(loc));
		} else {
			game.getBoard().apply(new Rotation(loc,1));
		}

		JFrame frame = (JFrame) SwingUtilities.getRoot(cell);
		frame.getContentPane().remove(cell.getParent());
		frame.revalidate();
		JPanel panel = new GamePanel(game);
		panel.revalidate();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		if (game.getBoard().isFinished()) {
			int choice = JOptionPane.showConfirmDialog(null, "Congratulations! You won! Would you play again?", "Hint",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				frame.getContentPane().remove(panel);
				frame.revalidate();
				game.start();
				panel = new GamePanel(game);
				panel.revalidate();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.pack();
				frame.setVisible(true);
			} else {
				System.exit(1);
			}
		}

	}
}

