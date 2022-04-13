package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private ArrayList<Family> families;
    private ArrayList<Food> totalFoodItems;
    private boolean passed = false;

    /**
     * constructor for Order class which calls an array of
     * Family objects
     * @param families : array of Family objects belong to a
     *                  specific order
     */
    Order(Family[] families){
        this.families = new ArrayList<>();
        this.families.addAll(Arrays.asList(families));
    }

    /**
     * Message formatting based on the order situation
     * @return
     */
    public String errorMessaging(){
        StringBuilder result = new StringBuilder("");

        if (!this.passed){
            result.append("Order failed!").append("\n").append("There is not enough " +
                    "food on the inventory. Please try another order, or exit.");
        } else {
            result.append("Order was placed successfully").append("\n").append("Please " +
                    "keep going for another order, or exit.");
        }

        return result.toString();
    }

    /**
     * get ArrayList of the families belong to each order
     * @return
     */
    public ArrayList<Family> getFamilies() {
        return families;
    }

    /**
     * get total food item which a specific order needs
     * @return
     */
    public ArrayList<Food> getTotalFoodItems() {
        return totalFoodItems;
    }

    /**
     * get boolean value of Passed which shows whether an order passed or not
     * @return
     */
    public boolean getPassed(){
        return passed;
    }

    /**
     * set the family ArrayList
     * @param families: an ArrayList of Family objects
     */
    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    /**
     * add a specific family to the families ArrayList
     * @param family: a Family object
     */
    public void addFamily(Family family){
        this.families.add(family);
    }

    /**
     * set totalFoodItems ArrayList
     * @param list
     */
    public void setTotalFoodItems(ArrayList<Food> list) {
        this.totalFoodItems = list;
    }

    /**
     * set the boolean Passed
     * @param passed
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    /**
     * go through all Family objects in the families ArrayList and call their hamper,
     * then call calcBestHamper() for each family. Then record their boolean result which
     * shows whether a hamper passed or not. If only one hamper couldn't pass, the whole order
     * will fail.
     * Also, through this method we will calc all hampers and place them on each Family object
     * @return : boolean result. if true, the whole order passed
     */
    public boolean calcHampers(){
        boolean result = true;
        for (Family family : families){
            family.getHamper().calcBestHamper();
            result = (result & family.getHamper().getIsFilled());
        }

        //update database if the whole order passed
        if (passed){
            for (Family family: families){
                Hamper hamper = family.getHamper();
                totalFoodItems.addAll(hamper.getFoodItems());
            }
            Inventory.removedItems.addAll(totalFoodItems);
            Inventory.updateInventory();
        }

        return result;
    }


}
