package edu.ucalgary.ensf409;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    public static HashMap<Integer, Food> inventory;
    public static ArrayList<Food> removedItems;
    private final SQL DATABASE;

    /**
     * constructor for the inventory class which calls an SQL class.
     * @param data
     */
    Inventory(SQL data) throws SQLException {
        DATABASE = data;

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
    public boolean updateInventory(){

        try {
            for (Food food: removedItems){
                DATABASE.deleteItem("AVAILABLE_FOOD", food.getItemId());
            }
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

}
