package com.game.haythem;

import com.ChiffreMystere.haythem.ChiffreMystereChallengerMode;
import com.ChiffreMystere.haythem.ChiffreMystereDefenseurMode;
import com.ChiffreMystere.haythem.ChiffreMystereDuelMode;
import com.menu.haythem.MenuSelection;

import java.util.InputMismatchException;

public class ChiffreMystereMenu extends MenuSelection {

    public ChiffreMystereMenu() {
    }


    public void runChiffreMystereMenu(){

       do {
           diplayGameModeSelection();
           try {
               choixModeJeux = sc.nextInt();
           }catch (InputMismatchException e){
               System.out.println("Veuillez saisir un chiffre");
               sc.nextLine();
           }
           selectedGameMode(choixModeJeux);

       }while ( choixModeJeux < 1 || choixModeJeux > 3);

    }

    public void selectedGameMode ( int choixModeJeux){

        switch (choixModeJeux){
            case 1 :
            {
                ChiffreMystereChallengerMode chiffreMystereChallengerMode = new ChiffreMystereChallengerMode();
                chiffreMystereChallengerMode.runChiffreMystereChallengerMode();
                break;
            }
            case 2 :
            {
                ChiffreMystereDefenseurMode chiffreMystereDefenseurMode = new ChiffreMystereDefenseurMode();
                chiffreMystereDefenseurMode.runChiffreMystereDefenseurMode();
                break;
            }
            case 3 :
            {
                ChiffreMystereDuelMode chiffreMystereDuelMode = new ChiffreMystereDuelMode();
                chiffreMystereDuelMode.runChiffreMystereDuelMode();
                break;
            }
            default :
            {
                System.out.println("Vous n'avez pas fait de choix valide. Merci d'entrer un choix valide.");
                break;
            }
        }

    }


}
