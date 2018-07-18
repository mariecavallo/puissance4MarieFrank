package fr.formation.puissance4;

import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Joueur.JoueurHumain;
import fr.formation.puissance4.Piece.Jeton;
import javafx.scene.paint.Color;

public class Controle {


    public boolean controle1a7(int choixColonne) {
        if (choixColonne >= 1 || choixColonne <= 7) {
            return true;
        } else {
            System.out.println("Saisir entre 1 et 7");
            return false;
        }
    }



    // retour true si le pion du dessous est vide

    public boolean controlePionDessous(Board lesJetons, int ligne, int colonne) {
        if (ligne != 6 && lesJetons.getJetons()[ligne - 1][colonne].getColor().equals(Color.TRANSPARENT)) {
            return true;
        } else {
            return false;
        }
    }



// retour true si la grille est pleine

    public boolean controleGrillePleine(Board lesJetons,int ligne, int colonne) {
        for (int j = 0; j < 7; j++) {
            if (lesJetons.getJetons()[ligne - 1][colonne].getColor().equals(Color.TRANSPARENT)) {
                return false;
            }
        }
        return true;

    }


}

