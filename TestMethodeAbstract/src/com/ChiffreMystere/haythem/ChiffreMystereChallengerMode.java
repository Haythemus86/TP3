package com.ChiffreMystere.haythem;

import com.menu.haythem.SelectionJeux;
import com.menu.haythem.MenuSelection;

import java.util.InputMismatchException;
import java.util.Random;

public class ChiffreMystereChallengerMode extends MenuSelection {

    private int nombreMystere = 0 , nombreJoueur = 0 , compteur = 0 ;
    private int[] tableauNombreMystere, tableauNombreJoueur;
    private boolean bonneReponse = false ;

    public ChiffreMystereChallengerMode() {


    }

    public void runChiffreMystereChallengerMode() {

        nombreMystere = generateNumber();

        //Test
        System.out.println("le nombre Mystere est " + nombreMystere);
        System.out.println();
        //Test

        tableauNombreMystere = decoupeNombreMystere(nombreMystere);

        do {

            while (!bonneReponse) {
                System.out.println("Devinez la combinaion Mystère");
                try {
                    nombreJoueur = sc.nextInt();
                    compteur++;
                    bonneReponse = true;
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Merci de saisir des chiffres");
                    bonneReponse = false;
                    sc.nextLine();
                }
            }
            bonneReponse = false;

            tableauNombreJoueur = decoupeNombreJoueur(nombreJoueur);
            compareTableau(tableauNombreMystere, tableauNombreJoueur, nombreJoueur);
        } while (nombreMystere != nombreJoueur && compteur != 3);

        if (nombreMystere == nombreJoueur) {
            System.out.println("Bravo vous avez gagner ");
        } else {
            System.out.println("Désolé vous avez perdu, la réponse était " + nombreMystere);
        }

        System.out.println();


        displayEndGameSelection();
        do {


        try {
            choixFinJeux = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Merci de saisir des chiffres");
            System.out.println();
            sc.nextLine();
        }
            displayEndGameSelection();


    }while ( choixFinJeux < 1 || choixFinJeux > 3);

        selectedEndGame(choixFinJeux);
    }

/*
    private int generateNumber(){
        int min = 1000, max = 9999;
        Random rand = new Random();

        int nombreAleatoire = rand.nextInt( max - min + 1 ) + min ;

        return nombreAleatoire;
    }
*/

/*
    public int[] decoupeNombreMystere ( int nombreMystere){

        String decoupe = ""+ nombreMystere;

        tableauNombreMystere = new int[decoupe.length()];

        for ( int i = 0 ; i < tableauNombreMystere.length; i++){
            tableauNombreMystere[i] =Integer.parseInt(""+ decoupe.charAt(i));
        }

        return tableauNombreMystere;
    }
*/

/*
    public int[] decoupeNombreJoueur ( int nombreJoueur){

        String decoupe = ""+ nombreJoueur;

        tableauNombreJoueur = new int[decoupe.length()];

        for ( int i = 0 ; i < decoupe.length(); i++){
            tableauNombreJoueur[i] =Integer.parseInt(""+ decoupe.charAt(i));
        }

        return tableauNombreJoueur ;
    }
*/

    public void compareTableau (int[] tableauNombreMystere, int[] tableauNombreJoueur, int nombreJoueur){


        System.out.print("Proposition : " + nombreJoueur +" -> Réponse : ");
        for ( int i = 0 ; i < tableauNombreMystere.length; i++){
            if (tableauNombreJoueur[i] < tableauNombreMystere[i]){
                System.out.print("+");
            }else if (tableauNombreJoueur[i] > tableauNombreMystere[i]){
                System.out.print("-");
            }else {
                System.out.print("=");
            }

        }

        System.out.println();
    }


    public void selectedEndGame(int choixFinJeux){
        switch (choixFinJeux){
            case 1 :
            {
                this.runChiffreMystereChallengerMode();
                break;
            }
            case 2 :
            {
                SelectionJeux selectionJeux = new SelectionJeux();
                selectionJeux.runSelectionJeux();
                break;
            }
            case 3 :
            {
                System.exit(0);
                break;
            }
            default :
            {
                System.out.println("choix non valide merci de faire un choix valide");
                break;
            }
        }
    }


}
