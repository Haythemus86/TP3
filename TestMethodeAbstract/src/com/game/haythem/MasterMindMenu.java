package com.game.haythem;

import com.mastermind.haythem.MasterMindDefenseurMode;
import com.mastermind.haythem.MasterMindDuelMode;
import com.menu.haythem.MenuSelection;
import com.mastermind.haythem.MasterMindChallengerMode;

public class MasterMindMenu extends MenuSelection {

    public MasterMindMenu() {

    }

    public void runMasterMindMenu(){
        diplayGameModeSelection();
        choixModeJeux = sc.nextInt();
        selectedGameMode(choixModeJeux);
    }

    public void selectedGameMode ( int choixModeJeux){

        switch (choixModeJeux){
            case 1 :
            {
                MasterMindChallengerMode masterMindChallengerMode = new MasterMindChallengerMode();
                masterMindChallengerMode.runMasterMindChallengerMode();
                break;
            }
            case 2 :
            {
                MasterMindDefenseurMode masterMindDefenseurMode = new MasterMindDefenseurMode();
                masterMindDefenseurMode.runMasterMindDefenseurMode();
                break;
            }
            case 3 :
            {
                MasterMindDuelMode masterMindDuelMode = new MasterMindDuelMode();
                masterMindDuelMode.runMasterMindDuelMode();
                break;
            }
            case 4 :
            {
                System.out.println("Vous n'avez pas fait de choix valide. Veuillez saisir un choix valide");
                break;
            }
        }

    }
}
