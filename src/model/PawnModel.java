package model;

import checkers.Coord;
import checkers.PieceSquareColor;

public class PawnModel extends AbstractPieceModel{

    public PawnModel(Coord coord, PieceSquareColor pieceSquareColor, CheckersGameModel checkersGameModel) {
        super(coord, pieceSquareColor, checkersGameModel);
    }

    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
        // Verify the arrival case is empty (cause to the EmptyBorders)
        for(PieceModel piece : this.getCheckersGameModel().getPieceList()){
            if(piece.getCoord().equals(targetCoord)){
                return false;
            }
        }
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
