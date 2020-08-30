// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import swen221.picturepuzzle.model.Game;

/**
 * PicturePuzzle defines a GUI allowing to play.
 *
 * @author betty
 *
 */
@SuppressWarnings("serial")
public class PicturePuzzle extends JFrame
{

	public static JPanel panel = new JPanel();
	public static JPanel displayCanvas = new JPanel();

	public static JLabel label = new JLabel("Num of cells:");
	public static String[] sizeString = { "2X2", "3X3", "4X4", "5X5", "6X6" };
	public static JComboBox<String> num = new JComboBox<>(sizeString);
	public static JButton OpenButton = new JButton("Open");
	public static JButton StartButton = new JButton("Start");

	public static Game game;
	public static int numCells = 3;

	public static File image;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() ->
		{
			PicturePuzzle p = new PicturePuzzle();
			p.setTitle("Picture Puzzle");
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p.setResizable(false);
			panel.setLayout(new FlowLayout());
			panel.add(label);
			panel.add(num);
			panel.add(OpenButton);
			panel.add(StartButton);
			p.getContentPane().add(panel, BorderLayout.NORTH);

			p.pack();
			p.setLocationRelativeTo(null);
			p.setVisible(true);
			//
			num.setSelectedIndex(1);
			// Add event handlers
			num.addActionListener((ActionEvent e) ->
			{
				setPuzzleDimensions(e);
			});

			OpenButton.addActionListener((ActionEvent e) ->
			{
				openImageFile(p);
			});

			StartButton.addActionListener((ActionEvent e) ->
			{
				startPicturePuzzle(p);
			});
		});

	}

	public static void setPuzzleDimensions(ActionEvent e)
	{
		String num = (String) ((JComboBox<?>) e.getSource()).getSelectedItem();
		numCells = Character.getNumericValue(num.charAt(0));
	}

	public static void startPicturePuzzle(PicturePuzzle p)
	{
		p.getContentPane().removeAll();
		p.getContentPane().add(panel, BorderLayout.NORTH);
		game.start();
		displayCanvas = new GamePanel(game);
		displayCanvas.revalidate();
		p.getContentPane().add(displayCanvas, BorderLayout.CENTER);
		// Show the original image
		JLabel label = new JLabel();
		try
		{
			label.setIcon(new ImageIcon(ImageIO.read(image)));
			// Show the original image
			p.pack();
			p.setVisible(true);
		} catch (IOException e1)
		{
			// Indicates a problem loading the image
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	/**
	 * Open an image file to use in the picture puzzle.
	 *
	 * @param p
	 */
	public static void openImageFile(PicturePuzzle p)
	{
		try
		{
			JFileChooser fileChooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
			fileChooser.setFileFilter(filter);
			File pwd = new File(System.getProperty("user.dir"));
			fileChooser.setCurrentDirectory(pwd);

			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				image = fileChooser.getSelectedFile();
				p.getContentPane().removeAll();
				p.getContentPane().add(panel, BorderLayout.NORTH);
				game = new Game(image, numCells);
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(ImageIO.read(image)));
				displayCanvas.removeAll();
				displayCanvas.add(label);
				displayCanvas.revalidate();
				p.getContentPane().add(displayCanvas, BorderLayout.CENTER);
				p.pack();
				p.setVisible(true);
			}
		} catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

}
