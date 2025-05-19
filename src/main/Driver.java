package main;

import controllers.PlanetSystemAPI;

import models.GasPlanet;
import models.IcePlanet;
import models.Planet;
import utils.ScannerInput;
import utils.Utilities;
import utils.CoreCompositionUtility;

import java.io.File;
import java.util.List;
import java.util.Set;

public class Driver {

    private PlanetSystemAPI Planets = new PlanetSystemAPI();

    public static void main(String[] args) throws Exception {
        new Driver().start();
    }
    public void start() {
    //TODO - construct fields

    //TODO - load all data once the serializers are set up
        File f = new File(Planets.fileName());
        if(f.exists() && !f.isDirectory()) {
            loadPlanets();
            System.out.println("File loaded successfully.");
        }


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
                case 3 -> searchPlanets();
                case 4 -> sortPlanets();
                case 10 -> loadPlanets();
                case 11 -> savePlanets();

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
                case 1 -> addPlanet();
                case 2 -> deletePlanet();
                case 3 -> listPlanets();
                case 4 -> updatePlanet();

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
                |   1) Planets Overview (Number of Planets)                      |
                |   2) List All Gas Planets                                      |
                |   3) List All Ice Planets                                      |                                       | 
                |   4) List All Planets heavier than                             | 
                |   5) List All Planets Smaller than                             |                                           | 
                |                                                                | 
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
                case 1 -> {
                    System.out.println("Planets Overview:");
                    System.out.println("Number of Planets: "+ Planets.numberOfPlanets());
                    System.out.println("Number of Gas Planets: "+ Planets.numberOfGasPlanets());
                    System.out.println("Number of Ice Planets: "+ Planets.numberOfIcePlanets());
                    System.out.println("List of Gas Planets are:");
                    System.out.println(Planets.listAllGasPlanets());
                    System.out.println("List of Ice Planets are:");
                    System.out.println(Planets.listAllIcePlanets());
                }
                case 2 -> {
                    System.out.println("List of Gas Planets are:");
                    System.out.println(Planets.listAllGasPlanets());
                }
                case 3 ->{
                    System.out.println("List of Ice Planets are:");
                    System.out.println(Planets.listAllIcePlanets());
                }
                case 4 -> {
                    double massThreshold = ScannerInput.readNextDouble("Enter the Planet Mass Threshold: ");
                    System.out.println("List of The Planets which are heavier than "+ massThreshold +":");
                    System.out.println(Planets.listAllPlanetObjectsHeavierThan(massThreshold));
                }
                case 5 -> {
                    double diameterThreshold = ScannerInput.readNextDouble("Enter the Planet diameter Threshold: ");
                    System.out.println("List of The Planets which are smaller than "+ diameterThreshold +":");
                    System.out.println(Planets.listAllPlanetObjectsSmallerThan(diameterThreshold));
                }

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
    /**
     * method to add a planet.
     */
    private void addPlanet(){
        planetDetails('A');
    }
    /**
     * method to update a planet.
     */
    private void updatePlanet(){
        planetDetails('U');
    }

    /**
     * method to get the details of a planet from the user.
     *
     * @param action "U" for update or "A" for add a planet object.
     *
     */
    private void planetDetails(char action){
        //Variables
        boolean isAdded = false;
        boolean isUpdated = false;
        int idToUpdate=0;
        String planetName;
        double mass;
        double diameter;
        double averageTemperature;
        String surfaceType;
        boolean hasLiquidWater;
        String gasComposition;
        String coreComposition;
        double radiationLevel;
        String iceComposition;

        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                      Planet Type Menu                          |       
                ------------------------------------------------------------------
                |   1) Gas Planet                                                | 
                |   2) Ice Planet                                                |
                |                                                                |  
                |   0) Return to Planet Object Menu                              |  
                |                                                                |
                ------------------------------------------------------------------
                ==>>  """);

        if (option >= 0 && option <= 2) {

            // back to Planet  Object menu if Option Zero
            if (option == 0) {
                planetsMenu();
            }

            if (action == 'U') {
                idToUpdate = ScannerInput.readNextInt("Enter the Planet ID to be Updated:  ");
            }


            // New Planet Object Menu
            planetName = ScannerInput.readNextLine("Enter the Planet Name:  ");
            mass = ScannerInput.readNextInt("Enter the Planet Mass:  ");
            diameter = ScannerInput.readNextDouble("Enter the Planet Diameter:  ");
            averageTemperature = ScannerInput.readNextDouble("Enter the Planet Average Temperature:  ");
            surfaceType = ScannerInput.readNextLine("Enter the Planet Surface Type:  ");

            //Ask the user to type in either a Y or an N.  This is then
            //converted to either a True or a False (i.e. a boolean value).
            hasLiquidWater = Utilities.YNtoBoolean(ScannerInput.readNextChar("Does this planet have Liquid Water?(y/n): "));

            switch (option) {
                case 1 -> {
                    gasComposition = ScannerInput.readNextLine("Enter the Gas Composition:  ");
                    System.out.println("Core Composition Options:");
                    List<String> coreKeys = CoreCompositionUtility.getCoreKeys();
                    showListOfOptions(coreKeys);
                    int coreOption = ScannerInput.readNextInt("Enter the Core Composition:  ");
                    while (coreOption <1 || coreOption>5 ) {
                        coreOption = ScannerInput.readNextInt("Wrong code ! Enter the Core Composition:  ");
                    }
                    coreComposition = coreKeys.get(coreOption);

                    radiationLevel = ScannerInput.readNextDouble("Enter the Radiation Level:  ");
                    GasPlanet newGasPlanet = new GasPlanet(planetName,mass, diameter, averageTemperature, surfaceType, hasLiquidWater,gasComposition, coreComposition, radiationLevel );
                        switch (action){
                            case 'U' -> isUpdated = Planets.updateGasPlanet(idToUpdate,  newGasPlanet);
                            case 'A' -> isAdded = Planets.addPlanetObject (newGasPlanet);
                        }
                    }
                case 2 -> {
                    iceComposition = ScannerInput.readNextLine("Enter the Ice Composition:  ");
                    IcePlanet newIcePlanet = new IcePlanet(planetName,mass, diameter, averageTemperature, surfaceType, hasLiquidWater, iceComposition);
                    switch (action){
                        case 'U' -> isUpdated = Planets.updateIcePlanet(idToUpdate, newIcePlanet);
                        case 'A' -> isAdded = Planets.addPlanetObject (newIcePlanet);
                    }
                }
            }
        }
        else{
            System.out.println("Invalid option entered: " + option);

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the add menu again
            planetDetails( action );
        }

        switch (action){
            case 'U' -> {
                if (isUpdated){
                    System.out.println("Planet Updated Successfully");
                }
                else{
                    System.out.println("No Planet Updated");
                }
            }
            case 'A' -> {
                if (isAdded){
                    System.out.println("Planet Added Successfully");
                }
                else{
                    System.out.println("No Planet Added");
                }
            }
        }

    }


    private void deletePlanet(){
        //Variables
        int indexToDelete;

        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                      Delete Planet Menu                        |
                ------------------------------------------------------------------
                |   1) Delete by Index                                           |
                |   2) Delete by ID                                              |
                |   3) Delete All                                                |
                |                                                                |  
                |   0) Return to Planet Object Menu                              |  
                |                                                                |
                ------------------------------------------------------------------
                ==>>  """);

        while (option != 0 ) {
            Planet planetToDelete;
            switch (option) {
                case 1 -> {
                    indexToDelete = ScannerInput.readNextInt("Enter the Index to Delete:  ");
                    planetToDelete = Planets.deletePlanetByIndex(indexToDelete);
                    if (planetToDelete != null) {
                        System.out.println("Planet Deleted Successfully: " + planetToDelete.toString());
                    }
                    else{
                        System.out.println("No Planet Deleted.");
                    }
                }
                case 2 ->{
                    indexToDelete = ScannerInput.readNextInt("Enter the ID to Delete:  ");
                    planetToDelete = Planets.deletePlanetById(indexToDelete);
                    if (planetToDelete != null) {
                        System.out.println("Planet Deleted Successfully: " + planetToDelete.toString());
                    }
                    else{
                        System.out.println("No Planet Deleted.");
                    }
                }
                case 3-> {
                    if(Planets.deleteAllPlanets())
                        System.out.println("Planets Deleted Successfully.");
                    else
                        System.out.println("Planets were not Deleted.");
                }
                default -> {
                    System.out.println("Invalid option entered: " + option);
                    //display the delete menu again
                    deletePlanet();
                }
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");
            //display the add menu again
            runPlanetsMenu();
        }
    }

    private void listPlanets(){
        System.out.println("List of Planets are:");
        System.out.println(Planets.listAllPlanets());
    }
    //---------------------------------------------------------------------
    //  Options 3 and 4 - Search and Sort Planets
    //---------------------------------------------------------------------
    //selection sort algorithm
    private void searchPlanets(){
        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                      Search Planets Menu                       |
                ------------------------------------------------------------------
                |   1) Search by ID                                              | 
                |   2) Search by Index                                           | 
                |   3) Search the top 5 most radiated Gas Planet                 | 
                |   4) Search the top 5 biggest planets by diameter              | 
                |                                                                |  
                |   0) Return to Main Menu                                       |  
                |                                                                |
                ------------------------------------------------------------------
                ==>>  """);

        while (option != 0) {

            switch (option) {
                case 1 -> searchPlanetById();
                case 2 -> searchPlanetByIndex();
                case 3 -> searchTopFiveRadiationLevel();
                case 4 -> searchTopFiveDiameter();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            searchPlanets();
        }
        runMainMenu();

    }
    //selection sort algorithm
    private void searchPlanetById() {
        int idToFind = ScannerInput.readNextInt("Enter the Planet ID:  ");
        if(Planets.isValidId(idToFind)){
            Planet planetFound = Planets.getPlanetById(idToFind);
            System.out.println("Planet found:");
            System.out.println( planetFound);



        }
        else {
            System.out.println("No planet found!");

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");
            searchPlanets();
        }
    }

    private void searchPlanetByIndex() {
        int indexToFind = ScannerInput.readNextInt("Enter the Planet Index:  ");
        Planet planetFound = Planets.getPlanetByIndex(indexToFind);
        if(planetFound != null){
            System.out.println("Planet found:");
            System.out.println( planetFound);
        }
        else{
            System.out.println("No planet found!");
        }
    }

    private void searchTopFiveRadiationLevel(){
        System.out.println("List of the top 5 most radiated Gas Planet:");
        List<Planet> top5RadiationLevel = Planets.topFiveHighestRadiationGasPlanet();
        if (top5RadiationLevel != null){
            for (Planet planet : top5RadiationLevel) {
                System.out.println(planet);
            }
        }else
            System.out.println("List is empty.");
    }

    private void searchTopFiveDiameter(){
        System.out.println("List of the top 5 biggest planets by diameter:");
        List<Planet> top5Diameter = Planets.topFiveBiggestPlanet();
        if (top5Diameter != null){
            for (Planet planet : top5Diameter) {
                System.out.println(planet);
            }
        }else
            System.out.println("List is empty.");
    }

    private void sortPlanets(){
        int option = ScannerInput.readNextInt("""
                ------------------------------------------------------------------
                |                      Sort Planets Menu                         |       
                ------------------------------------------------------------------
                |   1) Sort by Diameter Ascending                                | 
                |   2) Sort by Diameter Descending                               | 
                |                                                                |  
                |   0) Return to Main Menu                                       |  
                |                                                                |
                ------------------------------------------------------------------
                ==>>  """);

        while (option != 0) {

            switch (option) {
                case 1 -> sortPlanetByDiameterAscending();
                case 2 -> sortPlanetByDiameterDescending();

                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            sortPlanets();
        }
        runMainMenu();
    }

    private void sortPlanetByDiameterAscending() {
        Planets.sortByDiameterAscending();
        System.out.println( Planets.listAllPlanets());
    }
    //selection sort algorithm
    private void sortPlanetByDiameterDescending() {
        Planets.sortByDiameterDescending();
        System.out.println( Planets.listAllPlanets());
    }

    //---------------------------------------------------------------------
    //  Options 10 and 11 - Save and Load Planets
    //---------------------------------------------------------------------

    //save all the posts in the newsFeed to a file on the hard disk
    private void savePlanets() {
        try {
            System.out.println("Saving to file: " + Planets.fileName());
            Planets.save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }

    //load all the posts into the newsFeed from a file on the hard disk
    private void loadPlanets() {
        try {
            System.out.println("Loading from file: " + Planets.fileName());
            Planets.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }


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
    private void showListOfOptions(List<String> list){
        int i = 1;
        for(String c : list){
            System.out.println(i+" "+c);
            i++;
        }
    }
}

