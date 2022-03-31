package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TestHamperClass {

     /**
      @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
      jinsu.kwak@ucalgary.ca</a>
      @UCID 30097737
      @version 1.0
      @since 1.0
      */

     //***************** Test Can be Tested multiple times with modify these values *****************
     public int[] expectedNutritionalNeedsAdultMale = {16, 28, 26, 30, 2500};
     public int[] expectedNutritionalNeedsAdultFemale = {16, 28, 26, 30, 2500};
     public int[] expectedNutritionalNeedsChildrenOver8 = {21, 33, 31, 15, 2000};
     public int[] expectedNutritionalNeedsChildrenUnder8 = {21, 33, 31, 15, 1400};

     public int numAdultMale = 2;
     public int numAdultFeMale = 1;
     public int numChildUnder8 = 1;
     public int numChildOver8 = 1;
     public int[] expectedNeedsFamily = new int[5];
     //**********************************************************************************************
     /**
      *  im not sure why it gives me an error message here
      */
    for (int i = 0; i < expectedNutritonalNeedsAdultMale.length-1 ; i++){
          expectedNeedsFamily[i] = (numAdultMale * expectedNutritionalNeedsAdultMale[i]) +
                  (numAdultFeMale * expectedNutritionalNeedsAdultFemale[i]) +
                  (numChildOver8 * expectedNutritionalNeedsChildrenOver8[i]) +
                  (numChildUnder8 * expectedNutritionalNeedsChildrenUnder8[i]);
     }

     NutritionalItems expectedNutritionalItemsFamily = new NutritionalItems(expectedNeedsFamily[0], expectedNeedsFamily[1],
             expectedNeedsFamily[2],expectedNeedsFamily[3],expectedNeedsFamily[4]);

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
          NutritionalItems expectedNutritionalItems = new NutritionalItems(1,2,3,4,5);
          hamper.setNutritionalRequirements(expectedNutritionalItems);
          NutritionalItems actualNutritionalRequirements = hamper.getNutritionalRequirements();

          int actualWholeGrains = actualNutritionalRequirements.getWholeGrains();
          int actualFruitVeggies = actualNutritionalRequirements.getFruitVeggies();
          int actualProtein = actualNutritionalRequirements.getProtein();
          int actualOthers = actualNutritionalRequirements.getOthers();
          int actualCalories = actualNutritionalRequirements.getCalories();

          int expectedWholeGrains = 1;
          int expectedFruitVeggies = 2;
          int expectedProtein = 3;
          int expectedOthers = 4;
          int expectedCalories = 5;

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
          Food apple = new Food(100,"Apple",1,2,3,4,5);
          Food orange = new Food(101,"Orange",6,7,8,9,10);
          Food grape = new Food(102,"Grape",11,12,13,14,15);

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
      *  however, if it unable to find combination of foods due to out of stock of foods in inventory, it should
      *  update the inventory but change isFilled status to false
      */
     @Test
     public void testCalcBestHamperWithEnoughFoods() {

     }

    @Test
    public void testCalcBestHamperWithNotEnoughFoods() {

    }

}
