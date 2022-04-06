package edu.ucalgary.ensf409;

public class Hamper {
    private NutritionalItems nutritionalRequirements;
    private ArrayList<Food> foodItems;
    private boolean isFilled = false;

    public Hamper( NutritionalItems nutritionalRequirements ){
        this.nutritionalRequirements = nutritionalRequirements;
        calcBestHamper();
    }

    // will be implemented in the future, We need to discuss about definition of "best hamper"
    public void calcBestHamper() {

    }

    //getters
    public NutritionalItems getNutritionalRequirements(){ return this.nutritionalRequirements; }
    public ArrayList<Food> getFoodItems(){ return this.foodItems; }
    public boolean getIsFilled(){ return this.isFilled; }

    //setters
    //UML argument name should be changed
    public void setNutritionalRequirements( NutritionalItems nutritionalRequirements){
        this.nutritionalRequirements = nutritionalRequirements;
    }
    public void setFoodItems( ArrayList<Food> foodItems ){ this.foodItems = foodItems; }
    public void setIsFilled( boolean status ){ this.isFilled = status; }
}
