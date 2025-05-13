package main;

import controllers.PlanetSystemAPI;

import utils.ScannerInput;

import java.io.File;

public class Driver {


    private PlanetSystemAPI planetAPI;


    public static void main(String[] args) throws Exception {
        new Driver().start();
    }
    public void start() {
    //TODO - construct fields

    //TODO - load all data once the serializers are set up
    runMainMenu();
    }


//TODO - construct menus
    //---------------------
    //  MAIN Menu Items
    //---------------------

    private int mainMenu() {

        //TODO write menu that user will see
        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                        Space Place                             |
                ------------------------------------------------------------------
                |   1) Planets CRUD MENU                                         | 
                |                                                                |
                |   2) Reports MENU                                              |                                          | 
                ------------------------------------------------------------------
                |   3) Search Planets                                            |
                |                                                                |
                |   4) Sort Planets                                              |
                ------------------------------------------------------------------            
                |   10) Load All                                                 |
                |   11) Save All                                                 |
                ------------------------------------------------------------------
                |   0)  Exit                                                     |  
                ------------------------------------------------------------------
                ==>>  """);
        return option;
    }

    private void runMainMenu() {
        int option = mainMenu();
        //TODO - write code to call appropiate method based on value in option

        while (option != 0) {

            switch (option) {
                case 1 -> runPlanetsMenu();
                case 2 -> runReportsMenu();
                case 3 -> exitApp();
                case 4 -> exitApp();
                case 10 -> exitApp();
                case 11 -> exitApp();

                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            option = mainMenu();
        }
        exitApp();
    }
    //---------------------
    //  PLANETS Menu Items
    //---------------------
    private int planetsMenu() {

        //TODO write menu that user will see
        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                    Planet Object Menu                          |
                ------------------------------------------------------------------
                |   1) Add a Planet Object                                       | 
                |   2) Delete a Planet Object                                    |                                          | 
                |   3) List all Planet Object                                    |
                |   4) Update a Planet Object                                    |
                |   0) Return to Main Menu                                       |  
                ------------------------------------------------------------------
                ==>>  """);
        return option;
    }

    private void runPlanetsMenu() {
        int option = planetsMenu();
        //TODO - write code to call appropiate method based on value in option

        while (option != 0) {

            switch (option) {
                case 1 -> exitApp();
                case 2 -> exitApp();
                case 3 -> exitApp();
                case 4 -> exitApp();

                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            option = planetsMenu();
        }
        runMainMenu();
    }

    //---------------------
    //  Reports Menu Items
    //---------------------
    private int reportsMenu() {

        //TODO write menu that user will see
        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                      Reports Menu                              |
                ------------------------------------------------------------------
                |   1) Planets Overview                                          | 
                |   0) Return to Main Menu                                       |  
                ------------------------------------------------------------------
                ==>>  """);
        return option;
    }

    private void runReportsMenu() {
        int option = reportsMenu();
        //TODO - write code to call appropiate method based on value in option

        while (option != 0) {

            switch (option) {
                case 1 -> exitApp();

                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            option = reportsMenu();
        }
        runMainMenu();
    }


//TODO update methods counting methods




    //---------------------
    //  General Menu Items
    //---------------------

//TODO - write all the methods that are called from your menu




    //---------------------
    //  Search/Sort
    //---------------------
// TODO search by different criteria i.e. look at the list methods and give options based on that.
// TODO sort  (and give a list of options - not a recurring menu thou)




    //---------------------
    //  Helper Methods
    //---------------------

//TODO- write any helper methods that are required
    private void exitApp() {

        System.out.println("Exiting....");
        System.exit(0);
    }

}

