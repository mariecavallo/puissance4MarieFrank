package fr.formation.puissance4.Board;

import fr.formation.puissance4.Joueur.Joueur;
import fr.formation.puissance4.Piece.Jeton;
import javafx.scene.paint.Color;

import java.awt.*;

public class Board {
    private Jeton[][] jetons;

    public Board(Jeton[][] jetons) {
        this.jetons = jetons;
    }

    public Jeton[][] getJetons() {
        return jetons;
    }

    public boolean gagnant(int ligne, int colonne) {
        Color color = getJetons()[(ligne)][colonne].getColor();
        if (!gagnantVertical(color, ligne, colonne) && !gagnantHorizontal(color, ligne, colonne) && !gagnantDiagonal1(color, ligne, colonne) &&!gagnantDiagonal2(color, ligne, colonne))
            return false;
        return true;
    }

    public boolean gagnantVertical(Color color, int ligne, int colonne) {
        int compteur = 0;
        for (int i = 0; (ligne + i) < 6; i++) {
            if (getJetons()[(ligne + i)][colonne].getColor() == color) {
                compteur++;
            }
        }
        if (compteur == 4)
            return true;
        else
            return false;
    }

    public boolean gagnantHorizontal(Color color, int ligne, int colonne) {
        int compteurGauche = 0;
        int compteurDroit = 0;
        for (int j = 0; (colonne + j) < 7; j++) {
            if (getJetons()[(ligne)][colonne + j].getColor() == color) {
                compteurGauche++;
            }
        }
        for (int j = 1; (colonne - j) >= 0; j++) {
            if (getJetons()[(ligne)][colonne - j].getColor() == color) {
                compteurDroit++;
            }
        }
        if ((compteurGauche + compteurDroit) == 4)
            return true;
        else
            return false;

    }

    public boolean gagnantDiagonal1(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 0,  j = 0 ; ligne + i < 6 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne - j].getColor() == color) {
                compteurBas++;
            }
        }
        for (int i = 1,  j = 1 ; ligne - i >= 0 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne + j].getColor() == color) {
                compteurHaut++;
            }
        }
        if ((compteurBas + compteurHaut) == 4)
            return true;
        else
            return false;
    }

    public boolean gagnantDiagonal2(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 0,  j = 0 ; ligne - i >= 0 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne - j].getColor() == color) {
                compteurBas++;
            }
        }
        for (int i = 1,  j = 1 ; ligne + i < 6 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne + j].getColor() == color) {
                compteurHaut++;
            }
        }
        if ((compteurBas + compteurHaut) == 4)
            return true;
        else
            return false;

    }


}
