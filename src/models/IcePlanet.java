package models;

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

    // Methods
    public String toString(){
        return"";
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
        this.iceComposition = iceComposition;
    }

    // Abstract Methods Implemented
    @Override
    public String displayInfo() {
        return "";
    }

    @Override
    public String classifyBody() {
        return "";
    }
}
