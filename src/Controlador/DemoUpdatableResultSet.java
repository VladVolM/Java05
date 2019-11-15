package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoUpdatableResultSet {
  public static Connection getConnection() throws Exception {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:databaseName";
    String username = "name";
    String password = "password";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void main(String[] args) {
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = getConnection();
      String query = "select id, name, age from employees where age > ?";
      pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
      pstmt.setInt(1, 20); // set input values
      rs = pstmt.executeQuery(); // create an updatable ResultSet
                                               // update a column value in the current row.
      rs.absolute(2);                          // moves the cursor to the 2nd row of rs
      rs.updateString("name", "newName");      // updates the 'name' column of row 2 to newName
      rs.updateRow();                          // updates the row in the data source
                                               // insert column values into the insert row.
      rs.moveToInsertRow();                    // moves cursor to the insert row
      rs.updateInt(1, 1234);                   // 1st column id=1234
      rs.updateString(2, "newName");           // updates the 2nd column
      rs.updateInt(3, 99);                     // updates the 3rd column to 99
      rs.insertRow();
      rs.moveToCurrentRow();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
} 
