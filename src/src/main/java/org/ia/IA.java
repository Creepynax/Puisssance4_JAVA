package org.ia;

import org.jeu.Jeu;
import org.joueur.Joueur;
import java.util.Random;

public class IA extends Joueur {

    public IA(int couleur) {
        super("Jarvis", couleur);
    }

    public void joue(Jeu jeu) {
        int randomNum = rand.nextInt(100) + 1;

        boolean randomBoolean = rand.nextBoolean();

    }
}