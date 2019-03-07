package gui;

import controler.CheckersGameControler;

import javax.swing.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class CheckersGameGUI extends JFrame implements Observer {

    private CheckersGameControler checkersGameControler;
    private JPanel checkersBoard;
    private CheckersGameGUIData checkersGameGUIData;
    private JMenuBar menuBar;
    private CheckersGameGUIBoardListeners checkersGameGUIBoardListeners;

    public CheckersGameGUI(CheckersGameControler checkersGameControler) {
        super();
        this.checkersGameControler = checkersGameControler;
        this.checkersGameGUIData = CheckersGameGUIDataFactory.createCheckersGameGUIData();
        this.checkersGameGUIBoardListeners = new CheckersGameGUIBoardListeners();
        this.checkersBoard = new CheckersGameGUIBoard(checkersGameGUIData, checkersGameGUIBoardListeners, checkersGameControler);
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
