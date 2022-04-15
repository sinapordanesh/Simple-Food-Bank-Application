


package edu.ucalgary.ensf409;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
public class FoodBankMain {

	public static void main(String[] args) throws SQLException {
		
		/**
		 * SQL part 
		 * connection.... ext..
		 */

		SQL sql = new SQL("jdbc:mysql://localhost/food_inventory","student","ensf");
		sql.initializeConnection();
		Inventory inventory = new Inventory(sql);
		NutritionalNeedsMap nutritionalNeedsMap = new NutritionalNeedsMap(sql);

		boolean on = true;
		boolean success = true;
		int numOfFamilies = 0;

		while(on) {
		
			GUIStart.start();

			ArrayList<Family> listOfFamilies = new ArrayList<Family>();
			numOfFamilies = GUIStart.start();
			ArrayList<Integer[]> families = GUIFamilyInfo.familyInfo(numOfFamilies);
		

			Iterator<Integer[]> iter = families.iterator();
			int id = 0;
			while(iter.hasNext()) {
				Integer[] members = iter.next();
				Family family = new Family(members[0],members[1],members[2],members[3], id);
				listOfFamilies.add(family);
				id++;
			}

			Order order = new Order(listOfFamilies.toArray());
			order.calcHampers();
		
			/**
			 *  ...
			 *
			 *  Further calculation in Order class
			 *  DB update... ext..
			 *
			 *  ...
			 */

			success = order.getPassed();

			/**
			 * 	...
			 *
			 *  TextOutput text = new TextOutput(order)
			 *  summary of order, File output... ext..
			 *
			 *  ...
			 *
			 */


			if(success) {
				on = GUISuccess.success(order);  // or TextOutput: text might go as an argument so we can text.forrmattedString for GUI

			} else {
				on = GUIFailed.failed();
			}
		}
	}
}
