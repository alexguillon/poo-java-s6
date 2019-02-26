package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameHalfPOO {

    private JFrame frame;
    private JPanel checkersBoard;
    private JPanel selectedPieceGUI;
    private static final int length = 10;

    public static void main(String[] args) {
        new CheckersGameHalfPOO();
    }

    public CheckersGameHalfPOO() {

        selectedPieceGUI = null;

        //Creation de la fenetre 600*600
        frame = new JFrame("Ceci est la fenêtre d'affichage de mon jeu de dames");
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creation du damier
        checkersBoard = new JPanel();
        //Ajout des cases de couleurs noires et blanches
        setBackgroundCheckersBoard(checkersBoard, length);
        //Ajout des pions cyans sur les 4 premieres lignes du damier (ligne 0 à 4)
        setPiecesCheckersBoard(checkersBoard, length,0,4,Color.CYAN);
        //Ajout des pions rouges sur les 4 dernieres lignes du damier (ligne 6 à 10)
        setPiecesCheckersBoard(checkersBoard, length,6,10,Color.RED);
        //Ajout du damier à la fenêtre et mis à jour du contenu graphique
        frame.add(checkersBoard);
        frame.revalidate();
        frame.repaint();
        frame.setResizable(false);
    }

    private void setBackgroundCheckersBoard(JPanel jPanel, int length){
        //Creation du layout de type grille pour que les cellules de couleurs se comportent comme une case du damier
        GridLayout gridManager = new GridLayout(length,length);
        jPanel.setLayout(gridManager);
        //On crée les 100 cases de couleurs
        for(int i=0; i<length; i++) {
            for (int j = 0; j < length; j++) {
                JPanel cell = new JPanel();
                BorderLayout layout = new BorderLayout();
                cell.setLayout(layout);
                // On met un padding à 10 pour chaque case afin que le pion ne recouvre pas la totalité de la case
                cell.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                //Test nombre impair sur i et j pour créer une alternance de couleurs
                cell.setBackground(((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) ? Color.WHITE : Color.BLACK);
                cell.addMouseListener(new SquareListener());
                jPanel.add(cell);
            }
        }
    }

    private void setPiecesCheckersBoard(JPanel jPanel, int length, int indexBegin, int indexEnd, Color color){
        for(int i=indexBegin; i<indexEnd; i++) {
            for (int j = 0; j < length; j++) {
                JPanel cell = (JPanel) jPanel.getComponent(i * 10 + j);
                if(!((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0))) { //Permet d'agir uniquement sur les cases noires
                    //On crée le pion sur la case noire
                    addPieceOnSquare(color, cell);
                }
            }
        }
    }

    private void addPieceOnSquare(Color color, JPanel cell) {
        JPanel checker = new JPanel();
        checker.setBackground(color);
        checker.addMouseListener(new PieceListener());
        cell.add(checker, BorderLayout.CENTER);
    }

    private void setSelectedPiece(JPanel pieceGUI){
        this.selectedPieceGUI = pieceGUI;
    }

    private void movePiece(JPanel destinationCell){
        destinationCell.add(selectedPieceGUI, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
    }

    private class PieceListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            setSelectedPiece((JPanel) e.getSource());
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
            movePiece((JPanel) e.getSource());
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
