package edu.ucalgary.ensf409;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 @author Noureldin Amer <a href="mailto: Noureldin.amer@ucalgary.ca">
 noureldin.amer@ucalgary.ca</a>
 @UCID 30119675
 @version 1.1
 @since 1.0
 */

public class TextOutputTest {
    
    public final Family FAMILY1 = new Family(1,1,1,1, 1);
    public final Family FAMILY2 = new Family(1,1,1,0, 2);
    public final Family FAMILY3 = new Family(1,0,1,0, 3);


    /**
     * helper method to construct order
     */
    private Order contructOrder(){
        ArrayList<Family> familys = new ArrayList<Family>();
        familys.add(FAMILY1);
        familys.add(FAMILY2);
        familys.add(FAMILY3);
        Order order = new Order(familys);
        return order;
    }

    /**
     * call TextOutput(order) with an Order object
     * TextOuput(Order) is called with a variable from class order and outputs
     *  it to a txt file, checks if object is created
     */
    @Test
    public void testTextOuputDefaultConstructor()
    {
        Order order = contructOrder();
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
        Order order = contructOrder();
        TextOutput newTextOutput = new TextOutput(order);
        Order actual = newTextOutput.getOrder();
        Order expected = order;
        assertEquals("actual value (of type ORDER) does not equal the actual"
        + "value", expected, actual);

    }

    }