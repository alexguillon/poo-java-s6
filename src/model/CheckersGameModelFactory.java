package model;

import checkers.Coord;
import checkers.PieceSquareColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckersGameModelFactory {
    private CheckersGameModelFactory(){

    }

    public static Map<PieceSquareColor, List<Coord>> getCheckersGameModelCoords(){
        Map<PieceSquareColor, List<Coord>> map = new HashMap<PieceSquareColor, List<Coord>>();
        Coord[] blackPieceCoords = new Coord[] {
            new Coord('b',10), new Coord('d',10), new Coord('f',10), new Coord('h',10), new Coord('j',10),
            new Coord('a',9), new Coord('c',9), new Coord('e',9), new Coord('g',9), new Coord('i',9),
            new Coord('b',8), new Coord('d',8), new Coord('f',8), new Coord('h',8), new Coord('j',8),
            new Coord('a',7), new Coord('c',7), new Coord('e',7), new Coord('g',7), new Coord('i',7)
        };
        Coord[] whitePieceCoords = new Coord[] {
                new Coord('b',4), new Coord('d',4), new Coord('f',4), new Coord('h',4), new Coord('j',4),
                new Coord('a',3), new Coord('c',3), new Coord('e',3), new Coord('g',3), new Coord('i',3),
                new Coord('b',2), new Coord('d',2), new Coord('f',2), new Coord('h',2), new Coord('j',2),
                new Coord('a',1), new Coord('c',1), new Coord('e',1), new Coord('g',1), new Coord('i',1)
        };
        map.put(PieceSquareColor.BLACK, Arrays.asList(blackPieceCoords));
        map.put(PieceSquareColor.WHITE, Arrays.asList(whitePieceCoords));
        return map;
    }

    public static int getLength(){
        return 10;
    }

    public static PieceSquareColor getBeginColor(){
        return PieceSquareColor.WHITE;
    }
}
