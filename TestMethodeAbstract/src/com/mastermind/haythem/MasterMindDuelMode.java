package com.mastermind.haythem;

import com.menu.haythem.MenuSelection;
import com.menu.haythem.SelectionJeux;

import java.util.InputMismatchException;

public class MasterMindDuelMode extends MenuSelection {

    private int chiffreMystereJoueur =0;
    private int[] tabChiffreMystereJoueur;
    private int chiffreMystereComputer;
    private int[] tabChiffreMystereComputer;
    private int propositionChiffreMystereComputer;
    private int[] tabPropositionChiffreMystereComputer;
    private int placer;
    private int present;
    private int propositionChiffreJoueur;
    private int[] tabPropositionChiffreJoueur;
    private int compteur = 0;
    private boolean bonneReponse;

    public MasterMindDuelMode() {


    }

    public void runMasterMindDuelMode(){
        System.out.println("**********MasterMind Duel Mode");



        do {
            try
            {
                System.out.println("Veuillez saisir votre combinaison secrète");
                chiffreMystereJoueur = sc.nextInt();
                bonneReponse = true;
            }catch (InputMismatchException e){
                System.out.println("erreur");
                bonneReponse = false;
                sc.nextLine();
            }
        }while (bonneReponse != true);


        tabChiffreMystereJoueur = decoupeNombreJoueur(chiffreMystereJoueur);
        System.out.println("Votre combinaison secrète est enregistré");

        System.out.println("L'ordianteur réfléchi à une combinaison secrète");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chiffreMystereComputer = generateNumber();
        tabChiffreMystereComputer = decoupeNombreMystere(chiffreMystereComputer);
        System.out.println("la combinaison secrète de l'ordinateur est enregistré");
        System.out.println("L'ordinateur commence");


        do {

        compteur++;
        propositionChiffreMystereComputer = generateNumber();

        tabPropositionChiffreMystereComputer = decoupePropositionChiffreMystereComputer(propositionChiffreMystereComputer);

        compareChiffreMystereComputerVsJoueur(tabPropositionChiffreMystereComputer,tabChiffreMystereJoueur, propositionChiffreMystereComputer);

        bonneReponse = true;
        do {
            try
            {
                System.out.println("A votre tour :");
                propositionChiffreJoueur = sc.nextInt();
                bonneReponse = true;
            }catch (InputMismatchException e ){
                System.out.println("erreur");
                bonneReponse = false;
                sc.nextLine();
            }

        }while ( bonneReponse != true);

        tabPropositionChiffreJoueur = decoupePropositionChiffreJoueur(propositionChiffreJoueur);

        comparePropositionChiffreJoueurVsComputer(tabPropositionChiffreJoueur,tabChiffreMystereComputer,propositionChiffreJoueur);
        }while (propositionChiffreJoueur != chiffreMystereComputer && propositionChiffreMystereComputer != chiffreMystereJoueur && compteur != 3);

        if ( propositionChiffreJoueur == chiffreMystereComputer){
            System.out.println("Bravo vous avez gagner la réponse était bien " + chiffreMystereComputer);
        }else if(propositionChiffreMystereComputer == chiffreMystereJoueur){
            System.out.println("L'ordinateur à gagner, la réponse était " + chiffreMystereJoueur);
        }
        else
        {
            System.out.println("Fin du jeux, aucun gagnant ");
        }



        do {


            displayEndGameSelection();
            try {
                choixFinJeux = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("erreur");
                sc.nextLine();
            }
        }while ( choixFinJeux < 1 || choixFinJeux >= 4 );

        selectedEndGame(choixFinJeux);

    }

    private void comparePropositionChiffreJoueurVsComputer(int[] tabPropositionChiffreJoueur, int[] tabChiffreMystereComputer, int propositionChiffreJoueur) {
        boolean[] bienPlacer = new boolean[tabPropositionChiffreJoueur.length];
        System.out.println("Proposition du joueur  : " + propositionChiffreJoueur);
        System.out.print("Réponse  : " );
        placer = 0 ; present = 0;
        for ( int i = 0 ; i < tabPropositionChiffreJoueur.length; i++){
            if ( tabPropositionChiffreJoueur[i] == tabChiffreMystereComputer[i]){
                bienPlacer[i]= true;
                placer++;
            }else{
                bienPlacer[i] =false;
            }
        }

        for ( int i = 0 ; i < tabPropositionChiffreJoueur.length; i++){
            for ( int j = 0 ; j < tabPropositionChiffreJoueur.length; j++){
                if (tabPropositionChiffreJoueur[i] == tabChiffreMystereComputer[j] && (!bienPlacer[j]) ){
                    present++;
                }
            }
        }

        if ( present > 0 && placer > 0){
            System.out.println(" présent "+ present+ ", bien placé " +placer);
        }else if ( present > 0 && placer == 0){
            System.out.println(" present " + present);
        }else if (present == 0 && placer > 0){
            System.out.println(" bien placé " + placer);
        }else{

        }
        System.out.println();



    }

    private int[] decoupePropositionChiffreJoueur(int propositionChiffreJoueur) {
        String decoupe = ""+propositionChiffreJoueur;
        tabPropositionChiffreJoueur =new int[decoupe.length()];
        for (int i = 0 ; i < decoupe.length(); i++){
            tabPropositionChiffreJoueur[i] = Integer.parseInt(""+decoupe.charAt(i));
        }
        return tabPropositionChiffreJoueur;
    }

    private int[] decoupePropositionChiffreMystereComputer(int propositionChiffreMystereComputer) {
        String decoupe = ""+propositionChiffreMystereComputer;
        tabPropositionChiffreMystereComputer = new int[decoupe.length()];
        for ( int i = 0 ; i < decoupe.length(); i++){
            tabPropositionChiffreMystereComputer[i] = Integer.parseInt(""+decoupe.charAt(i));
        }

        return tabPropositionChiffreMystereComputer;
    }

    public void compareChiffreMystereComputerVsJoueur(int[] tabPropositionChiffreMystereComputer,int[] tabChiffreMystereJoueur, int propositionChiffreMystereComputer){
        boolean[] bienPlacer = new boolean[tabPropositionChiffreMystereComputer.length];
        System.out.println("Proposition de l' ordinateur : " + propositionChiffreMystereComputer);
        System.out.print("Réponse  : " );

        placer = 0 ; present = 0;
        for ( int i = 0 ; i < tabPropositionChiffreMystereComputer.length; i++){
            if ( tabPropositionChiffreMystereComputer[i] == tabChiffreMystereJoueur[i]){
                bienPlacer[i]= true;
                placer++;
            }else{
                bienPlacer[i] =false;
            }
        }

        for ( int i = 0 ; i < tabPropositionChiffreMystereComputer.length; i++){
            for ( int j = 0 ; j < tabChiffreMystereJoueur.length; j++){
                if (tabPropositionChiffreMystereComputer[i] == tabChiffreMystereJoueur[j] && (!bienPlacer[j]) ){
                    present++;
                }
            }
        }

        if ( present > 0 && placer > 0){
            System.out.println(" présent "+ present+ ", bien placé " +placer);
        }else if ( present > 0 && placer == 0){
            System.out.println(" present " + present);
        }else if (present == 0 && placer > 0){
            System.out.println(" bien placé " + placer);
        }else{

        }
    }


    public void selectedEndGame(int choixFinJeux){
        switch (choixFinJeux){
            case 1 :
            {
                this.runMasterMindDuelMode();
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
