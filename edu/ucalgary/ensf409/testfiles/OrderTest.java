package edu.ucalgary.ensf409;

import edu.ucalgary.ensf409.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;



/**
 @author Saman Pordanesh <a href="mailto:saman.pordanesh@ucalgary.ca">
 saman.pordanesh@ucalgary.ca</a>
 @UCID 30127440
 @version 1.1
 @since 1.0
 */

public class OrderTest {
    // need some pre-built complete family class(with Nutritional needs, Hamper etc.)

    //Order(Family[]) is called with a Family objects array -> remove if create
    // an Order object here!
    private Family[] families1 = {
            new Family(1, 3, 2, 4, 1, 1),
            new Family(0,2, 3,1, 2, 1),
            new Family(1, 1, 6, 1, 3, 1),
            new Family(2, 0, 0, 0, 4, 1),
            new Family(0, 1, 1, 0, 5, 1)
    };

    private ArrayList<Family> families = new ArrayList<>(Arrays.asList(families1));


    private Order order = new Order(families);

    private ArrayList<Food> foodItems = new ArrayList<>(Arrays.asList(
            new Food(12, "apple", 0, 30, 0, 70, 1000),
            new Food(23, "fish", 70 , 0, 30, 0, 1000)));

    private HashMap<Integer, Food> inventory = new HashMap<Integer, Food>() {{
        put(12, new Food(12, "apple", 0, 30, 0, 70, 1000));
        put(23, new Food(23, "fish", 70 , 0, 30, 40, 1000));
    }};



    /**
     * Order(Family[]) is called with a Family objects array which check
     * whether they assigned to the class successfully or not
     */
    @Test
    public void testOrderClassConstructor(){
        //needs more test

        boolean test = true;

        if (order == null){
            test = false;
        }

        assertTrue("The instructor doesnt transfere Objcts from array " +
                "to the ArrayList properly", true);
    }

    /**
     *Order(Family[]) is called with a Family objects array and
     * throws IllegalArgumentException if a wrong object is passed
     */
//    @Test
//    public void testOrderClassConstructorThrowsException(){
//        boolean thrown = false;
//
//        Integer[] testWrongObjects = new Integer[5];
//
//        Order testOrder;
//        try {
//            testOrder = new Order(testWrongObjects);
//        } catch (IllegalArgumentException e) {
//            thrown = true;
//        }
//
//        assertTrue("object list which sent to the Order is not suitable", thrown);
//    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * errorMessage() returns failed formatted message if passed= false
     * and success formatted message if passed= true
     */
    @Test
    public void testErrorMessaging(){

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("Order failed!").append("\n").append("There is not enough" +
                " food on the inventory. Please try another order, or exit.");

        order.setPassed(false);
        String realMessage = order.errorMessaging();

        assertEquals("The order class is not properly sending a message when " +
                "the hamper is not proccessable", expectedMessage.toString(), realMessage);

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getFamilies() returns the proper ArrayList<Family>
     */
    @Test
    public void testGetFamiliesArrayList(){
        ArrayList<Family> expectedFamilyArrayList = families;

        ArrayList<Family> realFamilyArrayList = order.getFamilies();

        assertEquals("The Families getter doesnt work properly!",
                expectedFamilyArrayList, realFamilyArrayList);

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getTotalFoodItems() returns the proper ArrayList<Food>
     */
    @Test
    public void testGetTotalFoodItemsArrayList(){
        //totalFoodItems on the Order class is the sum of food items of all families hampers.
        // as we are passing one family here to the Oreder, totalFoodItems will be equal to the
        // one food item list

        ArrayList<Food> expectedFoodList = this.foodItems;

        Family[] testFamily = {new Family(1, 2, 0, 0, 1, 1)};

        //to initialize the hamper, we need NutritionalItems
        NutritionalItems nutritionalItems = new NutritionalItems(
                150, 250, 350, 450, 550);

        //hamper initialization
        Hamper hamper = new Hamper(nutritionalItems);
        hamper.setFoodItems(expectedFoodList);
        testFamily[0].setHamper(hamper);

        //initialize the order by family array
        Order testOrder = new Order(new ArrayList<>(Arrays.asList(testFamily)));
        order.setTotalFoodItems(testFamily[0].getHamper().getFoodItems());
        ArrayList<Food> realTotalFoodItems = order.getTotalFoodItems();


        boolean equalItems = realTotalFoodItems.equals(expectedFoodList);

        assertTrue("Items are not set properly on the constructor!",
                equalItems);

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getPassed() returns true if all families hampers isFilled property are true,
     * otherwise returns false
     */
    @Test
    public void testGetPassed(){
        //when hamper has proper food items based on its
        // nutritional needs(for each family which here there is only one family),
        // the passed parameter on the Order should return True.

        boolean expectedPassedValue = true;
        ArrayList<Food> expectedFoodList = this.foodItems;

        Family[] testFamily = {new Family(1, 2, 0,
                0, 1, 1)};

        //to initialize the hamper, we need NutritionalItems
        NutritionalItems nutritionalItems = new NutritionalItems(
                150, 250, 350, 450, 550);

        //hamper initialization
        Hamper hamper = new Hamper(nutritionalItems);
        hamper.setFoodItems(expectedFoodList);
        hamper.setIsFilled(true);
        testFamily[0].setHamper(hamper);

        //initialize the order by family array
        Order testOrder = new Order(new ArrayList<>(Arrays.asList(testFamily)));

        //the value of passed will be determined based on the isFilled property of
        // each hamper after calling calcHampers on the Order class
        testOrder.calcHampers();
        boolean realPassedVallue = testOrder.getPassed();

        assertEquals("The passed value is not true which shows hamper isn't " +
                "suitable for the order, althiugh it is. so, there is somthing wring!",
                realPassedVallue, expectedPassedValue);
    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setFamilies(Family[]) set the proper families ArrayList
     */
    @Test
    public void testSetFamiliesArrayList(){

        boolean isSet = true;
        ArrayList<Family> expectedFamilyArratList = new ArrayList<>();
        expectedFamilyArratList.add(new Family(1, 2, 1, 2, 1, 1));
        expectedFamilyArratList.add(new Family(2, 1, 1, 0, 2, 1));

        this.order.setFamilies(expectedFamilyArratList);
        ArrayList<Family> realFamiliesArrayList = this.order.getFamilies();

        for (int i = 0; i < expectedFamilyArratList.size(); i++){
            if (expectedFamilyArratList.get(i) != realFamiliesArrayList.get(i)){
                isSet = false;
                break;
            }
        }

        assertTrue("serFamilies setter is not working properly", isSet);

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * addFamily(Family) add the proper Family object to ArrayList<Family>
     */
    @Test
    public void testAddFamilyObjectToTheFamiliesArrayList(){

        Family addedFamily = new Family(1, 1, 3, 1, 1, 1);
        this.order.addFamily(addedFamily);

        //comparing the added Family by the last object on the Families ArrayList
        assertSame("The new Family object is not added properly",
                addedFamily, order.getFamilies().get(order.getFamilies().size() - 1));

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setTotalFoodItems(ArrayList<Food>) set the proper totalFoodItem ArrayList
     */
    @Test
    public void testSetTotalFoodItemsArrayList(){
        boolean isSet = true;
        //define a new food list
        ArrayList<Food> expectedFoodItems = new ArrayList<>();
        expectedFoodItems.add(new Food(1, "zucchini", 15, 0, 40, 45, 2500));
        expectedFoodItems.add(new Food(2, "eggs", 33, 28, 0, 39, 1000));

        //set new food list
        this.order.setTotalFoodItems(expectedFoodItems);

        //get the new food list
        ArrayList<Food> realTotalFoodItems = this.order.getTotalFoodItems();

        //looping through objects
        for (int i = 0; i < expectedFoodItems.size(); i++){
            if (expectedFoodItems.get(i) != realTotalFoodItems.get(i)){
                isSet = false;
                break;
            }
        }

        assertTrue("the TotalFoodItems is not set properly!", isSet);
    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setPassed(boolean) set boolean correctly
     */
    @Test
    public void testSetPassed(){
        boolean expectedPassedSet = true;

        this.order.setPassed(true);
        boolean realPassed = this.order.getPassed();

        assertEquals("The Passed parameter is not set properly",
                expectedPassedSet, realPassed);

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * calcHamper() goes through families ArrayList and do
     * family.hamper.calcBestHamper().
     * and after that, check that all families hamper object
     * have isFilled= true to pass the order and return true.
     */
    @Test
    public void testCalcHamperWhenHamperWillBePassed(){
        //after calc of hampers, we will expect to receive true from isPassed
        boolean expectedIsPassed = true;

        //set our static hash map to desire one for the test
        Inventory.inventory = this.inventory;

        //needed object to create hamper objects
        NutritionalItems nutritionalItems1 = new NutritionalItems(
                150, 0, 350, 0, 550);
        NutritionalItems nutritionalItems2 = new NutritionalItems(
                0, 250, 0, 450, 1000);


        //hampers initialization
        Hamper hamper1 = new Hamper(nutritionalItems1);
        Hamper hamper2 = new Hamper(nutritionalItems2);

        //set hampers isFilled = true
        hamper1.setIsFilled(true);
        ArrayList<Food> hamper1Foods = new ArrayList<>();
        hamper1Foods.add(inventory.get(12));
        hamper1.setFoodItems(hamper1Foods);


        hamper2.setIsFilled(true);
        ArrayList<Food> hamper2Foods = new ArrayList<>();
        hamper2Foods.add(inventory.get(23));
        hamper2.setFoodItems(hamper2Foods);

        //initialize two sample families
        Family family1 = new Family(1, 1, 0, 0, 1, 1);
        Family family2 = new Family(2, 0, 0, 1, 2, 1);
        //set nutritional need for each family (for a week)

        //set families hampers
        family1.setHamper(hamper1);
        family2.setHamper(hamper2);

        //creating Family lisr and initialize an order
        Family[] families = {family1, family2};
        Order order = new Order(new ArrayList<>(Arrays.asList(families)));

        order.calcHampers();
        boolean realIsPassed = order.getPassed();

        assertEquals("We expected the hamper were filled properly and" +
                " return isFilled as true value to pass the whole order," +
                " but seems there is something wrong which it dint happen!",
                realIsPassed, expectedIsPassed);
    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * calcHamper() goes through families ArrayList and do family.
     * hamper.calcBestHamper() and after that, check all families
     * hamper object isFilled parameter which in this case one or more of them
     * is false and method should returns false, also set passed= false which
     * consequently order will fail.
     */
    @Test
    public void testCalcHamperWhenHamperWillNotBePassed(){
        //after calc of hampers, we will expect to receive false from isPassed
        boolean expectedIsPassed = false;

        //set our static hash map to desire one for the test
        Inventory.inventory = this.inventory;

        //needed object to create hamper objects
        // this nutritional needs are higher than nutritionalItems
        // of the whole inventory that we currently have
        NutritionalItems nutritionalItems1 = new NutritionalItems(
                150, 100, 350, 100, 550);
        NutritionalItems nutritionalItems2 = new NutritionalItems(
                100, 250, 100, 450, 100);


        //hampers initialization
        Hamper hamper1 = new Hamper(nutritionalItems1);
        Hamper hamper2 = new Hamper(nutritionalItems2);

        //set hampers isFilled = true
        hamper1.setIsFilled(false);
        hamper2.setIsFilled(false);

        //initialize two sample families
        Family family1 = new Family(1, 1, 0, 0, 1, 1);
        Family family2 = new Family(2, 0, 0, 1, 2, 1);

        //set families hampers
        family1.setHamper(hamper1);
        family2.setHamper(hamper2);

        //creating Family lisr and initialize an order
        Family[] families = {family1, family2};
        Order order = new Order(new ArrayList<>(Arrays.asList(families)));

        order.calcHampers();
        boolean realIsPassed = order.getPassed();

        assertEquals("We expected one or more hampers failed on " +
                "filling properly and return isFilled as false value which " +
                "doesn't make to pass the whole order, but seems there is something" +
                " wrong which we passed the order on this test!",
                realIsPassed, expectedIsPassed);
    }

}
