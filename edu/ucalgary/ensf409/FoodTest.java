package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;


/**
 @author Saman Pordanesh <a href="mailto:saman.pordanesh@ucalgary.ca">
 saman.pordanesh@ucalgary.ca</a>
 @UCID 30127440
 @version 1.1
 @since 1.0
 */

public class FoodTest {

    private NutritionalItems nutritionalItems = new NutritionalItems(10,
            20, 30, 40, 1000);
    private Food food = new Food(12, "apple", 0, 30, 0, 70, 1000);

    /**
     * Food(id: int, name: String, wG:int, fV:int, p:int, o:int, c:int)
     * is called with 5 arguments and check whether object created successfully or not.
     */
    @Test
    public void testFoodClassConstructor(){

        Food food = new Food(23, "fish", 70 , 0, 30, 0, 1000);
        assertNotNull("Food constructor did not create an object when given a " +
                "valid array of log entries.", food);
    }

//    /**
//     * Food(id: int, name: String, wG:int, fV:int, p:int, o:int, c:int)
//     * is called with 5 arguments and check whether object created successfully or not and
//     * catch any IllegalArgumentException if we passed any bad argument.
//     */
//    @Test
//    public void testFoodClassConstructorInvalidData(){
//        boolean throwException = false;
//
//        try {
//            Food food = new Food("23", "fish", 70 , 0, 30, 0, 1000);
//        } catch (IllegalArgumentException e){
//            throwException = true;
//        }
//
//        assertTrue("Food constructor did not throw an IllegalArgumentException " +
//                "when given an invalid integer arguments!", throwException);
//    }

    /**
     * Food(id: int, name: String, wG:int, fV:int, p:int, o:int, c:int) is called
     * with 5 arguments.
     * getItemId() returns the correct integer itemId
     */
    @Test
    public void testGetItemId(){
        int expectedId = 12;
        int realId = this.food.getItemId();
        assertEquals("Method getItemId did not return the expected result:"
                , expectedId, realId);
    }

    /**
     * Food(id: int, name: String, wG:int, fV:int, p:int, o:int, c:int) is called
     * with 5 arguments.
     * getName() returns the correct string name of item
     */
    @Test
    public void testGetName(){
        String expectedName = "apple";
        String realName = this.food.getName();
        assertEquals("Method GetName did not return the expected result:",
                expectedName, realName);
    }

    /**
     * Food(id: int, name: String, wG:int, fV:int, p:int, o:int, c:int) is called
     * with 5 arguments.
     * getNutritionalNeeds() returns the correct NutritionalItems object, corresponding
     * to each Food object
     */
    @Test
    public void testGetNutritionalItems(){
        NutritionalItems expectedNutritionalItems = new NutritionalItems(10
                , 20, 30, 40, 1000);
        Food food = new Food(43, "beef", 10, 20, 30, 40, 1000);
        NutritionalItems realNutritionalItems = food.getNutritionalItems();

        boolean testSameItems = true;
        if (expectedNutritionalItems.getWholeGrains() != realNutritionalItems.getWholeGrains()){
            testSameItems = false;
        } else if (expectedNutritionalItems.getFruitVeggies() != realNutritionalItems.getFruitVeggies()){
            testSameItems = false;
        } else if (expectedNutritionalItems.getProtein() != realNutritionalItems.getProtein()){
            testSameItems = false;
        } else if (expectedNutritionalItems.getOthers() != realNutritionalItems.getOthers()){
            testSameItems = false;
        } else if (expectedNutritionalItems.getCalories() != realNutritionalItems.getCalories()){
            testSameItems = false;
        }

        assertTrue("Method getNutritionaItems did not return the expected object", testSameItems);
    }

}
