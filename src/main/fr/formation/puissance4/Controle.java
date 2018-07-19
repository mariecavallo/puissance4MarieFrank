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

    public boolean controleChiffre (int colonne){

        if (colonne != (int) colonne){
            System.out.println("Vous devez entrer un chiffre.");
            return false;
        } else
            return true;
    }



    // retour true si le pion du dessous est vide

    public boolean controlePionDessous(Board lesJetons, int ligne, int colonne) {
        if (ligne != 5  && lesJetons.getJetons()[ligne + 1][colonne].getColor().equals(Color.TRANSPARENT)) {
            return true;
        } else {
            return false;
        }
    }



// retour true si la grille est pleine

    public boolean controleGrillePleine(Board lesJetons) {
        int compteur = 0;
        for (int j = 0; j < 7; j++ ) {
            if (!lesJetons.getJetons()[0][j].getColor().equals(Color.TRANSPARENT)) {
                compteur++;
            }
        }
        if (compteur==7)
            return true;
        else
            return false;
    }


}

