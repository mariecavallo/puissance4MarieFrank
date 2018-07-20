package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import javafx.scene.paint.Color;

import java.util.Random;

public class StrategyMarie extends Strategy {

    @Override
    public String choixPosition(Board board, Color myColor, Color coloradverse) {
        int choixColonne;
        choixColonne = choixColonneNiveau(board, myColor, coloradverse);
        String choix = descentePion(board, myColor, choixColonne);
        if (Color.RED.equals(myColor))
            return choix + ",RED";
        else
            return choix + ",YELLOW";
    }

    public String descentePion(Board board, Color color, int j) {
        int i = 0;
        while (i != 5 && board.getJetons()[i + 1][j].getColor().equals(Color.TRANSPARENT)) {
            i++;
        }
        board.getJetons()[i][j].setColor(color);
        return i + "," + (j);
    }

    public int descentePion(Board board, int j) {
        int i = 0;
        while (i != 5 && board.getJetons()[i + 1][j].getColor().equals(Color.TRANSPARENT)) {
            i++;
        }
        return i;
    }

    // Verifie si une position est perdante en 1 coup
    public Integer verifColonneDefense(Board board, Color colorAdverse, int niveau) {

        Integer choixColonne = null;

        if (board.getJetons()[5][3].getColor().equals(Color.TRANSPARENT))
            choixColonne = 3;

        for (int j = 0; j < 7; j++) {
            int ligneDescente = descentePion(board, j);
            if (board.compteurVertical(colorAdverse, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurHorizontal(colorAdverse, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurDiagonaleSONE(colorAdverse, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurDiagonaleNOSE(colorAdverse, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
        }
        return choixColonne;
    }

    // Verifie si une position est gagnante en 1 coup
    public Integer verifColonneAttaque(Board board, Color myColor, int niveau) {

        Integer choixColonne = null;

        for (int j = 0; j < 7; j++) {
            int ligneDescente = descentePion(board, j);
            if (board.compteurVertical(myColor, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurHorizontal(myColor, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurDiagonaleSONE(myColor, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
            if (board.compteurDiagonaleNOSE(myColor, ligneDescente, j) == niveau) {
                choixColonne = j;
            }
        }
        return choixColonne;
    }

    public int colonneRnd(Board board) {
        int choixColonne = 0;
        boolean saisieCorrect = false;
        while (!saisieCorrect) {
            Random random = new Random();
            choixColonne = random.nextInt(7);
            if (!board.getJetons()[0][choixColonne].getColor().equals(Color.TRANSPARENT)) {
                saisieCorrect = false;
                System.out.println("La colonne est pleine. Veuillez choisir une autre colonne !");
            } else {
                saisieCorrect = true;
            }
        }
        return choixColonne;
    }

    public Integer choixColonneNiveau(Board board, Color myColor, Color colorAdverse) {
        Integer choixColonne;
        choixColonne = verifColonneAttaque(board, myColor, 3);
        if (choixColonne == null || colonnePleine(board, choixColonne)) {
            choixColonne = verifColonneDefense(board, colorAdverse, 3);
            if (choixColonne == null || colonnePleine(board, choixColonne)) {
                choixColonne = verifColonneAttaque(board, myColor, 2);
                if (choixColonne == null || colonnePleine(board, choixColonne)) {
                    choixColonne = verifColonneDefense(board, colorAdverse, 2);
                    if ((choixColonne == null || colonnePleine(board, choixColonne)) && board.getJetons()[5][3].getColor().equals(Color.TRANSPARENT)) {
                        choixColonne = 3;
                    } else {
                        choixColonne = colonneRnd(board);
                    }
                    return choixColonne;
                }
            }
        }
        return choixColonne;
    }

    public boolean colonnePleine(Board board, int colonne) {
        if (!board.getJetons()[0][colonne].getColor().equals(Color.TRANSPARENT)) {
            System.out.println("La colonne est pleine. Veuillez choisir une autre colonne !");
            return true;
        } else {
            return false;
        }
    }
}

