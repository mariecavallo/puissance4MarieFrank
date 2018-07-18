import fr.formation.puissance4.Board.Board;
import fr.formation.puissance4.Joueur.*;
import fr.formation.puissance4.Piece.Jeton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Main {
    public static void main(String[] args) {
        Jeton[][] jetons = new Jeton[6][7];
        for (int ligne = 0; ligne < jetons.length; ligne++) {
            for (int colonne = 0; colonne < jetons[ligne].length; colonne++) {
                Circle diskPreview = new Circle(40);
                diskPreview.setOpacity(1);
                diskPreview.setFill(Color.TRANSPARENT);
                jetons[ligne][colonne] = new Jeton(diskPreview);
            }
        }
        // Exemple pour réaliser des tests de fonctionalités des classes dérivées de class Joueur
        Joueur joueur = new JoueurHumain(Color.YELLOW, new Board(jetons));



    }
}
