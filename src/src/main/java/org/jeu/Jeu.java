package org.jeu;

import org.joueur.Joueur;

class Partie{

    private Joueur[] joueurs = new Joueur[2];
    private Jeu jeu;

    public Partie(Joueur joueur1, Joueur joueur2) {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        jeu = new Jeu();
    }

    public void joue() {
        int vainqueur = -1;
        int cJoueur = 0;

        while (vainqueur==-1) {
            joueurs[cJoueur].joue(jeu);
            if (jeu.estPlein()) {
                vainqueur = -1;
            }

            // Si 4 pions sont alignés, on a un vainqueur
            // (même si le jeu est plein!)

            if (jeu.cherche4()) {
                vainqueur = cJoueur;
            }

            // On change de joueur pour l'itération suivante
            cJoueur++;
            cJoueur %= 2;
        }

        System.out.println("La partie est finie.");
        jeu.toString();
        if (vainqueur == -1) {
            System.out.println("Match nul.");
        } else {
            System.out.println("Le vainqueur est " + joueurs[vainqueur].getNom());
        }
    }
}

public class Jeu {

    public final static int VIDE = 0;
    public final static int BLEU = 1;
    public final static int ROUGE = 2;

    private int ligne = 6;
    private int colonne = 7;
    private int[][] grille;   // 0 = vide, 1 = joueur bleu, 2 = joueur rouge

    public Jeu() {
        initJeu();
    }

    private void initJeu() {
        grille = new int[colonne][ligne];
        for (int col = 0; col < colonne ; col++) {
            for (int row = 0; row < ligne; row++) {
                grille[col][row] = VIDE;
            }
        }
    }

    public boolean joueCoup(int col, int joueur) {
        if ((col < 0) || (col >= colonne)) {
            return false;
        }

        // Trouve la première place vide dans la colonne
        for (int row = 0; row < ligne; row++) {
            if (grille[col][row] == VIDE) {
                grille[col][row] = joueur;
                return true;
            }
        }

        // La colonne est pleine
        return false;
    }

    /**
     * Cette méthode vérifie toutes les lignes, colonnes et diagonales pour une série de 4 pions
     * de la même couleur. Si une telle série existe, retourne true.
     *
     * Notez qu'il n'est pas nécessaire de retourner la couleur des 4 pions alignés,
     * puisqu'il s'agit de celle de celui qui vient de jouer.
     * @return true si le jeu contient 4 pions alignés
     */
    public boolean cherche4() {
        // Vérifie les horizontales ( - )
        for (int row = 0; row < ligne; row++) {
            if (cherche4alignes(0, row, 1, 0)) {
                return true;
            }
        }

        // Vérifie les verticales ( ¦ )
        for (int col = 0; col < colonne; col++) {
            if (cherche4alignes(col, 0, 0, 1)) {
                return true;
            }
        }

        // Diagonales (cherche depuis la ligne du bas)
        for (int col = 0; col < colonne; col++) {
            // Première diagonale ( / )
            if (cherche4alignes(col, 0, 1, 1)) {
                return true;
            }
            // Deuxième diagonale ( \ )
            if (cherche4alignes(col, 0, -1, 1)) {
                return true;
            }
        }

        // Diagonales (cherche depuis les colonnes gauches et droites)
        for (int row = 0; row < ligne; row++) {
            // Première diagonale ( / )
            if (cherche4alignes(0, row, 1, 1)) {
                return true;
            }
            // Deuxième diagonale ( \ )
            if (cherche4alignes(colonne - 1, ligne, -1, 1)) {
                return true;
            }
        }

        // On n'a rien trouvé
        return false;
    }

    /**
     * Cette méthode cherche 4 pions alignés sur une ligne. Cette ligne est définie par
     * le point de départ, ou origine de coordonnées (oCol,oLigne), et par le déplacement
     * delta (dCol,dLigne). En utilisant des valeurs appropriées pour dCol et dLigne
     * on peut vérifier toutes les directions:
     * - horizontale:    dCol = 0, dLigne = 1
     * - vérticale:      dCol = 1, dLigne = 0
     * - 1ère diagonale: dCol = 1, dLigne = 1
     * - 2ème diagonale: dCol = 1, dLigne = -1
     *
     * @param oCol   Colonne d'origine de la recherche
     * @param oRow Ligne d'origine de la recherche
     * @param dCol   Delta de déplacement sur une colonne
     * @param dRow Delta de déplacement sur une ligne
     * @return true si on trouve un alignement
     */
    private boolean cherche4alignes(int oCol, int oRow, int dCol, int dRow) {
        int couleur = VIDE;
        int compteur = 0;

        int curCol = oCol;
        int curRow = oRow;

        while ((curCol >= 0) && (curCol < colonne) && (curRow >= 0) && (curRow < ligne)) {
            if (grille[curRow][curCol] != couleur) {
                // Si la couleur change, on réinitialise le compteur
                couleur = grille[curRow][curCol];
                compteur = 1;
            } else {
                // Sinon on l'incrémente
                compteur++;
            }

            // On sort lorsque le compteur atteint 4
            if ((couleur != VIDE) && (compteur == 4)) {
                return true;
            }

            // On passe à l'itération suivante
            curCol += dCol;
            curRow += dRow;
        }

        // Aucun alignement n'a été trouvé
        return false;
    }

    /**
     * Vérifie s'il est encore possible de placer des pions
     * @return true si le tableau est plein
     */
    public boolean estPlein() {
        // On cherche une case vide. S'il n'y en a aucune, le tableau est plein
        for (int col = 0; col < colonne; col++) {
            for (int row = 0; row < ligne; row++) {
                if (grille[col][row] == VIDE) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getTaille() {
        return grille.length;
    }

}

