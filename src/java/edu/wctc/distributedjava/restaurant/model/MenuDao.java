/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distributedjava.restaurant.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rdunckel
 */
public class MenuDao {

    private Connection conn;
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    public List<MenuItem> getEntrees() {

        List<MenuItem> entrees = new ArrayList<MenuItem>();
        MenuItem item = null;

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Steak");
        tempNames.add("Lobster");
        tempNames.add("Chicken");

        for (String name : tempNames) {
            item = new MenuItem();
            item.setItemName(name);
            entrees.add(item);
        }

        return entrees;
    }

    public List<MenuItem> getBeverages() {

        List<MenuItem> beverages = new ArrayList<MenuItem>();
        MenuItem item = null;

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Water");
        tempNames.add("Martini");
        tempNames.add("Wine");

        for (String name : tempNames) {
            item = new MenuItem();
            item.setItemName(name);
            beverages.add(item);
        }

        return beverages;
    }

    public List<MenuItem> getDesserts() {

        List<MenuItem> desserts = new ArrayList<MenuItem>();
        MenuItem item = null;

        List<String> tempNames = new ArrayList<String>();
        tempNames.add("Creme Brulee");
        tempNames.add("Chocolate Cake");
        tempNames.add("Bananas Foster");

        for (String name : tempNames) {
            item = new MenuItem();
            item.setItemName(name);
            desserts.add(item);
        }

        return desserts;
    }

    public static void main(String[] args) {
        testDb();
    }

    public static void testDb() {

        // First instantiate and store an object of this class
        MenuDao db = new MenuDao();

        /*
         * ============= JDBC INITIALIZATION ==================
         */

        // STEP 1: Set the fully qualified name of the JDBC driver class
        // (Here we use the Microsoft driver .jar provided on Blackboard
        // Did you remember to import java.sql.* ?
        db.driverClassName = "com.mysql.jdbc.Driver";

        // STEP 2: Set the driver-specific URL (Uniform Resource Locator)
        // This is a server-specific address format
        db.url = "jdbc:mysql://bit.glassfish.wctc.edu:3306/jsfshowcase";

        // STEP 3: Set user name and password (if required)
        db.userName = "advjava";
        db.password = "advjava";

        // STEP 4: Now make a connection to the database
        // Checked exceptions demand try-catch
        try {
            // This loads the class into memory
            Class.forName(db.driverClassName);

            // Now let the Driver Manager use the class to create a connection object
            // It figures this out from the url
            db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Error: Failed to load JDBC driver!");
            cnfex.printStackTrace();
            System.exit(1);  // terminate program
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database: " + sqlex.getMessage());
            sqlex.printStackTrace();
            System.exit(1);  // terminate program
        }

        /*
         * =========== Now Use JDBC to Work With Your Database ================================
         */

        // We'll need a statement object to execute the sql query (a statement)
        Statement stmt = null;

        // We'll need one of these to hold results returned from our query.
        // Remember, not all queries return results.
        ResultSet rs = null;

        // Now create an sql query string (most sql is standard, but
        // some database products use proprietary code, like this one for MS-Access)
//		String sql = "SELECT * FROM [dbo].[EMPLOYEE] WHERE "
//                        + "HIREDATE > '1/1/1988' ORDER BY LASTNAME";
        String sql = "SELECT * FROM employee";

        try {
            // Next use the connection object created earlier to create a statement object
            stmt = db.conn.createStatement();

            // Then use the executeQuery() method of the statement object
            // to execute the read-only query.
            // Be sure to check all the methods of the statement object in the API.
            // You would use an updateQuery() method, e.g., to insert or edit records
//                        stmt.executeUpdate(sqlInsert);
            rs = stmt.executeQuery(sql);

            System.out.println("============================");
            System.out.println("Output from SQL Server...");
            System.out.println("============================");

            // The ResultSet contains the records returned by your query.
            // Loop through the ResultSet to extract the data
            int count = 0;
            while (rs.next()) {
                // Each record contains three display fields which we will reference
                // by number (1 based). Read up on other methods we could use in ResultSet.
                System.out.println("\nRecord No: " + (count + 1));
//                                System.out.println("\nID: " + rs.getInt(1)); // column one (ResultSet field)
                System.out.println("Last Name: " + rs.getObject(1)); // named field
                System.out.println("First Name: " + rs.getObject(2));
                System.out.println("Email: " + rs.getObject(3));
                System.out.println("Hire Date: " + rs.getObject(4));
                count++;
            }
            System.out.println("==================\n" + count + " records found.");
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Make sure we close the statement and connection objects no matter what.
            // Since these also throw checked exceptions, we need a nested try-catch
            try {
                stmt.close();
                db.conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
