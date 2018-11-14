package com.ChiffreMystere.haythem;

import com.menu.haythem.MenuSelection;
import com.menu.haythem.SelectionJeux;

import java.util.InputMismatchException;
import java.util.Random;

public class ChiffreMystereDefenseurMode extends MenuSelection {

    private int nombreMystereJoueur =0 , computerNumber = 0, choixFinJeux = 0 ;
    private int[] tableauNombreMystereJoueur, tableauComputerNumber;
    private boolean bonneReponse = false;
    public ChiffreMystereDefenseurMode() {
    }

    public void runChiffreMystereDefenseurMode() {


        while (!bonneReponse) {
            System.out.println("Entre un nombre mystère que l'ordinateur doit trouver");
            try {
                nombreMystereJoueur = sc.nextInt();
                bonneReponse = true;
            } catch (InputMismatchException e) {
                System.out.println("Merci de saisir des chiffres svp");
                bonneReponse = false;
                sc.nextLine();
            }

        }
        bonneReponse = false;

        tableauNombreMystereJoueur = decoupeNombreJoueur(nombreMystereJoueur);

        computerNumber = generateNumber();
        decoupeNombreMystere(computerNumber);
        tableauComputerNumber = decoupeNombreMystere(computerNumber);
        System.out.println("l ordinateur a entrer le chiffre " + computerNumber);

        compareTbaleau(tableauComputerNumber, tableauNombreMystereJoueur, computerNumber);



        do {
            sc.nextLine();
            displayEndGameSelection();

        try {
            choixFinJeux = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Merci de saisir des chiffres svp");
        }

    }while ( choixFinJeux < 1 || choixFinJeux > 3);
        selectedEndGame(choixFinJeux);
        sc.nextLine();
    }

    /*

    public int[] decoupeComputerNumber(int computerNumber){

        String decoupe = "" + computerNumber;
        tableauComputerNumber = new int[decoupe.length()];

        for ( int i = 0 ; i < decoupe.length() ; i++){
            tableauComputerNumber[i] = Integer.parseInt(""+ decoupe.charAt(i));
        }
        return tableauComputerNumber;

    }

    */

    /*
    private int generateNumber(){
        int min = 1000, max = 9999;
        Random rand = new Random();

        int nombreAleatoire = rand.nextInt( max - min + 1 ) + min ;

        return nombreAleatoire;
    }
    */


    /*
    public int[] decoupeNombreMystereJoueur(int nombreMystereJoeur){

        String decoupe = "" + nombreMystereJoeur;
        tableauNombreMystereJoueur = new int[decoupe.length()];
        for ( int i = 0 ; i < decoupe.length(); i++){
            tableauNombreMystereJoueur[i] = Integer.parseInt(""+ decoupe.charAt(i));
        }
        return tableauNombreMystereJoueur;

    }

    */

    public void compareTbaleau( int[] tableauComputerNumber , int[] tableauNombreMystereJoueur , int computerNumber){

        System.out.print("Proposition : " + computerNumber + "-> Réponse : " );

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < tableauComputerNumber.length; i++) {
                if (tableauComputerNumber[i] < tableauNombreMystereJoueur[i]) {
                    System.out.print("+");
                    tableauComputerNumber[i] += 1;
                } else if (tableauComputerNumber[i] > tableauNombreMystereJoueur[i]) {
                    System.out.print("-");
                    tableauComputerNumber[i] -= 1;
                } else {
                    System.out.print("=");
                }
            }

            System.out.println();


            System.out.print("Proposition : ");
            for (int i = 0; i < tableauComputerNumber.length; i++) {
                System.out.print(tableauComputerNumber[i]);
            }
            System.out.print("  Réponse  ->  : ");

        }while (! java.util.Arrays.equals(tableauComputerNumber, tableauNombreMystereJoueur) );

        System.out.println();
        System.out.println("L'ordinateur a trouver la réponse ! ");


    }




    public void selectedEndGame(int choixFinJeux){
        switch (choixFinJeux){
            case 1 :
            {
                this.runChiffreMystereDefenseurMode();
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
