package checkers;

import java.util.Objects;

public class Coord {

    private char colonne;
    private int ligne;

    public Coord(char c, int l){
        colonne = c;
        ligne = l;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "colonne=" + colonne +
                ", ligne=" + ligne +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord)) return false;
        Coord coord = (Coord) o;
        return colonne == coord.colonne &&
                ligne == coord.ligne;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colonne, ligne);
    }

    public static boolean coordonnees_valides(char col, int ligne, int max){
        return((col-'a'>=0) && (col-'a'<max) && (ligne>=0) && (ligne<max));
    }

    public static boolean coordonnees_valides(Coord coord, int max){
        return((coord.colonne-'a'>=0) && (coord.colonne-'a'<max) && (coord.ligne>=0) && (coord.ligne<max));
    }

    public char getColonne() {
        return colonne;
    }

    public void setColonne(char colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
}
