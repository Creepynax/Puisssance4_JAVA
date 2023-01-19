
package org.joueur;

public class Joueur {
    private String nom;
    private String couleur;

    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    public Joueur(String nom, int couleur) {
        //constructor
        this.nom = nom;

        this.couleur = determinerCouleur(couleur);
    }

    public String getNom() {
        return nom;
    }

    public String getCouleur() {
        return couleur;
    }
    public String determinerCouleur(int couleur) {
        if (couleur == 1) {
            return RED_BACKGROUND_BRIGHT;
        } else if (couleur == 2) {
            return GREEN_BACKGROUND_BRIGHT;
        } else if (couleur == 3) {
            return YELLOW_BACKGROUND_BRIGHT;
        } else if (couleur == 4) {
            return BLUE_BACKGROUND_BRIGHT;
        } else if (couleur == 5) {
            return PURPLE_BACKGROUND_BRIGHT;
        } else if (couleur == 6) {

            return CYAN_BACKGROUND_BRIGHT;
        } else if (couleur == 7) {
        return WHITE_BACKGROUND_BRIGHT;
    }
        return "Veuillez choisir une couleur";
    }
}
