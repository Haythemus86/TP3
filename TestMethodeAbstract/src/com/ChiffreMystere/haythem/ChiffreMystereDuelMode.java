package com.ChiffreMystere.haythem;

import com.menu.haythem.MenuSelection;
import com.menu.haythem.SelectionJeux;

import java.util.InputMismatchException;
import java.util.Random;

public class ChiffreMystereDuelMode extends MenuSelection {

    private int chiffreMystereJoueur = 0 , chiffreMystereComputer = 0, propositionChiffreJoueur = 0, propositionChiffreComputer = 0 ;
    private int[] tableauNombreMystereJoueur, tableauChiffreMystereComputer, tableauPropositionChiffreJoueur, tableauPropositionChiffreComputer;


    public ChiffreMystereDuelMode() {
    }

    public void runChiffreMystereDuelMode(){



        while (!reponseIsGood){
            try
            {
                System.out.println("Entrez votre chiffre Mystere");
                chiffreMystereJoueur = sc.nextInt();
                reponseIsGood =  true;
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Merci de saisir des chiffres svp");
                reponseIsGood = false;
                sc.nextLine();
            }

        }
        reponseIsGood = false;

        tableauNombreMystereJoueur = decoupeNombreJoueur(chiffreMystereJoueur);
        System.out.println("Le chiffre mystere du  joueur est enregistré ");




        System.out.println("L'ordinateur sélectionne un chiffre Mystere");
        chiffreMystereComputer = generateNumber();
        tableauChiffreMystereComputer = decoupeNombreMystere(chiffreMystereComputer);
        System.out.println("Le chiffre mystere de l'ordinateur est enregistré ");

        propositionChiffreComputer = generateNumber();
        tableauPropositionChiffreComputer = decoupeNombreMystere(propositionChiffreComputer);

        System.out.println("Le joueur commence :");




        do {
            while ( !reponseIsGood) {

                System.out.println("Veuillez saisir un nombre");
                try {
                    propositionChiffreJoueur = sc.nextInt();
                    reponseIsGood = true;
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Merci de saisir des chiffres svp");
                    reponseIsGood = false;
                    sc.nextLine();
                }
            }
            reponseIsGood = false;
            tableauPropositionChiffreJoueur = decoupeNombreJoueur(propositionChiffreJoueur);

            compareTableauJoueurVsComputer(tableauPropositionChiffreJoueur, tableauChiffreMystereComputer, propositionChiffreJoueur);
            System.out.println();
            System.out.println("L'ordinateur réfléchi à une réponse ");
           compareTbaleauComputerVsJoueur(tableauPropositionChiffreComputer,tableauNombreMystereJoueur,propositionChiffreComputer);



        }while ((propositionChiffreJoueur != chiffreMystereComputer) && (! java.util.Arrays.equals(tableauPropositionChiffreComputer,tableauNombreMystereJoueur)));





        do {
            sc.nextLine();
            displayEndGameSelection();

            try
            {
                choixFinJeux = sc.nextInt();
            }catch (InputMismatchException e ){
                System.out.println("Merci de saisir des chiffres svp");
            }
        }while ( choixFinJeux < 1 || choixFinJeux > 3);


        selectedEndGame(choixFinJeux);
        sc.nextLine();


    }

    @Override
    public int[] decoupeNombreJoueur(int propositionChiffreJoueur) {
        String decoupe = ""+ propositionChiffreJoueur;

        tableauPropositionChiffreJoueur = new int[decoupe.length()];

        for ( int i = 0 ; i < decoupe.length(); i++){
            tableauPropositionChiffreJoueur[i] =Integer.parseInt(""+ decoupe.charAt(i));
        }

        return tableauPropositionChiffreJoueur;
    }

    @Override
    public int[] decoupeNombreMystere(int propositionChiffreComputer) {
        String decoupe = ""+propositionChiffreComputer;
        tableauPropositionChiffreComputer = new int[decoupe.length()];
        for (int i = 0 ; i < decoupe.length(); i++){
            tableauPropositionChiffreComputer[i] = Integer.parseInt(""+decoupe.charAt(i));
        }

        return tableauPropositionChiffreComputer;
    }

    public void compareTableauJoueurVsComputer (int[] tableauPropositionChiffreJoueur, int[] tableauChiffreMystereComputer, int propositionChiffreJoueur){

        System.out.print("Proposition Joueur : " + propositionChiffreJoueur + " Réponse : -> ");
        for ( int i = 0 ; i < tableauPropositionChiffreJoueur.length; i++){
            if ( tableauPropositionChiffreJoueur[i] < tableauChiffreMystereComputer[i]){
                System.out.print("+");
            }else if (tableauPropositionChiffreJoueur[i] > tableauChiffreMystereComputer[i] ){
                System.out.print("-");
            }else{
                System.out.print("=");
            }
        }
        System.out.println();



    }

    public void compareTbaleauComputerVsJoueur( int[] tableauPropositionChiffreComputer , int[] tableauNombreMystereJoueur , int propositionChiffreComputer){

        System.out.print("Proposition  Ordinateur : ");
        for ( int i = 0 ; i < tableauPropositionChiffreComputer.length; i++){
            System.out.print(tableauPropositionChiffreComputer[i]);

        }
        System.out.print(" Réponse : -> ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < tableauPropositionChiffreComputer.length; i++) {
                if (tableauPropositionChiffreComputer[i] < tableauNombreMystereJoueur[i]) {
                    System.out.print("+");
                    tableauPropositionChiffreComputer[i] += 1;
                } else if (tableauPropositionChiffreComputer[i] > tableauNombreMystereJoueur[i]) {
                    System.out.print("-");
                    tableauPropositionChiffreComputer[i] -= 1;
                } else {
                    System.out.print("=");
                }
            }

            System.out.println();






        System.out.println();


    }



    public void selectedEndGame(int choixFinJeux){
        switch (choixFinJeux){
            case 1 :
            {
                this.runChiffreMystereDuelMode();
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
