package swen221.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.Test;

import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.Round;
import swen221.chessview.moves.Castling;
import swen221.chessview.moves.Check;
import swen221.chessview.moves.EnPassant;
import swen221.chessview.moves.NonCheck;
import swen221.chessview.moves.PawnPromotion;
import swen221.chessview.moves.SinglePieceMove;
import swen221.chessview.moves.SinglePieceTake;
import swen221.chessview.pieces.Bishop;
import swen221.chessview.pieces.King;
import swen221.chessview.pieces.Knight;
import swen221.chessview.pieces.Pawn;
import swen221.chessview.pieces.Piece;
import swen221.chessview.pieces.Queen;
import swen221.chessview.pieces.Rook;

public class ChessViewTests
{

	// ================================================
	// Valid Tests
	// ================================================

	@Test
	public void testValid_01()
	{
		String input = "a2-a3\n" +
						"";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|P|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_02()
	{
		String input = "a2-a3 b7-b6\n" + 
						"";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" + 
						"6|_|p|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|P|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_03()
	{
		String input = "a2-a4 b7-b5\n" + 
						"";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|p|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_04()
	{
		String input = "d2-d4 d7-d5\n" + 
					   "e2-e4 d5xe4\n" + 
					   	"";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|_|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|P|p|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|_|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_05()
	{
		String input = "d2-d3 d7-d5\n" + 
					   "e2-e4 d5xe4\n" + 
					   "d3xe4\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|_|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|_|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_06()
	{
		String input = "Nb1-c3\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|N|_|_|_|_|_|\n" + 
						"2|P|P|P|P|P|P|P|P|\n" + 
						"1|R|_|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_07()
	{
		String input = "Nb1-a3\n" +
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|N|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" + 
						"1|R|_|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_08()
	{
		String input = "d2-d4 Nb8-c6\n" + 
					   "e2-e4 Nc6xd4\n" + 
					   "";
		
		String output = "8|r|_|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|n|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|_|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_09()
	{
		String input = "Nb1-c3 e7-e5\n" + 
					   "e2-e3 e5-e4\n" + 
					   "Nc3xe4\n" + "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|N|_|_|_|\n" + 
						"3|_|_|_|_|P|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|_|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_10()
	{
		String input = "d2-d3 d7-d5\n" + 
					   "Bc1-g5 Bc8-g4\n" + 
					   "";
		
		String output = "8|r|n|_|q|k|b|n|r|\n" + 
						"7|p|p|p|_|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|p|_|_|B|_|\n" + 
						"4|_|_|_|_|_|_|b|_|\n" + 
						"3|_|_|_|P|_|_|_|_|\n" + 
						"2|P|P|P|_|P|P|P|P|\n" + 
						"1|R|N|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_11()
	{
		String input = "d2-d3 d7-d5\n" + 
				   		"Bc1-g5 Bc8-g4\n" + 
				   		"Bg5-h4\n" + "";
		String output = "8|r|n|_|q|k|b|n|r|\n" + 
				   		"7|p|p|p|_|p|p|p|p|\n" + 
				   		"6|_|_|_|_|_|_|_|_|\n" + 
				   		"5|_|_|_|p|_|_|_|_|\n" + 
				   		"4|_|_|_|_|_|_|b|B|\n" + 
				   		"3|_|_|_|P|_|_|_|_|\n" + 
				   		"2|P|P|P|_|P|P|P|P|\n" + 
				   		"1|R|N|_|Q|K|B|N|R|\n" + 
				   		"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_12()
	{
		String input = "d2-d3 d7-d5\n" + 
					   "Bc1-g5 Bc8-g4\n" + 
					   "Bg5xe7\n" + "";
		
		String output = "8|r|n|_|q|k|b|n|r|\n" + 
						"7|p|p|p|_|B|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|p|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|b|_|\n" + 
						"3|_|_|_|P|_|_|_|_|\n" + 
						"2|P|P|P|_|P|P|P|P|\n" + 
						"1|R|N|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_13()
	{
		String input = "e2-e4 e7-e5\n" + 
					   "Qd1-g4 Qd8-h4\n" + 
					   "Qg4-f4 Qh4-h6\n" + 
					   "Qf4-f6 Qh6xh2\n" + "";
		
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|Q|_|_|\n" + 
						"5|_|_|_|_|p|_|_|_|\n" + 
						"4|_|_|_|_|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|q|\n" + 
						"1|R|N|B|_|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testValid_14()
	{
		String input = "a2-a4 h7-h5\n" + 
					   "Ra1-a3 Rh8-h6\n" + 
					   "Ra3-d3 Rh6-g6\n" + 
					   "Rd3xd7\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|_|\n" + 
						"7|p|p|p|R|p|p|p|_|\n" + 
						"6|_|_|_|_|_|_|r|_|\n" + 
						"5|_|_|_|_|_|_|_|p|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|_|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}
	
	// King Movement
	@Test
	public void validWhiteKingMove()
	{
		String input = "e2-e3 e7-e6\n" + 
					   "Ke1-e2" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|p|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|P|_|_|_|\n" + 
						"2|P|P|P|P|K|P|P|P|\n" + 
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void validBlackKingMove()
	{
		String input = "e2-e3 e7-e6\n" + 
					   "a2-a3 Ke8-e7\n" + 
					   "";
		
		String output = "8|r|n|b|q|_|b|n|r|\n" + 
						"7|p|p|p|p|k|p|p|p|\n" + 
						"6|_|_|_|_|p|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|P|_|_|_|P|_|_|_|\n" + 
						"2|_|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	// Capture Tests
	@Test
	public void validCaptureWhiteKnight()
	{
		String input = "Ng1-f3 f7-f6\n" + 
					   "Nf3-g5 f6xNg5\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|_|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|p|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|_|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureBlackKnight()
	{
		String input = "a2-a3 Ng8-f6\n" + 
					   "f2-f3 Nf6-g4\n" + 
					   "f3xNg4\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|_|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|P|_|\n" + 
						"3|P|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|_|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureWhiteBishop()
	{
		String input = "e2-e3 a7-a6\n" + 
					   "Bf1-c4 b7-b6\n" + 
					   "Bc4-e6 f7xBe6\n" +
					   "";
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
					   "7|_|_|p|p|p|_|p|p|\n" + 
					   "6|p|p|_|_|p|_|_|_|\n" + 
					   "5|_|_|_|_|_|_|_|_|\n" + 
					   "4|_|_|_|_|_|_|_|_|\n" + 
					   "3|_|_|_|_|P|_|_|_|\n" + 
					   "2|P|P|P|P|_|P|P|P|\n" + 
					   "1|R|N|B|Q|K|_|N|R|\n" + 
					   "  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureBlackBishop()
	{
		String input = "a2-a3 e7-e6\n" + 
					   "b2-b3 Bf8-c5\n" + 
					   "c2-c3 Bc5-e3\n" + 
					   "d2xBe3\n" + "";
		
		String output = "8|r|n|b|q|k|_|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|p|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|P|P|P|_|P|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n"	+
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureWhiteRook()
	{
		String input = "a2-a4 b7-b5\n" + 
					   "Ra1-a3 a7-a6\n" + 
					   "Ra3-d3 b5-b4\n" + 
					   "Rd3-d6 e7xRd6\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|_|p|p|_|p|p|p|\n" + 
						"6|p|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|p|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|_|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureBlackRook()
	{
		String input = "a2-a3 a7-a5\n" + 
					   "b2-b3 Ra8-a6\n" + 
					   "c2-c3 Ra6-c6\n" + 
					   "d2-d3 Rc6-c4\n" + 
					   "b3xRc4\n" + 
					   "";
		
		String output = "8|_|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|p|_|_|_|_|_|_|_|\n" + 
						"4|_|_|P|_|_|_|_|_|\n" + 
						"3|P|_|P|P|_|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureWhiteQueen()
	{
		String input = "e2-e4 e7-e5\n" + 
					   "Qd1-g4 Qd8-h4\n" + 
					   "Qg4-f4 Qh4-h6\n" + 
					   "Qf4-f6 Qh6xh2\n" + 
					   "a2-a3 g7xQf6\n" + 
					   "";
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
					   "7|p|p|p|p|_|p|_|p|\n" + 
					   "6|_|_|_|_|_|p|_|_|\n" + 
					   "5|_|_|_|_|p|_|_|_|\n" + 
					   "4|_|_|_|_|P|_|_|_|\n" + 
					   "3|P|_|_|_|_|_|_|_|\n" + 
					   "2|_|P|P|P|_|P|P|q|\n" + 
					   "1|R|N|B|_|K|B|N|R|\n" + 
					   "  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureBlackQueen()
	{
		String input = "e2-e4 e7-e5\n" + 
					   "Qd1-g4 Qd8-h4\n" + 
					   "Qg4-f4 Qh4-h6\n" + 
					   "Qf4-f6 Qh6xh2\n" + 
					   "Rh1xQh2\n" + 
					   "";
		
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|Q|_|_|\n" + 
						"5|_|_|_|_|p|_|_|_|\n" + 
						"4|_|_|_|_|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|R|\n" + 
						"1|R|N|B|_|K|B|N|_|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCaptureWhitePawnEP()
	{
		String input = "a2-a3 e7-e5\n" + 
					   "a3-a4 e5-e4\n" + 
					   "d2-d4 e4xd3ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|p|_|_|_|_|\n" + 
						"2|_|P|P|_|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";
		
		check(input, output);
	}

	@Test
	public void validCaptureBlackPawnEP()
	{
		String input = "e2-e4 a7-a5\n" + 
					   "e4-e5 f7-f5\n" + 
					   "e5xf6ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
					   	"7|_|p|p|p|p|_|p|p|\n" + 
					   	"6|_|_|_|_|_|P|_|_|\n" + 
					   	"5|p|_|_|_|_|_|_|_|\n" + 
					   	"4|_|_|_|_|_|_|_|_|\n" + 
					   	"3|_|_|_|_|_|_|_|_|\n" + 
					   	"2|P|P|P|P|_|P|P|P|\n" + 
					   	"1|R|N|B|Q|K|B|N|R|\n" + 
					   	"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void validKingCapture()
	{
		String input = "a2-a3 e7-e6\n" + 
					   "a3-a4 Qd8-g5\n" +
					   "a4-a5 Qg5-e5\n" +
					   "a5-a6 Qe5xe2+\n" +
					   "Ke1xQe2\n" +
					   "";
		
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
					   	"7|p|p|p|p|_|p|p|p|\n" + 
					   	"6|P|_|_|_|p|_|_|_|\n" + 
					   	"5|_|_|_|_|_|_|_|_|\n" + 
					   	"4|_|_|_|_|_|_|_|_|\n" + 
					   	"3|_|_|_|_|_|_|_|_|\n" + 
					   	"2|_|P|P|P|K|P|P|P|\n" + 
					   	"1|R|N|B|Q|_|B|N|R|\n" + 
					   	"  a b c d e f g h";

		check(input, output);
	}

	// Castling Tests
	@Test
	public void validCastleWhiteQueenSide()
	{
		String input = "d2-d4 a7-a6\n" + 
					   "Bc1-e3 a6-a5\n" + 
					   "Nb1-c3 a5-a4\n" + 
					   "Qd1-d2 a4-a3\n" +
					   "O-O-O\n" + "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|P|_|_|_|_|\n" + 
						"3|p|_|N|_|B|_|_|_|\n" + 
						"2|P|P|P|Q|P|P|P|P|\n" + 
						"1|_|_|K|R|_|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCastleWhiteKingSide()
	{
		String input = "e2-e3 a7-a6\n" + 
					   "Bf1-d3 a6-a5\n" + 
					   "Ng1-f3 a5-a4\n" + 
					   "Qd1-e2 a4-a3\n" + 
					   "O-O\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
					   "7|_|p|p|p|p|p|p|p|\n" + 
					   "6|_|_|_|_|_|_|_|_|\n" + 
					   "5|_|_|_|_|_|_|_|_|\n" + 
					   "4|_|_|_|_|_|_|_|_|\n" + 
					   "3|p|_|_|B|P|N|_|_|\n" + 
					   "2|P|P|P|P|Q|P|P|P|\n" + 
					   "1|R|N|B|_|_|R|K|_|\n" + 
					   "  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCastleBlackQueenSide()
	{
		String input = "a2-a3 d7-d6\n" + 
					   "a3-a4 Bc8-e6\n" + 
					   "a4-a5 Nb8-c6\n" + 
					   "a5-a6 Qd8-d7\n" + 
					   "Ra1-a2 O-O-O+\n" +
					   "";
		
		String output = "8|_|_|k|r|_|b|n|r|\n" + 
					   "7|p|p|p|q|p|p|p|p|\n" + 
					   "6|P|_|n|p|b|_|_|_|\n" + 
					   "5|_|_|_|_|_|_|_|_|\n" + 
					   "4|_|_|_|_|_|_|_|_|\n" + 
					   "3|_|_|_|_|_|_|_|_|\n" + 
					   "2|R|P|P|P|P|P|P|P|\n" +
					   "1|_|N|B|Q|K|B|N|R|\n" + 
					   "  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void validCastleBlackKingSide()
	{
		String input = "a2-a3 e7-e6\n" + 
					   "a3-a4 Bf8-d6\n" + 
					   "a4-a5 Ng8-f6\n" + 
					   "a5-a6 Qd8-e7\n" + 
					   "Ra1-a2 O-O+\n" +
					   "";
		
		String output = "8|r|n|b|_|_|r|k|_|\n" + 
						"7|p|p|p|p|q|p|p|p|\n" + 
						"6|P|_|_|b|p|n|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|R|P|P|P|P|P|P|P|\n" + 
						"1|_|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	// Check Tests
	@Test
	public void ValidWhiteInCheck()
	{
		String input = "d2-d4 c7-c5\n" + 
					   "f2-f3 Qd8-a5+\n" + 
					   "";
		
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|p|p|_|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|q|_|p|_|_|_|_|_|\n" + 
						"4|_|_|_|P|_|_|_|_|\n" + 
						"3|_|_|_|_|_|P|_|_|\n" + 
						"2|P|P|P|_|P|_|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidBlackInCheck()
	{
		String input = "e2-e4 f7-f5\n" + 
					   "Qd1-h5+\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|_|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|p|_|Q|\n" + 
						"4|_|_|_|_|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	// EnPassant Tests
	@Test
	public void validWhiteEP()
	{
		String input = "a2-a3 e7-e5\n" + 
					   "a3-a4 e5-e4\n" + 
					   "d2-d4 e4xd3ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|p|_|_|_|_|\n" + 
						"2|_|P|P|_|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";
		
		check(input, output);
	}

	@Test
	public void validBlackEP()
	{
		String input = "e2-e4 a7-a5\n" + 
					   "e4-e5 f7-f5\n" +
					   "e5xf6ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|_|p|p|\n" + 
						"6|_|_|_|_|_|P|_|_|\n" + 
						"5|p|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	// Promotion Tests
	@Test
	public void ValidPromoteWhiteToQueen()
	{
		String input = "b2-b4 a7-a5\n" + 
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" +
					   "b6xc7 d7-d6\n" +
					   "c7-c8=Q\n" + 
					   "";
		
		String output = "8|r|n|Q|q|k|b|n|r|\n" + 
						"7|_|_|_|_|p|p|p|p|\n" + 
						"6|b|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|_|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteWhiteToKnight()
	{
		String input = "b2-b4 a7-a5\n" + 
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" + 
					   "b6xc7 d7-d6\n" + 
					   "c7-c8=N\n" + "";
		
		String output = "8|r|n|N|q|k|b|n|r|\n" + 
						"7|_|_|_|_|p|p|p|p|\n" + 
						"6|b|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|_|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteWhiteToRook()
	{
		String input = "b2-b4 a7-a5\n" + 
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" + 
					   "b6xc7 d7-d6\n" + 
					   "c7-c8=R\n" + "";
		
		String output = "8|r|n|R|q|k|b|n|r|\n" + 
						"7|_|_|_|_|p|p|p|p|\n" + 
						"6|b|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|_|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteWhiteToBishop()
	{
		String input = "b2-b4 a7-a5\n" +
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" + 
					   "b6xc7 d7-d6\n" + 
					   "c7-c8=B\n" + 
					   "";
		
		String output = "8|r|n|B|q|k|b|n|r|\n" + 
						"7|_|_|_|_|p|p|p|p|\n" + 
						"6|b|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|_|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteBlackToQueen()
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3 c2-c1=Q\n" +
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|B|_|_|P|_|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n" + 
						"1|R|N|q|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteBlackToKnight()
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3 c2-c1=N\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|_|_|_|_|_|_|_|\n" +
						"3|B|_|_|P|_|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n" + 
						"1|R|N|n|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteBlackToRook()
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3 c2-c1=R\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|B|_|_|P|_|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n" + 
						"1|R|N|r|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void ValidPromoteBlackToBishop()
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3 c2-c1=B\n" +
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|B|_|_|P|_|_|_|_|\n" + 
						"2|_|_|_|_|P|P|P|P|\n" + 
						"1|R|N|b|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	// ================================================
	// Invalid Tests
	// ================================================

	@Test
	public void testInvalid_01()
	{
		String input = "a2-a4 a7-a4\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void testInvalid_02()
	{
		try
		{
			String input = "a2-a3 a7_a6\n" + 
						   "";
			
			String output = "8|r|n|b|q|k|b|_|r|\n" + 
							"7|_|p|p|p|p|p|p|p|\n" + 
							"6|p|_|_|_|_|_|_|_|\n" + 
							"5|_|_|_|_|_|_|_|_|\n" + 
							"4|_|_|_|_|_|_|_|_|\n" + 
							"3|P|_|_|_|_|_|_|_|\n" + 
							"2|_|P|P|P|P|_|P|P|\n" + 
							"1|R|N|B|Q|K|B|N|R|\n" + 
							"  a b c d e f g h";

			check(input, output);
		} catch (AssertionError e)
		{
			return;
		}
	}
	
	// Pawn Movement
	@Test
	public void invalidWhitePawnMove()	// Pawn can only capture diagonally
	{
		String input = "a2-a4 a7-a5\n" + 
					   "a4xa5\n" +
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|p|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void invalidBlackPawnMove()	// Pawn can only capture diagonally
	{
		String input = "a2-a3 a7-a5\n" + 
					   "a3-a4 a5xa4\n" +
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|p|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	// Capture Tests
	@Test
	public void invalidCapture()	// Cannot capture empty space
	{
		String input = "a2-a3 e7-e5\n" + 
					   "a3-a4 e5xd4\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|p|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	// Castling Tests

	@Test
	public void invalidCastleWhiteQueenSide()	
	// There should not be any pieces between the king and the rook
	{
		String input = "d2-d4 a7-a6\n" + 
					   "Bc1-e3 a6-a5\n" + 
					   "Nb1-c3 a5-a4\n" + 
					   "O-O-O\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|p|_|_|P|_|_|_|_|\n" + 
						"3|_|_|N|_|B|_|_|_|\n" + 
						"2|P|P|P|_|P|P|P|P|\n" + 
						"1|R|_|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidCastleWhiteKingSide()
	// There should not be any pieces between the king and the rook
	{
		String input = "e2-e3 a7-a6\n" + 
					   "Bf1-d3 a6-a5\n" + 
					   "O-O\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|p|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|B|P|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|_|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidCastleBlackQueenSide()
	// There should not be any pieces between the king and the rook
	{
		String input = "a2-a3 d7-d6\n" + 
					   "a3-a4 Bc8-e6\n" + 
					   "a4-a5 Nb8-c6\n" + 
					   "a5-a6 O-O-O+\n" + 
					   "";
		
		String output = "8|r|_|_|q|k|b|n|r|\n" + 
						"7|p|p|p|_|p|p|p|p|\n" + 
						"6|P|_|n|p|b|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidCastleBlackKingSide()
	// There should not be any pieces between the king and the rook
	{
		String input = "a2-a3 e7-e6\n" + 
					   "a3-a4 Bf8-d6\n" + 
					   "a4-a5 Ng8-f6\n" + 
					   "a5-a6 Qd8-e7\n" +
					   "e2-e3 Nf6-e4\n" +  
					   "Ra1-a2 f7-f6\n" + 
					   "Qd1-h5 O-O+\n" +
					   "";
	
		String output = "8|r|n|b|_|k|_|_|r|\n" + 
						"7|p|p|p|p|q|_|p|p|\n" + 
						"6|P|_|_|b|p|p|_|_|\n" + 
						"5|_|_|_|_|_|_|_|Q|\n" + 
						"4|_|_|_|_|n|_|_|_|\n" + 
						"3|_|_|_|_|P|_|_|_|\n" + 
						"2|R|P|P|P|_|P|P|P|\n" + 
						"1|_|N|B|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void invalidCastleCheckWhiteQueenSide() // King cannot be in check
	{
		String input = "d2-d4 a7-a6\n" + 
					   "Bc1-e3 a6-a5\n" + 
					   "Nb1-c3 a5-a4\n" + 
					   "Qd1-d3 c7-c6\n" + 
					   "Nc3-d5 Qd8-a5+\n" +
					   "O-O-O\n" + "";
	
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|_|p|_|p|p|p|p|p|\n" + 
						"6|_|_|p|_|_|_|_|_|\n" + 
						"5|q|_|_|N|_|_|_|_|\n" + 
						"4|p|_|_|P|_|_|_|_|\n" + 
						"3|_|_|_|Q|B|_|_|_|\n" + 
						"2|P|P|P|_|P|P|P|P|\n" + 
						"1|R|_|_|_|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void invalidCastleCheckWhiteKingSide() // King cannot be in check
	{
		String input = "e2-e3 a7-a6\n" + 
				   	   "Bf1-c4 a6-a5\n" + 
				   	   "Ng1-f3 a5-a4\n" + 
				   	   "Qd1-e2 a4-a3\n" + 
				   	   "d2-d3 c7-c6\n" + 
				   	   "e3-e4 Qd8-a5+\n" + 
				   	   "O-O\n" + 
				   	   "";
	
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|_|p|_|p|p|p|p|p|\n" + 
						"6|_|_|p|_|_|_|_|_|\n" + 
						"5|q|_|_|_|_|_|_|_|\n" + 
						"4|_|_|B|_|P|_|_|_|\n" + 
						"3|p|_|_|P|_|N|_|_|\n" + 
						"2|P|P|P|_|Q|P|P|P|\n" + 
						"1|R|N|B|_|K|_|_|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void invalidCastleCheckBlackQueenSide() // King cannot be in check
	{
		String input = "a2-a3 d7-d6\n" + 
					   "a3-a4 Bc8-e6\n" + 
					   "a4-a5 Nb8-c6\n" + 
					   "a5-a6 Qd8-d7\n" + 
					   "e2-e3 f7-f6\n" +
					   "Qd1-h5+ O-O-O+\n" +
					   "";
	
		String output = "8|r|_|_|_|k|b|n|r|\n" + 
						"7|p|p|p|q|p|_|p|p|\n" + 
						"6|P|_|n|p|b|p|_|_|\n" + 
						"5|_|_|_|_|_|_|_|Q|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|P|_|_|_|\n" + 
						"2|_|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|_|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidCastleCheckBlackKingSide() // King cannot be in check
	{
		String input = "a2-a3 e7-e6\n" + 
				  	   "a3-a4 Bf8-d6\n" + 
				  	   "a4-a5 O-O+\n" + 
				  	   "";
		
		String output = "8|r|n|b|q|k|_|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|b|p|_|_|_|\n" + 
						"5|P|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidCastlingNoSuchMove()
	{
		try
		{
			String input = "a2-a3 e7-e6\n" + 
					   	   "a3-a4 Bf8-d6\n" + 
					   	   "a4-a5 Ng8-f6\n" + 
					   	   "a5-a6 Qd8-e7\n" + 
					   	   "Ra1-a2 O-O-O-O+\n" + 
					   	   "";
			
			String output = "8|r|n|b|_|_|r|k|_|\n" + 
							"7|p|p|p|p|q|p|p|p|\n" + 
							"6|P|_|_|b|p|n|_|_|\n" + 
							"5|_|_|_|_|_|_|_|_|\n" + 
							"4|_|_|_|_|_|_|_|_|\n" + 
							"3|_|_|_|_|_|_|_|_|\n" + 
							"2|R|P|P|P|P|P|P|P|\n" + 
							"1|_|N|B|Q|K|B|N|R|\n" + 
							"  a b c d e f g h";

			check(input, output);
		} catch (AssertionError e)
		{
			return;
		}
	}

	// Check Tests
	@Test
	public void invalidCheckValidMove() // The king is not in check
	{
		String input = "b2-b4 a7-a5\n" + 
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" +
					   "b6xc7 d7-d6+\n" + 
					   "";
		
		String output = "8|r|n|_|q|k|b|n|r|\n" + 
						"7|_|_|P|p|p|p|p|p|\n" +
						"6|b|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void validCheckInvalidMove()	// Move is not valid, but the check would have been valid
	{
		String input = "d2-d4 c7-c5\n" + 
					   "f2-f3 Qd8-b4+\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|_|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|p|_|_|_|_|_|\n" + 
						"4|_|_|_|P|_|_|_|_|\n" + 
						"3|_|_|_|_|_|P|_|_|\n" + 
						"2|P|P|P|_|P|_|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}
	@Test
	public void invalidCheckInvalidMove() // The king is not in check and the move is not even valid
	{
		String input = "a2-a5+" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void whiteStillInCheck()	// King needs to block the check
	{
		String input = "d2-d4 c7-c5\n" + 
					   "f2-f3 Qd8-a5+\n" + 
					   "h2-h3\n" + 
					   "";
		
		String output = "8|r|n|b|_|k|b|n|r|\n" + 
						"7|p|p|_|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|q|_|p|_|_|_|_|_|\n" + 
						"4|_|_|_|P|_|_|_|_|\n" + 
						"3|_|_|_|_|_|P|_|_|\n" +
						"2|P|P|P|_|P|_|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void blackStillInCheck()	// King needs to block the check
	{
		String input = "e2-e4 f7-f5\n" + 
					   "Qd1-h5+ a7-a6\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|_|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|p|_|Q|\n" + 
						"4|_|_|_|_|P|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|_|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	// EnPassant Tests
	@Test
	public void invalidWhiteEP()	// This is a normal capture not ep
	{
		String input = "a2-a3 e7-e5\n" + 
					   "a3-a4 e5-e4\n" + 
					   "d2-d3 e4xd3ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|_|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|p|_|_|_|\n" +
						"3|_|_|_|P|_|_|_|_|\n" + 
						"2|_|P|P|_|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidBlackEP()	// This is a normal capture not ep
	{
		String input = "e2-e4 a7-a5\n" + 
					   "e4-e5 f7-f6\n" + 
					   "e5xf6ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|_|p|p|\n" + 
						"6|_|_|_|_|_|p|_|_|\n" + 
						"5|p|_|_|_|P|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|P|P|P|P|_|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidEP()	// Enemy pawn move was not double step
	{
		String input = "a2-a3 b7-b5\n" + 
					   "a3-a4 b5-b4\n" + 
					   "a4xb5ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|_|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|p|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidEP_02()	// Enemy pawn move was not double step
	{
		String input = "a2-a4 b7-b5\n" + 
					   "a4-a5 b5xa4ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
					   	"7|p|_|p|p|p|p|p|p|\n" + 
					   	"6|_|_|_|_|_|_|_|_|\n" + 
					   	"5|P|p|_|_|_|_|_|_|\n" + 
					   	"4|_|_|_|_|_|_|_|_|\n" + 
					   	"3|_|_|_|_|_|_|_|_|\n" + 
					   	"2|_|P|P|P|P|P|P|P|\n" + 
					   	"1|R|N|B|Q|K|B|N|R|\n" + 
					   	"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidEP_03()
	{
		String input = "a2-a4ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
					 	"7|p|p|p|p|p|p|p|p|\n" + 
					 	"6|_|_|_|_|_|_|_|_|\n" + 
					 	"5|_|_|_|_|_|_|_|_|\n" + 
					 	"4|_|_|_|_|_|_|_|_|\n" + 
					 	"3|_|_|_|_|_|_|_|_|\n" + 
					 	"2|P|P|P|P|P|P|P|P|\n" + 
					 	"1|R|N|B|Q|K|B|N|R|\n" + 
					 	"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidEP_04()
	{
		String input = "a2-a4 a7-a5ep\n" + 
					   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|p|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" + 
						"2|_|P|P|P|P|P|P|P|\n" + 
						"1|R|N|B|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

// Promotion Tests

	@Test
	public void invalidPromoteWhiteToKing()	// Pawn cannot be promoted to king
	{
		String input = "b2-b4 a7-a5\n" + 
					   "b4xa5 b7-b5\n" + 
					   "a5xb6ep Bc8-a6\n" + 
					   "b6xc7 d7-d6\n" + 
					   "c7-c8=K\n" + 
					   "";
		
		String output = "8|r|n|_|q|k|b|n|r|\n" + 
						"7|_|_|P|_|p|p|p|p|\n" + 
						"6|b|_|_|p|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|_|_|_|_|_|_|_|_|\n" + 
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidPromoteBlackToKing()	// Pawn cannot be promoted to king
	{
		String input = "a2-a4 a7-a5\n" + 
				 	   "b2-b4 a5xb4\n" + 
				 	   "c2-c3 b4xc3\n" + 
				 	   "Bc1-a3 c3-c2\n" + 
				 	   "d2-d3 c2-c1=K\n" + 
				 	   "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|B|_|_|P|_|_|_|_|\n" + 
						"2|_|_|p|_|P|P|P|P|\n" + 
						"1|R|N|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidPromoteWhiteToPawn()	// Pawn cannot be promoted to pawn
	{
		try
		{
			String input = "b2-b4 a7-a5\n" + 
						   "b4xa5 b7-b5\n" + 
						   "a5xb6ep Bc8-a6\n" + 
						   "b6xc7 d7-d6\n" + 
						   "c7-c8=P\n" + 
						   "";
			
			String output = "8|r|n|P|q|k|b|n|r|\n" + 
							"7|_|_|_|_|p|p|p|p|\n" + 
							"6|b|_|_|p|_|_|_|_|\n" + 
							"5|_|_|_|_|_|_|_|_|\n" + 
							"4|_|_|_|_|_|_|_|_|\n" + 
							"3|_|_|_|_|_|_|_|_|\n" + 
							"2|P|_|P|P|P|P|P|P|\n" + 
							"1|R|N|B|Q|K|B|N|R|\n" + 
							"  a b c d e f g h";

			check(input, output);
		} catch (AssertionError e)
		{
			return;
		}
	}

	@Test
	public void invalidPromoteBlackToPawn()	// Pawn cannot be promoted to pawn
	{
		try
		{
			String input = "a2-a4 a7-a5\n" + 
						   "b2-b4 a5xb4\n" + 
						   "c2-c3 b4xc3\n" + 
						   "Bc1-a3 c3-c2\n" + 
						   "d2-d3 c2-c1=P\n" + 
						   "";
			
			String output = "8|r|n|b|q|k|b|n|r|\n" + 
							"7|_|p|p|p|p|p|p|p|\n" + 
							"6|_|_|_|_|_|_|_|_|\n" + 
							"5|_|_|_|_|_|_|_|_|\n" + 
							"4|P|_|_|_|_|_|_|_|\n" + 
							"3|B|_|_|P|_|_|_|_|\n" + 
							"2|_|_|_|_|P|P|P|P|\n" + 
							"1|R|N|p|Q|K|B|N|R|\n" + 
							"  a b c d e f g h";

			check(input, output);
		} catch (AssertionError e)
		{
			return;
		}
	}

	@Test
	public void invalidPromoteNotAtEnd()	// Pawn must be at end of board to be promoted
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3=Q\n" + "";
		
		String output = "8|r|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|P|_|_|_|_|_|_|_|\n" + 
						"3|B|_|_|_|_|_|_|_|\n" + 
						"2|_|_|p|P|P|P|P|P|\n" + 
						"1|R|N|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

	@Test
	public void invalidPromoteNotAPawn()	// Only pawns can be promoted
	{
		String input = "a2-a4 a7-a5\n" + 
					   "b2-b4 a5xb4\n" + 
					   "c2-c3 b4xc3\n" + 
					   "Bc1-a3 c3-c2\n" + 
					   "d2-d3 Ra8xa4\n" + 
					   "Ba3-b4 Ra3xa1=Q\n" + 
					   "";
		
		String output = "8|_|n|b|q|k|b|n|r|\n" + 
						"7|_|p|p|p|p|p|p|p|\n" + 
						"6|_|_|_|_|_|_|_|_|\n" + 
						"5|_|_|_|_|_|_|_|_|\n" + 
						"4|r|B|_|_|_|_|_|_|\n" + 
						"3|_|_|_|P|_|_|_|_|\n" + 
						"2|_|_|p|_|P|P|P|P|\n" + 
						"1|R|N|_|Q|K|B|N|R|\n" + 
						"  a b c d e f g h";

		check(input, output);
	}

// ================================================
// Misc Tests
// ================================================

	@Test
	public void castleStringTest()
	{
		Castling ca = new Castling(false, false); // Black Queen Side
		assert (ca.toString().equals("O-O-O"));
		ca = new Castling(true, false);		// White Queen Side
		assert (ca.toString().equals("O-O-O"));
		ca = new Castling(false, true);		// Black King Side
		assert (ca.toString().equals("O-O"));
		ca = new Castling(true, true);		// White King Side
		assert (ca.toString().equals("O-O"));
	}

	@Test
	public void checkStringTest()
	{
		Position po = new Position(1, 1);
		Position pn = new Position(2, 1);
		Piece P = new Pawn(false);
		SinglePieceMove m = new SinglePieceMove(P, po, pn);
		Check ch = new Check(m);
		assert (ch.toString().equals("a1-a2+"));
		assert (ch.move() == m);
	}

	@Test
	public void epStringTest()
	{
		Position po = new Position(1, 1);
		Position pn = new Position(2, 1);
		Piece P = new Pawn(false);
		SinglePieceMove m = new SinglePieceMove(P, po, pn);
		Piece Q = new Queen(false);
		PawnPromotion pp = new PawnPromotion(m, Q);
		assert (pp.toString().equals("a1-a2=Q"));
	}

	@Test
	public void promotionStringTest()
	{
		Position po = new Position(1, 1);
		Position pn = new Position(2, 1);
		Piece P = new Pawn(false);
		SinglePieceMove m = new SinglePieceMove(P, po, pn);
		EnPassant ep = new EnPassant(m);
		assert (ep.toString().equals("a1-a2ep"));
	}

	@Test
	public void miscStringTests()
	{
		Piece K = new King(false);
		Position po = new Position(1, 1); // Old Position
		Position pn = new Position(2, 1); // New Position
		SinglePieceMove m = new SinglePieceMove(K, po, pn);
		assert (m.toString().equals("Ka1-a2"));

		Piece B = new Bishop(false);
		m = new SinglePieceMove(B, po, pn);
		assert (m.toString().equals("Ba1-a2"));

		Piece N = new Knight(false);
		m = new SinglePieceMove(N, po, pn);
		assert (m.toString().equals("Na1-a2"));

		Piece Q = new Queen(false);
		m = new SinglePieceMove(Q, po, pn);
		assert (m.toString().equals("Qa1-a2"));

		Piece R = new Rook(false);
		m = new SinglePieceMove(R, po, pn);
		assert (m.toString().equals("Ra1-a2"));

		Piece P = new Pawn(false);
		m = new SinglePieceMove(P, po, pn);
		assert (m.toString().equals("a1-a2"));

		assert (!P.equals(R));

		// SinglePieceTake
		SinglePieceTake spt = new SinglePieceTake(P, R, po, pn);
		assert (spt.toString().equals("a1xRa2"));

		// NonCheck
		NonCheck nc = new NonCheck(m);
		assert (nc.toString().equals("a1-a2"));
		assert (nc.move() == m);
	}

	@Test
	public void roundTests()
	{
		Piece P = new Pawn(false);
		Position po = new Position(1, 1); // Old Position
		Position pn = new Position(2, 1); // New Position
		SinglePieceMove m = new SinglePieceMove(P, po, pn);
		Round r = new Round(m, null);
		assert (r.toString().equals("a1-a2"));
		r = new Round(m, m);
		assert (r.toString().equals("a1-a2 a1-a2"));
		try
		{
			r = new Round(null, m);
			assert (r.toString().equals("a1-a2"));
		} catch (IllegalArgumentException e)
		{
			return;
		}
	}

	@Test
	public void positionTests()
	{
		Piece P = new Pawn(false);
		Position po = new Position(1, 1); // Old Position
		Position pn = new Position(2, 1); // New Position
		SinglePieceMove m = new SinglePieceMove(P, po, pn);
		assert (po.hashCode() == 0);
		assert (!(po.equals(P)));

		Position ivp = new Position(9, 1); // Invalid Row
		assert (!ivp.isValid());
		ivp = new Position(1, 9); // Invalid Col
		assert (!ivp.isValid());
		ivp = new Position(0, 1); // Invalid Row
		assert (!ivp.isValid());
		ivp = new Position(1, 0); // Invalid Col
		assert (!ivp.isValid());
	}

	@Test
	public void ChessGameTests()
	{

		String input = "d2-d4 a7-a6\n" + "";
		try
		{
			ChessGame cg = new ChessGame(input);
			assert (cg.rounds().size() == 1);
			try
			{
				Position p = cg.positionFromString("12345");
				fail("Invalid String");
			} catch (IllegalArgumentException e)
			{
			}
			try
			{
				input = "d2+d4 a7-a6\n" + "";
				cg = new ChessGame(input);
				fail("Invalid String");
			} catch (IllegalArgumentException e)
			{
			}
		} catch (Exception e)
		{
			fail("test failed because of exception on input: " + input);
		}
	}

	// The following provides a simple helper method for all tests.
	public static void check(String input, String expectedOutput)
	{
		try
		{
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty())
			{
				fail("test failed with insufficient boards on input: " + input);
			}
			String actualOutput = boards.get(boards.size() - 1).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e)
		{
			fail("test failed because of exception on input: " + input);
		}
	}
}
