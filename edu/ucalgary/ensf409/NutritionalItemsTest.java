package edu.ucalgary.ensf409;

import org.junit.*;
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

    /* 
    PercentageToCalories() calculates the calories required for the Wholegrains,
    FruitVeggies, Protien and Other, rounds them down if not integer
     */
    @Test
    public void testPercentageToCalories()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int excpected[] = new int[] {400, 700, 650, 750};
        int actuals[] = new int[4];
        actuals = newNutritionalItems.percentageToCalories();
        assertArrayEquals("actual values of do not match expected", excpected, 
        actuals);


    }
    
    //does not have purpose, will revise later
    public void testCaloriesToPercentages()
    {

    }

    //below are tests for setters/getters
    @Test
    public void testGetWholeGrains()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int expected = 16;
        int actual = newNutritionalItems.getWholeGrains();
        assertEquals("actual values of do not match expected", expected, actual);
    }

    @Test
    public void testGetFruitVeggies()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int expected = 28;
        int actual = newNutritionalItems.getFruitVeggies();
        assertEquals("actual values of do not match expected", expected, actual);
    }

    @Test
    public void testGetProtien()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int expected = 26;
        int actual = newNutritionalItems.getProtien();
        assertEquals("actual values of do not match expected", expected, actual);
    }

    @Test
    public void testGetOthers()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int expected = 30;
        int actual = newNutritionalItems.getOthers();
        assertEquals("actual values of do not match expected", expected, actual);
    }

    @Test
    public void testGetCalories()
    {
        NutritionalItems newNutritionalItems = new NutritionalItems(16, 28, 26,
        30, 2500);
        int expected = 2500;
        int actual = newNutritionalItems.getCalories();
        assertEquals("actual values of do not match expected", expected, actual);
    }
}
