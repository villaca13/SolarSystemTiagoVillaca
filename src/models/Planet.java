package models;


public abstract class Planet {

    // variables
    private int id;
    private int nextId;
    private String name;
    private boolean hasLiquidWater;
    private String surfaceType;
    private double averageTemperature;
    private double mass;
    private double diameter;


    //Abstract methods
    public abstract String displayInfo();
    public abstract String classifyBody();

    // Concrete methods
    public double calculateGravity() {
        double xFactor =  Math.pow(6.67430, -11);
        return mass*xFactor/Math.pow(diameter/2,2);
    }

    // getters and setters

    // id  **********************************
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    // nextId ************************************
    public int getNextId(){
        return nextId;
    }
    public void setNextId(int nextId){
        this.nextId = nextId;
    }

    // name ***************************************
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Surface type  ****************************
    public String getSurfaceType() {
        return surfaceType;
    }
    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    // average temperature ***************************
    public double getAverageTemperature() {
        return averageTemperature;
    }
    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    // mass **************************************
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }

    // Diameter **************************************
    public double getDiameter() {
        return diameter;
    }
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    // has liquid water *************************
    public boolean isHasLiquidWater() {
        return hasLiquidWater;
    }
    public void setHasLiquidWater(boolean hasLiquidWater) {
        this.hasLiquidWater = hasLiquidWater;
    }


}
