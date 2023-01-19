
package org.joueur;

import org.jeu.Jeu;

import java.util.Scanner;

public class Joueur{

    public static String nom;
    private int couleur;

    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    public Joueur(String nom, int couleur) {
        //constructor
        this.nom = nom;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }
    public int getCouleur() {
        Scanner input = new Scanner(System.in);
        System.out.println("Que voulez vous faire ? : " +
                "\n[1] Jouer en ROUGE " +
                "\n[2] Jouer en VERT " +
                "\n[3] Jouer en JAUNE " +
                "\n[4] Jouer en BLEU " +
                "\n[5] Jouer en VIOLET " +
                "\n[6] Jouer en CYAN " +
                "\n[7] Jouer en BLANC ");

        int choix = Integer.parseInt(input.next());

        if (choix == 1){
            System.out.println(RED);
        }else if (choix == 2){
            System.out.println(GREEN);
        }else if (choix == 3){
            System.out.println(YELLOW);
        }else if (choix == 4){
            System.out.println(BLUE);
        }else if (choix == 5){
            System.out.println(PURPLE);
        }else if (choix == 6){
            System.out.println(CYAN);
        }else if (choix == 7){
            System.out.println(WHITE);
        }
        return couleur;
    }


    /**
     * Cette méthode joue un coup avec le tableau reçu en paramètre.
     * La méthode est vide car les sous-classes doivent l'implémenter.
     * (Vous verrez prochainement comment gérer ce genre de cas plus proprement)
     * @param jeu Le Jeu avec lequel jouer.
     */

}
