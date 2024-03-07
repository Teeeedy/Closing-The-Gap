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
public class PageST23 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST23.html";

    @Override
    public void handle(Context context) throws Exception {

        String html = "<html>";
        JDBCConnection jdbc = new JDBCConnection();


        html += """
                
            <!DOCTYPE html>
            <html lang="en" dir="ltr">
            <head>
                <meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale = 1">
                <link rel='stylesheet' type='text/css' href='Page23.css' />
                <title>"Australia Wide Population"</title>
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


            """;

            html = html + """
                        
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



                    html += "<div class = 'datainfo'><p>Resultant population change from 2016 to 2021 is " + jdbc.getTotalPopulationChange() + " people</p></div>";

                    html += "<div class = 'datainfo'><p>Median population Australia wide for 2021 is " + jdbc.getMedianPopulation2021() + " people</p></div>";

                    html += "<div class = 'datainfo'><p>Median population Australia wide for 2016 is " + jdbc.getMedianPopulation2016() + " people</p></div>";

                    
                    
                    html = html + """

                    <div class = 'section1'>
                        
                        <div class="column" id='column1'>
                            <div class = 'data-title'><h2>Median Populations Of Each State In 2016</h2></div>
                            
                                <div class="outer-wrapper">
                                <div class="table-wrapper">
                                        <table class='table'>
                                            <thead>
                                            
                                            <th class='title'>Median Population</th>
                                            <th class='title'>State</th>
                                            
                                            </thead>
                    """;
                    
                                int medianACT = 2;
                                int medianNSW = 69;
                                int medianNorthernTerritory = 146;
                                int medianOtherterritories = 157;
                                int medianQLD = 199;
                                int medianSouthAustralia = 275;
                                int medianTasmania = 327;
                                int medianVictoria = 384;
                                int medianWesternAustralia = 494;

                    int count = 0;
                    ArrayList<medianpopulation> populations = jdbc.populationByState();
                            for (medianpopulation medianpopulations : populations) {

                                if (medianpopulations.getlgaState() == "ACT") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "NSW") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                
                                if (medianpopulations.getlgaState() == "NSW") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Northern Territory") {
                                        medianACT = (count + 1) / 2;
 

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Northern Territory") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Other Territories") {
                                        medianACT = (count + 1) / 2;
  

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Other Territories") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "QLD") {
                                        medianACT = (count + 1) / 2;
 

                                    }
                                }
                                if (medianpopulations.getlgaState() == "QLD") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "South Australia") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "South Australia") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Tasmania") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Tasmania") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Victoria") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "Victoria") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Western Australia") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Western Australia") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "") {
                                        medianACT = (count + 1) / 2;
                                        
                                    }
                            }

                        }

                            html += "  <tr>  ";
                            html += " <td class='data'> " + populations.get(medianACT).getpopulation() + " </td> " + " <td class='data'>ACT</td>";
                            html += "  </tr>  ";
                            html += "  <tr>  ";
                            html += " <td class='data'> " + populations.get(medianNSW).getpopulation() + " </td> " + " <td class='data'>NSW</td>";
                            html += "  </tr>  ";
                            html += "  <tr>  ";
                            html += " <td class='data'> " + populations.get(medianNorthernTerritory).getpopulation() + " </td> " + " <td class='data'>Northern Territory</td>";
                            html += "  </tr>  ";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianOtherterritories).getpopulation() + " </td> " + " <td class='data'>Other Territories</td>";
                            html += "</tr>";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianQLD).getpopulation() + " </td> " + " <td class='data'>QLD</td>";
                            html += "</tr>";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianSouthAustralia).getpopulation() + " </td> " + " <td class='data'>South Australia</td>";
                            html += "</tr>";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianTasmania).getpopulation() + " </td> " + " <td class='data'>Tasmania</td>";
                            html += "</tr>";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianVictoria).getpopulation() + " </td> " + " <td class='data'>Victoria</td>";
                            html += "</tr>";
                            html += "<tr>";
                            html += " <td class='data'> " + populations.get(medianWesternAustralia).getpopulation() + " </td> " + " <td class='data'>WA</td>";
                            html += "</tr>";
                        
                         html = html + "</tbody>";
                         html = html + "</table>";
                         
                         html = html + "</div>";

                         html += """

                            </div>
                            </div>
                            </div>
    
    
    
                        """;



                         html = html + """
                        

                        <div class = 'section2'>
                        <div class="column" id='column1'>
                            <div class = 'data-title'><h2>Median Populations Of Each State In 2021</h2></div>
                            
                                <div class="outer-wrapper">
                                <div class="table-wrapper">
                                        <table class='table'>
                                            <thead>
                                            
                                            <th class='title'>Median Population</th>
                                            <th class='title'>State</th>
                                            
                                            </thead>
                    """;
                    
                    int medianOtherterritories2 = 156;
                    ArrayList<medianpopulation> populations2021 = jdbc.populationByState2021();
                            for (medianpopulation medianpopulations : populations2021) {


                                if (medianpopulations.getlgaState() == "ACT") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "NSW") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                
                                if (medianpopulations.getlgaState() == "NSW") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Northern Territory") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "Northern Territory") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Other Territories") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "Other Territories") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "QLD") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "QLD") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "South Australia") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "South Australia") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Tasmania") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Tasmania") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Victoria") {
                                        medianACT = (count + 1) / 2;


                                    }
                                }
                                if (medianpopulations.getlgaState() == "Victoria") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "Western Australia") {
                                        medianACT = (count + 1) / 2;

                                    }
                                }
                                if (medianpopulations.getlgaState() == "Western Australia") {
                                    ++count;
                                    medianACT = 1;
                                    if (populations.get(count+1).getlgaState() == "") {
                                        medianACT = (count + 1) / 2;
                                        
                                    }
                            }

                        }

                                html += "  <tr>  ";
                                html += " <td class='data'> " + populations2021.get(medianACT).getpopulation() + " </td> " + " <td class='data'>ACT</td>";
                                html += "  </tr>  ";
                                html += "  <tr>  ";
                                html += " <td class='data'> " + populations2021.get(medianNSW).getpopulation() + " </td> " + " <td class='data'>NSW</td>";
                                html += "  </tr>  ";
                                html += "  <tr>  ";
                                html += " <td class='data'> " + populations2021.get(medianNorthernTerritory).getpopulation() + " </td> " + " <td class='data'>Northern Territory</td>";
                                html += "  </tr>  ";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianOtherterritories2).getpopulation() + " </td> " + " <td class='data'>Other Territories</td>";
                                html += "</tr>";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianQLD).getpopulation() + " </td> " + " <td class='data'>QLD</td>";
                                html += "</tr>";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianSouthAustralia).getpopulation() + " </td> " + " <td class='data'>South Australia</td>";
                                html += "</tr>";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianTasmania).getpopulation() + " </td> " + " <td class='data'>Tasmania</td>";
                                html += "</tr>";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianVictoria).getpopulation() + " </td> " + " <td class='data'>Victoria</td>";
                                html += "</tr>";
                                html += "<tr>";
                                html += " <td class='data'> " + populations2021.get(medianWesternAustralia).getpopulation() + " </td> " + " <td class='data'>WA</td>";
                                html += "</tr>";
                            
                            html = html + "</tbody>";
                            html = html + "</table>";
                            
                            html = html + "</div>";

                            html += """
                                </div>
                                </div>
                                </div>
                            """;

                            html += """
                                    


                            <div class = 'datainfo2'><p>In the above tables we are able to see the change in median population from 2016 to 2021 amongst the states in Australia. 
                            In almost all cases except for 'Other Territories' there is an evident increase in the median population. Using the median as a 
                            method for recording the change in population sizes can be an accurate measure for some of the larger states with several LGA's 
                            located within them. However for some of the smaller states, such as 'ACT' or 'Other Territories' it is not so accurate as there 
                            are only 3 LGAs within either of them. This highlights the importance of having large samples as well as.</p></div>




                                    """;


        html += """
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



        html = html + "</body>" + "</html>";

        context.html(html);
    }

}