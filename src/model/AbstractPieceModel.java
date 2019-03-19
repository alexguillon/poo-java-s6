package model;

import checkers.Coord;
import checkers.PieceSquareColor;

import java.util.Objects;

public abstract class AbstractPieceModel implements PieceModel{

    private Coord coord;
    private PieceSquareColor pieceSquareColor;
    private CheckersGameModel checkersGameModel;

    public AbstractPieceModel(Coord coord, PieceSquareColor pieceSquareColor, CheckersGameModel checkersGameModel) {
        this.coord = coord;
        this.pieceSquareColor = pieceSquareColor;
        this.checkersGameModel = checkersGameModel;
    }

    @Override
    public Coord getCoord() {
        return coord;
    }

    @Override
    public CheckersGameModel getCheckersGameModel() {
        return checkersGameModel;
    }

    @Override
    public void move(Coord targetCoord) {
        this.coord = targetCoord;
    }

    @Override
    public PieceSquareColor getPieceColor() {
        return pieceSquareColor;
    }

    @Override
    public boolean isMoveOk(Coord targetCoord, boolean isPieceToTake) {
        return false;
    }

    @Override
    public String toString() {
        return "AbstractPieceModel{" +
                "coord=" + coord +
                ", pieceSquareColor=" + pieceSquareColor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPieceModel)) return false;
        AbstractPieceModel that = (AbstractPieceModel) o;
        return Objects.equals(getCoord(), that.getCoord()) &&
                pieceSquareColor == that.pieceSquareColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoord(), pieceSquareColor);
    }
}
