/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HamperClassTest {


    //***************** Test Can be Tested multiple times with modify these values *****************
    public int[] expectedNutritionalNeedsAdultMale = {16, 28, 26, 30, 2500};
    public int[] expectedNutritionalNeedsAdultFemale = {16, 28, 26, 30, 2500};
    public int[] expectedNutritionalNeedsChildrenOver8 = {21, 33, 31, 15, 2000};
    public int[] expectedNutritionalNeedsChildrenUnder8 = {21, 33, 31, 15, 1400};

    public int numAdultMale = 1;
    public int numAdultFeMale = 1;
    public int numChildUnder8 = 1;
    public int numChildOver8 = 2;
    public int[] expectedNeedsFamily = new int[4];
    public int[] expectedNeedsFamilyPercentage = new int[4];
    //**********************************************************************************************
    /**
     *  im not sure why it gives me an error message here
     */
    for (int i = 0; i < expectedNeedsFamily.length-1 ; i++){
        expectedNeedsFamily[i] = (numAdultMale * expectedNutritionalNeedsAdultMale[4]*expectedNutritionalNeedsAdultMale[i]*(1/100)) +
                (numAdultFeMale * expectedNutritionalNeedsAdultFemale[4]*expectedNutritionalNeedsAdultFemale[i]*(1/100)) +
                (numChildOver8 * expectedNutritionalNeedsChildrenOver8[4]*expectedNutritionalNeedsChildrenOver8[i]*(1/100)) +
                (numChildUnder8 * expectedNutritionalNeedsChildrenUnder8[4]*expectedNutritionalNeedsChildrenUnder8[i]*(1/100));
    }

    for(int i = 0 ; i < expectedNeedsFamily.length-1 ; i ++){
        expectedNeedsFamilyPercentage[i] = (expectedNeedsFamily[i]/(expectedNeedsFamily[0]+ expectedNeedsFamily[1]
                +expectedNeedsFamily[2]+expectedNeedsFamily[3]))*100;
    }

    int totalCaloriesFamily = expectedNutritionalNeedsAdultMale[4] + expectedNutritionalNeedsAdultFemale[4]
            + expectedNutritionalNeedsChildrenOver8[4] + expectedNutritionalNeedsChildrenUnder8[4];


    NutritionalItems expectedNutritionalItemsFamily = new NutritionalItems(expectedNeedsFamilyPercentage[0],
            expectedNeedsFamilyPercentage[1], expectedNeedsFamilyPercentage[2],expectedNeedsFamilyPercentage[3],
            totalCaloriesFamily);

    /**
     * Hamper(nutritionalRequirements: NutritionalItems)
     * check object created successfully or not.
     */
    @Test
    public void testFamilyClassConstructor() {
        Hamper actualHamper = new Hamper(expectedNutritionalItemsFamily);
        assertNotNull("Hamper class was not created", actualHamper);

    }

    /**
     *  test for getNutritionalRequirement(): NutritionalItems
     *  check if it returns NutritionalItems object
     */
    @Test
    public void testGetNutritionalRequirements() {
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        NutritionalItems actualNutritionalItem = hamper.getNutritionalRequirements();
        assertNotNull("NutritionalItem class was not returned through" +
                "getNutritionalRequirement() method", actualNutritionalItem);
    }


    /**
     *  test for setNutritionalRequirement(nutritionalRequirements: NutritionalItems)
     *  check if it set NutritionalItems with right object
     */
    @Test
    public void testSetNutritionalRequirements() {
        Hamper hamper = new hamepr(expectedNutritionalItemsFamily);
        NutritionalItems expectedNutritionalItems = new NutritionalItems(10,20,30,40,500);
        hamper.setNutritionalRequirements(expectedNutritionalItems);
        NutritionalItems actualNutritionalRequirements = hamper.getNutritionalRequirements();

        int actualWholeGrains = actualNutritionalRequirements.getWholeGrains();
        int actualFruitVeggies = actualNutritionalRequirements.getFruitVeggies();
        int actualProtein = actualNutritionalRequirements.getProtein();
        int actualOthers = actualNutritionalRequirements.getOthers();
        int actualCalories = actualNutritionalRequirements.getCalories();

        int expectedWholeGrains = 10;
        int expectedFruitVeggies = 20;
        int expectedProtein = 30;
        int expectedOthers = 40;
        int expectedCalories = 500;

        assertEquals("setter for WholeGrain dose unexpected behavior",
                expectedWholeGrains, actualWholeGrains);
        assertEquals("setter for FruitVeggies dose unexpected behavior",
                expectedFruitVeggies, actualFruitVeggies);
        assertEquals("setter for Protein dose unexpected behavior",
                expectedProtein, actualProtein);
        assertEquals("setter for Others dose unexpected behavior",
                expectedOthers, actualOthers);
        assertEquals("setter for Calories dose unexpected behavior",
                expectedCalories, actualCalories);
    }

    /**
     *   test for getFoodItems():ArrayList<Food>
     */
    @Test
    public void testGetFoodItems() {

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        ArrayList<Food> actualFoodItems = hamper.getFoodItems();
        assertNotNull("getFoodItems() dose not returned ArrayList<Food>", actualFoodItem);

    }

    /**
     *  test for setFoodItems(foodItems: ArrayList<Food>)
     */
    @Test
    public void testSetFoodItems() {

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        Food apple = new Food(100,"Apple",10,20,30,40,500);
        Food orange = new Food(101,"Orange",21,22,23,34,1000);
        Food grape = new Food(102,"Grape",24,33,33,10,15);

        Arraylist<Food> foods = new ArrayList<Food>();
        foods.add(apple);
        foods.add(orange);
        foods.add(grape);
        hamper.setFoodItems(foods);

        int ActualAppleId = hamper.getFoodItems().get(0).getItemId();
        String ActualAppleName = hamper.getFoodItems().get(0).getName();
        int ActualOrangeId = hamper.getFoodItems().get(1).getItemId();
        String ActualOrangeName = hamper.getFoodItems().get(1).getName();
        int ActualGrapeId = hamper.getFoodItems().get(2).getItemId();
        String ActualGrapeName = hamper.getFoodItems().get(2).getName();

        int expectedAppleId = 100;
        String expectedAppleName = "Apple";
        int expectedOrangeId = 101;
        String expectedOrangeName = "Orange";
        int expectedGrapeId = 102;
        String expectedGrapeName = "Grape";

        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedAppleId, ActualAppleId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedAppleName, ActualAppleName);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedOrangeId, ActualOrangeId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedOrangeName, ActualOrangeName);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedGrapeId, ActualGrapeId);
        assertEquals("setter for FoodItems dose unexpected behavior",
                expectedGrapeName, ActualGrapeName);

    }

    /**
     * test for getIsFilled(): boolean
     * which indicates this hamper can be filled(meet nutrition requirement) with current foods in inventory
     * and, it's default value is False
     */
    @Test
    public void testGetIsFilled() {
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        boolean actualIsFilled = hamper.getIsFilled();
        assertTrue("getIsFilled() was not returned correct value ",actualIsFilled);
    }

    /**
     *  test for setIsFilled(status: boolean)
     *  default value of isFilled is False
     */
    @Test
    public void testSetIsFilled() {
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        hamper.setIsFilled(true);
        boolean actualIsFilled = hamper.getIsFilled();
        assertFalse("setIsFilled did not update current status",actualIsFilled);
    }

    /**
     *  test for calcBestHamper()
     *  this method attempt to fill the foodItems in hamper class with most efficient way that meets nutritional requirements.
     *  if it successfully calculated best food combination with exist foods it should update the inventory and change
     *  isFilled status to true
     *  however, if it unable to find combination of foods due to out of stock of foods in inventory, it should not
     *  update the inventory and change isFilled status to false
     */

    /**
     * setInventory req
     */
    @Test
    public void testCalcBestHamperWithEnoughFoods() {


        NutritionalItems assumedNutritionalRequirementsForFamily = new NutritionalItems(15,20,27,38,6000); //900,1200,1620,2280
        Hamper hamper = new Hamper(assumedNutritionalRequirementsForFamily);

        /**
         *  we need a definition of efficient hamper to test this method
         *  1. find set of foods that have maximum of +20% of each nutrition's per family  Y1/N1
         *
         *  Y1. find set that have minimum quantity of foods (hamper filled) ** if it has to be the most efficient we must compare every
         *      single sets and check % diff here to confirm hamper
         *
         *  N1. if we could not find set that fit in maximum of 20% range, then find set that exceed 20% Y2/N2
         *
         *  Y2. set that exceed 20% food set (hamper filled) ** if it has to be the most efficient we must compare every
         *      single sets and check % diff here to confirm hamper
         *
         *  N2. could not find food set (hamper is not filled)
         */
        // ex)  NutritionalItems(15,20,27,38,6000)
        //      min nutrition  = 900,1200,1620,2280
        //      min +20% range = 1080,1440,1944,2736
        //      apple = 70,140,210,280
        //      orange = 0,0,330,670
        //      grape = 1125,0,21,60
        //      tuna = 620,1160,220,0

        // one possible sets =


        minWholeGrains = (15/100)*6000;
        minFruitsVeggies = (20/100)*6000;
        minProtein = (27/100)*6000;
        minOther = (38/100)*6000;

        HashMap<Integer, Food> smallInventory = new HashMap<Food>();
        Inventory.setInventory = smallInventory;

        Food apple0 = new Food(100,"Apple",10,20,30,40,700); //70,140,210,280
        Food orange0 = new Food(101,"Orange",0,0,33,67,1000);//0,0,330,670
        Food grape0 = new Food(102,"Grape",75,0,21,4,1500);  //1125,0,21,60
        Food tuna0 = new Food(103,"Tuna",31,58,11,0,2000);   //620,1160,220,0
        Food apple1 = new Food(104,"Apple",10,20,30,40,700);
        Food orange1 = new Food(105,"Orange",0,0,33,67,1000);
        Food grape1 = new Food(106,"Grape",75,0,21,4,1500);
        Food tuna1 = new Food(107,"Tuna",31,58,11,0,2000);
        Food apple2 = new Food(108,"Apple",10,20,30,40,700);
        Food orange2 = new Food(109,"Orange",0,0,33,67,1000);
        Food grape2 = new Food(110,"Grape",75,0,21,4,1500);
        Food tuna2 = new Food(111,"Tuna",31,58,11,0,2000);

        smallInventory.put(100, apple0);
        smallInventory.put(101, orange0);
        smallInventory.put(102, grape0);
        smallInventory.put(103, tuna0);
        smallInventory.put(104, apple1);
        smallInventory.put(105, orange1);
        smallInventory.put(106, grape1);
        smallInventory.put(107, tuna1);
        smallInventory.put(108, apple2);
        smallInventory.put(109, orange2);
        smallInventory.put(110, grape2);
        smallInventory.put(111, tuna2);

        hamper.calcBestHamper();



    }

    @Test
    public void testCalcBestHamperWithNotEnoughFoods() {

    }

}
