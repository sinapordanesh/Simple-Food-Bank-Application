/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.3
 @since 1.0
 */

package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HamperTest {


    //***************** Test Can be Tested multiple times with modify these values *****************
    public double[] expectedNutritionalNeedsAdultMale = {16, 28, 26, 30, 2500};
    public double[] expectedNutritionalNeedsAdultFemale = {16, 28, 26, 30, 2500};
    public double[] expectedNutritionalNeedsChildrenOver8 = {21, 33, 31, 15, 2000};
    public double[] expectedNutritionalNeedsChildrenUnder8 = {21, 33, 31, 15, 1400};

    public int numAdultMale = 1;
    public int numAdultFeMale = 1;
    public int numChildUnder8 = 1;
    public int numChildOver8 = 2;
    public double [] expectedNeedsFamily = new double [4];
    public double [] expectedNeedsFamilyPercentage = new double [4];
    //**********************************************************************************************

    /**
     * helper method to create class NutritionalItems with given family members
     */

    public NutritionalItems createNutritionalItemsForFamily() {
    	
    	
        for (int i = 0; i < expectedNeedsFamily.length; i++) {

            // convert percentage form of individual family member type nutritional needs to actual value of specific nutrition type
            // sum them up and store at array
            expectedNeedsFamily[i] = (numAdultMale * expectedNutritionalNeedsAdultMale[4] * expectedNutritionalNeedsAdultMale[i] * (double)(1.0 / 100.0)*7) +
                    (numAdultFeMale * expectedNutritionalNeedsAdultFemale[4] * expectedNutritionalNeedsAdultFemale[i] * (double)(1.0 / 100.0)*7) +
                    (numChildOver8 * expectedNutritionalNeedsChildrenOver8[4] * expectedNutritionalNeedsChildrenOver8[i] * (double)(1.0 / 100.0)*7) +
                    (numChildUnder8 * expectedNutritionalNeedsChildrenUnder8[4] * expectedNutritionalNeedsChildrenUnder8[i] * (double)(1.0 / 100.0)*7);
        }

        // convert back to percentage form for that family
        for (int i = 0; i < expectedNeedsFamily.length ; i++) {
            expectedNeedsFamilyPercentage[i] = (expectedNeedsFamily[i] / (expectedNeedsFamily[0] + expectedNeedsFamily[1]
                    + expectedNeedsFamily[2] + expectedNeedsFamily[3])) * 100;
        }

        // calculate weekly calories separately
        double totalCaloriesFamily = expectedNutritionalNeedsAdultMale[4] * 7 + expectedNutritionalNeedsAdultFemale[4] * 7
                + expectedNutritionalNeedsChildrenOver8[4] * 7 + expectedNutritionalNeedsChildrenUnder8[4] * 7;


        NutritionalItems expectedNutritionalItemsFamily = new NutritionalItems(expectedNeedsFamilyPercentage[0],
                expectedNeedsFamilyPercentage[1], expectedNeedsFamilyPercentage[2], expectedNeedsFamilyPercentage[3],
                totalCaloriesFamily);

        return expectedNutritionalItemsFamily;
    }


    /**
     * Hamper(nutritionalRequirements: NutritionalItems)
     * check object created successfully or not.
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     *
     */
    @Test
    public void testHamperClassConstructor() {

        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper actualHamper = new Hamper(expectedNutritionalItemsFamily);
        assertNotNull("Hamper class was not created", actualHamper);

    }

    /**
     *  test for getNutritionalRequirement(): NutritionalItems
     *  check if it returns NutritionalItems object
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testGetNutritionalRequirements() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        NutritionalItems actualNutritionalItem = hamper.getNutritionalRequirements();
        assertNotNull("NutritionalItem class was not returned through" +
                "getNutritionalRequirement() method", actualNutritionalItem);
    }


    /**
     *  test for setNutritionalRequirement(nutritionalRequirements: NutritionalItems)
     *  check if it set NutritionalItems with right object
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetNutritionalRequirements() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        NutritionalItems expectedNutritionalItems = new NutritionalItems(10,20,30,40,500);
        hamper.setNutritionalRequirements(expectedNutritionalItems);
        NutritionalItems actualNutritionalRequirements = hamper.getNutritionalRequirements();

        double actualWholeGrains = actualNutritionalRequirements.getWholeGrains();
        double actualFruitVeggies = actualNutritionalRequirements.getFruitVeggies();
        double actualProtein = actualNutritionalRequirements.getProtein();
        double actualOthers = actualNutritionalRequirements.getOthers();
        double actualCalories = actualNutritionalRequirements.getCalories();

        double expectedWholeGrains = 10;
        double expectedFruitVeggies = 20;
        double expectedProtein = 30;
        double expectedOthers = 40;
        double expectedCalories = 500;

        assertEquals("setter for WholeGrain dose unexpected behavior",
                expectedWholeGrains, actualWholeGrains, 0);
        assertEquals("setter for FruitVeggies dose unexpected behavior",
                expectedFruitVeggies, actualFruitVeggies, 0);
        assertEquals("setter for Protein dose unexpected behavior",
                expectedProtein, actualProtein, 0);
        assertEquals("setter for Others dose unexpected behavior",
                expectedOthers, actualOthers, 0);
        assertEquals("setter for Calories dose unexpected behavior",
                expectedCalories, actualCalories, 0);
    }

    /**
     *   test for getFoodItems():ArrayList<Food>
     *   createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *   specific family with percentage form.
     */
    @Test
    public void testGetFoodItems() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        ArrayList<Food> items = new ArrayList<Food>();
        hamper.setFoodItems(items);
        ArrayList<Food> actualFoodItems = hamper.getFoodItems();
        assertNotNull("getFoodItems() dose not returned ArrayList<Food>", actualFoodItems);

    }

    /**
     *  test for setFoodItems(foodItems: ArrayList<Food>)
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetFoodItems() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();

        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        Food apple = new Food(100,"Apple",10,20,30,40,500);
        Food orange = new Food(101,"Orange",21,22,23,34,1000);
        Food grape = new Food(102,"Grape",24,33,33,10,15);

        ArrayList<Food> foods = new ArrayList<Food>();
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
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     */
    @Test
    public void testGetIsFilled() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        boolean actualIsFilled = hamper.getIsFilled();
        assertFalse("getIsFilled() was not returned correct value ",actualIsFilled);
    }

    /**
     *  test for setIsFilled(status: boolean)
     *  default value of isFilled is False
     *  createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     *  specific family with percentage form.
     */
    @Test
    public void testSetIsFilled() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Hamper hamper = new Hamper(expectedNutritionalItemsFamily);
        hamper.setIsFilled(true);
        boolean actualIsFilled = hamper.getIsFilled();
        assertTrue("setIsFilled did not update current status",actualIsFilled);
    }
    
    

    /**
     *  test for calcBestHamper()
     *  this method attempt to fill the foodItems in hamper class with most efficient way that meets nutritional requirements.
     *  if it successfully calculated best food combination with exist foods it should update the inventory and change
     *  isFilled status to true
     *  however, if it is unable to find combination of foods due to out of stock of foods in inventory, it should not
     *  update the inventory and change isFilled status to false
     */


    /**
     *  testCalcBestHamperWithEnoughFoods() is test when the inventory have enough foods
     */
    @Test
    public void testCalcBestHamperWithEnoughFoods() {

        NutritionalItems assumedNutritionalRequirementsForFamily = new NutritionalItems(10,10,10,70,1000); //100,100,100,700
        Hamper hamper = new Hamper(assumedNutritionalRequirementsForFamily);
        // ex)  NutritionalItems(15,20,20,35,1000)
        //      min nutrition  = 100,100,100,700

        //      apple =  10,10,10,70,300   --> 30,30,30,210   *3
        //      orange = 70,10,10,10,300   --> 210,30,30,30   *1
        //      grape =  10,10,10,70,100   --> 10,10,10,70    *1
        //      tuna =   10,10,10,70,500   --> 50,50,50,350   *2

        // few possible sets = 2 apple and 1 tuna --> 110,110,110,770 (1)
        //                     2 tuna                                 (2)
        // since (2) needs only 2 foods while (1) requires 3 foods this CalcBestHamperWithEnoughFoods()
        // must save two tunas into its foodItems array and delete tuna0, and tuna1 from inventory hash map and set is filled true

        HashMap<Integer, Food> smallInventory = new HashMap<Integer, Food>();

        Food apple0 = new Food(100,"Apple",10,10,10,70,300);
        Food orange0 = new Food(101,"Orange",70,10,10,10,300);
        Food grape0 = new Food(102,"Grape",10,10,10,70,100);
        Food tuna0 = new Food(103,"Tuna",10,10,10,70,500);
        Food tuna1 = new Food(104,"Tuna",10,10,10,70,500);
        Food apple1 = new Food(105,"Apple",10,10,10,70,300);
        Food apple2 = new Food(106,"Apple",10,10,10,70,300);

        smallInventory.put(100, apple0);
        smallInventory.put(101, orange0);
        smallInventory.put(102, grape0);
        smallInventory.put(103, tuna0);
        smallInventory.put(104, tuna1);
        smallInventory.put(105, apple1);
        smallInventory.put(106, apple2);
        
        Inventory.setInventory(smallInventory);


        hamper.calcBestHamper();
        // see if it deletes other foods then tuna0 and tuna1
        assertEquals("calcBestHamper() deleted wrong foods",apple0,smallInventory.get(100));
        assertEquals("calcBestHamper() deleted wrong foods",orange0,smallInventory.get(101));
        assertEquals("calcBestHamper() deleted wrong foods",grape0,smallInventory.get(102));
        assertEquals("calcBestHamper() deleted wrong foods",apple1,smallInventory.get(105));
        assertEquals("calcBestHamper() deleted wrong foods",apple2,smallInventory.get(106));

        // see if it deletes food that require to fill hamper
        assertNull("calcBestHamper() deleted wrong foods",smallInventory.get(103));
        assertNull("calcBestHamper() deleted wrong foods",smallInventory.get(104));


        // see if it fills its foodItems: ArrayList<Food>
        Food actualFoodsInArray0 = hamper.getFoodItems().get(0);
        Food actualFoodsInArray1 = hamper.getFoodItems().get(1);
        assertEquals("calcBestHamper() filled food array with wrong foods",tuna0, actualFoodsInArray0);
        assertEquals("calcBestHamper() filled food array with wrong foods",tuna1, actualFoodsInArray1);

        // see if it set isFilled to true
        assertTrue("even hamper is filled it did not set isFilled to true", hamper.getIsFilled());

    }

    /**
     *  testCalcBestHamperWithNotEnoughFoods() is test when the inventory have Not enough foods
     */
    @Test
    public void testCalcBestHamperWithNotEnoughFoods() {
        NutritionalItems assumedNutritionalRequirementsForFamily = new NutritionalItems(10,10,10,70,1000); //100,100,100,700
        Hamper hamper = new Hamper(assumedNutritionalRequirementsForFamily,1);
        //      min nutrition  = 100,100,100,700
        //      apple =  10,10,10,70,300   --> 30,30,30,210   *1
        //      orange = 70,10,10,10,300   --> 210,30,30,30   *1
        //      grape =  10,10,10,70,100   --> 10,10,10,70    *1
        //      it is not possible to form a hamper with given foods that meets minimum requirement

        Food apple0 = new Food(100,"Apple",10,10,10,70,300);
        Food orange0 = new Food(101,"Orange",70,10,10,10,300);
        Food grape0 = new Food(102,"Grape",10,10,10,70,100);

        HashMap<Integer, Food> smallInventory = new HashMap<Integer, Food>();
        smallInventory.put(100, apple0);
        smallInventory.put(101, orange0);
        smallInventory.put(102, grape0);
        
        Inventory.setInventory(smallInventory);

        hamper.calcBestHamper();

        // see if it deletes foods even hamper cannot be filled (which should not)
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",apple0,smallInventory.get(100));
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",orange0,smallInventory.get(101));
        assertEquals("calcBestHamper() deleted foods when hamper could not filled",grape0,smallInventory.get(102));

        // see if it fills its foodItems: ArrayList<Food> even hamper cannot be filled (which should not)
        assertNull("calcBestHamper() filled its array of foods when hamper could not filled",
                hamper.getFoodItems());

        // see if it set isFilled is still false
        boolean status = hamper.getIsFilled();
        assertFalse("even hamper cannot be filled, the status is true", status);

    }
    
    /**
     *  test for Hamper constructor throws exceptions when it gets invalid input
     */
    @Test
    public void testHamperConstructorThrowsExceptions() {
    	boolean isPassed = true;
    	
    	NutritionalItems zero = new NutritionalItems(10,10,10,70,100);
    	zero = null;
    	try {
        	Hamper hamper = new Hamper(zero);
    	} catch (NullPointerException e) {
    		isPassed = false;
    	}
    	assertFalse("Hamper constructor did not throw execptions when user entered invaild input", isPassed);

    }

}
