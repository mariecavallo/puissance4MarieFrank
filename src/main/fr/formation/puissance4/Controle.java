package fr.formation.puissance4;

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

    public boolean controlePionDessous(int ligne, int colonne){
        if (ligne != 6)
            if (Color.RED.equals(color) || (Color.YELLOW.equals(color)


    }


}
