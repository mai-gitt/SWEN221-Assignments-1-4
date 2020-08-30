package swen221.chessview;

/**
 * 	Position object uses index 1 to 8 for rows and columns
 * 	Represents a position on the board
 */
public final class Position {
	private int row; // must be between 1 and 8
	private int col; // must be between 1 and 8
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int row() { 
		return row; 
	}
	
	public int column() { 
		return col; 
	}
	
	/**
	 * 	If the index of either the row or the col is over 8/under 1
	 * 	The position is not valid as it is not on the board
	 */
	public boolean isValid() {
		return col >= 1 && col <= 8 && row >= 1 && row <= 8;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Position) {
			Position p = (Position) o;
			return row == p.row && col == p.col;
		}
		return false;
	}
	
	public int hashCode() {
		return row ^ col;
	}
	
	public String toString() {		
		return ((char)('a'+(col-1))) + Integer.toString(row);		
	}
}
