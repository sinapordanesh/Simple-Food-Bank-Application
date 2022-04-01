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


public class FamilyClassTest {

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
     Family(numAM: int, numAF: int, numCO8: int , numCU8: int)
     check object created successfully or not.
     */
    @Test
    public void testFamilyClassConstructor() {

        Family fam = new Family(numAdultMale,numAdultFeMale,numChildOver8,numChildUnder8);
        assertNotNull("Family class was not created", fam);
    }


    /**
     *  calcIndividualWeeklyNutritionalNeeds()
     *  check if it creates and set NutritionalItems for that relates to specific family object
     *
     */
    @Test
    public void testWeeklyNutritionalNeedsForFamily() {

        Family fam = new Family(numAdultMale, numAdultFeMale, numChildOver8, numChildUnder8);

        NutritionalItems actualNutritionalItems = fam.calcIndividualWeeklyNutritionalNeeds();

        int actualWholeGrains = actualNutritionalItems.getWholeGrains();
        int actualFruitVeggies = actualNutritionalItems.getFruitVeggies();
        int actualProtein = actualNutritionalItems.getProtein();
        int actualOthers = actualNutritionalItems.getOthers();
        int actualCalories = actualNutritionalItems.getCalories();

        int expectedWholeGrains = expectedNutritionalItemsFamily.getWholeGrains();
        int expectedFruitVeggies = expectedNutritionalItemsFamily.getFruitVeggies();
        int expectedProtein = expectedNutritionalItemsFamily.getProtein();
        int expectedOthers = expectedNutritionalItemsFamily.getOthers();
        int expectedCalories = expectedNutritionalItemsFamily.getCalories();


        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for WholeGrain was not correct",
                expectedWholeGrains, actualWholeGrains);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for FruitVeggies was not correct",
                expectedFruitVeggies, actualFruitVeggies);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Protein was not correct",
                expectedProtein, actualProtein);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Others was not correct",
                expectedOthers, actualOthers);
        assertEquals("Calculation of calcIndividualWeeklyNutritionalNeeds for Calories was not correct",
                expectedCalories, actualCalories);
    }

    /**
     *  setHamper(hamper : Hamper)
     *  check if it sets correct hamper
     */
    @Test
    public void testSetHamper() {
        Family fam = new Family(numAdultMale,numAdultFeMale,numChildOver8,numChildUnder8);
        Hamper actualHamper = new Hamper(expectedNutritionalItemsFamily);
        fam.setHamper(actualHamper);
        Hamper expectedHamper = fam.getHamper();
        assertSame("setHamper() did not set correct hamper that provided",expectedHamper, actualHamper);


    }

    /**
     *  getHamper() : Hamper
     *  check if it returns Hamper object
     */
    @Test
    public void testGetHamper() {
        Family fam = new Family(numAdultMale,numAdultFeMale,numChildOver8,numChildUnder8);
        Hamper actualHamper = fam.getHamper();
        assertNotNull("getHamper() does not return Hamper class", actualHamper );

    }

    /**
     *  test for
     *  setAdultMale(num: int)         getAdultMale() : int
     *  setAdultFemale(num: int)       getAdultFemale() : int
     *  setChildOver8(num: int)        getChildOver8() : int
     *  setChildUnder8(num: int)       getChildUnder8() : int
     */
    @Test
    public void testSetterAndGetterFamilyClass() {
        Family fam = new Family(numAdultMale,numAdultFeMale,numChildOver8,numChildUnder8);
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

        assertEquals("Setter and Getters for AdultMale dose not have expected behavior",
                expectedNumAdultMale, actualNumAdultMale);
        assertEquals("Setter and Getters for AdultFemale dose not have expected behavior",
                expectedNumAdultFemale, actualNumAdultFemale);
        assertEquals("Setter and Getters for ChildOver8 dose not have expected behavior",
                expectedNumChildOver8, actualNumChildOver8);
        assertEquals("Setter and Getters for ChildUnder8 dose not have expected behavior",
                expectedNumChildUnder8, actualNumChildUnder8);
    }


    /**
     *  createSuitableHamper(nutritionalRequirements: NutritionalItems)
     *  check if it creates and set hamper that belongs to specific family object
     *  with most efficient combination that meets nutritional Requirements
     */

    /**
     *  for createSuitableHamper(nutritionalRequirements: NutritionalItems) method in Family Class
     *  my suggestion: since family class and hamper class is composition relationship,
     *  what if we just create and calculate best hamper within the Family class constructor
     *  because it just seems like duplicated method calcBestHamper() in Hamper Class
     *
     *
     *  public Family(AM:int, AF:int, CO8:int, CU8:int) {
     *      this.AM = AM;
     *      this.AF = AF;
     *      this.C08 = C08;
     *      this.CU8 = CU8;
     *
     *      calcIndividualWeeklyNutritionalNeeds()  // in here this.IndividualWeeklyNutritionalNeeds will set
     *
     *      this.hamper = new Hamper(this.IndividualWeeklyNutritionalNeeds)
     *
     *  }
     *
     *  public Hamper(nutritionalRequirements: NutritionalItems){
     *      ...
     *      calcBestHamper()
     *      ...
     *  }
     *
     */

    @Test
    public void TestCreateSuitableHamper() {
        Family fam = new Family(numAdultMale,numAdultFeMale,numChildOver8,numChildUnder8);
        int expectedNumAdultMale = 3;
        int expectedNumAdultFemale = 2;
        int expectedNumChildOver8 = 1;
        int expectedNumChildUnder8 = 0;


    }