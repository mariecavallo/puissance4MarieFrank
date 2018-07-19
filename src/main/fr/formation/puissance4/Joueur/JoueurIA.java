package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Joueur.IA.Strategy;
import fr.formation.puissance4.Joueur.IA.Strategy1;
import fr.formation.puissance4.Joueur.Joueur;
import javafx.scene.paint.Color;

public class JoueurIA extends Joueur {

    Strategy strategy;

    public JoueurIA(Color color, Board board) {
        super(color, board);
        strategy = new Strategy1();
    }

    @Override
    public String envoyer() {
        return null;
    }

    @Override
    public void recevoir(String messageRecu) {

    }
}
