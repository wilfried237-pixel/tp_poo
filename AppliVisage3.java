package src;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * AppliVisage3.java
 *
 *
 * @author Philippe Genoud
 * @version
 */
public class AppliVisage3 {

    public static void main(String[] args) {

        JFrame laFenetre = new JFrame("VISAGE ANIME");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(512, 512);

        Dessin d = new Dessin();
        laFenetre.add(d);

        laFenetre.setVisible(true);

        // creation d'un objet VisageRond
        VisageRond v1 = null; // = new VisageRond();
        VisageRond v2 = new VisageRond(d.getLargeur() / 2, d.getHauteur() / 2);
        v2.setDy(-5);

        // on rajoute cet objet la zÃ´ne de dessin
        d.ajouterObjet(v1);
        d.ajouterObjet(v2);

        // la boucle d'animation
        while (true) {

            // les visage effectuent un dÃ©placement Ã©lÃ©mentaire
            v1.deplacerAvecRebond();
            v2.deplacerAvecRebond();

            // la zone de dessin se rÃ©affiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(50);

        }

    }

} // AppliVisage1

