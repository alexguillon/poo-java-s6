package gui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameGUIBoardListeners {

    public class PieceListener implements MouseListener{
        private CheckersGameGUIBoard checkersGameGUIBoard;
        public PieceListener(CheckersGameGUIBoard checkersGameGUIBoard){
            super();
            this.checkersGameGUIBoard = checkersGameGUIBoard;
        }
        public void mouseClicked(MouseEvent ev){
            JPanel piece = (JPanel) ev.getSource();
            SquareGUI square = (SquareGUI) piece.getParent();
            int indexSquare = square.getId();
            if(checkersGameGUIBoard.getCheckersGameControler().isPieceMovable(indexSquare)){
                this.checkersGameGUIBoard.setSelectedPiece((JPanel) ev.getSource()); //On récupère le pion sélectionnée et on stocke sa référence dans la variable globale selectedPieceGUI
            }
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

    public class SquareListener implements MouseListener{
        private CheckersGameGUIBoard checkersGameGUIBoard;
        public SquareListener(CheckersGameGUIBoard checkersGameGUIBoard){
            super();
            this.checkersGameGUIBoard = checkersGameGUIBoard;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if(this.checkersGameGUIBoard.selectedPieceGUI!=null) {
                this.checkersGameGUIBoard.movePiece((JPanel) e.getSource()); //On déplace la pièce dans la case choisie
            }
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

