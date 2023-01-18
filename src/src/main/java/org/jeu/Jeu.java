package org.jeu;

import java.util.Scanner;
import org.joueur.Joueur;


public class Jeu {

    public static void Jeu(){
        Scanner in = new Scanner(System.in);

<<<<<<< HEAD
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
=======
        char[][] grid = new char[6][7];

        //initialize array
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = ' ';
>>>>>>> julien
            }
        }

        int turn = 1;
        char player = 'R';
        boolean winner = false;

        //play a turn
        while (winner == false && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print("Player " + player + ", choose a column: ");
                play = in.nextInt();

                //validate play
                validPlay = validate(play,grid);

            }while (validPlay == false);


            //drop the checker
            for (int row = grid.length-1; row >= 0; row--){
                if(grid[row][play] == ' '){
                    grid[row][play] = player;
                    break;
                }
            }

            //determine if there is a winner
            winner = isWinner(player,grid);

            //switch players
            if (player == 'R'){
                player = 'B';
            }else{
                player = 'R';
            }

            turn++;
        }
        display(grid);

        if (winner){
            if (player=='R'){
                System.out.println("Black won");
            }else{
                System.out.println("Red won");
            }
        }else{
            System.out.println("Tie game");
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
=======
    public static void display(char[][] grid){
        System.out.println("     0     1     2     3     4     5     6");
        System.out.println("  ___________________________________________");
        for (int row = 0; row < grid.length; row++){
            System.out.print("  |  ");
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col]);
                System.out.print("  |  ");
            }
            System.out.println();
            System.out.println("  -------------------------------------------");
        }
        System.out.println("     0     1     2     3     4     5     6");
        System.out.println();
    }

    public static boolean validate(int column, char[][] grid){
        //valid column?
        if (column < 0 || column > grid[0].length){
            return false;
        }

        //full column?
        if (grid[0][column] != ' '){
            return false;
        }

        return true;
    }

    public static boolean isWinner(char player, char[][] grid){
        //check for 4 across
        for(int row = 0; row<grid.length; row++){
            for (int col = 0;col < grid[0].length - 3;col++){
                if (grid[row][col] == player   &&
                        grid[row][col+1] == player &&
                        grid[row][col+2] == player &&
                        grid[row][col+3] == player){
                    return true;
                }
            }
        }
        //check for 4 up and down
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col] == player &&
                        grid[row+2][col] == player &&
                        grid[row+3][col] == player){
                    return true;
                }
            }
        }
        //check upward diagonal
        for(int row = 3; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row-1][col+1] == player &&
                        grid[row-2][col+2] == player &&
                        grid[row-3][col+3] == player){
                    return true;
                }
            }
        }
        //check downward diagonal
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col+1] == player &&
                        grid[row+2][col+2] == player &&
                        grid[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}