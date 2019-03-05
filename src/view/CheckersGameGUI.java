package view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class CheckersGameGUI extends JFrame implements Observer {

    private JPanel checkersBoard;
    private CheckersGameGUIData checkersGameGUIData;
    private JMenuBar menuBar;
    private CheckersGameGUIBoardListeners checkersGameGUIBoardListeners;
    public CheckersGameGUI(){
        super();
        this.checkersGameGUIData = CheckersGameGUIDataFactory.createCheckersGameGUIData();
        this.checkersGameGUIBoardListeners = new CheckersGameGUIBoardListeners();
        this.checkersBoard = new CheckersGameGUIBoard(checkersGameGUIData, checkersGameGUIBoardListeners);
        this.setContentPane(checkersBoard);
        this.menuBar = new CheckersGameGUIMenu(checkersGameGUIData);
        this.setJMenuBar(menuBar);
        checkersGameGUIData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
        revalidate();
    }
}
