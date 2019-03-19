package model;

import checkers.Coord;
import checkers.PieceSquareColor;

import java.util.LinkedList;
import java.util.List;

public class CheckersGameModel {

    private List<PieceModel> pieceList;
    private int length;
    private PieceSquareColor currentColor;

    public CheckersGameModel(){
        length = CheckersGameModelFactory.getLength();
        currentColor = CheckersGameModelFactory.getBeginColor();
        pieceList = new LinkedList<PieceModel>();
        for(int i=0; i<CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.BLACK).size();i++){
            PawnModel newPiece = new PawnModel(CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.BLACK).get(i), PieceSquareColor.BLACK, this);
            pieceList.add(newPiece);
        }
        for(int i=0; i<CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.WHITE).size();i++){
            PawnModel newPiece = new PawnModel(CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.WHITE).get(i), PieceSquareColor.WHITE, this);
            pieceList.add(newPiece);
        }
    }

    public int getLength(){
        return length;
    }

    public List<PieceModel> getPieceList(){
        return pieceList;
    }

    public boolean isPieceMovable(Coord coord){
        boolean bool =false;
        for (PieceModel piece : pieceList) {
            if(piece.getPieceColor().equals(currentColor)){
                if(piece.getCoord().equals(coord)){
                    bool = true;
                }
            }
        }
        return bool;
    }

    public boolean isMovePieceOk(Coord initCoord, Coord targetCoord){
        PieceModel currentPiece = null;
        for (PieceModel piece : pieceList) {
            if(piece.getCoord().equals(initCoord)){
                currentPiece = piece;
            }
        }
        return currentPiece.isMoveOk(targetCoord, false);
    }

    public Coord movePiece(Coord initCoord, Coord targetCoord){
        return null;
    }

    public String toString() {
        String[][] damier = new String[this.length][this.length];

        // Création d'un tableau 2D avec les noms des pièces
        for(PieceModel piece : this.pieceList) {
            PieceSquareColor color = piece.getPieceColor();
            String stColor = (PieceSquareColor.WHITE.equals(color) ? "--B--" : "--N--" );
            int col = piece.getCoord().getColonne()-'a';
            int lig = piece.getCoord().getLigne()-1;
            damier[lig][col] = stColor;
        }

        // Affichage du tableau formatté
        String st = "   a   b   c   d   e   f   g   h   i   j\n";
        for(int lig=9; lig>=0 ; lig--){
            st += (lig+1) + "   ";
            for(int col=0; col<=9; col++){
                String stColor = damier[lig][col];
                if(stColor!=null){
                    st += stColor + "   ";
                } else {
                    st += "-----    ";
                }
            }
            st += "\n";
        }
        return "Damier du model \n" + st;
    }

}
