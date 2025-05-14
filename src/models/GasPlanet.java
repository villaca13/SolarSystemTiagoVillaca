package models;

public class GasPlanet extends Planet{

    // Variables
    private String gasComposition;
    private String coreComposition;
    private double radiationLevel;

    // getters and setters
    // Gas composition **************************
    public String getGasComposition() {
        return gasComposition;
    }
    public void setGasComposition(String gasComposition) {
        this.gasComposition = gasComposition;
    }

    // Core Composition ************************************
    public String getCoreComposition() {
        return coreComposition;
    }
    public void setCoreComposition(String coreComposition) {
        this.coreComposition = coreComposition;
    }

    // radiation level **************************************
    public double getRadiationLevel() {
        return radiationLevel;
    }
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
