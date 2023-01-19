
package org.joueur;

public class Joueur {
    private String nom;
    private String couleur;
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN


    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

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
    private String determinerCouleur(int couleur) {
        if (couleur == 1) {
            return RED_BRIGHT;
        } else if (couleur == 2) {
            return GREEN_BRIGHT;
        } else if (couleur == 3) {
            return YELLOW_BRIGHT;
        } else if (couleur == 4) {
            return BLUE_BRIGHT;
        } else if (couleur == 5) {
            return PURPLE_BRIGHT;
        } else if (couleur == 6) {
            return CYAN_BRIGHT;
        }
        return "Veuillez choisir une couleur";
    }
}
