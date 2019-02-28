package view;

import javax.swing.*;

public class CheckersGameGUI extends JFrame {

    private JPanel checkersBoard;
    private JMenuBar menuBar;

    public CheckersGameGUI(){
        super();

        this.checkersBoard = new CheckersGameGUIBoard();
        this.setContentPane(checkersBoard);

        //this.menuBar = new CheckersGameGUIMenu();
        //this.setJMenuBar(menuBar);
    }
}
