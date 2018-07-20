package fr.formation.puissance4.Board;

import fr.formation.puissance4.Piece.Jeton;
import javafx.scene.paint.Color;

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
        if (!gagnantVertical(color, ligne, colonne) && !gagnantHorizontal(color, ligne, colonne) && !gagnantDiagonaleSONE(color, ligne, colonne) &&!gagnantDiagonaleNOSE(color, ligne, colonne))
            return false;
        return true;
    }

    // Verifie si la position du pion ajouté est gagnante verticalement
    public boolean gagnantVertical(Color color, int ligne, int colonne) {
        int compteur = 0;
        for (int i = 0; (ligne + i) < 6; i++) {
            if (getJetons()[(ligne + i)][colonne].getColor() == color) {
                compteur++;
            } else {
                break;
            }
        }
        if (compteur >= 4)
            return true;
        else
            return false;
    }

    // Verifie si la position du pion ajouté est gagnante horizontalement
    public boolean gagnantHorizontal(Color color, int ligne, int colonne) {
        int compteurGauche = 0;
        int compteurDroit = 0;
        for (int j = 0; (colonne + j) < 7; j++) {
            if (getJetons()[(ligne)][colonne + j].getColor() == color) {
                compteurDroit++;
            } else {
                break;
            }
        }
        for (int j = 1; (colonne - j) >= 0; j++) {
            if (getJetons()[(ligne)][colonne - j].getColor() == color) {
                compteurGauche++;
            } else {
                break;
            }
        }
        if ((compteurGauche + compteurDroit) >= 4)
            return true;
        else
            return false;

    }

    // Verifie si la position du pion ajouté est gagnante dans la diagonale Sud-Ouest / Nord-Est
    public boolean gagnantDiagonaleSONE(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 0,  j = 0 ; ligne + i < 6 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne - j].getColor() == color) {
                compteurBas++;
            } else {
                break;
            }
        }
        for (int i = 1,  j = 1 ; ligne - i >= 0 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne + j].getColor() == color) {
                compteurHaut++;
            } else {
                break;
            }
        }
        if ((compteurBas + compteurHaut) >= 4)
            return true;
        else
            return false;
    }

    // Verifie si la position du pion ajouté est gagnante dans la diagonale Nord-Ouest / Sud-Est
    public boolean gagnantDiagonaleNOSE(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 0,  j = 0 ; ligne - i >= 0 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne - j].getColor() == color) {
                compteurBas++;
            } else {
                break;
            }
        }
        for (int i = 1,  j = 1 ; ligne + i < 6 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne + j].getColor() == color) {
                compteurHaut++;
            } else {
                break;
            }
        }
        if ((compteurBas + compteurHaut) >= 4)
            return true;
        else
            return false;

    }

    public int compteurVertical(Color color, int ligne, int colonne) {
        int compteur = 0;
        for (int i = 1; (ligne + i) < 6; i++) {
            if (getJetons()[(ligne + i)][colonne].getColor() == color) {
                compteur++;
            } else {
                break;
            }
        }
        return compteur;
    }

    public int compteurHorizontal(Color color, int ligne, int colonne) {
        int compteurGauche = 0;
        int compteurDroit = 0;
        for (int j = 1; (colonne + j) < 7; j++) {
            if (getJetons()[(ligne)][colonne + j].getColor() == color) {
                compteurDroit++;
            } else {
                break;
            }
        }
        for (int j = 1; (colonne - j) >= 0; j++) {
            if (getJetons()[(ligne)][colonne - j].getColor() == color) {
                compteurGauche++;
            } else {
                break;
            }
        }
        return compteurGauche + compteurDroit;
    }

    public int compteurDiagonaleSONE(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 1,  j = 1 ; ligne + i < 6 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne - j].getColor() == color) {
                compteurBas++;
            } else {
                break;
            }
        }
        for (int i = 1,  j = 1 ; ligne - i >= 0 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne + j].getColor() == color) {
                compteurHaut++;
            } else {
                break;
            }
        }
        return compteurBas + compteurHaut;
    }

    public int compteurDiagonaleNOSE(Color color, int ligne, int colonne) {
        int compteurBas = 0;
        int compteurHaut = 0;
        for (int i = 1,  j = 1 ; ligne - i >= 0 && colonne - j >= 0 ; i++ , j++) {
            if (getJetons()[ligne - i][colonne - j].getColor() == color) {
                compteurBas++;
            } else {
                break;
            }
        }
        for (int i = 1,  j = 1 ; ligne + i < 6 && colonne + j < 7 ; i++ , j++) {
            if (getJetons()[ligne + i][colonne + j].getColor() == color) {
                compteurHaut++;
            } else {
                break;
            }
        }
        return compteurBas + compteurHaut;
    }

}
