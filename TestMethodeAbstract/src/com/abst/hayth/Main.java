package com.abst.hayth;

import com.menu.haythem.SelectionJeux;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static int chiffre;
    private static boolean condition = false;

    public static void main(String[] args) {

        //SelectionJeux selectionJeux = new SelectionJeux();
        //selectionJeux.runSelectionJeux();





        Properties properties = new Properties();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties.setProperty("nombreCase", "4");
        properties.setProperty("nombreEssai", "10");
        try {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        while ( !condition) {
            System.out.println("veuillez saisir un chiffre");
            try {
                chiffre = sc.nextInt();
                condition = true;
            } catch (InputMismatchException e) {
                System.out.println("saisr des chiffres ");
                condition = false;
                sc.nextLine();
            }
        }
*/
    }

    }

