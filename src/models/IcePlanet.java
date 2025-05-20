package models;

import utils.Utilities;

public class IcePlanet extends Planet{
    // variables
    private String iceComposition;

    /**
     * Constructor for objects of class ice Planet
     *
     * @param name Name of the planet, max 30 chars
     * @param mass mass of the planet, measured in ronnagrams earth is approx 6.0rg must be > 0.1 default to 0.1
     * @param diameter diameter of the planet, measured in kilometres must be > 0.5 default to 0.5
     * @param surfaceType surface type of the planet, e.g., “rocky”, “volcanic”, “metallic” max 20 chars
     * @param averageTemperature Average temperature of the planet, Average surface temperature in °C must be a value between -400 and 400 default 0
     * @param hasLiquidWater if the planet has liquid water,true or false
     * @param iceComposition ice planet composition, max 30 chars
     *
     */
    public IcePlanet(String name, double mass, double diameter,  double averageTemperature, String surfaceType, boolean hasLiquidWater, String iceComposition){
        super(name, mass, diameter, averageTemperature, surfaceType, hasLiquidWater);
        this.iceComposition = iceComposition;
    }
    // default values
    public IcePlanet(){
        super();
        this.iceComposition = "(30 chars)";
    }





    // getter and setters
    /**
     * Returns ice planet composition
     */
    public String getIceComposition() { return iceComposition; }
    /**
     * Updates the ice planet composition  to the value passed as a parameter
     * @param iceComposition The new ice planet composition
     */
    public void setIceComposition(String iceComposition) {
        final int maxLength = 30;
        if(Utilities.validStringlength( iceComposition , maxLength ))
            this.iceComposition = iceComposition;
        else
            this.iceComposition = Utilities.truncateString(iceComposition,maxLength);
    }


    //---------------------
    // Abstract Methods Implemented
    //---------------------
    @Override
    public String displayInfo() { return "Ice Composition: " + getIceComposition(); }

    @Override
    public String classifyBody() {return ICEPLANETS; }

    //---------------------
    //  ToString
    //---------------------
    /**
     * Builds a String representing a user friendly representation of the object state
     * @return Details of the specific planet
     */
    public String toString(){
        return "ID: " + getId()
                + ", Planet Name: " + getName()
                + ", Mass: " + getMass()
                + ", Diameter: " + getDiameter()
                + ", Average Temperature: " + getAverageTemperature()
                + ", Surface Type: " + getSurfaceType()
                + ", Has Liquid Water: " + hasLiquidWater()
                + ", Gravity: " + String.format("%.2e", calculateGravity())
                +", " + classifyBody()
                +", " + displayInfo();
    }
}
