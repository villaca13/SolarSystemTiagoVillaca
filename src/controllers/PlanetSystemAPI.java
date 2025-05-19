package controllers;



import models.*;
import utils.ISerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import utils.ISerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static utils.Utilities.isValidIndex;


public class PlanetSystemAPI implements ISerializer {


    //TODO Create a list to store the Planets
    private List<Planet> planetList;


    //TODO create a File field to story filename
    public String fileName(){
        return "planets.xml";
    }

    //TODO create constructor to initialise filename and instantiate the planets list
    public PlanetSystemAPI() { planetList = new ArrayList<Planet>(); }

    //TODO - CRUD Methods
    /**
     * Add the planet object, passed as a parameter, to the ArrayList.
     *
     * @param planet Planet object to be added to the ArrayList.
     */
    public boolean addPlanetObject(Planet planet) {
        return planetList.add(planet);
    }

    /**
     * Delete a Planet from the ArrayList, if it exists, at the index passed as a parameter.
     *
     * @param indexToDelete Index of the Planet object in the ArrayList
     * @return The deleted planet object or null if no object is at the index location
     */
    public Planet deletePlanetByIndex(int indexToDelete) {
        if ( isValidIndex(planetList, indexToDelete)) {
            return planetList.remove(indexToDelete);
        }
        return null;
    }

    /**
     * Delete a Planet from the ArrayList, if it exists, at the index passed as a parameter.
     *
     * @return true if The planet object has been cleared or false if it is not cleared
     */
    public boolean deleteAllPlanets() {
        List<Planet> toDelete = planetList;
        return planetList.removeAll(toDelete);
    }

    /**
     * Delete a Planet from the ArrayList, if it exists, at the ID passed as a parameter.
     *
     * @param idToDelete ID of the Planet object in the ArrayList
     * @return The deleted planet object or null if no object is at the id location
     */
    public Planet deletePlanetById(int idToDelete) {
        int indexToDelete =findIndexById(idToDelete);
        return deletePlanetByIndex(indexToDelete);
    }

    /**
     * get a planet object at a specific index location.
     * If the index location is not valid, return null.
     *
     * @param index Index of the Planet object in the ArrayList
     * @return The planet object or null if no object is at the index location
     */
    public Planet getPlanetByIndex(int index) {
        if (isValidIndex(planetList, index)) {
            return planetList.get(index);
        }
        return null;
    }

    /**
     * get a planet object at a specific ID location.
     * If the ID location is not valid, return null.
     *
     * @param id of the Planet object in the ArrayList
     * @return The planet object or null if no object is at the ID location
     */
    public Planet getPlanetById(int id) {
        int index =findIndexById(id);
        return getPlanetByIndex(index);
    }

    /**
     * get a list of planet objects by Type
     * If the list is empty, return null.
     *
     * @param planetType of the Planet object in the ArrayList
     * @return a list of planet objects By the type passed as parameter or null if  the list is empty
     */
    public List<Planet> getPlanetsByType(String planetType) {
        if(numberOfPlanets()>0){
            List<Planet> planetByType = new ArrayList<>();
            for(Planet pl : planetList){
                if(pl.classifyBody().equals(planetType)){
                    planetByType.add(pl);
                }
            }
            return planetByType;
        }else
            return null;
    }


    // TODO Reporting Methods
    /**
     * This method builds and returns a String containing all the planets in the ArrayList.
     * For each planet stored, the associated index number is included.
     * If no planets are stored in the ArrayList, the String "No planets" is returned.
     *
     * @return A String containing all the planets in the ArrayList, or "No planets",
     * if empty.
     */
    public String listAllPlanets() {
        if (planetList.isEmpty()) {
            return "No Planets";
        } else {
            String listOfPlanets = "";
            for (int i = 0; i < planetList.size(); i++) {
                listOfPlanets += i + ": " + planetList.get(i) + "\n";
            }
            return listOfPlanets;
        }
    }

    /**
     * This method builds and returns a String containing all the Gas planets in the ArrayList.
     * For each planet stored, the associated index number is included.
     * If no planets are stored in the ArrayList, the String "No Gas planets" is returned.
     *
     * @return A String containing all the Gas planets in the ArrayList, or "No Gas planets",
     * if empty.
     */
    public String listAllGasPlanets() {
        String listOfPlanets = "";
        int i=0;
        for(Planet planet : planetList) {
            if (planet.classifyBody() == planet.GASPLANETS) {
                listOfPlanets += i + ": " + planet + "\n";
                i++;
            }
        }

        if (i==0) {
            return "No Gas planets";
        }else {
            return listOfPlanets;
        }
    }

    /**
     * This method builds and returns a String containing all the Ice planets in the ArrayList.
     * For each planet stored, the associated index number is included.
     * If no planets are stored in the ArrayList, the String "No Ice planets" is returned.
     *
     * @return A String containing all the Gas planets in the ArrayList, or "No Ice planets",
     * if empty.
     */
    public String listAllIcePlanets() {
        String listOfPlanets = "";
        int i=0;
        for(Planet planet : planetList) {
            if (planet.classifyBody() == planet.ICEPLANETS) {
                listOfPlanets += i + ": " + planet + "\n";
                i++;
            }
        }

        if (i==0) {
            return "No Ice planets";
        }else {
            return listOfPlanets;
        }
    }

    /**
     * This method builds and returns a String containing all the planets heavier than the parameter passed.
     * For each planet stored, the associated index number is included.
     * If no planets are stored in the ArrayList, the String "No planets heavier than the parameter " is returned.
     *
     * @param massThreshold The mass threshold to be used to filter the planets.
     * @return A String containing all the planets in the ArrayList which is heavier than the parameter,
     * or "No Ice planets", if empty.
     */
    public String listAllPlanetObjectsHeavierThan(double massThreshold) {
        String listOfPlanets = "";
        int i=0;
        for(Planet planet : planetList) {
            if (planet.getMass() > massThreshold) {
                listOfPlanets += i + ": " + planet + "\n";
                i++;
            }
        }

        if (i==0) {
            return "No planets heavier than "+massThreshold;
        }else {
            return listOfPlanets;
        }
    }

    /**
     * This method builds and returns a String containing all the planets are smaller than the parameter passed.
     * For each planet stored, the associated index number is included.
     * If no planets are stored in the ArrayList, the String "No planets smaller than the parameter " is returned.
     *
     * @param diameterThreshold The diameter threshold to be used to filter the planets.
     * @return A String containing all the planets in the ArrayList which is heavier than the parameter,
     * or "No Ice planets", if empty.
     */
    public String listAllPlanetObjectsSmallerThan(double diameterThreshold) {
        String listOfPlanets = "";
        int i=0;
        for(Planet planet : planetList) {
            if (planet.getDiameter() < diameterThreshold) {
                listOfPlanets += i + ": " + planet + "\n";
                i++;
            }
        }

        if (i==0) {
            return "No planets smaller than "+diameterThreshold;
        }else {
            return listOfPlanets;
        }
    }


    // TODO number methods

    // Number of planets *************************
    /**
     * Returns number of planets
     */
    public int numberOfPlanets() {
        return planetList.size();
    }
    /**
     * Returns number of gas planets
     */
    public int numberOfGasPlanets() {
        if(planetList.isEmpty())
            return 0;
        else
            return countPlanets(Planet.GASPLANETS);
    }
    /**
     * Returns number of ice planets
     */
    public int numberOfIcePlanets() {
        if(planetList.isEmpty())
            return 0;
        else
            return countPlanets(Planet.ICEPLANETS);
    }



    //TODO get Planet methods

    /**
     * This method returns the planets ArrayList
     *
     * @return the planets ArrayList
     */
    public List<Planet> getPlanets() {
        return planetList;
    }

    /**
     * This method takes in an ArrayList of planets objects and sets the planets ArrayList to it.
     *
     * @param planets An ArrayList of product objects.
     */
    public void setPlanets(ArrayList<Planet> planets) {
        this.planetList = planets;
    }


    //TODO - Update methods
    /**
     * Update an Ice Planet in the ArrayList with the contents passed in the Planet object parameter.
     *
     * @param idToUpdate Index of the Ice Planet object in the ArrayList
     * @param updateDetails An Ice Planet object containing the updated details
     * @return The status of the update, True or False
     */
    public boolean updateIcePlanet(int idToUpdate, IcePlanet updateDetails) {
        //find the product object by the index number
        IcePlanet foundProduct = findIcePlanet(idToUpdate);

        //if the product exists, use the details passed in the updateDetails parameter to
        //update the found product in the ArrayList.
        if (foundProduct != null) {
            foundProduct.setName( updateDetails.getName() );
            foundProduct.setMass( updateDetails.getMass() );
            foundProduct.setDiameter( updateDetails.getDiameter() );
            foundProduct.setAverageTemperature( updateDetails.getAverageTemperature() );
            foundProduct.setSurfaceType( updateDetails.getSurfaceType() );
            foundProduct.setHasLiquidWater( updateDetails.hasLiquidWater() );
            foundProduct.setIceComposition( updateDetails.getIceComposition() );
            return true;
        }
        //if the object was not found, return false, indicating that the update was not successful
        return false;
    }

    /**
     * Update a Gas Planet in the ArrayList with the contents passed in the Planet object parameter.
     *
     * @param idToUpdate Index of the Gas Planet object in the ArrayList
     * @param updateDetails A Gas Planet object containing the updated details
     * @return The status of the update, True or False
     */
    public boolean updateGasPlanet(int idToUpdate, GasPlanet updateDetails) {
        //find the product object by the index number
        GasPlanet foundProduct = findGasPlanet(idToUpdate);

        //if the product exists, use the details passed in the updateDetails parameter to
        //update the found product in the ArrayList.
        if (foundProduct != null ) {
            foundProduct.setName( updateDetails.getName() );
            foundProduct.setMass( updateDetails.getMass() );
            foundProduct.setDiameter( updateDetails.getDiameter() );
            foundProduct.setAverageTemperature( updateDetails.getAverageTemperature() );
            foundProduct.setSurfaceType( updateDetails.getSurfaceType() );
            foundProduct.setHasLiquidWater( updateDetails.hasLiquidWater() );
            foundProduct.setGasComposition( updateDetails.getGasComposition() );
            foundProduct.setCoreComposition( updateDetails.getCoreComposition());
            foundProduct.setRadiationLevel( updateDetails.getRadiationLevel());
            return true;
        }
        //if the object was not found, return false, indicating that the update was not successful
        return false;
    }

    //TODO - sort methods
    /**
     * Selection sort algorithm for sorting the arraylist of planets by diamenter ascending/Descending.
     */
    public void sortByDiameterDescending(){
        for (int i = planetList.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (planetList.get(j).getDiameter() < planetList.get(highestIndex).getDiameter()) {
                    highestIndex = j;
                }
            }
            swapPlanets(planetList , i, highestIndex);
        }

    }
    public void sortByDiameterAscending(){
        for (int i = planetList.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (planetList.get(j).getDiameter() > planetList.get(highestIndex).getDiameter()) {
                    highestIndex = j;
                }
            }
            swapPlanets(planetList , i, highestIndex);
        }
    }
    /**
     * Selection sort algorithm for sorting the arraylist of planets by radiation Descending.
     *
     * @return a list of Gas Planets sorted by Radiation level or null if a list is empty
     */
    public List<Planet> sortByRadiationDescending(){
        if(numberOfGasPlanets()>0){
            List<Planet> gasPlanets = getPlanetsByType( Planet.GASPLANETS);

            for (int i = gasPlanets.size()  - 1; i >= 0; i--) {
                int highestIndex = 0;

                for (int j = 0; j <= i; j++) {
                    if ( ((GasPlanet) gasPlanets.get(j)).getRadiationLevel() < ((GasPlanet) gasPlanets.get(highestIndex)).getRadiationLevel()) {
                        highestIndex = j;
                    }
                }
                swapPlanets(gasPlanets , i, highestIndex);
            }
            return gasPlanets;
        }else
            return null;
    }

    private void swapPlanets(List<Planet> planets, int i, int j) {
        Planet smaller = planets.get(i);
        Planet bigger = planets.get(j);

        planets.set(i,bigger);
        planets.set(j,smaller);
    }

    //TODO Top 5 methods
    public List<Planet> topFiveHighestRadiationGasPlanet(){
        List<Planet> gasPlanetTop5;
        if (numberOfGasPlanets() > 0 ){
            gasPlanetTop5 = sortByRadiationDescending();
            int limit = Math.min(gasPlanetTop5.size(), 5);

            for ( int i= 0; i< gasPlanetTop5.size() ; i++ ){
                if (i >= 5){
                    gasPlanetTop5.remove(i);
                }
            }
            return gasPlanetTop5;
        }else
            return null;
    }

    public List<Planet> topFiveBiggestPlanet(){
        if (!planetList.isEmpty()){
            List<Planet> planetTop5 = new ArrayList<>();
            int limit = Math.min(planetList.size(), 5);

            sortByDiameterDescending();

            for ( int i= 0; i< limit ; i++ ){
                planetTop5.add(planetList.get(i));
            }
            return planetTop5;
        }else
            return null;
    }

    // TODO Persistence methods
    /**
     * The load method uses the XStream component to read all the models objects from the planets.xml
     * file stored on the hard disk.  The read objects are loaded into the posts ArrayList
     *
     * @throws Exception An exception is thrown if an error occurred during the load e.g. a missing file.
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Planet.class, IcePlanet.class, GasPlanet.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        planetList = (List<Planet>) in.readObject();
        Planet.setNextId(highestPlanetId()+1);
        in.close();
    }
    /**
     * The save method uses the XStream component to write all the objects in the posts ArrayList
     * to the planets.xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(planetList);
        out.close();
    }






    //---------------------
    //  Helper Methods
    //---------------------
    /**
     * Find the Index by the Planet Id passed as a parameter
     *
     * @param id of planet object
     * @return The index of Planet object in the list
     */
    public int findIndexById(int id){
        int index = 0;
        for(Planet planet : planetList) {
            if (planet.getId() == id) {
                index = planetList.indexOf(planet);
            }
        }
        return index;
    }
    /**
     * Method to count planets by type (ICE or GAS) in the list.
     *
     * @param planetType is to identify if it is Ice or Gas
     * @return The counter of Planet objects found in the list
     */
    private int countPlanets(String planetType){
        int count = 0;
        for(Planet planet : planetList) {
            if (planet.classifyBody().equals(planetType)) {
                count++;
            }
        }
        return count;
    }
    /**
     * Find an Ice Planet object at a specific index location.
     * If the index location is not valid, return null.
     *
     * @param id of the Ice Planet object in the ArrayList
     * @return The Ice Planet object or null if no object is at the index location
     */
    public IcePlanet findIcePlanet(int id) {
        if (isValidId(id)){
            int index = findIndexById(id);
            if (isValidIndex( planetList , index)) {
                return (IcePlanet) planetList.get(index);
            }
            else
                return null;
        }
        else
            return null;
    }
    /**
     * Find a Gas Planet object at a specific index location.
     * If the index location is not valid, return null.
     *
     * @param id of the Gas Planet object in the ArrayList
     * @return The Gas Planet object or null if no object is at the index location
     */
    public GasPlanet findGasPlanet(int id) {
        if (isValidId(id)){
            int index =findIndexById(id);
            if (isValidIndex( planetList , index)) {
                return (GasPlanet) planetList.get(index);
            }
            else
                return null;

        }
        else
            return null;
    }

    /**
     * This method returns the highest number of Planet ID in the ArrayList.
     * If no planets are stored in the ArrayList, 1000 is returned.
     *
     * @return The highest Planet ID in the ArrayList or 1000, if no planets are added yet.
     */
    public int highestPlanetId() {
        if (!planetList.isEmpty()) {
            int highestPlanetId = planetList.get(0).getId();
            for (Planet planets : planetList) {
                if (planets.getId() > highestPlanetId)
                    highestPlanetId = planets.getId();
            }
            return highestPlanetId;
        } else {
            return 1000;
        }
    }
    //TODO validation method below:
    //the following is isValidId can be updated
    //to suit your code - checks is the id already there in the list

    public boolean isValidId(int id) {
        for (Planet pl : planetList) {
            if (pl.getId() == id)
                return true;
        }
        return false;
    }

}   
