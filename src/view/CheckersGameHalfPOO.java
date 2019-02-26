package VIEW;

import javax.swing.*;
import java.awt.*;

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

    private static void setBackgroundCheckersBoard(JPanel jPanel, int length){
        //Creation du layout de type grille pour que les cellules de couleurs se comportent comme une case du damier
        GridLayout gridManager = new GridLayout(length,length);
        jPanel.setLayout(gridManager);
        //On crée les 100 cases de couleurs
        for(int i=0; i<length; i++) {
            for (int j = 0; j < length; j++) {
                JPanel cell = new JPanel();
                //Test nombre impair sur i et j pour créer une alternance de couleurs
                cell.setBackground(((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) ? Color.WHITE : Color.BLACK);
                jPanel.add(cell);
            }
        }
    }

    private static void setPiecesCheckersBoard(JPanel jPanel, int length, int indexBegin, int indexEnd, Color color){
        for(int i=indexBegin; i<indexEnd; i++) {
            for (int j = 0; j < length; j++) {
                //On boucle sur chaque case pour lui ajouter un pion (que sur les cases noires)
                JPanel cell = (JPanel) jPanel.getComponent(i*10+j);
                //On ajoute un layout à la case
                BorderLayout layout = new BorderLayout();
                cell.setLayout(layout);
                // On met un padding à 10 pour chaque case afin que le pion ne recouvre pas la totalité de la case
                cell.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                JPanel checker = new JPanel();
                checker.setBackground(color);
                if(!((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)))
                    cell.add(checker, BorderLayout.CENTER); //On ajoute le pion sur la case si la case est noire
            }
        }
    }
}
