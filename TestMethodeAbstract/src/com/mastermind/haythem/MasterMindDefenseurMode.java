package com.mastermind.haythem;

import com.menu.haythem.MenuSelection;
import com.menu.haythem.SelectionJeux;

import java.util.InputMismatchException;

public class MasterMindDefenseurMode extends MenuSelection {

    public int chiffreMystereJoueur = 0, propositionChiffreMystereComputer = 0;
    public int[] tableauChiffreMystereJoueur, tableauPropositionChiffreComputer;
    private int placer;
    private int present;
    private int compteur;


    public MasterMindDefenseurMode() {

    }


    public void runMasterMindDefenseurMode(){

        System.out.println("MasterMind Defenseur Mode");




        try
        {
            //Initialisation
            System.out.println("veuillez saisir une combinaison mystere ");
            chiffreMystereJoueur = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Merci de saisir des chiffres");
        }

         tableauChiffreMystereJoueur = decoupeNombreJoueur(chiffreMystereJoueur);



         do {
            compteur++;

             System.out.println("L'ordinateur réfléchi à une combinaison");
             propositionChiffreMystereComputer = generateNumber();
             tableauPropositionChiffreComputer = decoupeNombreMystere(propositionChiffreMystereComputer);

             compareTableau(tableauChiffreMystereJoueur, tableauPropositionChiffreComputer, propositionChiffreMystereComputer);

         }while ( propositionChiffreMystereComputer != chiffreMystereJoueur && compteur != 10 );

        if ( propositionChiffreMystereComputer ==  chiffreMystereJoueur && compteur != 10){
            System.out.println("Bravo vous avez trouvez la bonne combinaison");
        }else{
            System.out.println("Désolé vous avez perdu, la bonne combinaison était : " + chiffreMystereJoueur);
        }







        displayEndGameSelection();
        choixFinJeux =  sc.nextInt();
        selectedEndGame(choixFinJeux);


    }

    public void compareTableau(int[] tableauChiffreMystereJoueur, int[] tableauPropositionChiffreComputer,int propositionChiffreMystereComputer){

        boolean[] bienPlacer = new boolean[tableauPropositionChiffreComputer.length];

        System.out.print("Réponse : " + propositionChiffreMystereComputer );

        placer = 0;
        present = 0;
        for (int i = 0 ; i < tableauChiffreMystereJoueur.length; i++){
            if ( tableauPropositionChiffreComputer[i] == tableauChiffreMystereJoueur[i]){
                placer++;
                bienPlacer[i] = true;
            }
            else
            {
                bienPlacer[i] = false;
            }
        }

        for ( int i = 0 ; i < tableauPropositionChiffreComputer.length; i++){
            for ( int j = 0 ; j < tableauChiffreMystereJoueur.length; j++){
                if (tableauPropositionChiffreComputer[i] == tableauChiffreMystereJoueur[j] && (!bienPlacer[j]) ){
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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




    public void selectedEndGame(int choixFinJeux){
        switch (choixFinJeux){
            case 1 :
            {
                this.runMasterMindDefenseurMode();
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
