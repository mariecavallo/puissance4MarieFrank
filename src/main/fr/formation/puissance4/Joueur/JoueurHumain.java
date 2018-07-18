package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Controle;
import javafx.scene.paint.Color;

import java.util.Scanner;

public class JoueurHumain extends Joueur {

    protected boolean gagnant;

    public JoueurHumain(Color color, Board board) {
        super(color, board);
        gagnant = false;
    }

    @Override
    public String envoyer() {

        if (gagnant)
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
        board.getJetons()[ligne][colonne].setColor(Color.valueOf(strings[2]));
        if(board.gagnant(ligne,colonne)){
            gagnant = true ;
            System.out.println("Vous avez perdu... Pion gagnant : ["+ligne+"] ["+colonne+"]");
        }
    }

    public String descentePion(int j) {
        int i = 0;
        while (i != 5 && board.getJetons()[i + 1][j - 1].getColor().equals(Color.TRANSPARENT)) {
            i++;
        }
        board.getJetons()[i][j - 1].setColor(this.color);
        return i + "," + (j - 1);
    }

    public int choixColonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choix colonne ?");
        int colonne = scanner.nextInt();
        return colonne;
    }

    public int ligne (String descentePion){
        String[] strings = descentePion.split(",");
        int ligne = Integer.parseInt(strings[0]);
        return ligne;
    }


}
