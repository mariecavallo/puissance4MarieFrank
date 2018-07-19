package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Controle;
import javafx.scene.paint.Color;

public class JoueurIA extends Joueur {

    protected boolean gagnant;
    protected boolean validiteCoupAdverse;
    protected Strategy strategy;

    public JoueurIA(Color color, Board board, Strategy strategy) {
        super(color, board);
        gagnant = false;
        validiteCoupAdverse = true;
        this.strategy = strategy;
    }

    @Override
    public String envoyer() {
        Controle controle = new Controle();
        if (gagnant || !validiteCoupAdverse || controle.controleGrillePleine(board) ) {
            return "Fin";
        } else {
            return strategy.choixPosition(board, color);
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
        } else {
            board.getJetons()[ligne][colonne].setColor(Color.valueOf(strings[2]));
        }
        if(board.gagnant(ligne,colonne)){
            gagnant = true ;
            System.out.println("Vous avez perdu... Pion gagnant : ["+ligne+"] ["+colonne+"]");
        }

    }
}
