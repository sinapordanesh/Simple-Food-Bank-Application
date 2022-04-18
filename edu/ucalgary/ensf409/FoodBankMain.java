
package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
public class FoodBankMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SQL sql = new SQL("jdbc:mysql://localhost:3306/food_inventory","student","ensf");
		sql.initializeConnection();
		Inventory inventory = new Inventory(sql);
		NutritionalNeedsMap nutritionalNeedsMap = new NutritionalNeedsMap(sql);
		GUIStart.start(1);
	}
}
