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

    public int removePiece(){
        Coord coordPieceToTake = this.checkersGameModel.removePiece();
        if(coordPieceToTake!=null){
            return transformCoordToIndex(coordPieceToTake);
        }
        return -1;
    }

    private Coord transformIndexToCoord(int squareIndex, int length){
        char col = 'a';
        int lig = 0;
        if(squareIndex%length==0){
            squareIndex--;
            col = (char)((squareIndex%length + 'a'));
            lig = (int)(squareIndex/length);
        } else {
            col = (char)((squareIndex%length + 'a')-1);
            lig = (int)(squareIndex/length);
        }
        return new Coord(col, lig);
    }

    private int transformCoordToIndex(Coord coord){
        int index = (coord.getColonne()-'a'+1)+coord.getLigne()*10;
        return index;
    }
}
