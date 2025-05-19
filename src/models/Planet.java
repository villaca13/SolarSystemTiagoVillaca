package models;

import utils.Utilities;


public abstract class Planet {

    // variables
    private int id;
    private String name;
    private boolean hasLiquidWater;
    private String surfaceType;
    private double averageTemperature;
    private double mass;
    private double diameter;
    ///  nextId field is used to create the id, it is incremented by 1 everytime a new Planet is created , default value is 1000
    private static int nextId = 1000;

    public final static String ICEPLANETS = "Ice Planet";
    public final static String GASPLANETS = "Gas Planet";

    /**
     * Constructor for objects of class Planet
     *
     * @param id of the planet, >= 1000.  Default error value 1000
     * @param name Name of the planet, max 30 chars
     * @param mass mass of the planet, measured in ronnagrams earth is approx 6.0rg must be > 0.1 default to 0.1
     * @param diameter diameter of the planet, measured in kilometres must be > 0.5 default to 0.5
     * @param surfaceType surface type of the planet, e.g., “rocky”, “volcanic”, “metallic” max 20 chars
     * @param averageTemperature Average temperatur of the planet, Average surface temperature in °C must be a value between -400 and 400 default 0
     * @param hasLiquidWater if the planet has liquid water, 	true or false
     *
     */
    public Planet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater ) {
        this.id =getNextId();
        incrementNextId();
        this.name = name ;
        this.mass = mass;
        this.diameter= diameter;
        this.surfaceType = surfaceType;
        this.averageTemperature = averageTemperature;
        this.hasLiquidWater = hasLiquidWater;
    }
    // default values
    public Planet() {
        this.id = getNextId();
        incrementNextId();
        this.name ="truncates to 30 chars" ;
        this.mass = 0.1;
        this.diameter= 0.5;
        this.surfaceType = "(20 chars)";
        this.averageTemperature = 0;
        this.hasLiquidWater = false;
    }


    //Abstract methods
    public abstract String displayInfo();
    public abstract String classifyBody();

    // Concrete methods
    public double calculateGravity() {
        double xFactor =  Math.pow(6.67430, -11);
        return mass*xFactor/Math.pow(diameter/2,2);
    }

    public void incrementNextId(){
        nextId++;
    }

    // getters and setters

    // id  **********************************
    /**
     * Returns planet id
     */
    public int getId() { return id; }
    /**
     * Updates the Planet id to the value passed as a parameter
     * @param id The new planet id
     */
    public void setId(int id){
        // set 1000 if id is < 1000
        this.id = Math.max(id, 1000);
    }

    // nextId ************************************
    /**
     * Returns planet next id
     */
    public static int getNextId(){
          return nextId;
    }
    /**
     * Updates the Planet nextId to the value passed as a parameter
     * @param nextId The planet next id
     */
    public static void setNextId(int nextId){ Planet.nextId = nextId;}

    // name ***************************************
    /**
     * Returns planet name
     */
    public String getName() { return name; }
    /**
     * Updates the Planet name to the value passed as a parameter
     * @param name The new planet name
     */
    public void setName(String name) {
        final int maxLength = 30;
        if(Utilities.validStringlength( name , maxLength ))
            this.name = name;
        else
            this.name = Utilities.truncateString(name,maxLength);
    }

    // Surface type  ****************************
    /**
     * Returns planet surface type
     */
    public String getSurfaceType() { return surfaceType; }
    /**
     * Updates the Planet surface type to the value passed as a parameter
     * @param surfaceType The new planet surface type
     */
    public void setSurfaceType(String surfaceType) {
        final int maxLength = 20;
        if(Utilities.validStringlength( surfaceType , maxLength ))
            this.surfaceType = surfaceType;
        else
            this.surfaceType = Utilities.truncateString(surfaceType,maxLength);
    }

    // average temperature ***************************
    /**
     * Returns planet  average temperature
     */
    public double getAverageTemperature() { return averageTemperature; }
    /**
     * Updates the Planet average temperature to the value passed as a parameter
     * @param averageTemperature The new planet average temperature
     */
    public void setAverageTemperature(double averageTemperature) {
        if(Utilities.validRange(averageTemperature,-400, 400)){
            this.averageTemperature = averageTemperature;
        }else
            this.averageTemperature =0;
    }

    // mass **************************************
    /**
     * Returns planet mass
     */
    public double getMass() { return mass; }
    /**
     * Updates the Planet mass to the value passed as a parameter
     * @param mass The new planet mass
     */
    public void setMass(double mass) {
        if(Utilities.validRange(mass,0.1, 9999999 )){
            this.mass = mass;
        }else
            this.mass =0.1;
    }

    // Diameter **************************************
    /**
     * Returns planet diameter
     */
    public double getDiameter() { return diameter; }
    /**
     * Updates the Planet diameter to the value passed as a parameter
     * @param diameter The new planet diameter
     */
    public void setDiameter(double diameter) {
        if(Utilities.validRange(diameter,0.5, 9999999 )){
            this.diameter = diameter;
        }else
            this.diameter =0.5;
    }

    // has liquid water *************************
    /**
     * Returns a boolean indicating if the planet has liquid water
     */
    public boolean hasLiquidWater() { return hasLiquidWater; }
    /**
     * Updates the Planet hasLiquidWater to the value passed as a parameter
     * @param hasLiquidWater indicating if the planet has liquid water
     */
    public void setHasLiquidWater(boolean hasLiquidWater) {
        this.hasLiquidWater = hasLiquidWater;
    }
}
