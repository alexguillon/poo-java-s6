package model;

import checkers.Coord;
import checkers.PieceSquareColor;

public class PawnModel extends AbstractPieceModel{

    public PawnModel(Coord coord, PieceSquareColor pieceSquareColor) {
        super(coord, pieceSquareColor);
    }

    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
        int deltaLigne = targetCoord.getLigne() - getCoord().getLigne();
        int deltaColonne = targetCoord.getColonne() - getCoord().getColonne();
        // If we take a piece
        if(isPieceToTake){
            return (Math.abs(deltaLigne)==2 && Math.abs(deltaColonne)==2);
        }
        // If we don't take anything
        else {
            return (Math.abs(deltaLigne)==1 && Math.abs(deltaColonne)==1);
        }
    }
}
