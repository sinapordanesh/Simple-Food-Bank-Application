package edu.ucalgary.ensf409;

import java.sql.*;

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
     * @param tableName
     * @return
     * @throws SQLException
     */
    public ResultSet getTable(String tableName) throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        return resultSet;
    }

    /**
     * Delete an item from specific table through its id.
     * Here, we set the function to delete only from
     * AVAILABLE_FOOD table, as the key name on the query
     * is based on that table, although we are passing the
     * table name as an argument.
     * @param tableName
     * @param itemId
     */
    public void deleteItem(String tableName, int itemId){
        try{
            String query = "DELETE FROM " + tableName + " WHERE ItemID = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setInt(1, itemId);

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
