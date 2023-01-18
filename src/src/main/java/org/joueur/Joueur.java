
package org.joueur;

import org.jeu.Jeu;

public class Joueur{

    public static String nom;
    private int couleur;

    public Joueur(String nom, int couleur) {
        //constructor
        this.nom = nom;
        this.couleur = couleur;
    }

    public static char nom() {
        return 0;
    }

    public String getNom() {
        return nom;
    }
    public int getCouleur() {
        return couleur;
    }


    /**
     * Cette méthode joue un coup avec le tableau reçu en paramètre.
     * La méthode est vide car les sous-classes doivent l'implémenter.
     * (Vous verrez prochainement comment gérer ce genre de cas plus proprement)
     * @param jeu Le Jeu avec lequel jouer.
     */

}