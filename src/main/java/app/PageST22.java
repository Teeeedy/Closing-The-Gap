package app;

import java.security.Key;
import java.util.ArrayList;

import org.sqlite.JDBC;

import io.javalin.http.Context;
import io.javalin.http.Handler;


/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST22 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page4.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        JDBCConnection jdbc = new JDBCConnection();
        
        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.2</title>";
               

        // Add some CSS (external file)
       // html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='Page22.css' />";
        
        html = html + "</head>";
        // Add the body
        html = html + "<body>";

        // Add the topnavg
        // This uses a Java v15+ Text Block
        html = html + """
            <div id='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='scope.html'>Scope</a>
                <a href='st21.html'>Sub Task 2.1</a>
                <a href='page4.html'>Sub Task 2.2</a>
                <a href='PageST23.html'>Sub Task 2.3</a>

            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Focused view by LGA</h1>
            </div>
        """;

        html += "<div class ='information'>" ;
        
        html += 
        "<p>" + 
        "The following information displays focused information on the change between the 2016 and 2021 data for the LGA that is to be selected, and continues off from information displayed from page 2.1. " +
        "</p>";

        html += "</div>";

        // html += """
                        
                
        //     <div class="outer-wrapper">
        //     <div class="table-wrapper">
        //                             <table>
        //                                 <thead>

        //                                 <th>Lga Code</th>
        //                                 <th>Lga Name</th>
        //                                 <th>Lga State</th>
        //                                 <th>Status</th>
        //                                 <th>Sex</th>
        //                                 <th>Age</th>
        //                                 <th>Count</th>
        //                                 <th>Year</th>

        //                                 </thead>
                                    
                                        
        //                  """;
                         
        //                     ArrayList<AllTables> datasetname = jdbc.getDatasets();
        //                     for (AllTables Datasets : datasetname) {
        //                     html = html + 
        //                     "<tr>"
        //                     + "<td>" + Datasets.getLgacode() + "</td>" 
        //                     + "<td>" + Datasets.getLga_name() + "</td>" 
        //                     + "<td>" + Datasets.getLga_state() + "</td>" 
        //                     + "<td>" + Datasets.getIndigenous_Status() + "</td>" 
        //                     + "<td>" + Datasets.getsex() + "</td>" 
        //                     + "<td>" + Datasets.getage() + "</td>" 
        //                     + "<td>" + Datasets.getcount() + "</td>" 
        //                     + "<td>" + Datasets.getLga_year() + "</td>" 
        //                     + "</tr>";
        //                     }
                        
        //                  html = html + "</tbody>";
        //                  html = html + "</table>";
                         
        //                  html = html + "</div>";
        //                  html = html + "</div>";


        // html = html + """
        //     <h3> test form </h3>
        //         <div className = 'test-form'>
        //             <label htmlFor='username'
        //             className='form-label'>
        //             Username
        //             </label>
        //             <input type="text" 
        //             name='username'
        //             placeholder="Enter your username" 
        //             id="test-username"
        //             />
        //         </div>

        //         <div className = 'test-form'>
        //             <label htmlFor='email'
        //             className='form-label'>
        //             Email
        //             </label>
        //             <input type="email" 
        //             name='email'
        //             placeholder="Enter your email" 
        //             id="test-email"
        //             />
        //         </div>

        //         <div className = 'test-form'>
        //             <label htmlFor='password'
        //             className='form-label'>
        //             Password
        //             </label>
        //             <input type="text" 
        //             name='password'
        //             placeholder="Enter your password" 
        //             id="test-password"
        //             />
        //         </div>

        //         <div className = 'test-form'>
        //             <label htmlFor='button'
        //             className='form-label'>
                    
        //             </label>
        //             <input type="submit" 
        //             name='button'
        //             value="Search" 
        //             id="test-button"
        //             />
        //         </div> """;
                
    

            // <meta name="viewport" content="width=device-width, initial-scale=1">
            // <div style="overflow-x:auto;">


             
                 
                    
                          

                            


                // html = html + """
                        
                       
                // <h2> 2021 Population Statistics </h2>
                
                
                // <form action='/page4.html' method='post' id='state_form' ;">  
                // <b> State: </b>  
                // <select id='lga_state' name='lga_state' >
                //     <option value="none" selected disabled hidden>Select a state</option>
                //     <option value="NSW">New South Wales</option>
                //     <option value="Victoria">Victoria</option>
                //     <option value="QLD">Queensland</option>
                //     <option value="South Australia">South Australia</option>
                //     <option value="Western Australia">Western Australia</option>
                //     <option value="Tasmania">Tasmania</option>
                //     <option value="Northern Territory">Northern Territory</option>
                //     <option value="ACT">Australian Capital Territories</option>
                //     <option value="Other Territories">Other Territories</option>
                // </select>
                // <button type='submit' class='btn dataset-btn'>Get LGAs</button> 
                // </form> 
              
                       
                //        """;
                        



                        // JDBCConnection jdbc = new JDBCConnection();
                        // String state_drop = context.formParam("lga_state");
        
                        // if (state_drop == null) {
                        //     html += "<h2>No State Selected</h2>";
                            
                        // } else {
                        //     ArrayList<LGA1> lga_state_drop = jdbc.getLGAByState(state_drop);
                        //     html += "<h3>" + state_drop + "</h3>";
                        //     html += """
                                
                        //         <form action='/page4.html' method='post'>
                        //         <label for='dataset_drop'>Select the LGA:</label>
                        //         <select id='dataset_drop' name='dataset_drop'>
                        //         <option value="" selected="selected" hidden="hidden">Select LGA</option>
                        //         <button type='submit' class='btn dataset-btn'>Get Your Dataset</button>
                        //         </form>
    
                        //         """;
                        //     for (LGA1 lga_code : lga_state_drop) {
                        //         html += "<option value =" + lga_code.getName() + "\">";
                        //         html += lga_code.getName();
                        //         html += "</option>";
                        //         html += "<button type='submit' class='btn dataset-btn'>Get Your Dataset</button>";

                        //     }
                        //      html += "<button type='submit' class='btn dataset-btn'>Get Your Dataset</button>";
                        // }
                        // html += "<button type='submit' class='btn dataset-btn'>Get Your Dataset</button>";
                        html += "<style>" + "p {text-align: center;}" + "</style>";

                        

                        html += "<p><b>Total population change since 2016 is an increase of " + jdbc.getTotalPopulationChange() + " people.</b></p>";
                        
                        html += """
                        
                
                            <div class="outer-wrapper">
                                    <table>
                                        <thead>

                                        <th>Total Population</th>
                                        <th>Year</th>

                                        </thead>
                                    
                                        
                         """;
                         
                            ArrayList<TotalPopulation> lganame = jdbc.getTotalPopulation();
                            for (TotalPopulation lga : lganame) {
                            html = html + 
                            "<tr>"
                            + "<td>" + lga.getTotpop() + "</td>" 
                            + "<td>" + lga.getLga_year() + "</td>" 
                            + "</tr>";
                            }
                        
                         html = html + "</tbody>";
                         html = html + "</table>";
                         
                         html = html + "</div>";


                        //            """;

                html += "<p><b>" + "Select a State and LGA to view population information on the selected 2021 LGA" + "</b></p>";



                // html += """
                        

                // <form action='/page4.html' method='post' id='dataset_form'>
                // <h2> Dataset: </h2>  
                //             <select id='dataset_choice' name='dataset_choice' >
                //             <option value="none" selected disabled hidden>--Select a state--</option>
                //             <option value="INDIGSTATUSBYAGEANDSEX">Indigenous status by age and sex</option>
                //             <option value="SCHOOLCOMPLETION">Highest year of school completed by sex</option>
                //             <option value="WEEKLYINCOME">Total household weekly income by indigenous status and household</option>  
                //             </select>
                //             <button type='submit' class='btn dataset-btn'>Choose dataset</button> 
                //             </form> 
                //                     """;


                html += """
                <form action='/page4.html' method='post' id='state_form'>  
                            <h2> State: </h2>  
                            <select id='lga_state' name='lga_state' >
                                <option value="none" selected disabled hidden>--Select a state--</option>
                                <option value="NSW">New South Wales</option>
                                <option value="Victoria">Victoria</option>
                                <option value="QLD">Queensland</option>
                                <option value="South Australia">South Australia</option>
                                <option value="Western Australia">Western Australia</option>
                                <option value="Tasmania">Tasmania</option>
                                <option value="Northern Territory">Northern Territory</option>
                                <option value="ACT">Australian Capital Territories</option>
                                <option value="Other Territories">Other Territories</option>
                            </select>
                            <button type='submit' class='btn dataset-btn'>Get LGAs</button> 
                            </form> 
           
                                    
                                    """;
                                    String state_drop = context.formParam("lga_state");
        
                                    if (state_drop == null) {
                                        html += """
                                            <style>
                                             h2{text-align: center;}
                                            </style>
                                            
                                            <h2>No State Selected</h2>
                                            
                                        
                                                    
                                                    """;
                                        
                                    } else {
                                        ArrayList<LGA1> lga_state_drop = jdbc.getLGAByState(state_drop);
                                        html +=  "<style>" +
                                        "h2{text-align: center;}" +
                                       "</style>" + "<h2>" + state_drop + "</h2>" ;
                                        html += """
                                            
                                            <form action='/page4.html' method='post' id='lga_form'>
                                            <h2>LGA:</h2>
                                            <select id='lga_drop' name='lga_drop'>
                                            <option value="" selected="selected" hidden="hidden">--Select an LGA--</option>
            
                                            
                                            
                
                                            """;                            
                                        for (LGA1 lga_code : lga_state_drop) {
                                            html += "<option value =" + lga_code.getName() + ">";
                                            html += lga_code.getName();
                                            html += "</option>";
                                            
                                        }
                                        html += "</select>";
                                        html += "<button type='submit' class='btn dataset-btn'>Display the chosen LGA</button>";
                                        html += "</form>";
                                    }
                                   
                html += """
                    <div class="outer-wrapper">
                                    <div class="table-wrapper">
                        
                         <table>
                            <thead>
                            
                            <th>Lga Code</th>
                            <th>Lga Name</th>
                            <th>State</th>
                            <th>Type</th>
                            <th>Area (sqkm)</th>
                           
                            
                            
                            </thead>
                            
                        """;


                        String lga_drop = context.formParam("lga_drop");

                            ArrayList<POPULATION> lganamea = jdbc.getLGAByName(lga_drop);
                            
                            if (lga_drop == null) {
                                
                            ArrayList<POPULATION> Populations = jdbc.getPopulations();
                            for (POPULATION Population : Populations) {
                            html = html + 
                            "<tr>"
                            + "<td>" + Population.getLga_code() + "</td>"
                            + "<td>" + Population.getLga_name() + "</td>"
                            + "<td>" + Population.getLga_state() + "</td>" 
                            + "<td>" + Population.getLga_type() + "</td>" 
                            + "<td>" + Population.getArea_sqkm() + "</td>" 
                
                            + "</tr>";
                            }
                                
                            } else {
                                html += "<h2>" + lganamea.get(0).getLga_code() + "</h2>";

                                    for (POPULATION Population : lganamea) {
                                        html = html + 
                                        "<tr>"
                                        + "<td>" + Population.getLga_code() + "</td>"
                                        + "<td>" + Population.getLga_name() + "</td>"
                                        + "<td>" + Population.getLga_state() + "</td>" 
                                        + "<td>" + Population.getLga_type() + "</td>" 
                                        + "<td>" + Population.getArea_sqkm() + "</td>" 
                                       
                                        + "</tr>";
                                        }
        
                            }

 
                html = html + "</tbody>";
                html = html + "</table>";

                html = html + "</div>";
                html = html + "</div>";


                                   
                // html += """
                //     <div class="outer-wrapper">
                //                     <div class="table-wrapper">
                        
                //          <table>
                //             <thead>
                            
                //             <th>Lga Code</th>
                //             <th>Lga Name</th>
                //             <th>State</th>
                //             <th>Indigenous Status</th>
                //             <th>Gender</th>
                //             <th>Age</th>
                //             <th>Count</th>
                //             <th>Year</th>
                           
                            
                            
                //             </thead>
                            
                //         """;


                  
                                
                //             ArrayList<AllTables> indigstats = jdbc.getINDIGSTATUS();
                       
                //                     for (AllTables indigstat : indigstats) {
                //                         html = html + 
                //                         "<tr>"
                //                         + "<td>" + indigstat.getLgacode() + "</td>"
                //                         + "<td>" + indigstat.getLga_name() + "</td>"
                //                         + "<td>" + indigstat.getLga_state() + "</td>" 
                //                         + "<td>" + indigstat.getIndigenous_Status() + "</td>" 
                //                         + "<td>" + indigstat.getsex() + "</td>" 
                //                         + "<td>" + indigstat.getage() + "</td>" 
                //                         + "<td>" + indigstat.getcount() + "</td>" 
                //                         + "<td>" + indigstat.getLga_year() + "</td>" 
                                       
                //                         + "</tr>";
                //                         }
        
                            

 
                // html = html + "</tbody>";
                // html = html + "</table>";

                // html = html + "</div>";
                // html = html + "</div>";

                // html += """
                //     <div class="outer-wrapper">
                //                     <div class="table-wrapper">
                        
                //          <table>
                //             <thead>
                            
                //             <th>Lga Code</th>
                //             <th>Lga Name</th>
                //             <th>State</th>
                //             <th>Indigenous Status</th>
                //             <th>Gender</th>
                //             <th>SchoolYear</th>
                //             <th>Count</th>
                //             <th>Year</th>
                           
                            
                            
                //             </thead>
                            
                //         """;


                  
                                
                //             ArrayList<schoolcompletion> indigstats2 = jdbc.getSCHOOL();
                       
                //                     for (schoolcompletion indigstat : indigstats2) {
                //                         html = html + 
                //                         "<tr>"
                //                         + "<td>" + indigstat.getLgacode() + "</td>"
                //                         + "<td>" + indigstat.getLga_name() + "</td>"
                //                         + "<td>" + indigstat.getLga_state() + "</td>" 
                //                         + "<td>" + indigstat.getIndigenous_Status() + "</td>" 
                //                         + "<td>" + indigstat.getsex() + "</td>" 
                //                         + "<td>" + indigstat.getSchoolyear() + "</td>" 
                //                         + "<td>" + indigstat.getcount() + "</td>" 
                //                         + "<td>" + indigstat.getLga_year() + "</td>" 
                                       
                //                         + "</tr>";
                //                         }
        
                            

 
                // html = html + "</tbody>";
                // html = html + "</table>";

                // html = html + "</div>";
                // html = html + "</div>";
                // html += """
                //     <div class="outer-wrapper">
                //                     <div class="table-wrapper">
                        
                //          <table>
                //             <thead>
                            
                //             <th>Lga Code</th>
                //             <th>Lga Name</th>
                //             <th>State</th>
                //             <th>Indigenous Status</th>
                //             <th>Income_bracket</th>
                //             <th>Count</th>
                //             <th>Year</th>
                           
                            
                            
                //             </thead>
                            
                //         """;


                  
                                
                //             ArrayList<weeklyincome> indigstats3 = jdbc.getINCOME();
                       
                //                     for (weeklyincome indigstat : indigstats3) {
                //                         html = html + 
                //                         "<tr>"
                //                         + "<td>" + indigstat.getLgacode() + "</td>"
                //                         + "<td>" + indigstat.getLga_name() + "</td>"
                //                         + "<td>" + indigstat.getLga_state() + "</td>" 
                //                         + "<td>" + indigstat.getIndigenous_Status() + "</td>" 
                //                         + "<td>" + indigstat.getincome_bracket() + "</td>" 
                //                         + "<td>" + indigstat.getcount() + "</td>" 
                //                         + "<td>" + indigstat.getLga_year() + "</td>" 
                                       
                //                         + "</tr>";
                //                         }
        
                            

 
                // html = html + "</tbody>";
                // html = html + "</table>";

                // html = html + "</div>";
                // html = html + "</div>";

                html += """

                    <h1>Select the dataset you would like to view</h1>
                    
                    <p> 
                    The following links display the tables of each dataset that contain both 2016 and 2021 information.
                    </p>
                    
                
            <a href='page10.html'>Dataset 1 - Indigenous Status by Age and Sex</a>
            <a href='page11.html'>Dataset 3 - Highest year of school completion by Indigenous Status</a>
            <a href='page12.html'>Dataset 4 - Househould weekly income by Indigenous Status</a>
            
                """;



                html = html + """
                    <div class='footer'>
                        <div class='footer-heading'>
                            <h2>About us</h2>
                            <a href='#'> Our story </a>
                            <a href='#'> Team </a>
                            <a href='#'> Blog </a>
                        </div>
    
                        <div class='footer-heading'>
                            <h2>Contact us</h2>
                            <a href='#'> Support </a>
                            <a href='#'> Send us a message </a>
                            <a href='#'> Newsletters </a>
                        </div>
    
                        <div class='footer-heading'>
                            <h2>Stay connected</h2>
                            <a href='#'> Facebook </a>
                            <a href='#'> Twitter </a>
                            <a href='#'> Instagram </a>
                        </div>
    
                    </div>
                """;
        
               

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


       
        
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);

        
    }
    }
