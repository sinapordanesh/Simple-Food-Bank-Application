package edu.ucalgary.ensf409.testfiles;

import org.junit.*;

import edu.ucalgary.ensf409.NutritionalItems;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 @author Noureldin Amer <a href="mailto: Noureldin.amer@ucalgary.ca">
 noureldin.amer@ucalgary.ca</a>
 @UCID 30119675
 @version 1.1
 @since 1.0
 */

public class NutritionalItemsTest {

    //Test data
    public final int[] expectedNutritionalNeedsAdultMale = {16, 28, 26, 30, 2500};
    public final int[] expectedNutritionalNeedsAdultFemale = {16, 28, 26, 30, 2500};
    public final int[] expectedNutritionalNeedsChildrenOver8 = {21, 33, 31, 15, 2000};
    public final int[] expectedNutritionalNeedsChildrenUnder8 = {21, 33, 31, 15, 1400};

    public final int numAdultMale = 2;
    public final int numAdultFeMale = 1;
    public final int numChildUnder8 = 1;
    public final int numChildOver8 = 1;
    public final int[] expectedNeedsFamily = new int[5];

    /**
     *  NutritionalItems constructor checks if object created successfully or not
     */
    @Test
    public void testNutritionalItemsTests_Constructor()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        assertNotNull("constructor failed, new NutritionalItems object"  
        + "is null: ", newNutritionalItems);
    }

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments.
     * PercentageToCalories() calculates the calories required for the Wholegrains,
     * FruitVeggies, Protien and Other, rounds them down if not integer
     */
    @Test
    public void testPercentageToCalories()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double excpected[] = {400, 700, 650, 750, 2500};
        double actuals[] = new double[5];
        actuals = newNutritionalItems.percentageToCalories();
        assertArrayEquals("actual values of do not match expected", excpected, 
        actuals, 1);


    }
    

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments
     * getWholeGrains returns the right value and assert if not
     */
    @Test
    public void testGetWholeGrains()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double expected = 16;
        double actual = newNutritionalItems.getWholeGrains();
        assertEquals("actual values of do not match expected", expected, actual, 0);
    }

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments
     * getFruitVeggies returns the right value and assert if not
     */
    @Test
    public void testGetFruitVeggies()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double expected = 28;
        double actual = newNutritionalItems.getFruitVeggies();
        assertEquals("actual values of do not match expected", expected, actual, 0);
    }

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments
     * getProtein returns the right value and assert if not
     */
    @Test
    public void testGetProtein()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double expected = 26;
        double actual = newNutritionalItems.getProtein();
        assertEquals("actual values of do not match expected", expected, actual, 0);
    }

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments
     * getOthers returns the right value and assert if not
     */
    @Test
    public void testGetOthers()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double expected = 30;
        double actual = newNutritionalItems.getOthers();
        assertEquals("actual values of do not match expected", expected, actual, 0);
    }

    /**
     * call NutritionalItems(int, int, int, int, int) with five integer arguments
     * getCalories returns the right value and assert if not
     */
    @Test
    public void testGetCalories()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        double expected = 2500;
        double actual = newNutritionalItems.getCalories();
        assertEquals("actual values of do not match expected", expected, actual, 0);
    }
}
