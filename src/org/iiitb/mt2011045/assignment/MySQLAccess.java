package org.iiitb.mt2011045.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  @SuppressWarnings("deprecation")
public void readDataBase(String query) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/Trip?"
              + "user=root&password=gaurav");

      /*// Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from trip.TRIP");
      writeResultSet(resultSet);*/

      // PreparedStatements can use variables and are more efficient
     /* preparedStatement = connect
          .prepareStatement("insert into  trip.TRIP values (default, ?, ?, ?, ? , ?, ?)");*/
      preparedStatement = connect
              .prepareStatement(query);
      // "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
      // Parameters start with 1
      /*preparedStatement.setString(1, "HOME");
      preparedStatement.setString(2, "Bangalore");
      preparedStatement.setString(3, "Indore");
      preparedStatement.setString(4, "Nagpur");
      preparedStatement.setString(5, "Yatra");
      preparedStatement.setDate(6, new java.sql.Date(1012, 12, 8));*/
      preparedStatement.executeUpdate();

      /*preparedStatement = connect
          .prepareStatement("SELECT TRIPNAME, FROMSTN, TOSTN, VIA, AGENT, TRAVELDATE FROM trip.TRIP");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);*/

      // Remove again the insert comment
     /* preparedStatement = connect
      .prepareStatement("delete from trip.TRIP where TRIPNAME= ? ; ");
      preparedStatement.setString(1, "HOME");
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from trip.TRIP");
      writeMetaData(resultSet);*/
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String tripName = resultSet.getString("TRIPNAME");
      String fromStn = resultSet.getString("FROMSTN");
      String toStn = resultSet.getString("TOSTN");
      String via = resultSet.getString("VIA");
      String agent = resultSet.getString("AGENT");
      Date date = resultSet.getDate("TRAVELDATE");
      
      System.out.println("TRIPNAME: " + tripName);
      System.out.println("FROMSTN: " + fromStn);
      System.out.println("TOSTN: " + toStn);
      System.out.println("VIA: " + date);
      System.out.println("AGENT: " + agent);
      System.out.println("AGENT: " + date);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

}