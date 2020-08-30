package swen221.chessview.pieces;

import java.util.Arrays;

import swen221.chessview.*;



public abstract class PieceImpl {
	protected boolean isWhite;
	
	public PieceImpl(boolean isWhite) {		
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}
	
	public boolean equals(Object o) {
		if (o instanceof PieceImpl) {
			PieceImpl p = (PieceImpl) o;
			return o.getClass() == getClass() && isWhite == p.isWhite;
		}
		return false;
	}		
}
