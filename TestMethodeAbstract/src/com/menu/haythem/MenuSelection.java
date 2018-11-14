package com.menu.haythem;

import java.util.Random;
import java.util.Scanner;

public abstract class MenuSelection {

    public int choixJeux , choixModeJeux, choixFinJeux;
   public  Scanner sc = new Scanner(System.in);
    public int nombreMystere = 0 , nombreJoueur = 0 ;
    public int[] tableauNombreMystere, tableauNombreJoueur;
    public boolean reponseIsGood = false;

    public MenuSelection() {
        choixJeux = 0 ;
        choixModeJeux = 0 ;
        choixFinJeux = 0;
    }



    protected void displayGameSelection() {
        System.out.println("***************Menu De Selection*************************");
        System.out.println("*********                                        ********");
        System.out.println("*********                                        ********");
        System.out.println("*********   1_ Jeux Combinaison Mystère          ********");
        System.out.println("*********   2_ Jeux du MasterMind                ********");
        System.out.println("*********                                        ********");
        System.out.println("*********                                        ********");
        System.out.println("*********************************************************");
    }


    protected void diplayGameModeSelection() {
        System.out.println("***************MENU MODE DE JEUX*************************");
        System.out.println("*********                                ****************");
        System.out.println("********                           ****************");
        System.out.println("********     1_ Mode Challenger    ****************");
        System.out.println("********     2_ Mode Défenseur     ****************");
        System.out.println("********     3_ Mode Duel          ****************");
        System.out.println("********                           ****************");
        System.out.println("********                           ****************");
        System.out.println("***************************************************");


    }


    protected void displayEndGameSelection() {
        System.out.println("******************************************************");
        System.out.println("******************************************************");
        System.out.println("*********    1_  Recommencer la partie    ************");
        System.out.println("*********    2_ Retour à l'écran Titre    ************");
        System.out.println("*********    3_ Quitter l'application     ************");
        System.out.println("******************************************************");
        System.out.println("******************************************************");
    }





// Calcul et Comparaison

    public int generateNumber(){
        int min = 1000, max = 9999;
        Random rand = new Random();

        int nombreAleatoire = rand.nextInt( max - min + 1 ) + min ;

        return nombreAleatoire;
    }

    public int[] decoupeNombreMystere ( int nombreMystere){

        String decoupe = ""+ nombreMystere;

        tableauNombreMystere = new int[decoupe.length()];

        for ( int i = 0 ; i < tableauNombreMystere.length; i++){
            tableauNombreMystere[i] =Integer.parseInt(""+ decoupe.charAt(i));
        }

        return tableauNombreMystere;
    }

    public int[] decoupeNombreJoueur ( int nombreJoueur){

        String decoupe = ""+ nombreJoueur;

        tableauNombreJoueur = new int[decoupe.length()];

        for ( int i = 0 ; i < decoupe.length(); i++){
            tableauNombreJoueur[i] =Integer.parseInt(""+ decoupe.charAt(i));
        }

        return tableauNombreJoueur ;
    }


    public void parcourTableau(int[] tableauParcourir){
        for (int i = 0 ; i < tableauParcourir.length; i++){
            System.out.println("case" + i  + "contient "  +tableauParcourir[i]);
        }
    }

}
