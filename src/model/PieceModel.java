package model;

import checkers.Coord;
import checkers.PieceSquareColor;

public interface PieceModel{
    public Coord getCoord();
    public void move(Coord targetCoord);
    public PieceSquareColor getPieceColor();
    public boolean isMoveOk(Coord tergetCoord, boolean isPieceToTake);
}
