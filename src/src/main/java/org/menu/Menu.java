package org.menu;

import org.jeu.Jeu;
import org.joueur.Joueur;
import org.tableau.Tableau;
import java.util.Scanner;
import org.score.Score;
public class Menu {

    static Scanner scan = new Scanner(System.in);
    static Tableau tableau;
    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Jouer tout seul \n[2] Jouer à deux \n[3] Top Score \n[4] Quitter le jeu \n\nQue voulez vous faire ? : ");
        int choix = Integer.parseInt(input.next());

        if (choix == 1) {
            System.out.println("\nJoueur 1 : Quel pseudo voulez-vous ?");
            String J1 = scan.next();


        } else if (choix == 2) {
            System.out.println("\nJoueur 1 : Quel pseudo voulez-vous ?");
            String J1 = scan.next();
            System.out.println("Joueur 2 : Quel pseudo voulez-vous ?");
            String J2 = scan.next();


            new Joueur(J1, 12);
            new Joueur(J2, 6);
            Jeu.Jeu();

        } else if (choix == 3) {
            System.out.println("Afficher la page de top Score");

            Score score1 = new Score("Player 1", 100, "2023-19-01");
            Score score2 = new Score("Player 2", 200, "2023-19-01");
            System.out.println(score1.compareTo(score2));
// This will print -1 because score1 is less than score2
        } else if (choix == 4) {
            System.out.println("Merci d'avoir joué à notre jeu, au plaisir de vous revoir");
            System.exit(0);
        }
    }
}