package edu.ucalgary.ensf409;

import java.sql.*;

public class SQL {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection dbConnection;

    SQL(String url, String user, String pw){
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public ResultSet getTable(String tableName) throws SQLException {
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        return resultSet;
    }

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

    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
