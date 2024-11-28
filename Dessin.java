package src;

/**
 * Dessin.java
 */
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Defini le contenu de la fenÃªtre de l'application d'animation des VisageRond.
 * Une zone de dessin est un JPanel qui gÃ¨re un liste d'objets VisageRond.
 * Lorsqu'il se rÃ©affiche l'objet Dessin redessinne les diffÃ©rents objets
 * VisageRond contenu dans cette liste.
 *
 * @author Philippe Genoud
 */
public class Dessin extends JPanel {

    /**
     * stocke la liste des VisageRond ayant Ã©tÃ© ajoutÃ©s Ã  cette zone de dessin.
     */
    private final List<VisageRond> listeDesVisageRond = new ArrayList<>();

    /**
     * retourne la largeur de la zone de dessin.
     *
     * @return la largeur.
     */
    public int getLargeur() {
        return getWidth();
    }

    /**
     * retourne la hauteur de la zone de dessin.
     *
     * @return la hauteur.
     */
    public int getHauteur() {
        return getHeight();
    }


    public void ajouterObjet(VisageRond v) {

        if (!listeDesVisageRond.contains(v)) {
            // l'objet n'est pas dÃ©jÃ  dans la liste
            // on le rajoute a la liste des objets du dessin
            listeDesVisageRond.add(v);
            v.setDessin(this);
            // le dessin se rÃ©affiche
            repaint();
        }
    }

    /**
     * temporisation de l'animation.
     *
     * @param duree delai de temporisation en ms.
     */
    public void pause(int duree) {
        try {
            Thread.sleep(duree);
        } catch (Exception e) {
        }
    }

    /**
     * affiche la zone de dessin et son contenu
     *
     * @param g le contexte graphique
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerLesVisageRond(g);
    }

    /**
     * Parcourt la liste des VisageRond pour afficher chacun d'eux.
     *
     * @param g le contexte graphique
     */
    private void dessinerLesVisageRond(Graphics g) {
        Iterator<VisageRond> lesObjets = listeDesVisageRond.iterator();

        while (lesObjets.hasNext()) {
            VisageRond objCour = lesObjets.next();
            objCour.dessiner(g);
        }
    }

} // Dessin
