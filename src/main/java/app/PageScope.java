package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageScope implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/scope.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        html += """
                
                

            <!DOCTYPE html>
            <html lang="en" dir="ltr">
            <head>
                <meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale = 1">
                <link rel='stylesheet' type='text/css' href='Scope.css' />
                <title>"Scope"</title>
            </head>
            <body>  
            <div id='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='scope.html'>Scope</a>
                <a href='st21.html'>Sub Task 2.1</a>
                <a href='page4.html'>Sub Task 2.2</a>
                <a href='PageST23.html'>Sub Task 2.3</a>

                </div>

                <div class = 'scope-heading'>
                    <img src="https://cdn.wallpapersafari.com/78/47/ZwEWHM.jpeg" alt="Indigenous Background Image" width="1080" height="500">
                    <div class = "centered-text">
                    <h1>Our Scope</h1>
                    </div>
                </div>

                <div class = 'test'>
                    <div class = 'scope-title1'>
                    <h2>
                        Scope Of Our Datasets
                    </h2>
                    </div>

                    <div class = 'scope-title2'>
                    <h2>
                        Purpose Of Our DataSets 
                    </h2>
                    </div>

                    <div class = 'scope-content1'>
                    <p>
                        The datasets used within this website are statistics, including information like the latest year 
                        of highschool completed, health conditions, weekly household income. All of these stats compare 
                        indigenous and non-indigenous children as well as whether they are male or female. The data varies 
                        from 2016 to 2021 to show the change in these stats over the course of 5 years, to show whether we 
                        have improved in closing the gap and by what percentage.   
                    </p>
                    </div>
                    <div class = 'scope-content2'>
                    <p>
                        The purpose of these datasets is to show whether over a five year span what fields we have been able 
                        to drastically improve in aiding indigenous people. Furthermore, these datasets also help in seeing 
                        which areas are still lacking and or are potentially stagnant and require more aid.
                    </p>
                    </div>

                </div>

                """;

                html = html + """
                        

                
                
                <div class="row">
                    <div class="column">
                        <img src="https://www.indigenousliteracyfoundation.org.au/site/user-assets/images/20140320closethegapday11716.jpg" 
                        alt="Indigenous Community" style="width:100%" >
                    </div>
                    <div class="column" id='column1'>
                        <div class = 'data-title'><h2> Comparison Of Total Populations </h2></div>
                        
                            <div class="outer-wrapper">
                            <div class="table-wrapper">
                                    <table class='table'>
                                        <thead>
                                        
                                        <th class='title'>Population</th>
                                        <th class='title'>Year</th>
                                        <th class='title'>LGA count</th>
                                        
                                        </thead>
                                        """;

                                        JDBCConnection jdbc = new JDBCConnection();
                            
                                        ArrayList<TotalPopulation> lganame = jdbc.getTotalPopulation();
                                        for (TotalPopulation lga : lganame) {
                                        html = html + 
                                        "<tr>"
                                        + "<td class='data'>" + lga.getTotpop() + "</td>" 
                                        + "<td class='data'>" + lga.getLga_year() + "</td>" 
                                        + "<td class='data'>" + jdbc.getLgaCount("" + lga.getLga_year() + "") + "</td>"
                                        + "</tr>";
                                        }
                                        html = html + "</tbody>";
                                        html = html + "</table>";

                                        html = html + "</div>";
                                        html = html + "</div>";


            

            html += "</body>";
                                        html += """

                    </div>
                </div>



                    """;

            html += "</body>";



                html = html + """
            <<div class='footer'>
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



        html = html + "</body>" + "</html>";

        context.html(html);
    }

}
