package org.menu;

import org.jeu.Jeu;
import org.joueur.Joueur;
import org.tableau.Tableau;
import java.util.Scanner;
public class Menu {

    static Scanner scan = new Scanner(System.in);
    static Tableau tableau;
    public static void menu() {
        Scanner input = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        System.out.println("[1] Jouer tout seul \n[2] Jouer à deux \n[3] Top Score \n[4] Quitter le jeu \n\nQue voulez vous faire ? : ");
        int choix = Integer.parseInt(input.next());

        if (choix == 1) {

            System.out.println("\nJoueur 1 : Quel pseudo voulez-vous ?");
            String J1 = scan.next();

        } else if (choix == 2) {
            System.out.println("Placer la partie avec les deux joueurs");
            System.out.println("\nJoueur 1 : Quel pseudo voulez-vous ?");
            String J1 = scan.next();
            System.out.println("Joueur 2 : Quel pseudo voulez-vous ?");
            String J2 = scan.next();
            new Joueur(J1, 12);
            new Joueur(J2, 6);
            Jeu.Jeu();

        } else if (choix == 3) {
            System.out.println("Afficher la page de top Score");
        } else if (choix == 4) {
            System.out.println("Merci d'avoir joué à notre jeu, au plaisir de vous revoir");
            System.exit(0);
        }
        else if(choix == 5){
            System.out.println("votre nom :");
            String prenom = nom.next();

        }
    }
}