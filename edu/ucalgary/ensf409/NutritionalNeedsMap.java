package edu.ucalgary.ensf409;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    private final SQL DATABASE;

    public static HashMap <String, NutritionalItems> table = new HashMap<>();

    public NutritionalNeedsMap(SQL data)
    {
        this.DATABASE = data;
        try {
           
            saturatingTable("Adult Male", ClientType.ADULTMALE);
            saturatingTable("Adult Female", ClientType.ADULTFEMALE);
            saturatingTable("Child over 8", ClientType.CHILDOVER8);
            saturatingTable("Child under 8", ClientType.CHILDUNDER8);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * the helper function to saturate the Hash Map table by query through
     * database and get necessary data
     * @param rowValue: the name of the row on DAILY_CLIENT_NEEDS table
     * @param clientType: type of client(1 from 4)
     * @throws SQLException
     */
    private void saturatingTable(String rowValue, ClientType clientType) throws SQLException {
        //
        ResultSet resultSet = DATABASE.getTableRow("DAILY_CLIENT_NEEDS", "Client", rowValue);
        resultSet.next();

        NutritionalItems items = clientType.getNutritionalItems(
                resultSet.getInt("WholeGrains"),
                resultSet.getInt("FruitVeggies"),
                resultSet.getInt("Protein"),
                resultSet.getInt("Other"),
                resultSet.getInt("Calories")
        );

        resultSet.close();
        table.put(clientType.toString(), items);
    }

    /**
    * Return HashMap <String, NutritionalItems> TABLE
    */
    public HashMap<String, NutritionalItems> getTable() {
            return table;
        }
}
