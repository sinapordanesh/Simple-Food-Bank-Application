package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private ArrayList<Family> families;
    private ArrayList<Food> totalFoodItems;
    private boolean passed = false;

    Order(Family[] families){
        this.families = new ArrayList<>();
        this.families.addAll(Arrays.asList(families));
    }

    public String errorMessaging(){
        StringBuilder result = new StringBuilder("");

        if (!this.passed){
            result.append("Order failed!").append("\n").append("There is not enough food on inventory. Pleae try another order, or exit.");
        } else {
            result.append("Order was placed successfully").append("\n").append("Please keep going for another order, or exit.");
        }

        return result.toString();
    }

    public ArrayList<Family> getFamilies() {
        return families;
    }

    public ArrayList<Food> getTotalFoodItems() {
        return totalFoodItems;
    }

    public boolean getPassed(){
        return passed;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    public void addFamily(Family family){
        this.families.add(family);
    }

    public void setTotalFoodItems(ArrayList<Food> list) {
        this.totalFoodItems = list;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public boolean calcHampers(){
        boolean result = true;
        for (Family family : families){
            family.getHamper().calcBestHamper();
            result = (result & family.getHamper().getIsFilled());
        }
        passed = result;
        return result;
    }


}
