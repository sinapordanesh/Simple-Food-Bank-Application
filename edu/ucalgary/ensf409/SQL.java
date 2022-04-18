package edu.ucalgary.ensf409;

import java.sql.*;

/**
 @author Saman Pordanesh <a href="mailto:saman.pordanesh@ucalgary.ca">
 saman.pordanesh@ucalgary.ca</a>
 @UCID 30127440
 @version 1.1
 @since 1.0
 */

public class SQL {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection dbConnection;

    /**
     * SQL class constructor which needs 3 arguments
     * @param url
     * @param user
     * @param pw
     */
    SQL(String url, String user, String pw){
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    /**
     * initialize the database connection
     */
    public void initializeConnection(){
        try{
            dbConnection = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the whole needed table and return a Resultset object
     * to loop through the table later.
     * @param tableName: name of the purpose table
     * @return
     * @throws SQLException
     */
    public ResultSet getTable(String tableName) throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        return resultSet;
    }

    /**
     * get a needed row from a table and return a Resultset object
     * to get information of the specific row.
     * @param tableName: name of the purpose table
     * @param rowName: the name of the variable to find the row
     * @param rowValue: the value which used to match a row.
     * @return
     * @throws SQLException
     */
    public ResultSet getTableRow(String tableName, String rowName, String rowValue) throws SQLException {

        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName + " WHERE " + rowName + " = " + "'" + rowValue + "'");

        return resultSet;
    }

    /**
     * Delete an item from specific table through its id.
     * Here, we set the function to delete only from
     * AVAILABLE_FOOD table, as the key name on the query
     * is based on that table, although we are passing the
     * table name as an argument.
     * @param tableName: name of the targeted table
     * @param itemId: the id of the targeted item
     */
    public void deleteItem(String tableName, int itemId){
        try{
            String query = "DELETE FROM available_food WHERE ItemID = " + itemId;
//            System.out.printf(query);
//            System.exit(0);
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.executeUpdate(query);
//            preparedStatement.setInt(1, itemId);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * getter
     * @return
     */
    public Connection getDbConnection() {
        return dbConnection;
    }

    /**
     * setter
     * @param dbConnection
     */
    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
