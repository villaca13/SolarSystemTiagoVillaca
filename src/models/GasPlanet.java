package models;

import utils.Utilities;

public class GasPlanet extends Planet{

    // Variables
    private String gasComposition;
    private String coreComposition;
    private double radiationLevel;

    /**
     * Constructor for objects of class gas Planet
     *
     * @param name Name of the planet, max 30 chars
     * @param mass mass of the planet, measured in ronnagrams earth is approx 6.0rg must be > 0.1 default to 0.1
     * @param diameter diameter of the planet, measured in kilometres must be > 0.5 default to 0.5
     * @param surfaceType surface type of the planet, e.g., “rocky”, “volcanic”, “metallic” max 20 chars
     * @param averageTemperature Average temperatur of the planet, Average surface temperature in °C must be a value between -400 and 400 default 0
     * @param hasLiquidWater if the planet has liquid water,true or false
     * @param gasComposition gas planet compositon, max 20 chars
     * @param coreComposition Must be one of Rocky and Metallic, Proportionally Small, Liquid Metallic Hydrogen Compressed Hydrogen or Ice Giant default UNKNOWN can use CoreCompositionUtility class
     * @param radiationLevel Higher in gas giant min .01 max 200.05 default .9
     *
     */
    public GasPlanet(String name, double mass, double diameter,  double averageTemperature, String surfaceType, boolean hasLiquidWater, String gasComposition, String coreComposition, double radiationLevel){
        super(name, mass, diameter, averageTemperature, surfaceType, hasLiquidWater);
        this.gasComposition = gasComposition;
        this.coreComposition = coreComposition;
        this.radiationLevel = radiationLevel;
    }
    // default values
    public GasPlanet(){
        super();
        this.gasComposition = "(20 chars)";
        this.coreComposition = "UNKNOWN";
        this.radiationLevel = 0.9;
    }



    // getters and setters
    // Gas composition **************************
    /**
     * Returns gas planet composition
     */
    public String getGasComposition() { return gasComposition; }
    /**
     * Updates the gas planet composition  to the value passed as a parameter
     * @param gasComposition The new gas planet composition
     */
    public void setGasComposition(String gasComposition) {
        this.gasComposition = gasComposition;
    }

    // Core Composition ************************************
    /**
     * Returns gas planet core composition
     */
    public String getCoreComposition() { return coreComposition; }
    /**
     * Updates the gas planet core composition  to the value passed as a parameter
     * @param coreComposition The new gas planet core composition
     */
    public void setCoreComposition(String coreComposition) {
        this.coreComposition = coreComposition;
    }

    // radiation level **************************************
    /**
     * Returns gas planet radiation level
     */
    public double getRadiationLevel() { return radiationLevel; }
    /**
     * Updates the gas planet radiation level  to the value passed as a parameter
     * @param radiationLevel The new gas planet radiation level
     */
    public void setRadiationLevel(double radiationLevel) {
        this.radiationLevel = radiationLevel;
    }


    // Methods
    public String toString(){
        return "";
    }

    // Abstract methods implemented
    @Override
    public String displayInfo() {
        return "";
    }

    @Override
    public String classifyBody() {
        return "";
    }
}
