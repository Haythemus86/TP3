package com.mastermind.haythem;

import com.menu.haythem.SelectionJeux;
import com.menu.haythem.MenuSelection;

public class MasterMindChallengerMode extends MenuSelection {

    private int chiffreMystereComputer =0, propositionChiffreJoueur = 0, present = 0 , placer = 0 , compteur = 0;
    private int[] tableauChiffreMystereComputer, tableauPropositionChiffreJoueur ;




    public MasterMindChallengerMode() {
    }


    public void runMasterMindChallengerMode(){

        System.out.println("MasterMind Challenger Mode");

        //Initialisation
        chiffreMystereComputer = generateNumber();
        tableauChiffreMystereComputer = decoupeNombreMystere(chiffreMystereComputer);
        //Test
        System.out.println("Combinaison secrète : " + chiffreMystereComputer);

    do {
        compteur++;
    //Partie Joueur
    System.out.println("Veuillez saisir une proposition");
    propositionChiffreJoueur = sc.nextInt();
    //Initialisation Joueur
    tableauPropositionChiffreJoueur = decoupeNombreJoueur(propositionChiffreJoueur);

    //Comparaison
    compareTableau(tableauChiffreMystereComputer, tableauPropositionChiffreJoueur, propositionChiffreJoueur);

    }while (  ( (propositionChiffreJoueur!= chiffreMystereComputer) && compteur != 3));

            if (compteur == 3){
                System.out.println("PERDU le résultat était " + chiffreMystereComputer);
            }else{
                System.out.println("BRAVO vous avez gagner !!!");
            }




        displayEndGameSelection();
        choixFinJeux = sc.nextInt();
        selectedEndGame(choixFinJeux);

    }


    public void compareTableau ( int[] tableauChiffreMystereComputer, int[] tableauPropositionChiffreJoueur, int propositionChiffreJoueur){

        System.out.print("Réponse : " );

        boolean[] bienPlacer = new boolean[tableauChiffreMystereComputer.length];


        placer = 0 ; present = 0;
        for (int i = 0 ; i< tableauChiffreMystereComputer.length; i++){
            if ( tableauPropositionChiffreJoueur[i] == tableauChiffreMystereComputer[i]){
                bienPlacer[i] = true;
                placer++;
            }else{
                bienPlacer[i] = false;
            }
        }

        for ( int i = 0 ; i < tableauChiffreMystereComputer.length; i++){
            for ( int j = 0 ; j < tableauPropositionChiffreJoueur.length; j++){
                if (tableauPropositionChiffreJoueur[i] == tableauChiffreMystereComputer[j] && (!bienPlacer[j]) ){
                    present++;
                }
            }
        }





       /* placer = 0; present = 0;
        for ( int i = 0 ;  i < tableauChiffreMystereComputer.length; i++){
            for (int j = 0 ; j < tableauChiffreMystereComputer.length; j++){
                if ( tableauPropositionChiffreJoueur[i] == tableauChiffreMystereComputer[j ] && i == j ){
                    placer++;
                }else if (tableauPropositionChiffreJoueur[i] == tableauChiffreMystereComputer[j] && ( i != j)  ){
                    present++;

                }else
                {

                }
            }
        }
        */
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
                this.runMasterMindChallengerMode();
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
