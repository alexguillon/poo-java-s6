package view;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PieceGUI extends JPanel {
    private PieceSquareColor pieceColor;
    private CheckersGameGUIData datas;

    public PieceGUI(PieceSquareColor pieceColor, CheckersGameGUIData datas){
        super();
        this.pieceColor = pieceColor;
        this.datas = datas;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.datas.getDatas().get("Forme").equals("Carre")){
            this.setBackground((Color) this.datas.getDatas().get(pieceColor));
            g.setColor((Color) this.datas.getDatas().get(pieceColor));
            g.drawRect(0,0, this.getWidth(), this.getHeight());
            g.fillRect(0,0, this.getWidth(), this.getHeight());
        }
        else if (this.datas.getDatas().get("Forme").equals("Cercle")) {
            this.setOpaque(false);
            g.setColor((Color) this.datas.getDatas().get(pieceColor));
            g.drawOval(0, 0, this.getWidth(), this.getHeight());
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
        }
        else if (this.datas.getDatas().get("Forme").equals("Pizza")) {
            this.setOpaque(false);
            g.setColor((Color) this.datas.getDatas().get(pieceColor));
            g.drawArc(-5,0,this.getWidth()+10, this.getHeight()+10, 90,-45);
            g.fillArc(-5,0,this.getWidth()+10, this.getHeight()+10, 90,-45);
            //g.fillOval(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
