package view;

import notPOO.CheckersGameHalfPOO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class CheckersGameGUIBoard extends JPanel {

    private MouseListener squareListener;
    private MouseListener pieceListener;

    public JPanel selectedPieceGUI;
    private int length;
    private CheckersGameGUIData datas;

    public CheckersGameGUIBoard(CheckersGameGUIData datas, CheckersGameGUIBoardListeners checkersGameGUIBoardListeners){
        super();
        this.length = (Integer) datas.getDatas().get("Taille");
        this.datas = datas;
        this.squareListener = checkersGameGUIBoardListeners.new SquareListener(this);
        this.pieceListener = checkersGameGUIBoardListeners.new PieceListener(this);

        this.selectedPieceGUI = null;

        this.setBackgroundCheckersBoard(length);
        this.setPiecesCheckersBoard(length, 0, 4, PieceSquareColor.CYAN);
        this.setPiecesCheckersBoard(length, 6, 10, PieceSquareColor.RED);
        repaint();
        revalidate();
    }

    private void addPieceOnSquare(PieceSquareColor pieceColor, JPanel cell) {
        //Fonction permettant d'ajouter un pion au damier
        PieceGUI checker = new PieceGUI(pieceColor,this.datas);
        checker.addMouseListener(pieceListener); //On ajoute un listener au pion
        cell.add(checker, BorderLayout.CENTER);
    }
    private void setBackgroundCheckersBoard(int length){
        //Creation du layout de type grille pour que les cellules de couleurs se comportent comme une case du damier
        GridLayout gridManager = new GridLayout(length,length);
        this.setLayout(gridManager);
        //On crée les 100 cases de couleurs
        for(int i=0; i<length; i++) {
            for (int j = 0; j < length; j++) {
                if(((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0))) {
                    JPanel cell = new SquareGUI(PieceSquareColor.WHITE,this.datas);
                    cell.addMouseListener(squareListener);
                    this.add(cell);
                }else{
                    JPanel cell = new SquareGUI(PieceSquareColor.BLACK,this.datas);
                    cell.addMouseListener(squareListener);
                    this.add(cell);
                }
            }
        }
    }
    private void setPiecesCheckersBoard(int length, int indexBegin, int indexEnd, PieceSquareColor pieceColor){
        for(int i=indexBegin; i<indexEnd; i++) {
            for (int j = 0; j < length; j++) {
                JPanel cell = (JPanel) this.getComponent(i * 10 + j);
                if(!((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0))) { //Permet d'agir uniquement sur les cases noires
                    //On crée le pion sur la case noire
                    addPieceOnSquare(pieceColor, cell);
                }
            }
        }
    }

    public void setSelectedPiece(JPanel pieceGUI){
        this.selectedPieceGUI = pieceGUI;
    }

    public void movePiece(JPanel destinationCell){
        //On déplace la piece stockée dans selectedPieceGUI dans la case de destination noire choisie
        destinationCell.add(selectedPieceGUI, BorderLayout.CENTER);
        repaint(); //On update la fenêtre
        revalidate();
    }



}
