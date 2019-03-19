package launcher;

import checkers.Coord;
import controler.CheckersGameControler;
import gui.CheckersGameGUI;
import model.CheckersGameModel;

import javax.swing.*;

public class CheckersGameMVCLauncher {

    public static void main(String[] args){

        CheckersGameModel checkersGameModel = new CheckersGameModel();

        CheckersGameControler checkersGameControler = new CheckersGameControler(checkersGameModel);

        // Fenêtre dans laquelle se dessine le damier
        // et qui propose un menu pour changer la couleur des cases
        // et la forme des pions

        JFrame frame = new CheckersGameGUI(checkersGameControler);

        frame.setTitle("Ceci est la fenêtre de mon jeu de dames - Version POO");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
