package edu.ucalgary.ensf409;

import org.junit.*;
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
    public final Family[] FAMILIES = new Family[]{FAMILY1, FAMILY2, FAMILY3}; 
    public final Order ORDER = new Order(FAMILIES);
    
    /**
     * call TextOutput(order) with an Order object
     * TextOuput(Order) is called with a variable from class order and outputs
     *  it to a txt file, checks if object is created
     */
    @Test
    public void testTextOuputDefaultConstructor()
    {
        TextOutput newTextOutput = new TextOutput(ORDER);
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
        TextOutput newTextOutput = new TextOutput(ORDER);
        Order actual = newTextOutput.getOrder();
        Order expected = ORDER;
        assertEquals("actual value (of type ORDER) does not equal the actual"
        + "value", expected, actual);

    }

    }