// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import swen221.tetris.logic.Game;
import swen221.tetris.moves.*;
import swen221.tetris.tetromino.*;
import swen221.tetris.tetromino.Tetromino;
import swen221.tetris.tetromino.Tetromino.Color;
import swen221.tetris.tetromino.Tetromino.Orientation;

public class Part4Tests
{

	@Test
	public void test_01()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_02()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_03()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_04()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_05()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_06()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new T_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_07()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|_|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_08()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|B|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_09()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_10()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_11()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_12()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_13()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_14()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_15()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new S_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_16()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new T_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_17()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|B|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_18()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new Z_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_19()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_20()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_21()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_22()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_23()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_24()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();		
		// S Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_25()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_26()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_27()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_28()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_29()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_30()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_31()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_32()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|B|B|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_33()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new Z_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|B|B|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_34()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|_|_|_|\n" + "|_|B|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_35()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|_|_|_|\n" + "|_|B|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_36()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new Z_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_37()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new Z_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_38()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new I_Tetromino(Orientation.NORTH, Color.BLUE),
				new Z_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_39()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new I_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_40()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new S_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}
}
