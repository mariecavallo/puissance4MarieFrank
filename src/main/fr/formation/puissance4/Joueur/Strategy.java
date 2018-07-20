package fr.formation.puissance4.Joueur;

import fr.formation.puissance4.Board.Board;
import javafx.scene.paint.Color;


public abstract class Strategy {

    public abstract String choixPosition (Board board, Color color, Color coloradverse);
}
