import view.CheckersGameGUI;

import javax.swing.*;

public class CheckersGamePOOLauncher {

    public static void main(String[] args){
        // Fenêtre dans laquelle se dessine le damier
        // et qui propose un menu pour changer la couleur des cases
        // et la forme des pions

        JFrame frame = new CheckersGameGUI();

        frame.setTitle("Ceci est la fenêtre de mon jeu de dames - Version POO");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
