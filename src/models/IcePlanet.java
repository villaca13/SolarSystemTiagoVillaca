package models;

public class IcePlanet extends Planet{
    // variables
    private String iceComposition;


    // Methods
    public String toString(){
        return"";
    }

    // getter and setters
    public String getIceComposition() {
        return iceComposition;
    }
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
