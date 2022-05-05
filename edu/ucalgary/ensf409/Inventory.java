package edu.ucalgary.ensf409;

import java.sql.ResultSet;
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


public class Inventory {

    public static HashMap<Integer, Food> inventory = new HashMap<>();
    public static ArrayList<Food> removedItems = new ArrayList<Food>();
    private static SQL database;

    /**
     * constructor for the inventory class which calls an SQL class.
     * @param data
     */
    Inventory(SQL data) throws SQLException {
        database = data;


        try{
            ResultSet resultSet = data.getTable("AVAILABLE_FOOD");
            saturateMapFromDatabase(resultSet);
            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * helper method to use in the constructor and satuarting the inventory hashmap
     * by a database object.
     * @param resultSet, database object for the query
     * @throws SQLException
     */
    private void saturateMapFromDatabase(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            int itemId = resultSet.getInt("ItemID");

            Food food = new Food(itemId,
                    resultSet.getString("Name"),
                    resultSet.getInt("GrainContent"),
                    resultSet.getInt("FVContent"),
                    resultSet.getInt("ProContent"),
                    resultSet.getInt("Other"),
                    resultSet.getInt("Calories"));

            inventory.put(itemId, food);
        }
    }

    /**
     * remove  items which were used to create hampers
     * after a successful order.
     * @return, boolean to show the process completed
     */
    public static boolean updateInventory(){

        try {
            for (Food food: removedItems){
                database.deleteItem("AVAILABLE_FOOD", food.getItemId());
            }
            removedItems.clear();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * return true if inventory is empty
     * @return
     */
    public boolean inventoryIsEmpty(){
        return inventory.isEmpty();
    }

	public static void setInventory(HashMap<Integer, Food> testInventory) {
		inventory = testInventory;
		
	}
	
	public static HashMap<Integer, Food> getInventory() {
		return inventory;
		
	}

}
