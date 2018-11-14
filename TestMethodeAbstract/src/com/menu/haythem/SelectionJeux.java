package com.menu.haythem;

import com.game.haythem.ChiffreMystereMenu;
import com.game.haythem.MasterMindMenu;

import java.util.InputMismatchException;

public class SelectionJeux extends MenuSelection {





    public SelectionJeux() {



    }

    public void runSelectionJeux(){




        do {

            displayGameSelection();
            try
            {
                choixJeux = sc.nextInt();
            }catch (InputMismatchException e ){
                System.out.println("Veuillez saisir des chiffres svp");
                sc.nextLine();
            }
            selectGame(choixJeux);

        }while( choixJeux < 1 || choixJeux > 2);


    }



    public void selectGame( int choixJeux){
        switch (choixJeux){
            case 1 :
            {
                ChiffreMystereMenu chiffreMystereMenu = new ChiffreMystereMenu();
                chiffreMystereMenu.runChiffreMystereMenu();
                break;
            }
            case 2 :
            {
                MasterMindMenu masterMindMenu = new MasterMindMenu();
                masterMindMenu.runMasterMindMenu();
                break;
            }
            default  :
            {
                System.out.println("Choix Invalide");
                break;
            }
        }
    }




}
