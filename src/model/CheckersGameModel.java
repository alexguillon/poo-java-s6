package model;

import checkers.Coord;
import checkers.PieceSquareColor;

import java.util.LinkedList;
import java.util.List;

public class CheckersGameModel {

    private List<PieceModel> pieceList;
    private int length;
    private PieceSquareColor currentColor;
    private PieceModel pieceToTake;

    public CheckersGameModel(){
        length = CheckersGameModelFactory.getLength();
        currentColor = CheckersGameModelFactory.getBeginColor();
        pieceList = new LinkedList<>();
        for(int i=0; i<CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.RED).size();i++){
            PawnModel newPiece = new PawnModel(CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.RED).get(i), PieceSquareColor.RED, this);
            pieceList.add(newPiece);
        }
        for(int i=0; i<CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.CYAN).size();i++){
            PawnModel newPiece = new PawnModel(CheckersGameModelFactory.getCheckersGameModelCoords().get(PieceSquareColor.CYAN).get(i), PieceSquareColor.CYAN, this);
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
        boolean isPieceToTake = false;
        char middleMoveCol = (char)((initCoord.getColonne()+targetCoord.getColonne())/2);
        int middleMoveLig = (initCoord.getLigne()+targetCoord.getLigne())/2;
        Coord middleMoveCoord = new Coord(middleMoveCol, middleMoveLig);
        for (PieceModel piece : pieceList) {
            if(piece.getCoord().equals(initCoord) && piece.getPieceColor().equals(currentColor)){
                currentPiece = piece;
            }
            else if(piece.getCoord().equals(middleMoveCoord) && !piece.getPieceColor().equals(currentColor)){
                isPieceToTake = true;
                pieceToTake = piece;
            }
        }
        if(currentPiece != null){
            return currentPiece.isMoveOk(targetCoord, isPieceToTake);
        }
        return false;
    }

    public Coord movePiece(Coord initCoord, Coord targetCoord){
        int index = 0;
        int i = 0;
        for (PieceModel piece : pieceList) {
            if(piece.getCoord().equals(initCoord)){
                index = i;
            }
            i++;
        }
        pieceList.get(index).move(targetCoord);
        /* if(pieceToTake != null){
            System.out.println(pieceToTake);
            removePieceToTake();
        } */
        currentColor = currentColor==PieceSquareColor.CYAN ? PieceSquareColor.RED : PieceSquareColor.CYAN;
        return targetCoord;
    }

    public int removePiece(){
        int indexPieceToTake = -1;
        if(pieceToTake!=null){
            indexPieceToTake = pieceList.indexOf(pieceToTake);
            pieceList.remove(pieceToTake);
            pieceToTake = null;
        }
        return indexPieceToTake;
    }

    public String toString() {
        String[][] damier = new String[this.length][this.length];

        // Création d'un tableau 2D avec les noms des pièces
        for(PieceModel piece : this.pieceList) {
            PieceSquareColor color = piece.getPieceColor();
            String stColor = (PieceSquareColor.CYAN.equals(color) ? "--B--" : "--N--" );
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
