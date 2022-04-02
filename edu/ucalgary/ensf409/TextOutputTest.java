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

public class TextOutputTest {
    public final Family FAMILY1 = new Family(1,1,1,1);
    public final Family FAMILY2 = new Family(1,1,1,0);
    public final Family FAMILY3 = new Family(1,0,1,0);
    public final Family[] FAMILIES = new Family[]{FAMILY1, FAMILY2, FAMILY3}; 
    public final Order ORDER = new Order(FAMILIES);
    
    /**
     * TextOuput(Order) is called with a variable from class order and outputs
     * it to a txt file, checks if object is created
     */
    @Test
    public void testTextOuput_DefaultConstructor()
    {
        TextOutput newTextOutput = new TextOutput(ORDER);
        assertNotNull("constructor failed, new TextOutput object is null", 
        newTextOutput);
    }

    /**
     *    test for formattedOuput() returns a formatted string
     */
    @Test
    public void testFormattedOuput()
    {
        TextOutput newTextOutput = new TextOutput(ORDER);
        String actual = newTextOutput.formattedOuput();
        String expected; //not sure how to implement this
        assertEquals("actual string of do not match expected string", 
        expected, actual);
    }

    /**
     * thes for getOrder() returns the Order (of type Order)
     */
    @Test
    public void testGetOrder()
    {
        TextOutput newTextOutput = new TextOutput(ORDER);
        Order actual = newTextOutput.getOrder();
        Stirng expected = ORDER;
        assertEquals("actual value (of type ORDER) does not equal the actual"
        + "value", expected, actual);

    }
}
