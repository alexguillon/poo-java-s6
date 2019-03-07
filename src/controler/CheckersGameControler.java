package controler;

import checkers.Coord;
import model.CheckersGameModel;

public class CheckersGameControler {

    private CheckersGameModel checkersGameModel;

    public CheckersGameControler(CheckersGameModel checkersGameModel) {
        this.checkersGameModel = checkersGameModel;
    }

    public boolean isPieceMovable(int squareIndex){
        boolean bool = false;
        Coord targetCoord = this.transformIndexToCoord(squareIndex, this.checkersGameModel.getLength());
        bool = this.checkersGameModel.isPieceMovable(targetCoord);
        return bool;
    }

    private Coord transformIndexToCoord(int squareIndex, int length){
        Coord coord = new Coord('a', 1);
        coord.setColonne((char)((squareIndex%length + 'a')-1));
        coord.setLigne((int)(squareIndex/length));
        System.out.println(coord);
        return coord;
    }
}
