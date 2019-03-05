package view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CheckersGameGUIDataFactory {

    private CheckersGameGUIDataFactory(){

    }

    public static CheckersGameGUIData createCheckersGameGUIData(){

        Map<Object, Object> map = new HashMap<> ();
        map.put(PieceSquareColor.BLACK, Color.BLACK);
        map.put(PieceSquareColor.WHITE, Color.WHITE);
        map.put(PieceSquareColor.CYAN, Color.CYAN);
        map.put(PieceSquareColor.RED, Color.RED);
        map.put("Taille", 10);
        map.put("Forme", "Cercle");
        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(map);
        return checkersGameGUIData;

    }

}
