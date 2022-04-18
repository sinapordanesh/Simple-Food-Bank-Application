package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 @author Saman Pordanesh <a href="mailto:saman.pordanesh@ucalgary.ca">
 saman.pordanesh@ucalgary.ca</a>
 @UCID 30127440
 @version 1.1
 @since 1.0
 */

public class InventoryTest {


    Food food = new Food(12, "apple", 0, 30, 0, 70, 1000);

    /**
     *  Inventory Static HashMap is called to check whether is acting as
     *  a static parameter or not.
     */
    @Test
    public void testInventoryHashMapIsStatic(){

        Food expectedFoodObject = new Food(12, "apple",
                0, 30, 0, 70, 1000);

        //add to the static hash map
        Inventory.inventory.put(12, expectedFoodObject);
        //get from static hash map
        Food realFoodObject = Inventory.inventory.get(12);

        assertSame("Inventory hash map wasn't updated properly as an static parameter!"
                , expectedFoodObject, realFoodObject);

    }

    /**
     * RemovedItems Static ArrayList is called to check whether is acting
     * as a static parameter or not.
     */
    @Test
    public void testRemovedItemsArrayListIsStatic(){

        Food expectedFoodObject = new Food(12, "apple", 0, 30, 0, 70, 1000);

        //add to the static hash map
        Inventory.removedItems.add(expectedFoodObject);
        //get from static hash map
        Food realFoodObject = Inventory.removedItems.get(0);

        assertSame("RemovedItems hash map wasn't updated properly as an static parameter!"
                , expectedFoodObject, realFoodObject);
    }


    /**
     * Inventory(SQL) is called with a SQL object and throws an
     * IllegalArgumentException when pass any other objects.
     */
    @Test
    public void testInventoryConstructorTrowsCorrectException(){
        // this test needs an SQL object which we dont have it now. I'll add one later.

        boolean throwException = false;
        SQL sql = new SQL("jdbc:mysql://localhost/inventory", "student", "ensf");

        // sql is a wrong object
        try {
            Inventory inventory = new Inventory(sql);

        }catch (Exception e){
            throwException = true;
        }

        assertTrue("Inventory constructor did not throw an IllegalArgumentException" +
                " when given an invalid SQL as its argument!", throwException);
    }


    /**
     * Inventory(SQL) is called with a SQL object and fill the "inventory" ArrayList.
     *
     */
    @Test
    public void testInventoryConstructorGetsDataFromDatabase(){
        //We need a SQL object for this test as well, which is not available yet.
    }

    /**
     * Inventory(SQL) is called with a SQL object
     * updateInventory() returns
     * true if database is updated.
     * Also, check the new database by expected one
     * SQL(url: String, user: String, pw: String) to get the new table
     * and check weather is it updated or not
     */
    @Test
    public void testUpdateInventoryWillUpdateTheDataBase(){
        //We need a SQL object for this test as well, which is not available yet.
    }

    /**
     * Inventory(SQL) is called with a SQL object
     * inventoryIsEmpty() returns false if inventory hash map is empty
     */
    @Test
    public void testInventoryIsEmpty(){

        boolean expectedResult = false;

        //make sure inventory is empty
        Inventory.inventory.clear();

        if (Inventory.inventory.isEmpty()){
            expectedResult = true;
        }

        assertTrue("InventoryIsEmpty methos is not returning the appropriate" +
                " boolean value!", expectedResult);
    }
}
