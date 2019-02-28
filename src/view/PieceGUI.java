package view;

import javax.swing.*;
import java.awt.*;

public class PieceGUI extends JPanel {
    PieceSquareColor pieceColor;

    public PieceGUI(PieceSquareColor pieceColor){
        super();
        this.pieceColor = pieceColor;

    }

    public void paintComponent(Graphics g){
        this.setBackground(pieceColor == PieceSquareColor.CYAN ? Color.CYAN : Color.RED);
        super.paintComponent(g);
    }

}
