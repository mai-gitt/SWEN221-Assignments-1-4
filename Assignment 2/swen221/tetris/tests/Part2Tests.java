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
import swen221.tetris.tetromino.Tetromino.Color;
import swen221.tetris.tetromino.Tetromino.Orientation;

public class Part2Tests
{
	@Test
	public void test_01()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.BLUE), new L_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|M|_|\n" + "|_|M|M|M|_|\n" + "|_|_|B|B|_|\n" + "|_|B|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_02()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n" + "|_|_|B|B|_|\n" + "|_|_|O|O|_|\n" + "|_|O|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_03()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.ORANGE), new S_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|Y|Y|_|_|\n" + "|_|O|O|_|_|\n" + "|_|_|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_04()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.MAGENTA), new T_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|O|_|_|\n" + "|_|O|O|O|_|\n" + "|_|_|M|_|_|\n" + "|_|M|M|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_05()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new T_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|M|_|_|\n" + "|_|M|M|M|_|\n" + "|_|_|_|B|_|\n" + "|_|B|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_06()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new Z_Tetromino(Orientation.NORTH, Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|D|D|_|_|\n" + "|_|_|D|D|_|\n" + "|_|_|B|B|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_07()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|O|O|_|\n" + "|_|_|O|O|_|\n" + "|_|R|R|R|R|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_08()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|_|Y|Y|_|\n" + "|_|_|D|_|_|\n" + "|_|D|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_09()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|D|D|_|\n" + "|_|_|D|D|_|\n" + "|_|_|M|M|_|\n" + "|_|M|M|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_10()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new T_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|M|_|_|\n" + "|_|M|M|M|_|\n" + "|_|D|D|_|_|\n" + "|_|_|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_11()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.GREEN), new T_Tetromino(Orientation.NORTH, Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|D|_|_|\n" + "|_|D|D|D|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_12()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new Z_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|O|O|_|_|\n" + "|_|_|O|O|_|\n" + "|_|D|D|_|_|\n" + "|_|_|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_13()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.GREEN), new Z_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|G|G|_|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|G|_|\n" + "|_|G|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_14()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.ORANGE), new I_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// I Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|B|B|_|\n" + "|_|_|B|B|_|\n" + "|_|O|O|O|O|\n" + "|_|_|_|O|_|\n" + "|_|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_15()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.ORANGE), new L_Tetromino(Orientation.NORTH, Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|D|_|\n" + "|_|D|D|D|_|\n" + "|_|_|O|_|_|\n" + "|_|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_16()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new S_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// S Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|G|G|_|\n" + "|_|G|G|_|_|\n" + "|_|D|_|_|_|\n" + "|_|D|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_17()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.GREEN), new T_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|R|_|_|\n" + "|_|R|R|R|_|\n" + "|_|_|_|G|_|\n" + "|_|G|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_18()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.ORANGE), new T_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|O|_|_|\n" + "|_|O|O|O|_|\n" + "|_|_|O|_|_|\n" + "|_|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_19()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.YELLOW), new T_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|G|_|_|\n" + "|_|G|G|G|_|\n" + "|_|_|_|Y|_|\n" + "|_|Y|Y|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_20()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new Z_Tetromino(Orientation.NORTH, Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|D|D|_|_|\n" + "|_|_|D|D|_|\n" + "|_|B|B|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_21()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.RED), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// L Tetromino
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|B|_|\n" + "|_|B|B|B|_|\n" + "|_|_|R|_|_|\n" + "|_|_|R|_|_|\n" + "|_|_|R|R|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_22()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.ORANGE), new S_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// S Tetromino
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_23()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.ORANGE), new I_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|R|R|R|R|_|\n" + "|_|_|_|O|_|\n" + "|_|_|O|O|_|\n" + "|_|_|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_24()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.BLUE), new J_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|O|_|_|_|_|\n" + "|O|O|O|_|_|\n" + "|_|_|B|B|_|\n" + "|_|_|B|_|_|\n" + "|_|_|B|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_25()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new L_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|Y|\n" + "|_|_|Y|Y|Y|\n" + "|_|_|D|D|_|\n" + "|_|_|D|_|_|\n" + "|_|_|D|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_26()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.GREEN), new O_Tetromino(Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		String expected = "|_|_|D|D|_|\n" + "|_|_|D|D|_|\n" + "|_|_|G|_|_|\n" + "|_|_|G|_|_|\n" + "|_|_|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_27()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.RED), new L_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// L Tetromino
		game.clock();
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|R|_|\n" + "|_|R|R|R|_|\n" + "|_|_|R|_|_|\n" + "|_|_|R|R|_|\n" + "|_|_|R|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_28()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new I_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|O|O|O|O|_|\n" + "|_|_|D|_|_|\n" + "|_|_|D|D|_|\n" + "|_|_|D|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_29()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.GREEN), new L_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|M|_|_|\n" + "|M|M|M|_|_|\n" + "|_|_|G|_|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_30()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|O|O|_|\n" + "|_|_|O|O|_|\n" + "|_|_|M|M|_|\n" + "|_|M|M|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_31()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.BLUE), new S_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|O|_|_|\n" + "|_|_|O|O|_|\n" + "|_|_|_|O|_|\n" + "|_|_|_|B|_|\n" + "|_|B|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_32()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.GREEN), new Z_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|R|_|\n" + "|_|_|R|R|_|\n" + "|_|_|R|G|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_33()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.GREEN), new T_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|M|M|M|_|\n" + "|_|_|M|_|_|\n" + "|_|_|G|G|_|\n" + "|_|G|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_34()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.RED), new J_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// J Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|R|_|_|_|_|\n" + "|R|R|R|_|_|\n" + "|_|R|R|R|_|\n" + "|_|R|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_35()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.MAGENTA), new J_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// J Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|Y|_|_|_|_|\n" + "|Y|Y|Y|_|_|\n" + "|_|M|M|M|_|\n" + "|_|M|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_36()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.YELLOW), new Z_Tetromino(Orientation.NORTH, Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|D|D|_|_|_|\n" + "|_|D|D|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|Y|Y|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_37()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new L_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|G|_|\n" + "|_|G|G|G|_|\n" + "|_|D|D|D|_|\n" + "|_|_|D|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_38()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|G|G|\n" + "|_|_|_|G|G|\n" + "|_|M|M|M|_|\n" + "|_|M|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_39()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.GREEN), new J_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|Y|_|_|_|\n" + "|_|Y|Y|Y|_|\n" + "|_|_|G|_|_|\n" + "|_|G|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_40()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.GREEN), new L_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n" + "|_|_|B|_|_|\n" + "|_|_|B|G|_|\n" + "|_|G|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_41()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|R|R|R|R|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_42()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|D|D|D|D|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_43()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|R|_|_|_|\n" + "|_|R|R|R|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_44()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|D|_|_|_|\n" + "|_|D|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_45()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|R|_|\n" + "|_|R|R|R|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_46()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|O|_|\n" + "|_|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_47()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|M|_|\n" + "|_|M|M|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_48()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|D|_|\n" + "|_|D|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_49()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|O|O|_|\n" + "|_|_|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_50()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_51()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_52()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|M|M|_|\n" + "|_|_|M|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_53()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|R|R|_|\n" + "|_|R|R|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_54()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|Y|Y|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_55()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|G|G|_|\n" + "|_|G|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_56()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|M|M|_|\n" + "|_|M|M|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_57()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|Y|_|_|\n" + "|_|Y|Y|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_58()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|_|_|\n" + "|_|B|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_59()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|Y|Y|_|_|\n" + "|_|_|Y|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_60()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_61()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|R|R|_|_|\n" + "|_|_|R|R|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_62()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|Y|_|_|_|\n" + "|_|Y|Y|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_63()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|G|_|_|_|\n" + "|G|G|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_64()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|G|_|_|\n" + "|_|_|G|G|G|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_65()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|B|B|_|\n" + "|_|_|B|B|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_66()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|R|_|_|\n" + "|_|_|R|R|_|\n" + "|_|_|R|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_67()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|Y|_|_|\n" + "|Y|Y|Y|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_68()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|D|_|_|_|\n" + "|D|D|D|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_69()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|G|_|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_70()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|Y|Y|_|_|\n" + "|_|Y|Y|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_71()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.YELLOW), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|Y|_|\n" + "|_|_|_|Y|Y|\n" + "|_|_|_|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_72()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|D|_|_|\n" + "|_|_|D|D|D|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_73()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|M|M|M|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_74()
	{
		Tetromino[] tetrominos =
		{ new J_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// J Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|M|M|M|_|\n" + "|_|_|_|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_75()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|O|O|O|_|\n" + "|_|O|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_76()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|R|R|_|\n" + "|_|R|R|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_77()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.GREEN), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|G|G|\n" + "|_|_|_|G|G|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_78()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n" + "|_|_|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_79()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.MAGENTA), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|M|M|_|\n" + "|_|_|M|M|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_80()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|O|O|_|_|\n" + "|_|_|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_81()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|_|Y|Y|_|\n" + "|_|_|O|O|_|\n" + "|_|O|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_82()
	{
		Tetromino[] tetrominos =
		{ new O_Tetromino(Color.GREEN), new T_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|M|_|_|\n" + "|_|M|M|M|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_83()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new T_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new DropMove());
		game.clock();
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|R|_|_|\n" + "|_|R|R|R|_|\n" + "|_|_|_|D|_|\n" + "|_|D|D|D|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_84()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.RED), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|R|R|_|_|\n" + "|_|R|R|_|_|\n" + "|_|_|O|_|_|\n" + "|_|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_85()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.GREEN), new J_Tetromino(Orientation.NORTH, Color.BLUE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|B|_|_|_|\n" + "|_|B|B|B|_|\n" + "|_|_|G|G|_|\n" + "|_|G|G|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_86()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.RED), new O_Tetromino(Color.DARK_GRAY),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|D|D|\n" + "|_|_|_|D|D|\n" + "|_|R|R|R|_|\n" + "|_|R|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_87()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.YELLOW), new T_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|O|O|O|\n" + "|_|_|_|O|Y|\n" + "|_|_|Y|Y|Y|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_88()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.ORANGE), new T_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
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
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|O|_|_|_|\n" + "|O|O|O|_|_|\n" + "|_|O|O|O|O|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_89()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.ORANGE), new Z_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// Z Tetromino
		game.clock();
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|G|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|_|O|\n" + "|_|_|O|O|O|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_90()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.MAGENTA), new O_Tetromino(Color.BLUE), new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|B|B|_|_|\n" + "|_|B|B|_|_|\n" + "|_|_|M|M|_|\n" + "|_|M|M|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_91()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.YELLOW), new J_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// J Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|_|Y|Y|Y|\n" + "|_|Y|Y|_|Y|\n" + "|_|_|Y|Y|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_92()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.RED), new T_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// T Tetromino
		game.clock();
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|G|_|_|\n" + "|_|G|G|G|_|\n" + "|_|R|R|R|_|\n" + "|_|R|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_93()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.GREEN), new I_Tetromino(Orientation.NORTH, Color.MAGENTA),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// I Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|M|M|M|M|_|\n" + "|_|G|G|_|_|\n" + "|_|_|G|G|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_94()
	{
		Tetromino[] tetrominos =
		{ new L_Tetromino(Orientation.NORTH, Color.GREEN), new L_Tetromino(Orientation.NORTH, Color.RED),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// L Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|R|_|_|\n" + "|R|R|R|_|_|\n" + "|_|G|G|G|_|\n" + "|_|G|_|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_95()
	{
		Tetromino[] tetrominos =
		{ new Z_Tetromino(Orientation.NORTH, Color.ORANGE), new O_Tetromino(Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// Z Tetromino
		game.clock();
		game.apply(new MoveLeft());
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
		String expected = "|_|_|_|_|_|\n" + "|_|O|O|_|_|\n" + "|_|O|O|_|_|\n" + "|O|O|_|_|_|\n" + "|_|O|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_96()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.MAGENTA), new S_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// S Tetromino
		game.clock();
		game.apply(new MoveLeft());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|Y|Y|_|_|\n" + "|Y|Y|M|_|_|\n" + "|_|_|M|M|_|\n" + "|_|_|M|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_97()
	{
		Tetromino[] tetrominos =
		{ new S_Tetromino(Orientation.NORTH, Color.ORANGE), new L_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// S Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		// L Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|O|\n" + "|_|_|O|O|O|\n" + "|_|_|O|O|_|\n" + "|_|O|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_98()
	{
		Tetromino[] tetrominos =
		{ new T_Tetromino(Orientation.NORTH, Color.ORANGE), new Z_Tetromino(Orientation.NORTH, Color.YELLOW),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// T Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new MoveRight());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|Y|Y|_|\n" + "|_|_|O|Y|Y|\n" + "|_|_|O|O|_|\n" + "|_|_|O|_|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_99()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.ORANGE), new Z_Tetromino(Orientation.NORTH, Color.GREEN),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// Z Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|G|_|\n" + "|_|_|G|G|_|\n" + "|_|_|G|_|_|\n" + "|O|O|O|O|_|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}

	@Test
	public void test_100()
	{
		Tetromino[] tetrominos =
		{ new I_Tetromino(Orientation.NORTH, Color.DARK_GRAY), new T_Tetromino(Orientation.NORTH, Color.ORANGE),
				new O_Tetromino(Color.BLUE) };
		Game game = new Game(Arrays.asList(tetrominos).iterator(), 5, 5);
		// I Tetromino
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		game.apply(new MoveDown());
		game.clock();
		// T Tetromino
		game.clock();
		game.apply(new ClockwiseRotation());
		game.apply(new ClockwiseRotation());
		game.clock();
		game.apply(new DropMove());
		game.clock();
		// O Tetromino
		String expected = "|_|_|_|_|_|\n" + "|_|_|_|_|_|\n" + "|_|O|O|O|_|\n" + "|_|_|O|_|_|\n" + "|_|D|D|D|D|\n";
		assertEquals(expected, game.getActiveBoard().toString());
	}
}
