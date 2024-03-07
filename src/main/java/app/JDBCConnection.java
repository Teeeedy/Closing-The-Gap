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
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/ctg.db";
    private static final String database = "jdbc:sqlite:database/lgas.db";
    private static final String Database = "jdbc:sqlite:database/outocomes.db";


    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the LGAs in the database.
     * @return
     *    Returns an ArrayList of LGA objects
     */
    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16     = results.getInt("lga_code16");
                String name16  = results.getString("lga_name16");

                // Create a LGA Object
                LGA lga = new LGA(code16, name16);

                // Add the lga object to the array
                lgas.add(lga);
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
        return lgas;
    }

    public ArrayList<Persona> getPersonas() {
        // Create the ArrayList of LGA objects to return
        ArrayList<Persona> personas = new ArrayList<Persona>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Personas";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String personaID     = results.getString("PersonaID");
                String personaName  = results.getString("Name");
                String imgPath = results.getString("Img_path");
                String description = results.getString("Description");
                String needs = results.getString("Needs");
                String goals = results.getString("Goals");
                String skillsExp = results.getString("SkillsExp");

                // Create a LGA Object
                Persona persona = new Persona(personaID, personaName, imgPath, description, needs, goals, skillsExp);

                // Add the lga object to the array
                personas.add(persona);
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
        return personas;
    }

    public ArrayList<POPULATION> getPopulations() {
        // Create the ArrayList of LGA objects to return
        ArrayList<POPULATION> Populations = new ArrayList<POPULATION>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM POPULATION WHERE lga_year = '2021'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lga_code = results.getInt("lga_code");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String lga_type = results.getString("lga_type");
                double area_sqkm = results.getDouble("area_sqkm");
                int total_population = results.getInt("total_population");
                int lga_year = results.getInt("lga_year");
         

                // Create a LGA Object
                POPULATION Population = new POPULATION(lga_code, lga_name, lga_state, lga_type, area_sqkm, total_population, lga_year);

                // Add the lga object to the array
                Populations.add(Population);
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
        return Populations;
    }
    public ArrayList<AllTables> getINDIGSTATUS() {
        // Create the ArrayList of LGA objects to return
        ArrayList<AllTables> indigstat = new ArrayList<AllTables>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Dataset12 order by Count DESC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lgacode = results.getInt("lgacode");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String Indigenous_status = results.getString("Indigenous_status");
                String Sex = results.getString("Sex");
                String Age = results.getString("Age");
                int Count = results.getInt("Count");
                int lga_year = results.getInt("lga_year");
                // String SchoolYear = results.getString("SchoolYear");
                // String Income_bracket = results.getString("Income_bracket");

                AllTables status = new AllTables(lgacode, lga_name, lga_state, Indigenous_status, Sex, Age, Count, lga_year);

                // Add the lga object to the array
                indigstat.add(status);
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
        return indigstat;
    }
    public ArrayList<schoolcompletion> getSCHOOL() {
        // Create the ArrayList of LGA objects to return
        ArrayList<schoolcompletion> indigstat = new ArrayList<schoolcompletion>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Dataset32 order by Count DESC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lgacode = results.getInt("lgacode");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String Indigenous_status = results.getString("Indigenous_status");
                String Sex = results.getString("Sex");
                // String Age = results.getString("Age");
                int Count = results.getInt("Count");
                int lga_year = results.getInt("lga_year");
                String SchoolYear = results.getString("SchoolYear");
                // String Income_bracket = results.getString("Income_bracket");

                schoolcompletion status = new schoolcompletion(lgacode, lga_name, lga_state, Indigenous_status, Sex, SchoolYear, Count, lga_year);

                // Add the lga object to the array
                indigstat.add(status);
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
        return indigstat;
    }
    public ArrayList<weeklyincome> getINCOME() {
        // Create the ArrayList of LGA objects to return
        ArrayList<weeklyincome> indigstat = new ArrayList<weeklyincome>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Dataset42 order by Count DESC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lgacode = results.getInt("lgacode");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String Indigenous_status = results.getString("Indigenous_status");
                int Count = results.getInt("Count");
                int lga_year = results.getInt("lga_year");
                String Income_bracket = results.getString("Income_bracket");

                weeklyincome status = new weeklyincome(lgacode, lga_name, lga_state, Indigenous_status, Income_bracket, Count, lga_year);

                // Add the lga object to the array
                indigstat.add(status);
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
        return indigstat;
    }

    public ArrayList<POPULATION> getTotalPopulations2021() {
        // Create the ArrayList of LGA objects to return
        ArrayList<POPULATION> Populations = new ArrayList<POPULATION>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM (total_population) FROM POPULATION WHERE lga_year = '2021' AND lga_year = '2016'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lga_code = results.getInt("lga_code");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String lga_type = results.getString("lga_type");
                double area_sqkm = results.getDouble("area_sqkm");
                int total_population = results.getInt("total_population");
                int lga_year = results.getInt("lga_year");
         

                // Create a LGA Object
                POPULATION Population = new POPULATION(lga_code, lga_name, lga_state, lga_type, area_sqkm, total_population, lga_year);

                // Add the lga object to the array
                Populations.add(Population);
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
        return Populations;
    }
    public ArrayList<POPULATION> getTotalPopulations2016() {
        // Create the ArrayList of LGA objects to return
        ArrayList<POPULATION> Populations = new ArrayList<POPULATION>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM (total_population) FROM POPULATION WHERE lga_year = '2016'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int lga_code = results.getInt("lga_code");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String lga_type = results.getString("lga_type");
                double area_sqkm = results.getDouble("area_sqkm");
                int total_population = results.getInt("total_population");
                int lga_year = results.getInt("lga_year");
         

                // Create a LGA Object
                POPULATION Population = new POPULATION(lga_code, lga_name, lga_state, lga_type, area_sqkm, total_population, lga_year);

                // Add the lga object to the array
                Populations.add(Population);
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
        return Populations;
    }
    
    public ArrayList<LGA1> getLGA() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA1> lga = new ArrayList<LGA1>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                int code = results.getInt("lga_code");
                String name = results.getString("lga_name");
                String lgaType = results.getString("lga_type");
                double area = results.getDouble("area_sqkm");
                double latitude = results.getDouble("latitude");
                double longitude = results.getDouble("longitude");
         

                // Create a LGA Object
                LGA1 lgas = new LGA1(code, name,lgaType, area, latitude, longitude);

                // Add the lga object to the array
                lga.add(lgas);
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
        return lga;
    }
    public ArrayList<LGA1> getLGAByState(String state) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA1> lga = new ArrayList<LGA1>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM POPULATION WHERE POPULATION.lga_year = 2021 and lga_state=\"" + state + "\";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                String name = results.getString("lga_name");
         

                // Create a LGA Object
                LGA1 lgas = new LGA1(name);

                // Add the lga object to the array
                lga.add(lgas);
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
        return lga;
    }

    public ArrayList<LGA1> getLGAByState2021(String state) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA1> lga = new ArrayList<LGA1>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(total_population) FROM POPULATION WHERE lga_year = 2021";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                
                // Lookup the columns we need
                String name = results.getString("lga_name");
         

                // Create a LGA Object
                LGA1 lgas = new LGA1(name);

                // Add the lga object to the array
                lga.add(lgas);
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
        return lga;
    }


    public ArrayList<POPULATION> getLGAByName(String namez) {
        // Create the ArrayList of LGA objects to return
        ArrayList<POPULATION> lganame = new ArrayList<POPULATION>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM POPULATION WHERE lga_year = 2021 and lga_name=\'" + namez + "\'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {


                
                // Lookup the columns we need
                int lga_code = results.getInt("lga_code");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String lga_type = results.getString("lga_type");
                double area_sqkm = results.getDouble("area_sqkm");
                int total_population = results.getInt("total_population");
                int lga_year = results.getInt("lga_year");
                
                POPULATION lga = new POPULATION(lga_code, lga_name, lga_state, lga_type, area_sqkm, total_population, lga_year);

                // Add the lga object to the array
                lganame.add(lga);
               
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
        return lganame;
    }
    public ArrayList<AllTables> getLGAByName2(String namez) {
        // Create the ArrayList of LGA objects to return
        ArrayList<AllTables> lganame = new ArrayList<AllTables>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Dataset12 WHERE lga_year = 2021 and lga_year = 2016 and lga_name=\'" + namez + "\' order by lgacode ASC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {


                
                // Lookup the columns we need
                int lgacode = results.getInt("lgacode");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String Indigenous_status = results.getString("Indigenous_status");
                String Sex = results.getString("Sex");
                String Age = results.getString("Age");
                int Count = results.getInt("Count");
                int lga_year = results.getInt("lga_year");
                // String SchoolYear = results.getString("SchoolYear");
                // String Income_bracket = results.getString("Income_bracket");

                AllTables specificdataset = new AllTables(lgacode, lga_name, lga_state, Indigenous_status, Sex, Age, Count, lga_year);

                // Add the lga object to the array
                lganame.add(specificdataset);
               
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
        return lganame;
    }

    public ArrayList<POPULATION> getTotalPopulation(String namez) {
        // Create the ArrayList of LGA objects to return
        ArrayList<POPULATION> lganame = new ArrayList<POPULATION>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM POPULATION WHERE lga_year = 2021 and lga_name=\'" + namez + "\'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {


                
                // Lookup the columns we need
                int lga_code = results.getInt("lga_code");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String lga_type = results.getString("lga_type");
                double area_sqkm = results.getDouble("area_sqkm");
                int total_population = results.getInt("total_population");
                int lga_year = results.getInt("lga_year");
                
                POPULATION lga = new POPULATION(lga_code, lga_name, lga_state, lga_type, area_sqkm, total_population, lga_year);

                // Add the lga object to the array
                lganame.add(lga);
               
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
        return lganame;
    }

    public ArrayList<TotalPopulation> getTotalPopulation() {
        // Create the ArrayList of LGA objects to return
        ArrayList<TotalPopulation> lganame = new ArrayList<TotalPopulation>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM totpopulation"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {


                
                // Lookup the columns we need
                int totpop = results.getInt("totpop");
                int lga_year = results.getInt("lga_year");


                
                
                TotalPopulation lga = new TotalPopulation(totpop, lga_year);

                // Add the lga object to the array
                lganame.add(lga);
               
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
        return lganame;
    }

    public int getTotalPopulationChange() {
        // Create the ArrayList of LGA objects to return
       int change = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT (t1.totpop - t2.totpop) AS changeinpop FROM totpopulation t1 CROSS JOIN totpopulation t2 WHERE t1.lga_year= '2021' AND t2.lga_year = '2016'"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {


                change = results.getInt("changeinpop");
               
               
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
        return change;
    }



    public int getMedianPopulation2021() {
        // Create the ArrayList of LGA objects to return
       int medianvalue = 137877;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT total_population AS medianpop FROM POPULATION ORDER BY ASC LIMIT 2 OFFSET ((SELECT COUNT(total_population) FROM POPULATION WHERE lga_year = 2021) / 2)"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                medianvalue = results.getInt("medianpop");
               
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
        return medianvalue;
    }


    public int getMedianPopulation2016() {
        // Create the ArrayList of LGA objects to return
       int medianvalue = 123607;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT total_population AS medianpop FROM POPULATION ORDER BY ASC LIMIT 1 OFFSET ((SELECT COUNT(total_population) FROM POPULATION) / 2)"; 
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {

                medianvalue = results.getInt("medianpop");
               
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
        return medianvalue;
    }


    public int getLgaCount(String lga_year) {
        // Create the ArrayList of LGA objects to return
        
        // Setup the variable for the JDBC connection
        Connection connection = null;
        int lgacount = 0;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COUNT(*) AS count FROM lga WHERE lga_year =" + lga_year;
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            
            while (results.next()) {
                
               lgacount = results.getInt("count"); 

               
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
        return lgacount;
    }

    public ArrayList<Outcome> getOutcomeTarget() {
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(Database);

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


    public ArrayList<medianpopulation> populationByState() {
        ArrayList<medianpopulation> populations = new ArrayList<medianpopulation>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String sql = "SELECT lga_state, total_population AS population FROM POPULATION WHERE lga_year = 2016 ORDER BY lga_state, population ASC;";

            System.out.print(sql);
        
            ResultSet results = statement.executeQuery(sql);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String lgaState = results.getString("lga_state");
                int population = results.getInt("population");

                // Create a LGA Object
                medianpopulation medianpopulations = new medianpopulation(lgaState, population);

                // Add the lga object to the array
                populations.add(medianpopulations);
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
        return populations;
    }


    public ArrayList<medianpopulation> populationByState2021() {
        ArrayList<medianpopulation> populations2021 = new ArrayList<medianpopulation>();
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String sql = "SELECT lga_state, total_population AS population FROM POPULATION WHERE lga_year = 2021 ORDER BY lga_state, population ASC;";
        
            ResultSet results = statement.executeQuery(sql);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String lgaState     = results.getString("lga_state");
                int population  = results.getInt("population");

                // Create a LGA Object
                medianpopulation medianpopulations = new medianpopulation(lgaState, population);

                // Add the lga object to the array
                populations2021.add(medianpopulations);
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
        return populations2021;
    }


    public ArrayList<String> getDatasetConditionColumns(String dataset) {
        Connection connection = null;
        ArrayList<String> columns = new ArrayList<String>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "";

            // The Query
            switch(dataset) {
                case "DATASET1":
                  query = "SELECT DISTINCT(Age) AS OPTIONS FROM INDIGSTATUSBYAGEANDSEX";
                  break;
                case "DATASET2":
                  query = "SELECT DISTINCT(Condition) AS OPTIONS FROM LTHC2021";
                  break;
                case "DATASET3":
                    query = "SELECT DISTINCT(SchoolYear) AS OPTIONS FROM SCHOOLCOMPLETION";
                    break;
                case "DATASET4":
                    query = "SELECT DISTINCT(Income_bracket) AS OPTIONS FROM WEEKLYINCOME";
                    break;
                default:
                    break;
            }
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                String option = results.getString("OPTIONS");

                columns.add(option);
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
        return columns;
    }

    public ArrayList<String> getIndigStatusColumns(String dataset) {
        Connection connection = null;
        ArrayList<String> columns = new ArrayList<String>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "";

            // The Query
            switch(dataset) {
                case "DATASET1":
                  query = "SELECT DISTINCT(Indigenous_status) AS indig_status FROM INDIGSTATUSBYAGEANDSEX";
                  break;
                case "DATASET2":
                  query = "SELECT DISTINCT(Indigenous_status) AS indig_status FROM LTHC2021";
                  break;
                case "DATASET3":
                    query = "SELECT DISTINCT(Indigenous_status) AS indig_status FROM SCHOOLCOMPLETION";
                    break;
                case "DATASET4":
                    query = "SELECT DISTINCT(Indigenous_status) AS indig_status FROM WEEKLYINCOME";
                    break;
                default:
                    break;
            }
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                String indig_status = results.getString("indig_status");

                columns.add(indig_status);
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
        return columns;
    }

    public ArrayList<POPULATION> getTotalPopulationByCondtionAndIndigStatus(String dataset, String status, String filter) {
        Connection connection = null;
        ArrayList<POPULATION> indigPopulationLgaCode = new ArrayList<POPULATION>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "";

            // The Query
            switch(dataset) {
                case "DATASET1":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM INDIGSTATUSBYAGEANDSEX WHERE Indigenous_status ='" + status + "' and lga_year = 2021 and Age = '" + filter + "' GROUP BY lgacode;";
                    break;
                case "DATASET2":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM LTHC2021 WHERE Indigenous_status ='" + status + "; and lga_year = 2021 and Condition = '" + filter + "' GROUP BY lgacode;";
                    break;
                case "DATASET3":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM SCHOOLCOMPLETION WHERE Indigenous_status ='" + status +"' and lga_year = 2021 and SchoolYear = '" + filter + "' GROUP BY lgacode;";
                    break;
                case "DATASET4":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM WEEKLYINCOME WHERE Indigenous_status ='" + status + "' and lga_year = 2021 and Iincome_bracket = '" + filter + "' GROUP BY lgacode;";
                    break;
                default:
                    break;
            }
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                
                int lga_code = results.getInt("lgacode");
                int totalIndigPopulation = results.getInt("totalIndingPop");


                POPULATION lgacode = new POPULATION(lga_code, "", "", "", 0.0, totalIndigPopulation, 2021);

                indigPopulationLgaCode.add(lgacode);
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
        return indigPopulationLgaCode;
    }

    public ArrayList<POPULATION> getTotalPopulationByIndigStatus (String dataset, String status) {
        Connection connection = null;
        ArrayList<POPULATION> indigPopulationLgaCode = new ArrayList<POPULATION>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "";

            // The Query
            switch(dataset) {
                case "DATASET1":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM INDIGSTATUSBYAGEANDSEX WHERE Indigenous_status ='" + status + "' and lga_year = 2021 GROUP BY lgacode;";
                    break;
                case "DATASET2":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM LTHC2021 WHERE Indigenous_status ='" + status + "' and lga_year = 2021 GROUP BY lgacode;";
                    break;
                case "DATASET3":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM SCHOOLCOMPLETION WHERE Indigenous_status ='" + status + "' and lga_year = 2021 GROUP BY lgacode;";
                    break;
                case "DATASET4":
                    query = "SELECT lgacode, SUM(Count) AS totalIndingPop FROM WEEKLYINCOME WHERE Indigenous_status ='" + status + "' and lga_year = 2021 GROUP BY lgacode;";
                    break;
                default:
                    break;
            }
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                
                int lga_code = results.getInt("lgacode");
                int totalIndigPopulation = results.getInt("totalIndingPop");


                POPULATION lgacode = new POPULATION(lga_code, "", "", "", 0.0, totalIndigPopulation, 2021);

                indigPopulationLgaCode.add(lgacode);
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
        return indigPopulationLgaCode;
    }
    public ArrayList<AllTables> getDatasets(String datasets) {
        Connection connection = null;
        ArrayList<AllTables> Datasets = new ArrayList<AllTables>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // String query = "SELECT * FROM Dataset12";
            String query= "";
            // The Query
            switch(datasets) {
                case "INDIGSTATUSBYAGEANDSEX":
                  query = "SELECT * FROM Dataset12";
                  break;
                case "SCHOOLCOMPLETION":
                  query = "SELECT * FROM Dataset32";
                  break;
                case "WEEKLYINCOME":
                    query = "SELECT * FROM Dataset42";
                    break;
            }
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                int lgacode = results.getInt("lgacode");
                String lga_name = results.getString("lga_name");
                String lga_state = results.getString("lga_state");
                String Indigenous_status = results.getString("Indigenous_status");
                String Sex = results.getString("Sex");
                String Age = results.getString("Age");
                int Count = results.getInt("Count");
                int lga_year = results.getInt("lga_year");
                // String SchoolYear = results.getString("SchoolYear");
                // String Income_bracket = results.getString("Income_bracket");

                AllTables specificdataset = new AllTables(lgacode, lga_name, lga_state, Indigenous_status, Sex, Age, Count, lga_year);

                Datasets.add(specificdataset);
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
        return Datasets;
    }

    public ArrayList<PageST21> getValuesFromDataSet(String dataset, String condition, String sex, String indigStatus, String orderCategory, String order, String year) {
        Connection connection = null;
        ArrayList<PageST21> displayList = new ArrayList<PageST21>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(database);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "";

            // The Query
            String StringDataset1 = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, Age AS Condition, Count AS [Number of People], PD AS [Proportional Data], GAP FROM INDIGSTATUSBYAGEANDSEX WHERE";
            String StringDataset2 = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, Condition as Condition, Count AS [Number of People], PD AS [Proportional Data], GAP FROM LTHC2021 WHERE";
            String StringDataset3 = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, SchoolYear as Condition, Count AS [Number of People], PD AS [Proportional Data], GAP FROM SCHOOLCOMPLETION WHERE";
            String StringDataset4 = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Income_bracket as Condition, Count AS [Number of People], PD AS [Proportional Data], GAP FROM WEEKLYINCOME WHERE";


            String orderCategoryAndDir = " ORDER BY \"" + orderCategory + "\" " + order + ";";


            String StringDataset1Sum = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, Age AS Condition, SUM(Count) AS [Number of People], PD AS [Proportional Data], GAP FROM INDIGSTATUSBYAGEANDSEX WHERE";
            String StringDataset2Sum = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, Condition AS Condition, SUM(Count) AS [Number of People], PD AS [Proportional Data], GAP FROM LTHC2021 WHERE";
            String StringDataset3Sum = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, SchoolYear AS Condition, SUM(Count) AS [Number of People], PD AS [Proportional Data], GAP FROM SCHOOLCOMPLETION WHERE";
            String StringDataset4Sum = "SELECT lgacode AS [LGA Code], Indigenous_status AS [Indigenous Status], Sex, Income_bracket AS Condition, SUM(Count) AS [Number of People], PD AS [Proportional Data], GAP FROM WEEKLYINCOME WHERE";



            // All Totals
            if (sex.equals("Total") && condition.equals("All") && indigStatus.equals("All")) {
                System.out.println(1);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1Sum + " lga_year = 2021" + " GROUP BY Condition, Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2Sum + " lga_year = 2021" + " GROUP BY Condition, Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3Sum + " lga_year = 2021" + " GROUP BY Condition, Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4Sum + " lga_year = 2021" + " GROUP BY Condition, Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }
                

            } else if (sex.equals("Total") && condition.equals("All") && !indigStatus.equals("All")) {
                System.out.println(2);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1Sum + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " GROUP BY Condition, lgacode ORDER BY \"" + orderCategory + "\", 'Condition' " + order;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2Sum + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " GROUP BY Condition, lgacode ORDER BY \"" + orderCategory + "\", 'Condition' " + order;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3Sum + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " GROUP BY Condition, lgacode ORDER BY \"" + orderCategory + "\", 'Condition' " + order;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4Sum + " Indigenous_status ='" + indigStatus + "' and lga_year = "+ year + " GROUP BY Condition, lgacode ORDER BY \"" + orderCategory + "\", 'Condition' " + order;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }

            } else if (sex.equals("Total") && !condition.equals("All") && !indigStatus.equals("All")) {
                System.out.println(3);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1Sum + " Indigenous_status ='" +  indigStatus + "' and lga_year = " + year + " and Age = '" + condition + "'" + " GROUP BY lgacode" + orderCategoryAndDir; 
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2Sum + " Indigenous_status ='" +  indigStatus + "' and lga_year = " + year + " and Condition = '" + condition + "'" + " GROUP BY lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3Sum + " Indigenous_status ='" +  indigStatus + "' and lga_year = " + year + " and SchoolYear = '" + condition + "'" + " GROUP BY lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4Sum + " Indigenous_status ='" +  indigStatus + "' and lga_year = " + year + " and Income_bracket = '" + condition + "'" + " GROUP BY lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }

            } else if (!sex.equals("Total") && !condition.equals("All") && indigStatus.equals("All")) {
                System.out.println(4);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1 + " lga_year = " + year + " and Age = '" + condition + "' and Sex ='" + sex  + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2 + " lga_year = " + year + " and Condition = '" + condition + "' and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3 + " lga_year = " + year + " and SchoolYear = '" + condition + "' and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4 + " lga_year = " + year + " and Income_bracket = '" + condition + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }
                
            }   else if (!sex.equals("Total") && condition.equals("All") && indigStatus.equals("All")) {
                System.out.println(5);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1 + " lga_year = " + year + " and Sex ='" + sex  + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2 + " lga_year = " + year + " and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3 + " lga_year = " + year + " and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4 + " lga_year = " + year + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }
                
                
                
            }   else if (!sex.equals("Total") && condition.equals("All") && !indigStatus.equals("All")) {
                System.out.println(6);
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1 + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " and Sex ='" + sex  + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2 + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " and Sex ='" + sex  + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3 + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + " and Sex ='" + sex  + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4 + " Indigenous_status ='" + indigStatus + "' and lga_year = " + year + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }
                
            }    else if (sex.equals("Total") && !condition.equals("All") && indigStatus.equals("All")) {
                 System.out.println(7);
                 switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1Sum + " lga_year =" + year + " and Age ='" + condition  + "'" + " GROUP BY Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2Sum + " lga_year =" + year + " and Condition ='" + condition  + "'" + " GROUP BY Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3Sum + " lga_year =" + year + " and SchoolYear ='" + condition  + "'" + " GROUP BY Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4Sum + " lga_year =" + year + " and Income_bracket ='" + condition  + "'" + " GROUP BY Indigenous_status, lgacode" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }  
                
            }   else {
                System.out.println("else");
                switch(dataset) {
                    case "DATASET1":
                        query = StringDataset1 + " Indigenous_status ='" + indigStatus + "' and lga_year =" + year + " and Age ='" + condition + "' and  Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET2":
                        query = StringDataset2 + " Indigenous_status ='" + indigStatus + "' and lga_year =" + year + " and Condition ='" + condition + "' and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET3":
                        query = StringDataset3 + " Indigenous_status ='" + indigStatus + "' and lga_year =" + year + " and SchoolYear ='" + condition + "' and Sex ='" + sex + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    case "DATASET4":
                        query = StringDataset4 + " Indigenous_status ='" + indigStatus + "' and lga_year =" + year + " and Income_bracket ='" + condition + "'" + orderCategoryAndDir;
                        System.out.println(query);
                        break;
                    default:
                        break;
                }
            }


            
                  
            ResultSet results = statement.executeQuery(query);

            while(results.next()) {
                
                PageST21 row = new PageST21();
                row.setLgaCode(results.getString("LGA Code"));
                row.setIndigStatus(results.getString("Indigenous Status"));

                if (sex.equals("Total")) {
                    row.setSex("Total");
                }
                else {
                    if (!dataset.equals("DATASET4")){
                        row.setSex(results.getString("Sex"));
                    } else {
                        row.setSex("Not Available");
                    }
                }
                row.setPropValue(results.getFloat("Proportional Data"));
                row.setGap(results.getFloat("GAP"));
               


             
                row.setCondition(results.getString("Condition"));
                row.setConditionCount(results.getInt("Number of People"));
                
               displayList.add(row);
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
        return displayList;


    }

   
}




    // TODO: Add your required methods here
