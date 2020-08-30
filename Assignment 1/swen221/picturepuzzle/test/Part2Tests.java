package swen221.picturepuzzle.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.moves.Move;

public class Part2Tests {
	@Test public void test_01() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_02() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_03() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_04() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_05() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_06() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_07() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 |         |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 | #000006 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_08() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_09() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 |         | #000008 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_10() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_11() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_12() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,1)));
		board.apply(new Move(new Location(0,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 |         |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 | #000006 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_13() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_14() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,0)));
		board.apply(new Move(new Location(1,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_15() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(2,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_16() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_17() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,2)));
		board.apply(new Move(new Location(0,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 |         | #000008 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_18() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(2,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 |         |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 | #000006 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_19() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_20() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 |         | #000008 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_21() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_22() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,2)));
		board.apply(new Move(new Location(2,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 |         | #000008 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_23() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,2)));
		board.apply(new Move(new Location(1,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 |         | #000008 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_24() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_25() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(2,2)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_26() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_27() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(2,1)));
		board.apply(new Move(new Location(2,0)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 |         |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 | #000006 |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_28() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_29() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(0,2)));
		board.apply(new Move(new Location(0,2)));
		board.apply(new Move(new Location(0,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_30() {
		int[] image = {
			0x000001, 0x000002, 0x000003,
			0x000004, 0x000005, 0x000006,
			0x000007, 0x000008, 0x000009,
		};
		// Create board
		Board board = new Board(image,3,3);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(2,2)));
		// Check output
		assertEquals(
			"+---------+---------+---------+\n" +
			"| #000001 | #000002 | #000003 |\n" +
			"+---------+---------+---------+\n" +
			"| #000004 | #000005 | #000006 |\n" +
			"+---------+---------+---------+\n" +
			"| #000007 | #000008 |         |\n" +
			"+---------+---------+---------+\n"
		,board.toString());
	}
}