package edu.ucalgary.ensf409;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextOutput implements TextFile {
    private final Order ORDER;
    
    public TextOutput(Order order)
    {
        this.ORDER = order;
    }

    //returns formattedOutput (String from array)
    public String formattedOutput()
    {
        ArrayList<Food> foodList = ORDER.getTotalFoodItems();
        String formattedOutput = "";

        for(Food food : foodList)
        {
            formattedOutput = Integer.toString(food.getItemId())+"\t"+food.getName()+"\n";
        }

        return formattedOutput;
    }

    //Order getter
    public Order getOrder()
    {
        return this.ORDER;
    }

    @Override
    public void generateFile(String outputFileName) //ie including .txt
    {
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(outputFileName));
            wr.write("Food Bank \n" + "Hamper Order Form \n \n" + "Name:\nDate:\n"
            + "\n Original Request \n" );
            
            ArrayList <Family> families = ORDER.getFamilies();
            int i;

            for(i = 0; i < families.size(); i++)
            {
                Family family = families.get(i);
                String adultMale;
                String adultFemale;
                String over8;
                String under8;
                int familyId = family.getFamilyId();

                if(family.getAdultMale() == 0)
                {
                    adultMale = "";
                } else {
                    adultMale = family.getAdultMale() + " Adult Male, ";
                }

                if (family.getAdultFemale() == 0) {
                    adultFemale = "";
                } else {
                    adultFemale = family.getAdultMale() + " Adult female, ";
                }

                if (family.getChildOver8() == 0) {
                    over8 = "";
                } else {
                    over8 = family.getAdultMale() + " Child Over 8, ";
                }

                if (family.getChildUnder8() == 0) {
                    under8 = "";
                } else {
                    under8 = family.getChildUnder8() + " Child Under 8";
                }
                
                wr.write("Hamper " + familyId + ": " +  adultMale + adultFemale +
                over8 + under8 + '\n');
            }
            
            for(int j = 0; j < families.size(); j++)
            {
                Family family = families.get(j);
                int familyId = family.getFamilyId();
                Hamper hamper = family.getHamper();
                ArrayList<Food> foodItems= hamper.getFoodItems();
                wr.write("Hamper " + familyId + " Items:\n");
                for(int k = 0; k < foodItems.size(); k ++)
                {
                    Food foodItem = foodItems.get(k);
                    wr.write(foodItem.getItemId() + "\t" + foodItem.getName() + "\n");
                }
                wr.write("\n\n"); //skip 2 lines
            }
            wr.close();

        } catch (IOException e) {
            System.out.println("Cannot create output file");
        }
        
    }
}