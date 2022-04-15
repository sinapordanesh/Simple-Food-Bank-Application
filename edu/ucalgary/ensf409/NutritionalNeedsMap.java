package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 @author Noureldin Amer <a href="mailto: Noureldin.amer@ucalgary.ca">
 noureldin.amer@ucalgary.ca</a>
 @UCID 30119675
 @version 1.1
 @since 1.0
 */

/**
 * Produce a HashMap <String, NutritionalItems>
 */

public class NutritionalNeedsMap {
    public static HashMap <String, NutritionalItems> table;

    public NutritionalNeedsMap(SQL data)
    {
        Statement myStmt;
        ResultSet results;

        try {
            myStmt = data.getDbConnection().createStatement();

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Adult Male'");
            table.put("ADULTMALE",ClientType.ADULTMALE.getNutritionalItems(results.getInt("WholeGrains"),
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Adult Adult Female'");
            table.put("ADULTFEMALE",ClientType.ADULTFEMALE.getNutritionalItems(results.getInt("WholeGrains"),
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Child over 8'");
            table.put("CHILDOVER8",ClientType.CHILDOVER8.getNutritionalItems(results.getInt("WholeGrains"),
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS WHERE Client = 'Child under 8'");
            table.put("CHILUNDER8",ClientType.CHILDUNDER8.getNutritionalItems(results.getInt("WholeGrains"),
            results.getInt("FruitVeggies"), results.getInt("Protein"), 
            results.getInt("Other"), results.getInt("Calories")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Return HashMap <String, NutritionalItems> TABLE
    */
    public HashMap<String, NutritionalItems> getTable() {
            return this.table;
        }
}
