package src;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * Animation d'un visage dans une fenÃªtre graphique.
 * Un visage est dessinÃ© Ã  l'intÃ©rieur d'une fenÃªtre et se dÃ©place. Chaque fois
 * que l'un des bords est atteint, le visage change de direction.
 * @author Philippe Genoud
 * @version
 */

public class AppliVisage1  {

    public static void main(String[] args) {

        // la fenÃªtre graphique
        JFrame laFenetre = new JFrame("VISAGE ANIME");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(512,512);

        // crÃ©Ã© la zone de dessin et la place dans la fenÃªtre
        Dessin d = new Dessin();
        laFenetre.add(d);

        //  affiche la fenÃªtre
        laFenetre.setVisible(true);

        // creation d'un objet VisageRond
        VisageRond  v1 = new VisageRond();

        // on rajoute cet objet la zÃ´ne de dessin
        d.ajouterObjet(v1);



        // la boucle d'animation
        // c'est une boucle infinie, le programme devra Ãªtre interrompu
        // par CTRL-C ou en cliquant dans la case de fermeture de la fenÃªtre
        while (true) {
            // le visage a atteint un des bords, il change de direction
            if (v1.bordAtteint())
                v1.inverserDxEtDy();

            // le visage effectue un dÃ©placement Ã©lÃ©mentaire
            v1.deplacer();

            // la zone de dessin se rÃ©affiche
            d.repaint(50);

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(30);

        }
    }

} // AppliVisage1

