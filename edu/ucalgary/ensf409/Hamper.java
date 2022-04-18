/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

package edu.ucalgary.ensf409;
import java.util.*;

public class Hamper {
    private NutritionalItems nutritionalRequirements;
    private ArrayList<Food> foodItems;
    private boolean isFilled = false;


    /**
     * Constructor for Hamper Class
     * @param nutritionalRequirements: Minimum Nutritional Requirements for single Family
     */
    public Hamper( NutritionalItems nutritionalRequirements ) throws NullPointerException {
    	if(nutritionalRequirements == null) {
    		throw new NullPointerException();
    	}
        this.nutritionalRequirements = nutritionalRequirements;
        calcBestHamper();
    }
    
    public Hamper( NutritionalItems nutritionalRequirements, int test) throws NullPointerException {
    	if(nutritionalRequirements == null) {
    		throw new NullPointerException();
    	}
    	this.nutritionalRequirements = nutritionalRequirements;
    }

    /**
     *  calculate best hamper and store foods into foodItem based on Nutritional Requirements
     */
    public void calcBestHamper() {

    	
        //possible food combinations
        ArrayList<ArrayList<Food>> possibleCombinations = new ArrayList<ArrayList<Food>>();
        //set of keys (Food ID)
        Set<Integer> keys = Inventory.inventory.keySet();
        //size of food lists
        int foodBankSize = Inventory.inventory.size();
        //change key set into array, so we can track the index
        Integer[] keyArray = keys.toArray(new Integer[foodBankSize]);
        //variable to record most efficient hamper
        double minTotalCalorieDiff = Double.POSITIVE_INFINITY;
        //variable to track combination to record
        int possibleCombinationIndex = -1;
        //variable that indicates current most efficient combination
        int minCalorieDiffCombinationIndex = 0;

        //create array that represent minimum nutrition requirement for single family
        double[] requirements = new double[5];
        for(int i = 0; i<5; i++){
            requirements[i] = this.nutritionalRequirements.percentageToCalories()[i];
        }

        //in nCr, n is fixed to total number of foods in food bank, r increments from 0
        for(int r = 0; r<keyArray.length; r++){
            // combinations = possible combinations for keyArray index for nCr where r can be differed
            List<int[]> combinations = generate(keyArray.length,r);
            // loop through combinations for specific r
            for(int[] combination : combinations) {
                //length of each combination in set of combinations for specific r
                int combinationSize = combination.length;
                //food list for each combination
                ArrayList<Food> possibleCombination = new ArrayList<Food>();
                //calorie form of each combination's nutrition
                double[] combinationNutrition = new double[5];
                //looping through combination's index from 0
                for (int i = 0; i < combinationSize; i++) {
                    //keyArray[i]: returns actual key that corresponds for index i, so food stores Food variable for key
                    Food food = Inventory.inventory.get(keyArray[combination[i]]);
                    //foodNutrition = NutritionalItems for single food (percentage form)
                    NutritionalItems foodNutrition = food.getNutritionalItems();
                    //add each nutrition types
                    combinationNutrition[0] = combinationNutrition[0] + foodNutrition.percentageToCalories()[0];
                    combinationNutrition[1] = combinationNutrition[1] + foodNutrition.percentageToCalories()[1];
                    combinationNutrition[2] = combinationNutrition[2] + foodNutrition.percentageToCalories()[2];
                    combinationNutrition[3] = combinationNutrition[3] + foodNutrition.percentageToCalories()[3];
                    combinationNutrition[4] = combinationNutrition[4] + foodNutrition.percentageToCalories()[4];
                    possibleCombination.add(food);
                }
                // if every nutrition type for that combination meets minimum requirement for single family
                // add that combination into possibleCombinations and if that combination also have minimum waste
                // update most efficient combination index to that combination index
                if ((combinationNutrition[0] >= requirements[0]) && (combinationNutrition[1] >= requirements[1]) &&
                        (combinationNutrition[2] >= requirements[2]) && (combinationNutrition[3] >= requirements[3])) {
                    possibleCombinations.add(possibleCombination);
                    possibleCombinationIndex++;
                    double comNut = combinationNutrition[4];
                    if((combinationNutrition[4] - requirements[4]) < minTotalCalorieDiff){
                        minTotalCalorieDiff = combinationNutrition[4]- requirements[4];
                        minCalorieDiffCombinationIndex = possibleCombinationIndex;
                        
                    }
                }
            }
        }

        //if could not found possible combinations, set isFilld to false and return
        //else set isFilld to true and store foods in that combinations into foodItems and remove these into Inventory
        if(possibleCombinations.size() == 0){
            this.isFilled = false;
            return;
        } else {
            this.foodItems = possibleCombinations.get(minCalorieDiffCombinationIndex);
            this.isFilled = true;
            for(int i = 0; i< this.foodItems.size(); i++){
                Food deletedFood = this.foodItems.get(i);
                int deletedFoodId = deletedFood.getItemId();
                Inventory.inventory.remove(deletedFoodId);
            }
        }
    }

    /**
     * List<int[]> generate(int n, int r)
     * @param n : number of elements
     * @param r : choose r
     * function to generate possible combination with given r for Food ID (key) index
     */
    private List<int[]> generate(int n, int r){
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1,0);
        return combinations;
    }

    /**
     * helper function to generate combination for method generate()
     */
    private void helper(List<int[]> combinations, int data[], int start, int end, int index){
        if(index == data.length){
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data,start+1, end, index+1);
            helper(combinations, data,start+1, end, index);
        }

    }


    /**
     * ---------------------- getters ------------------------
     * NutritionalItems getNutritionalRequirements(): NutritionalItems
     * ArrayList<Food> getFoodItems(): ArrayList<Food>
     * boolean getIsFilled(): boolean
     */
    public NutritionalItems getNutritionalRequirements(){ return this.nutritionalRequirements; }
    public ArrayList<Food> getFoodItems(){ return this.foodItems; }
    public boolean getIsFilled(){ return this.isFilled; }

    /**
     * ---------------------- setters ------------------------
     * setNutritionalRequirements( NutritionalItems: nutritionalRequirements )
     * setFoodItems( ArrayList<Food>: foodItems )
     * setIsFilled( boolean: status )
     */
    public void setNutritionalRequirements( NutritionalItems nutritionalRequirements){
        this.nutritionalRequirements = nutritionalRequirements;
    }

    public void setFoodItems( ArrayList<Food> foodItems ){ this.foodItems = foodItems; }
    public void setIsFilled( boolean status ){ this.isFilled = status; }


}
