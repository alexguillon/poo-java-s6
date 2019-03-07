package gui;

import checkers.PieceSquareColor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SquareGUI extends JPanel {

    private PieceSquareColor pieceColor;
    private Map datas;
    private int id;
    private static int nbObject = 1;

    public SquareGUI(PieceSquareColor pieceColor, Map datas){
        super();
        this.id = nbObject;
        nbObject++;
        this.pieceColor = pieceColor;
        this.datas = datas;
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        // On met un padding à 10 pour chaque case afin que le pion ne recouvre pas la totalité de la case
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void paintComponent(Graphics g){
        this.setBackground((Color)this.datas.get(pieceColor)); //Si la case est de type noire, on dessine une case noire, sinon une case blanche
        super.paintComponent(g);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
