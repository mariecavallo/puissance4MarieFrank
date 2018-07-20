package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import javafx.scene.paint.Color;

import java.util.Random;

public class StrategyRnd extends Strategy {

    public StrategyRnd() {
    }

    @Override
    public String choixPosition(Board board, Color color, Color colorAdverse) {
        String choix = descentePion(board, color,choixColonne(board));
        if (Color.RED.equals(color))
            return choix + ",RED";
        else
            return choix + ",YELLOW";
    }

    public int choixColonne(Board board) {
        int colonne = 0;
        boolean saisieCorrect = false;
        while (!saisieCorrect) {
            Random random = new Random();
            colonne = random.nextInt(7) + 1;
            if (!board.getJetons()[0][colonne - 1].getColor().equals(Color.TRANSPARENT)) {
                saisieCorrect = false;
                System.out.println("La colonne est pleine. Veuillez choisir une autre colonne !");
            } else {
                saisieCorrect = true;
            }
        }
        return colonne;
    }

    public String descentePion(Board board, Color color, int j) {
        int i = 0;
        while (i != 5 && board.getJetons()[i + 1][j - 1].getColor().equals(Color.TRANSPARENT)) {
            i++;
        }
        board.getJetons()[i][j - 1].setColor(color);
        return i + "," + (j - 1);
    }
}
