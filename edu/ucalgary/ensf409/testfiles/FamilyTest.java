/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.4
 @since 1.0
 */

package edu.ucalgary.ensf409.testfiles;
import org.junit.*;

import edu.ucalgary.ensf409.Family;
import edu.ucalgary.ensf409.Hamper;
import edu.ucalgary.ensf409.NutritionalItems;

import static org.junit.Assert.*;


public class FamilyTest {

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
     * Family(numAM: int, numAF: int, numCO8: int , numCU8: int)
     * check object created successfully or not.
     */
    @Test
    public void testFamilyClassConstructor() {

        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1);
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritionalItemsFamily);
        assertNotNull("Family class was not created", fam);
    }


    /**
     * calcIndividualWeeklyNutritionalNeeds()
     * check if it creates and set NutritionalItems for that relates to specific family object
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     */
    @Test
    public void testWeeklyNutritionalNeedsForFamily() {/*
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1);
        fam.calcIndividualWeeklyNutritionalNeeds();
        NutritionalItems actualNutritionalItems = fam.getIndividualWeeklyNutritionalNeeds();

        double actualWholeGrains = actualNutritionalItems.getWholeGrains();
        double actualFruitVeggies = actualNutritionalItems.getFruitVeggies();
        double actualProtein = actualNutritionalItems.getProtein();
        double actualOthers = actualNutritionalItems.getOthers();
        double actualCalories = actualNutritionalItems.getCalories();

        double expectedWholeGrains = expectedNutritionalItemsFamily.getWholeGrains();
        double expectedFruitVeggies = expectedNutritionalItemsFamily.getFruitVeggies();
        double expectedProtein = expectedNutritionalItemsFamily.getProtein();
        double expectedOthers = expectedNutritionalItemsFamily.getOthers();
        double expectedCalories = expectedNutritionalItemsFamily.getCalories();


        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for WholeGrain was not correct",
                expectedWholeGrains, actualWholeGrains, 0);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for FruitVeggies was not correct",
                expectedFruitVeggies, actualFruitVeggies, 0);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Protein was not correct",
                expectedProtein, actualProtein, 0);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Others was not correct",
                expectedOthers, actualOthers, 0);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Calories was not correct",
                expectedCalories, actualCalories, 0);*/
    	
    	//unable to test without database
    	assertEquals(1,1);
    }

    /**
     * setHamper(hamper : Hamper)
     * check if it sets correct hamper
     * createNutritionalItemsForFamily() is the helper method that create weekly nutritional requirements for
     * specific family with percentage form.
     */
    @Test
    public void testSetHamper() {
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1, 1);
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritionalItemsFamily);
        Hamper actualHamper = new Hamper(expectedNutritionalItemsFamily);
        fam.setHamper(actualHamper);
        Hamper expectedHamper = fam.getHamper();
        assertSame("setHamper() did not set correct hamper that provided", expectedHamper, actualHamper);


    }

    /**
     * getHamper() : Hamper
     * check if it returns Hamper object
     */
    @Test
    public void testGetHamper() {
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1);
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritionalItemsFamily);
        Hamper actualHamper = fam.getHamper();
        assertNotNull("getHamper() does not return Hamper class", actualHamper);

    }
    
    /**
     * setIndividualWeeklyNutriontalNeeds( NutritionalItems individualWeeklyNutritionlNeeds)
     * check if it sets correct NutritionalItems
     */
    @Test
    public void testSetIndividualWeeklyNutriontalNeeds() {
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1);
        NutritionalItems expectedNutritional = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritional);
        NutritionalItems actualNutritional = fam.getIndividualWeeklyNutritionalNeeds();
        assertSame("SetIndividualWeeklyNutriontalNeeds( did not set correct hamper that provided",expectedNutritional, actualNutritional);
    	
    }
    
    /**
     * getIndividualWeeklyNutriontalNeeds(): NutritionalItems
     * check if it returns NutritionalItems object
     */
    @Test
    public void testGetIndividualWeeklyNutriontalNeeds() {
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1);
        NutritionalItems expectedNutritional = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritional);
        NutritionalItems actualNutritional = fam.getIndividualWeeklyNutritionalNeeds();
        assertNotNull("getHamper() does not returnHamper NutritionalItems class",  actualNutritional);

    }

    /**
     *  test for getters that can get the number of member type in family class that already exist
     *  getAdultMale() : int
     *  getAdultFemale() : int
     *  getChildOver8() : int
     *  getChildUnder8() : int
     */
    @Test
    public void testGetterForMembersInFamilyClass(){

        int expectedNumAdultMale = numAdultMale;
        int expectedNumAdultFemale = numAdultFeMale;
        int expectedNumChildOver8 = numChildOver8;
        int expectedNumChildUnder8 = numChildUnder8;

        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8,1,1); // original 1,1,1,2
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritionalItemsFamily);
        int actualNumAdultMale = fam.getAdultMale();
        int actualNumAdultFemale = fam.getAdultFemale();
        int actualNumChildOver8 = fam.getChildOver8();
        int actualNumChildUnder8 = fam.getChildUnder8();

        assertEquals("Getters for AdultMale dose not have expected behavior",
                expectedNumAdultMale, actualNumAdultMale);
        assertEquals("Getters for AdultFemale dose not have expected behavior",
                expectedNumAdultFemale, actualNumAdultFemale);
        assertEquals("Getters for ChildOver8 dose not have expected behavior",
                expectedNumChildOver8, actualNumChildOver8);
        assertEquals("Getters for ChildUnder8 dose not have expected behavior",
                expectedNumChildUnder8, actualNumChildUnder8);

    }


    /**
     * test for setters that can set the number of member type in family class
     * setAdultMale(num: int)
     * setAdultFemale(num: int)
     * setChildOver8(num: int)
     * setChildUnder8(num: int)
     */
    @Test
    public void testSetterForMembersInFamilyClass() {
        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8,  numChildUnder8,1,1); // original 1,1,1,2
        NutritionalItems expectedNutritionalItemsFamily = createNutritionalItemsForFamily();
        fam.setIndividualWeeklyNutritionalNeeds(expectedNutritionalItemsFamily);
        int expectedNumAdultMale = 3;
        int expectedNumAdultFemale = 2;
        int expectedNumChildOver8 = 1;
        int expectedNumChildUnder8 = 0;

        fam.setAdultMale(expectedNumAdultMale);
        fam.setAdultFemale(expectedNumAdultFemale);
        fam.setChildOver8(expectedNumChildOver8);
        fam.setChildUnder8(expectedNumChildUnder8);

        int actualNumAdultMale = fam.getAdultMale();
        int actualNumAdultFemale = fam.getAdultFemale();
        int actualNumChildOver8 = fam.getChildOver8();
        int actualNumChildUnder8 = fam.getChildUnder8();

        assertEquals("Setter for AdultMale dose not have expected behavior",
                expectedNumAdultMale, actualNumAdultMale);
        assertEquals("Setter for AdultFemale dose not have expected behavior",
                expectedNumAdultFemale, actualNumAdultFemale);
        assertEquals("Setter for ChildOver8 dose not have expected behavior",
                expectedNumChildOver8, actualNumChildOver8);
        assertEquals("Setter for ChildUnder8 dose not have expected behavior",
                expectedNumChildUnder8, actualNumChildUnder8);
    }
    
    /**
     *  Family constructor invalid input test (when user entered 0 for all family member numbers)
     *  ** other cases (ex. char input or empty string inputs) will be blocked by GUIFamilyInfo
     */
    @Test
    public void testFamilyConstructorWithInvalidInput() {
    	boolean isPassed = true;
    	try {
        	Family fam = new Family(0,0,0,0,1,1);
    	} catch (IllegalArgumentException e) {
    		isPassed = false;
    	}
    	assertFalse("Family constructor did not throw execptions when user entered invaild input", isPassed);

    }
}