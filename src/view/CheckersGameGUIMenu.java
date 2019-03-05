package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CheckersGameGUIMenu extends JMenuBar {
    private JMenu menu, submenuShape;
    private JColorChooser colorChooserWhiteSquare, colorChooserBlackSquare;
    private JMenuItem cercle, carre, arc, submenuWhite, submenuBlack;
    private JColorActionListener actionListener;
    private Map<Object, Object> checkersGameGUIData;

    public CheckersGameGUIMenu(Map<Object, Object> checkersGameGUIData){
        this.checkersGameGUIData = checkersGameGUIData;
        menu=new JMenu("Paramètres d'affichage");
        submenuWhite=new JMenuItem("Couleur cases blanches");
        submenuBlack=new JMenuItem("Couleur cases noires");
        submenuShape=new JMenu("Couleur cases noires");
        cercle=new JMenuItem("Cercle");
        carre=new JMenuItem("Carré");
        arc=new JMenuItem("Arc");
        colorChooserWhiteSquare = new JColorChooser();
        colorChooserBlackSquare = new JColorChooser();
        menu.add(submenuWhite);
        menu.add(submenuBlack);
        submenuShape.add(cercle); submenuShape.add(carre); submenuShape.add(arc);
        menu.add(submenuShape);
        this.add(menu);
        actionListener = new JColorActionListener();
        submenuWhite.addActionListener(actionListener);
        submenuBlack.addActionListener(actionListener);
    }


    private class JColorActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(submenuWhite)){
                Color c = colorChooserWhiteSquare.showDialog((Component) e.getSource(), "Choisir une couleur pour les cases blanches", (Color)checkersGameGUIData.get(PieceSquareColor.WHITE));
                checkersGameGUIData.put(PieceSquareColor.WHITE, c);
            }
            else if(e.getSource().equals(submenuBlack)){
                Color c = colorChooserBlackSquare.showDialog((Component) e.getSource(), "Choisir une couleur pour les cases noires", (Color)checkersGameGUIData.get(PieceSquareColor.BLACK));
                checkersGameGUIData.put(PieceSquareColor.BLACK, c);
            }
        }

    }



}
