package app;


import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class JDBCOutcome {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/outocomes.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */

    /**
     * Get all of the LGAs in the database.
     * @return
     *    Returns an ArrayList of LGA objects
     */
    /**
        public ArrayList<Outcome> getOutcome() {
        // Create the ArrayList of LGA objects to return
       **/ 
    //   public void createTable() throws SQLException {
    //     Connection connection = null;

    //     try {
    //         // Connect to JDBC data base
    //         connection = DriverManager.getConnection(DATABASE);

    //         // Prepare a new SQL Query & Set a timeout
    //         Statement statement = connection.createStatement();
    //         statement.setQueryTimeout(30);

    //     String sql = "(CREATE TABLE Outcomes" + 
    //     "OutcomeID VARCHAR(255) NOT NULL" +
    //     "OutcomeDescription VARCHAR(255) NOT NULL" +
    //     "PRIMARY KEY (OutcomeID))" ;
    //     statement.executeUpdate(sql);
    //     }
    //     catch (SQLException e) {
    //         // If there is an error, lets just pring the error
    //         System.err.println(e.getMessage());
    //     } finally {
    //         // Safety code to cleanup
    //         try {
    //             if (connection != null) {
    //                 connection.close();
    //             }
    //         } catch (SQLException e) {
    //             // connection close failed.
    //             System.err.println(e.getMessage());
    //         }
            
    //     }
    // }
      

      

       public ArrayList<Outcome> getOutcome() {
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

        String sql = "SELECT * FROM Outcomes";
        
        ResultSet results = statement.executeQuery(sql);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String OutcomeName     = results.getString("OutcomeName");
                String OutcomeDescription  = results.getString("OutcomeDescription");

                // Create a LGA Object
                Outcome outcome = new Outcome(OutcomeName, OutcomeDescription);

                // Add the lga object to the array
                outcomes.add(outcome);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return outcomes;
    }
    public ArrayList<Outcome> getOutcomeTarget() {
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

        String sql = "SELECT * FROM Outcomes WHERE OutcomeName = 'Outcome 1' OR OutcomeName = 'Outcome 5' OR OutcomeName = 'Outcome 8'";
        
        ResultSet results = statement.executeQuery(sql);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String OutcomeName     = results.getString("OutcomeName");
                String OutcomeDescription  = results.getString("OutcomeDescription");

                // Create a LGA Object
                Outcome outcome = new Outcome(OutcomeName, OutcomeDescription);

                // Add the lga object to the array
                outcomes.add(outcome);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return outcomes;
    }
}


        // try {
        //     // Connect to JDBC data base
        //     connection = DriverManager.getConnection(DATABASE);

        //     // Prepare a new SQL Query & Set a timeout
        //     Statement statement = connection.createStatement();
        //     statement.setQueryTimeout(30);

        //     // The Query

        //     System.out.println("Inserting records into the table...");          
        //     String sql = "INSERT INTO Outcomes VALUES (sad, 'Zara')";
        //     statement.executeUpdate(sql);
        //     sql = "INSERT INTO Outcomes VALUES (asd, 'Mahnaz')";
        //     statement.executeUpdate(sql);
        //     sql = "INSERT INTO Outcomes VALUES (asd, 'Zaid')";
        //     statement.executeUpdate(sql);
        //     sql = "INSERT INTO Outcomes VALUES(asd, 'Sumit')";
        //     statement.executeUpdate(sql);
        //     System.out.println("Inserted records into the table...");   
        //     ResultSet results = statement.executeQuery(sql);
        //     while (results.next()) {
        //         // Lookup the columns we need
        //         String outcome_id = results.getString("outcome name");
        //         String outcome_description = results.getString("outcome description");

        //         // Create a LGA Object
        //         Outcome outcome = new Outcome(outcome_id, outcome_description);

        //         // Add the lga object to the array
        //         outcomes.add(outcome);
        //         statement.close(); }
        //     } catch (SQLException e) {
        //         // If there is an error, lets just pring the error
        //         System.err.println(e.getMessage());
        //     } finally {
        //         // Safety code to cleanup
        //         try {
        //             if (connection != null) {
        //                 connection.close();
        //             }
        //         } catch (SQLException e) {
        //             // connection close failed.
        //             System.err.println(e.getMessage());
        //         }
        //     }
            
          
            /**"(CREATE TABLE Outcomes" + 
            "OutcomeID VARCHAR(255) NOT NULL" +
            "OutcomeDescription VARCHAR(255) NOT NULL" +
            "PRIMARY KEY (OutcomeID))" ;**/

            // Get Result
            /**ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String outcome_id = results.getString("outcome name");
                String outcome_description = results.getString("outcome description");

                // Create a LGA Object
                Outcome outcome = new Outcome(outcome_id, outcome_description);

                // Add the lga object to the array
                outcomes.add(outcome);
            }
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return outcomes;
    }**/



    // TODO: Add your required methods here




    // TODO: Add your required methods here




