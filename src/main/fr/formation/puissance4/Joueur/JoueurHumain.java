package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Controle;
import javafx.scene.paint.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurHumain extends Joueur {

    private boolean gagnant;
    private boolean validiteCoupAdverse;

    public JoueurHumain(Color color, Board board) {
        super(color, board);
        gagnant = false;
        validiteCoupAdverse = true;
    }

    @Override
    public String envoyer() {

        if (gagnant || !validiteCoupAdverse)
            return "Fin";
        else {
            String choix = descentePion(choixColonne());
            if (Color.RED.equals(color))
                return choix + ",RED";
            else
                return choix + ",YELLOW";
        }
    }

    @Override
    public void recevoir(String messageRecu) {
        String[] strings = messageRecu.split(",");
        int ligne = Integer.parseInt(strings[0]);
        int colonne = Integer.parseInt(strings[1]);
        Controle controle = new Controle();
        if (!board.getJetons()[ligne][colonne].getColor().equals(Color.TRANSPARENT) || controle.controlePionDessous(board, ligne, colonne)){
            validiteCoupAdverse = false;
            System.out.println("erreur controle");
        } else {
            board.getJetons()[ligne][colonne].setColor(Color.valueOf(strings[2]));
        }
        if(board.gagnant(ligne,colonne)){
            gagnant = true ;
            System.out.println("Vous avez perdu... Pion gagnant : ["+ligne+"] ["+colonne+"]");
        }
    }

    // Position finale après descente du pion

    public String descentePion(int j) {
        int i = 0;
        while (i != 5 && board.getJetons()[i + 1][j - 1].getColor().equals(Color.TRANSPARENT)) {
            i++;
        }
        board.getJetons()[i][j - 1].setColor(this.color);
        return i + "," + (j - 1);
    }


    // choix de la colonne par l'utilisateur et vérification de la saisie

    public int choixColonne() {
        int colonne = 0 ;
        boolean saisieCorrect = false;
        while (!saisieCorrect) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("choix colonne ?");
                colonne = scanner.nextInt();
                saisieCorrect = true;
                if (!board.getJetons()[0][colonne-1].getColor().equals(Color.TRANSPARENT)){
                    saisieCorrect = false;
                    System.out.println("La colonne est pleine. Veuillez choisir une autre colonne !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez entrer un chiffre !");
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Vous devez entrer un chiffre entre 1 et 7 !");
            }
        }
        return colonne;
    }

    // Recupère la valeur de la ligne après descente pion

    public int ligne (String descentePion){
        String[] strings = descentePion.split(",");
        int ligne = Integer.parseInt(strings[0]);
        return ligne;
    }


}
