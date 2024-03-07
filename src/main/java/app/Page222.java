package app;
import java.security.Key;
import java.util.ArrayList;

import org.sqlite.JDBC;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Page222 implements Handler {
    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page10.html";
    

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        JDBCConnection jdbc = new JDBCConnection();

        html = html + "<head>";
        html = html + "<link rel='stylesheet' type='text/css' href='Page222.css' />";
        html += "</head>";
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
        html += "<div class ='information'>" ;
        
        html += 
        "<p>" + 
        "The following information compares the data between the 2016 and 2021 dataset for each LGA. The data is been pre-filtered in order to display the LGA ranking. The LGA with the highest count for the given condition is displayed first, and decreases as the table moves further down. The information shown is only for individuals who identify themselves as Indigenous." +        "</p>";
        html += "</div>";

        html += "<h1>Indigenous Status by Age and Sex</h1>";

        html += """
            <div class="outer-wrapper">
                            <div class="table-wrapper">
                
                 <table>
                    <thead>
                    
                    <th>Lga Code</th>
                    <th>Lga Name</th>
                    <th>State</th>
                    <th>Indigenous Status</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Count</th>
                    <th>Year</th>
                   
                    
                    
                    </thead>
                    
                """;


          
                        
                    ArrayList<AllTables> indigstats = jdbc.getINDIGSTATUS();
               
                            for (AllTables indigstat : indigstats) {
                                html = html + 
                                "<tr>"
                                + "<td>" + indigstat.getLgacode() + "</td>"
                                + "<td>" + indigstat.getLga_name() + "</td>"
                                + "<td>" + indigstat.getLga_state() + "</td>" 
                                + "<td>" + indigstat.getIndigenous_Status() + "</td>" 
                                + "<td>" + indigstat.getsex() + "</td>" 
                                + "<td>" + indigstat.getage() + "</td>" 
                                + "<td>" + indigstat.getcount() + "</td>" 
                                + "<td>" + indigstat.getLga_year() + "</td>" 
                               
                                + "</tr>";
                                }


        html = html + "</tbody>";
        html = html + "</table>";

        html = html + "</div>";
        html = html + "</div>";

        html += """
                   
                    
            <h1>Select the dataset you would like to view</h1>
            <p> 
                    The following links display the tables of each dataset that contain both 2016 and 2021 information.
                    </p>
                    
                
            <a href='page10.html'>Dataset 1 - Indigenous Status by Age and Sex</a>
            <a href='page11.html'>Dataset 3 - Highest year of school completion by Indigenous Status</a>
            <a href='page12.html'>Dataset 4 - Househould weekly income by Indigenous Status</a>
            
                """;
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
