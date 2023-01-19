package org.ia;

import java.util.Random;
import java.util.ArrayList;
import org.joueur.Joueur;

public class IA extends Joueur {
    private static Random rand;
    public IA() {
        super("Jarvis", 7);
        rand = new Random();

    }
    public static int chooseMove(String[][] grid) {
        // Liste des colonnes disponibles (non pleines)
        ArrayList<Integer> availableColumns = new ArrayList<Integer>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = grid.length-1; i >= 0; i--) {
                if (grid[i][j].equals(" ")) {
                    availableColumns.add(j);
                    break;
                }
            }
        }
        if (availableColumns.size() == 0) {
            throw new IllegalStateException("Pas de colonne disponible pour jouer");
        }
        // Sélection aléatoire d'une colonne disponible
        int randomIndex = rand.nextInt(availableColumns.size());
        int randomColumn = availableColumns.get(randomIndex);

        return randomColumn;
    }

}







