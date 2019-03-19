package controler;

import checkers.Coord;
import model.CheckersGameModel;
import model.PieceModel;

public class CheckersGameControler {

    private CheckersGameModel checkersGameModel;
    private Coord currentPieceCoord;

    public CheckersGameControler(CheckersGameModel checkersGameModel) {
        this.checkersGameModel = checkersGameModel;
    }

    public boolean isPieceMovable(int squareIndex){
        this.currentPieceCoord = this.transformIndexToCoord(squareIndex, this.checkersGameModel.getLength());
        return this.checkersGameModel.isPieceMovable(this.currentPieceCoord);
    }

    public boolean isMoveTargetOk(int indexArrivalSquare){
        Coord targetCoord = this.transformIndexToCoord(indexArrivalSquare, this.checkersGameModel.getLength());
        return this.checkersGameModel.isMovePieceOk(this.currentPieceCoord, targetCoord);
    }

    public int movePiece(int squareIndex){
        Coord targetCoord = this.transformIndexToCoord(squareIndex, this.checkersGameModel.getLength());
        Coord newCoord = this.checkersGameModel.movePiece(currentPieceCoord, targetCoord);
        return transformCoordToIndex(newCoord);
    }

    private Coord transformIndexToCoord(int squareIndex, int length){
        Coord coord = new Coord('a', 1);
        coord.setColonne((char)((squareIndex%length + 'a')-1));
        coord.setLigne((int)(squareIndex/length));
        return coord;
    }

    private int transformCoordToIndex(Coord coord){
        return (coord.getColonne()-'a'+1)+coord.getLigne()*10;
    }
}
