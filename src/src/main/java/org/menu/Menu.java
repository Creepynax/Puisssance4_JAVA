package org.menu;

import org.ia.IA;
import org.jeu.Jeu;
import org.joueur.Joueur;

import java.util.Scanner;
public class Menu {
    public static void menu() {
        Scanner input = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        System.out.println("[1] Jouer tout seul \n[2] Jouer à deux \n[3] Top Score \n[4] Quitter le jeu \n\nQue voulez vous faire ? : ");
        int choix = Integer.parseInt(input.next());

        if (choix == 1) {
            System.out.println("Placer l'IA \n");

            Jeu jeu = new Jeu();

        } else if (choix == 2) {
            System.out.println("Placer la partie avec les deux joueurs");
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