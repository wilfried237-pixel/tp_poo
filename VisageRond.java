package src;

import java.awt.Color;
import java.awt.Graphics;

/**
 * <p>
 * Cette classe permet de modÃ©liser un visage de forme ovale.
 * </p>
 * <p>
 * Le repÃ¨re graphique est dÃ©fini avec son origine en haut Ã  gauche de la zÃ´ne
 * de dessin, l'axe des x horizontal et l'axe des y vertical vers le bas.
 * </p>
 * <p><img src='figurevisage.gif' alt='schema d'un visage'></p>
 * <p>Un visage est dÃ©fini par :</p>
 * <ul>
 * <li> les coordonnÃ©es xhg, yhg du coin supÃ©rieur gauche du rectangle
 * englobant,</li>
 * <li> une largeur et une hauteur,</li>
 * <li> un dÃ©placement Ã©lÃ©mentaire horizontal (dx) et un dÃ©placement Ã©lÃ©mentaire
 * vertical (dy).</li>
 * </ul>
 *
 *
 * @author Philippe Genoud
 *
 */
public class VisageRond {

    //---------------------------------------------------------
    // Les constantes de la classe VisageRond
    //---------------------------------------------------------
    /**
     * Largeur minimale pour un VisageRond.
     */
    public static final int LARGEUR_MIN = 15;

    /**
     * Hauteur minimale pour un VisageRond.
     */
    public static final int HAUTEUR_MIN = 15;

    //-------------------------------------------------------------
    // Les attributs (variables d'instance) de la classe VisageRond
    //-------------------------------------------------------------
    /**
     * La zÃ´ne de dessin dans laquelle se trouve le VisageRond.
     */
    private Dessin d;

    /**
     * abscisse coin supÃ©rieur gauche du rectangle englobant le visage.
     */
    private int xhg = 0;

    /**
     * ordonnÃ©e coin supÃ©rieur gauche du rectangle englobant le visage.
     */
    private int yhg = 0;

    /**
     * largeur du visage. Par dÃ©faut 50 pixels.
     */
    private int largeur = 100;

    /**
     * hauteur du visage. Par dÃ©faut 50 pixels.
     */
    private int hauteur = 100;

    /**
     * dÃ©placement Ã©lÃ©mentaire horizontal du visage. Par dÃ©faut 5 pixels.
     */
    private int dx = 5;

    /**
     * deplacement Ã©lÃ©mentaire vertical du visage. Par dÃ©faut 5 pixels.
     */
    private int dy = 5;

    //---------------------------------------------------------
    // Les constructeurs de la classe VisageRond
    //---------------------------------------------------------
    /**
     * Constructeur avec valeurs par dÃ©faut. CrÃ©e un visage de taille 50x50 dont
     * le coin supÃ©rieur gauche du rectangle englobant est situÃ© au point (0,0)
     * de la zÃ´ne de dessin. Ce visage est Ã©galement dotÃ© d'un dÃ©placement
     * Ã©lÃ©mentaire horizontal et vertical de +5 pixels.
     */
    public VisageRond() {
    }

    /**
     * Constructeur avec positionnement du visage. CrÃ©e un visage de taille
     * 50x50 mais dont la position du coin supÃ©rieur gauche du rectangle
     * englobant est fixÃ©e Ã  la crÃ©ation. Ce visage est dotÃ© d'un dÃ©placement
     * Ã©lÃ©mentaire horizontal et vertical de +5 pixels.
     *
     * @param xg abscisse du coin supÃ©rieur gauche du rectangle englobant.
     * @param yg ordonnÃ©e du coin supÃ©rieur gauche du rectangle englobant.
     */
    public VisageRond(int xg, int yg) {
        this.d = d;
        xhg = xg;
        yhg = yg;

    }

    /**
     * Constructeur avec positionnement du visage et dÃ©finition de sa taille.
     * CrÃ©e un visage dont les diemensions et la position du coin supÃ©rieur
     * gauche du rectangle englobant sont fixÃ©es Ã  la crÃ©ation. Ce visage est
     * dotÃ© d'un dÃ©placement Ã©lÃ©mentaire horizontal et vertical de +5 pixels.
     *
     * @param xg abscisse du coin supÃ©rieur gauche du rectangle englobant.
     * @param yg abscisse du coin supÃ©rieur gauche du rectangle englobant.
     * @param larg largeur du visage. La largeur doit Ãªtre supÃ©rieure Ã
     * LARGEUR_MIN
     * @param haut hauteur du visage. La hauteur doit Ãªtre supÃ©rieure Ã
     * HAUTEUR_MIN
     *
     * @see VisageRond#LARGEUR_MIN
     * @see VisageRond#HAUTEUR_MIN
     */
    public VisageRond(int xg, int yg, int larg, int haut) {
        xhg = xg;
        yhg = yg;

        largeur = Math.max(larg, LARGEUR_MIN);
        hauteur = Math.max(haut, HAUTEUR_MIN);
    }

    /**
     * Donne la valeur du dÃ©placement Ã©lÃ©mentaire horizontal.
     *
     * @return valeur de dx, dÃ©placement Ã©lÃ©mentaire horizontal.
     */
    public int getDx() {
        return dx;
    }

    /**
     * Fixe dÃ©placement Ã©lÃ©mentaire horizontal.
     *
     * @param v Valeur Ã  affecter Ã  dx, dÃ©placement Ã©lÃ©mentaire horizontal.
     */
    public void setDx(int v) {
        this.dx = v;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int v) {
        this.dy = v;
    }

    /**
     * Inverse sens du dÃ©placement horizontal.
     */
    public void inverserDx() {
        dx = -dx;
    }

    /**
     * Inverse sens du dÃ©placement vertical.
     */
    public void inverserDy() {
        dy = -dy;
    }

    /**
     * Inverse sens des dÃ©placements horizontal et vertical.
     */
    public void inverserDxEtDy() {
        dx = -dx;
        dy = -dy;
    }

    /**
     * Fait effectuer au visage un dÃ©placement Ã©lementaire. La position du coin
     * supÃ©rieur gauche du visage est modifiÃ©e en lui ajoutant le dÃ©placement
     * Ã©lÃ©mentaire dÃ©fini par dx et dy.
     */
    public void deplacer() {
        xhg += dx;
        yhg += dy;
    }

    /**
     * Fait effectuer au visage un dÃ©placement Ã©lementaire. La position du coin
     * supÃ©rieur gauche du visage est modifiÃ©e en lui ajoutant le dÃ©placement
     * Ã©lÃ©mentaire dÃ©fini par dx et dy. Si le visage dÃ©passe de l'un des bords
     * de la zone de dessin il inverse sa direction de dÃ©placement.
     */
    public void deplacerAvecRebond() {
        if (bordGaucheAtteint() || bordDroitAtteint()) {
            inverserDx();
        }
        if (bordHautAtteint() || bordBasAtteint()) {
            inverserDy();
        }
        xhg += dx;
        yhg += dy;
    }

    /**
     * Evalue si le visage atteint le bord gauche de la zÃ´ne de dessin.
     *
     * @return <code>true</code> si le rectangle englobant le visage intersecte
     * le cotÃ© gauche de la zÃ´ne de dessin, <code>
     *         false</code> sinon.
     */
    public boolean bordGaucheAtteint() {
        return (xhg < 0);
    }

    /**
     * Evalue si le visage atteint le bord droit de la zÃ´ne de dessin.
     *
     * @return <code>true</code> si le rectangle englobant le visage intersecte
     * le cotÃ© droit de la zÃ´ne de dessin, <code>
     *         false</code> sinon.
     */
    public boolean bordDroitAtteint() {
        return ((xhg + largeur) > d.getLargeur());
    }

    /**
     * Evalue si le visage atteint le bord haut de la zÃ´ne de dessin.
     *
     * @return <code>true</code> si le rectangle englobant le visage intersecte
     * le cotÃ© haut de la zÃ´ne de dessin, <code>
     *         false</code> sinon.
     */
    public boolean bordHautAtteint() {
        return (yhg < 0);
    }

    /**
     * Evalue si le visage atteint le bord bas de la zÃ´ne de dessin.
     *
     * @return <code>true</code> si le rectangle englobant le visage intersecte
     * le cotÃ© bas de la zÃ´ne de dessin, <code>
     *         false</code> sinon.
     */
    public boolean bordBasAtteint() {
        return ((yhg + hauteur) >= d.getHauteur());
    }

    /**
     * Evalue si le visage atteint l'un des bords de la zÃ´ne de dessin.
     *
     * @return <code>true</code> si le rectangle englobant le visage intersecte
     * l'un des cotÃ©s de la zÃ´ne de dessin, <code>
     *         false</code> sinon.
     */
    public boolean bordAtteint() {
        return bordDroitAtteint() || bordGaucheAtteint() || bordHautAtteint()
                || bordBasAtteint();
    }

    /**
     * fixe la zÃ´ne de dessin dans laquelle le visage est affichÃ©.
     *
     * @param d rÃ©fÃ©rence de la^zÃ´ne de dessin associÃ©e au Visage
     *
     * @see Dessin
     */
    public void setDessin(Dessin d) {
        this.d = d;
    }

    /**
     * affiche le visage.
     *
     * @param g le contexte graphique de la zÃ´ne de dessin en charge de
     * l'affichage.
     *
     * @see java.awt.Graphics
     */
    public void dessiner(Graphics g) {
        // dessiner le contour du visage
        g.setColor(Color.PINK);
        g.fillOval(xhg, yhg, largeur, hauteur);
        g.setColor(Color.BLACK);
        g.drawOval(xhg, yhg, largeur, hauteur);

        // dessiner la bouche
        g.drawLine(xhg + largeur / 4, yhg + (2 * hauteur) / 3, xhg + (3 * largeur) / 4, yhg + (2 * hauteur) / 3);

        // dessiner les yeux
        int largeurOeil = largeur / 5;
        int hauteurOeil = hauteur / 5;

        g.drawOval(xhg
                + largeurOeil, yhg + hauteurOeil, largeurOeil, hauteurOeil);
        g.drawOval(xhg
                + 3 * largeurOeil, yhg + hauteurOeil, largeurOeil, hauteurOeil);

    }

} // VisageRond

