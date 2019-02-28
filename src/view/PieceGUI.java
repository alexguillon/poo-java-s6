package view;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PieceGUI extends JPanel {
    private PieceSquareColor pieceColor;
    private Map<Object,Object> datas;

    public PieceGUI(PieceSquareColor pieceColor, Map<Object,Object> datas){
        super();
        this.pieceColor = pieceColor;
        this.datas = datas;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.datas.get("Forme").equals("Carre")){
            this.setBackground((Color) this.datas.get(pieceColor));
        }
        if (this.datas.get("Forme").equals("Cercle")) {
            this.setOpaque(false);
            g.setColor((Color) this.datas.get(pieceColor));
            g.drawOval(0, 0, this.getWidth(), this.getHeight());
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
