package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import javafx.scene.paint.Color;

public class JoueurHumain extends Joueur {
    public JoueurHumain(Color color, Board board) {
        super(color, board);
    }

    @Override
    public String envoyer() {
        if (Color.RED.equals(color))
            return "4,4,RED";
        else
            return "4,4,YELLOW";
    }

    @Override
    public void recevoir(String messageRecu) {
        String[] strings = messageRecu.split(",");
        int ligne = Integer.parseInt(strings[0]);
        int colonne = Integer.parseInt(strings[1]);
        board.getJetons()[ligne][colonne].setColor(Color.valueOf(strings[2]));
    }

    public String descentePion(int j) {
        int i = 0;
        while (board.getJetons()[i][j].getColor() == color.TRANSPARENT) {
            i++;
        }
        return "i, j";
    }

}
