package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class TextOutput implements TextFile {
    private final ORDER;
    
    public TextOutput(Order order)
    {
        this.ORDER = order;
    }

    //returns formattedOutput (String from array)
    public String formattedOutput()
    {
        ArrayList<String> foodList = Order.getTotalFoodItems();
        String formattedOutput = "";

        for(String food : foodList)
        {
            formattedOutput += food + 'n';
        }
    }

    //Order getter
    public Order getOrder()
    {
        return this.ORDER;
    }
}
