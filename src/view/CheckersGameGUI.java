package view;

import javax.swing.*;
import java.util.Map;

public class CheckersGameGUI extends JFrame {

    private JPanel checkersBoard;
    private Map<Object, Object> checkersGameGUIData;
    private JMenuBar menuBar;

    public CheckersGameGUI(){
        super();
        this.checkersGameGUIData = CheckersGameGUIDataFactory.createCheckersGameGUIData();
        this.checkersBoard = new CheckersGameGUIBoard(checkersGameGUIData);
        this.setContentPane(checkersBoard);

        //this.menuBar = new CheckersGameGUIMenu(checkersGameGUIData);
        //this.setJMenuBar(menuBar);
    }
}
