package view;

import notPOO.CheckersGameHalfPOO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameGUIBoard extends JPanel {

    private MouseListener squareListener;
    private MouseListener pieceListener;
    private JPanel selectedPieceGUI;
    private int length = 10;

    public CheckersGameGUIBoard(){
        super();

        this.squareListener = new SquareListener();
        this.pieceListener = new PieceListener();

        this.selectedPieceGUI = null;

        this.setBackgroundCheckersBoard(length);
        this.setPiecesCheckersBoard(length, 0, 4, PieceSquareColor.CYAN);
        this.setPiecesCheckersBoard(length, 6, 10, PieceSquareColor.RED);
        repaint();
        revalidate();
    }

    private void addPieceOnSquare(PieceSquareColor color, JPanel cell) {
        //Fonction permettant d'ajouter un pion au damier
        PieceGUI checker = new PieceGUI(color);
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
                BorderLayout layout = new BorderLayout();
                JPanel cell = new JPanel();
                cell.setLayout(layout);
                // On met un padding à 10 pour chaque case afin que le pion ne recouvre pas la totalité de la case
                cell.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                //Test nombre impair sur i et j pour créer une alternance de couleurs
                cell.setBackground(((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) ? Color.WHITE : Color.BLACK);
                cell.addMouseListener(squareListener);
                this.add(cell);
            }
        }
    }
    private void setPiecesCheckersBoard(int length, int indexBegin, int indexEnd, PieceSquareColor color){
        for(int i=indexBegin; i<indexEnd; i++) {
            for (int j = 0; j < length; j++) {
                JPanel cell = (JPanel) this.getComponent(i * 10 + j);
                if(!((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0))) { //Permet d'agir uniquement sur les cases noires
                    //On crée le pion sur la case noire
                    addPieceOnSquare(color, cell);
                }
            }
        }
    }

    private void setSelectedPiece(JPanel pieceGUI){
        this.selectedPieceGUI = pieceGUI;
    }

    private void movePiece(JPanel destinationCell){
        //On déplace la piece stockée dans selectedPieceGUI dans la case de destination noire choisie
        destinationCell.add(selectedPieceGUI, BorderLayout.CENTER);
        repaint(); //On update la fenêtre
        revalidate();
    }


    private class PieceListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            setSelectedPiece((JPanel) e.getSource()); //On récupère le pion sélectionnée et on stocke sa référence dans la variable globale selectedPieceGUI
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class SquareListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(selectedPieceGUI!=null)
                movePiece((JPanel) e.getSource()); //On déplace la pièce dans la case choisie
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
