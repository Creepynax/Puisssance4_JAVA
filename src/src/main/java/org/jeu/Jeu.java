package org.jeu;

import java.util.Scanner;
import org.joueur.Joueur;


public class Jeu {

    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
    public static void Jeu(Joueur Joueur1, Joueur Joueur2){
        Scanner in = new Scanner(System.in);

        String[][] grid = new String[6][7];

        //initialize array
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = " ";
            }
        }

        int turn = 1;

        String player1 = Joueur1.getNom();
        String color1 = Joueur1.getCouleur();
        String pion1 = color1 + "@" + WHITE_BRIGHT;

        String player2 = Joueur2.getNom();
        String color2 = Joueur2.getCouleur();
        String pion2 = color2 + "=" + WHITE_BRIGHT;

        String Joueur = player1;
        String color = pion1;
        boolean winner = false;

        //play a turn
        while (!winner && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print(Joueur + ", choisis une colonne: ");

                play = in.nextInt();

                //validate play
                validPlay = validate(play,grid);

            }while (!validPlay);


            //drop the checker
            for (int row = grid.length-1; row >= 0; row--){
                if(grid[row][play].equals(" ")){
                    grid[row][play] = color;
                    break;
                }
            }

            //determine if there is a winner
            winner = isWinner(color,grid);

            //switch players
            if (color.equals(pion1)){
                color = pion2;
                Joueur = player2;
            }else{
                color = pion1;
                Joueur = player1;
            }

            turn++;
        }
        display(grid);

        if (winner){

            if (color.equals(pion1)){
                System.out.println(player1 + " a gagné la partie !");
            }else{
                System.out.println(player2 + " a gangé la partie !");
            }
        }else{
            System.out.println("Égalité entre les deux joueurs");

        }

    }

    public static void display(String[][] grid){
        System.out.println(WHITE_BRIGHT + "     0     1     2     3     4     5     6");
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

    public static boolean validate(int column, String[][] grid){
        //valid column?
        if (column < 0 || column > grid[0].length){
            return false;
        }

        //full column?
        if (grid[0][column] != " "){
            return false;
        }

        return true;
    }

    public static boolean isWinner(String player, String[][] grid){
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