package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class NutritionalNeedsMap {
    HashMap <String, NutritionalItems> TABLE; 
    public NutritionalNeedsMap(Connection dbConnect)
    {
        Statement myStmt;
        ResultSet results;

        try {
            myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Adult Male'");
            TABLE.put("ADULTMALE",ClientType.ADULTMALE.getNutritionalItems(results.getInt("WholeGrains"), 
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Adult Adult Female'");
            TABLE.put("ADULTFEMALE",ClientType.ADULTFEMALE.getNutritionalItems(results.getInt("WholeGrains"), 
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Child over 8'");
            TABLE.put("CHILDOVER8",ClientType.CHILDOVER8.getNutritionalItems(results.getInt("WholeGrains"), 
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Child under 8'");
            TABLE.put("CHILUNDER8",ClientType.CHILDUNDER8.getNutritionalItems(results.getInt("WholeGrains"), 
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
