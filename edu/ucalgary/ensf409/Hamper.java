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


    public Hamper( NutritionalItems nutritionalRequirements ){
        this.nutritionalRequirements = nutritionalRequirements;
        calcBestHamper();
    }


    public void calcBestHamper() {
        ArrayList<ArrayList<Food>> possibleCombinations = new ArrayList<ArrayList<Food>>();
        Set<Integer> keys = Inventory.inventory.keySet();
        int foodBankSize = Inventory.inventory.size();
        Integer[] keyArray = keys.toArray(new Integer[foodBankSize]);
        double minTotalCalorieDiff = Double.POSITIVE_INFINITY;
        int possibleCombinationIndex = 0;
        int minCalorieDiffCombinationIndex = 0;

        double[] requirements = new double[5];
        for(int i = 0; i<5; i++){
            requirements[i] = this.nutritionalRequirements.percentageToCalories()[i];
        }

        for(int r = 0; r<keyArray.length; r++){
            List<int[]> combinations = generate(keyArray.length,r);
            for(int[] combination : combinations) {
                int combinationSize = combination.length;
                ArrayList<Food> possibleCombination = new ArrayList<Food>();
                double[] combinationNutrition = new double[5];
                for (int i = 0; i < combinationSize; i++) {
                    Food food = Inventory.inventory.get(keyArray[i]);
                    combinationNutrition[0] = combinationNutrition[0] + food.getNutritionalItem.percentageToCalories()[0];
                    combinationNutrition[1] = combinationNutrition[1] + food.getNutritionalItem.percentageToCalories()[1];
                    combinationNutrition[2] = combinationNutrition[2] + food.getNutritionalItem.percentageToCalories()[2];
                    combinationNutrition[3] = combinationNutrition[3] + food.getNutritionalItem.percentageToCalories()[3];
                    combinationNutrition[4] = combinationNutrition[4] + food.getNutritionalItem.percentageToCalories()[4];
                    possibleCombination.add(food);
                }
                if ((combinationNutrition[0] >= requirements[0]) && (combinationNutrition[1] >= requirements[1]) &&
                        (combinationNutrition[2] >= requirements[2]) && (combinationNutrition[3] >= requirements[3])) {
                    possibleCombinations.add(possibleCombination);
                    possibleCombinationIndex++;
                    if((combinationNutrition[4] - requirements[1]) < minTotalCalorieDiff){
                        minTotalCalorieDiff = combinationNutrition[4];
                        minCalorieDiffCombinationIndex = possibleCombinationIndex;
                    }
                }
            }
        }

        if(possibleCombinations.size() == 0){
            this.isFilled = false;
            return;
        } else {
            this.foodItems = possibleCombinations.get(minCalorieDiffCombinationIndex);
            this.isFilled = true;
            for(int i = 0; i< this.foodItems.size(); i++){
                Food deletedFoodId = this.foodItems.get(i).getItemId();
                Inventory.inventory.remove(deletedFoodId);
            }
        }


    }

    //function to generate possible combination with given r for Food ID
    private List<int[]> generate(int n, int r){
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1,0);
        return combinations;
    }

    //helper function to generate combination for method generate()
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
