package edu.ucalgary.ensf409;

import org.junit.*;

import edu.ucalgary.ensf409.Family;
import edu.ucalgary.ensf409.NutritionalItems;
import edu.ucalgary.ensf409.Order;
import edu.ucalgary.ensf409.TextOutput;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


/**
 @author Noureldin Amer <a href="mailto: Noureldin.amer@ucalgary.ca">
 noureldin.amer@ucalgary.ca</a>
 @UCID 30119675
 @version 1.1
 @since 1.0
 */

public class TextOutputTest {

    
    //private ArrayList<Family> families = new ArrayList<>();

//private ArrayList<Family> families = new ArrayList<>(Arrays.asList(families1));

    /**
     * helper method to construct order
     */
    
    private ArrayList<Family> contructOrder(){
        //ArrayList<Family> familys = new ArrayList<Family>();
        Family family1 = new Family(1, 3, 2, 4, 1, 1);
        Family family2 = new Family(0,2, 3,1, 2, 1);
        Family family3 = new Family(1, 1, 6, 1, 3, 1);
        Family family4 = new Family(2, 0, 0, 0, 4, 1);
        Family family5 = new Family(0, 1, 1, 0, 5, 1);
        ArrayList<Family> families = new ArrayList<>();
        family1.setIndividualWeeklyNutritionalNeeds(new NutritionalItems(1,2,3,4,5));
        family2.setIndividualWeeklyNutritionalNeeds(new NutritionalItems(1,2,3,4,5));
        family3.setIndividualWeeklyNutritionalNeeds(new NutritionalItems(1,2,3,4,5));
        family4.setIndividualWeeklyNutritionalNeeds(new NutritionalItems(1,2,3,4,5));
        family5.setIndividualWeeklyNutritionalNeeds(new NutritionalItems(1,2,3,4,5));
        families.add(family1);
        families.add(family2);
        families.add(family3);
        families.add(family4);
        families.add(family5);
        return families;
    }
    

    /**
     * call TextOutput(order) with an Order object
     * TextOuput(Order) is called with a variable from class order and outputs
     *  it to a txt file, checks if object is created
     */
    @Test
    public void testTextOuputDefaultConstructor()
    {
        ArrayList<Family> families1 = contructOrder();
        Order order = new Order(families1);
        TextOutput newTextOutput = new TextOutput(order);
        assertNotNull("constructor failed, new TextOutput object is null", 
        newTextOutput);
    }

    
    /**
     * call TextOutput(order) with an Order object
     * getOrder() returns the Order (of type Order)
     */
    @Test
    public void testGetOrder()
    {
        //Order order = contructOrder();
        ArrayList<Family> families1 = contructOrder();
        Order order = new Order(families1);
        TextOutput newTextOutput = new TextOutput(order);
        Order actual = newTextOutput.getOrder();
        Order expected = order;
        assertEquals("actual value (of type ORDER) does not equal the actual"
        + "value", expected, actual);

    }

    }