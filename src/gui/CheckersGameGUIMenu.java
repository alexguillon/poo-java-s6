package gui;

import checkers.PieceSquareColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CheckersGameGUIMenu extends JMenuBar {
    private JMenu menu, submenuShape;
    private JColorChooser colorChooserWhiteSquare, colorChooserBlackSquare, colorChooserPiecePlayer1, colorChooserPiecePlayer2;
    private JMenuItem cercle, carre, pizza, submenuWhite, submenuBlack, subMenuPiecePlayer1, subMenuPiecePlayer2;
    private JMenuListener actionListener;
    private Map checkersGameGUIData;

    public CheckersGameGUIMenu(Map checkersGameGUIData){
        this.checkersGameGUIData = checkersGameGUIData;
        menu=new JMenu("Paramètres d'affichage");
        submenuWhite=new JMenuItem("Couleur cases blanches");
        submenuBlack=new JMenuItem("Couleur cases noires");
        subMenuPiecePlayer1=new JMenuItem("Couleur pions joueur 1");
        subMenuPiecePlayer2=new JMenuItem("Couleur pions joueur 2");
        submenuShape=new JMenu("Forme des pions");
        cercle=new JMenuItem("Cercle");
        carre=new JMenuItem("Carré");
        pizza=new JMenuItem("Pizza");
        colorChooserWhiteSquare = new JColorChooser();
        colorChooserBlackSquare = new JColorChooser();
        colorChooserPiecePlayer1 = new JColorChooser();
        colorChooserPiecePlayer2 = new JColorChooser();
        menu.add(submenuWhite);
        menu.add(submenuBlack);
        menu.add(subMenuPiecePlayer1);
        menu.add(subMenuPiecePlayer2);
        submenuShape.add(cercle); submenuShape.add(carre); submenuShape.add(pizza);
        menu.add(submenuShape);
        this.add(menu);
        actionListener = new JMenuListener();
        submenuWhite.addActionListener(actionListener);
        submenuBlack.addActionListener(actionListener);
        submenuShape.addActionListener(actionListener);
        subMenuPiecePlayer1.addActionListener(actionListener);
        subMenuPiecePlayer2.addActionListener(actionListener);
        cercle.addActionListener(actionListener);
        carre.addActionListener(actionListener);
        pizza.addActionListener(actionListener);
    }


    private class JMenuListener implements ActionListener {

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
            else if(e.getSource().equals(subMenuPiecePlayer1)){
                Color c = colorChooserBlackSquare.showDialog((Component) e.getSource(), "Choisir une couleur pour les pions du joueur 1", (Color)checkersGameGUIData.get(PieceSquareColor.BLACK));
                checkersGameGUIData.put(PieceSquareColor.CYAN, c);
            }
            else if(e.getSource().equals(subMenuPiecePlayer2)){
                Color c = colorChooserBlackSquare.showDialog((Component) e.getSource(), "Choisir une couleur pour les pions du joueur 2", (Color)checkersGameGUIData.get(PieceSquareColor.BLACK));
                checkersGameGUIData.put(PieceSquareColor.RED, c);
            }
            else if(e.getSource().equals(carre)){
                checkersGameGUIData.put("Forme", "Carre");
            }
            else if(e.getSource().equals(cercle)){
                checkersGameGUIData.put("Forme", "Cercle");
            }
            else if(e.getSource().equals(pizza)){
                checkersGameGUIData.put("Forme", "Pizza");
            }
        }

    }



}
