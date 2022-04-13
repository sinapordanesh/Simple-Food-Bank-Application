


package edu.ucalgary.ensf409;
import java.util.ArrayList;
import java.util.Iterator;
public class FoodBankMain {

	public static void main(String[] args) {
		
		/**
		 * SQL part 
		 * connection.... ext..
		 */
		/*
		boolean on = true;
		boolean success = true;
		int numOfFamilies = 0;
		*/
		//while(on) {
		
			GUIStart.start();
/*
		ArrayList<Family> listOfFamilies = new ArrayList<Family>();
		numOfFamilies = GUIStart.start();
		ArrayList<Integer[]> families = GUIFamilyInfo.familyInfo(numOfFamilies);
		
		
		Iterator<Integer[]> iter = families.iterator();
		while(iter.hasNext()) {
			Integer[] members = iter.next();
			Family family = new Family(members[0],members[1],members[2],members[3]);
			listOfFamilies.add(family);
		}
		
		Order order = new Order(listOfFamilies);
		
		/**
		 *  ...
		 * 
		 *  Further calculation in Order class
		 *  DB update... ext..
		 *  
		 *  ...
		 */
/*		
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
/*
		
		if(success == true) {
			on = GUISuccess.success(order);  // or TextOutput: text might go as an argument so we can text.forrmattedString for GUI
			
		} else {
			on = GUIFailed.failed();
		}
		
*/		
		}
	//}

}
