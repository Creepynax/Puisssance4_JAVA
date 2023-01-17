package org.ia;

import org.jeu.Jeu;
import org.joueur.Joueur;

public class IA extends Joueur {

    public IA(int couleur) {
        super("Jarvis", couleur);
    }

    public void joue(Jeu jeu) {
        for (int col = 0; col < jeu.getTaille(); col++) {
            if (jeu.joueCoup(col, this.getCouleur())) {
                System.out.println(this.getNom() + " a joué en " + (col + 1));
                return;
            }
        }
    }
}