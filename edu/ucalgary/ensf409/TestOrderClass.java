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

public class TestOrderClass {
    // need some pre-built complete family class(with Nutritional needs, Hamper etc.)

    //Order(Family[]) is called with a Family objects array -> remove if create an Order object here!

    /**
     * Order(Family[]) is called with a Family objects array which check
     * whether they assigned to the class successfully or not
     */
    @Test
    public void testOrderClassConstructor(){

    }

    /**
     *Order(Family[]) is called with a Family objects array and
     * throws IllegalArgumentException if a wrong object is passed
     */
    @Test
    public void testOrderClassConstructorThrowsException(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * errorMessage() returns failed formatted message if passed= false
     * and success formatted message if passed= true
     */
    @Test
    public void testErrorMessaging(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getFamilies() returns the proper ArrayList<Family>
     */
    @Test
    public void testGetFamiliesArrayList(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getTotalFoodItems() returns the proper ArrayList<Food>
     */
    @Test
    public void testGetTotalFoodItemsArrayList(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * getPassed() returns true if all families hampers isFilled property are true,
     * otherwise returns false
     */
    @Test
    public void testGetPassed(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setFamilies(Family[]) set the proper families ArrayList
     */
    @Test
    public void testSetFamiliesArrayList(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * addFamily(Family) add the proper Family object to ArrayList<Family>
     */
    @Test
    public void testAddFamilyObjectToTheFamiliesArrayList(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setTotalFoodItems(ArrayList<Food>) set the proper totalFoodItem ArrayList
     */
    @Test
    public void testSetTotalFoodItemsArrayList(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * setPassed(boolean) set boolean correctly
     */
    @Test
    public void testSetPassed(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * calcHamper() goes through families ArrayList and do family.hamper.calcBestHamper()
     * and after that, check that all families hamper object have isFilled= true to pass
     * the order and return true
     */
    @Test
    public void testCalcHamperWhenHamperWillBePassed(){

    }

    /**
     * Order(Family[]) is called with a Family objects array.
     * calcHamper() goes through families ArrayList and do family.hamper.calcBestHamper()
     * and after that, check all families hamper object isFilled parameter which in this case
     * one or more of them is false and method should returns false, also set passed= false which
     * consequently order will fail.
     */
    @Test
    public void testCalcHamperWhenHamperWillNotBePassed(){

    }

}
