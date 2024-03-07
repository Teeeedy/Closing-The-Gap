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
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";
               //<link rel='stylesheet' type='text/css' href='./mission.css' />
               //<link rel='stylesheet' type='text/css' href='./src/main/resources/css/mission.css' />
        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='./Index.css' />";
        //html = html + "<link rel='stylesheet' type='text/css' href='./common.css' />";
        //html = html + "<link rel='stylesheet' type='text/css' href='./src/main/resources/css/Index.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
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
        <body>
            <div class='header'>
                <h1>
                    Closing the Gap
                </h1>
                <div class ='information'>
                <p>The Closing the Gap challenge is an intiative that has 19 national socio-economic targets across areas that have an impact on life outcomes for Aboriginal and Torres Strait Islander people.</p>
                </div>
                <div class ='image'>
                <h1> <img src ="imagelandscape.png">
                </div>
                </h1>
            </div>
        </body>
        """;

       
        // Add Div for page Content
        // Add HTML for the list of pages (as well as topnav)
        // Cannot hard-code the socioeconomic outcome names, so just leaving it to make it look similar to the wireframe
        html = html + """
         <div class='content-1'>
                <h2>Socioeconomic Targets</h2>
                <p>------------------------------------------------------------------------</p>
                </div>
                """;
                
        html = html + """
         <div class='content-2'>
            """;
            

            // Look up some information from JDBC
            // First we need to use your JDBCConnection class
            JDBCOutcome jdbc = new JDBCOutcome();
    
            // Next we will ask this *class* for the LGAs
            
            ArrayList<Outcome> outcomes = jdbc.getOutcome();

    
            // Add HTML for the LGA list
            
            // Finally we can print out all of the LGAs
            for (Outcome outcome : outcomes) {
                html = html + "<div class = 'content-outcomes'>" + "<h5>" + outcome.getid() 
                             + "</h5>" + "<p style='font-size:18px'>" + outcome.getOutcomeDesc() + "</p>" + "</div>";
            }
    
            // Finish the List HTML
            html = html + "</ul>";
            // html = html + "</div>";
            // Close Content div
            html = html + """
                </div>
                   """;

                   

            html = html + """
         <div class='content-1'>
                <h2>Focused Socioeconomic Targets</h2>
                <p>------------------------------------------------------------------------</p>
                </div>
                """;

                html = html + """
                    <div class='content-2'>
                       """;

            ArrayList<Outcome> outcomestarget = jdbc.getOutcomeTarget();

    
            // Add HTML for the LGA list
            
            // Finally we can print out all of the LGAs
            for (Outcome outcome : outcomestarget) {
                html = html + "<div class = 'content-outcomes-target'>" + "<h5>" + outcome.getid() 
                             + "</h5>" + "<p style='font-size:20px'>" + outcome.getOutcomeDesc() + "</p>" + "</div>";
            }
            html = html + "</div>";

            // html = html + """
            //     <div class='content-2'>
       
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5> 
            // </div>

               
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5> 
            // </div>

               
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5> 
            //     </div>

               
                
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5>
            //     </div>

                
               
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5>
            //     </div>

                
                
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5>
            //     </div>

                
            
            // <div class = 'content-outcomes'>
            //     <h5>Outcome name(s) - Cannot be hard-coded</h5>
            //     </div>

            //     <p>------------------------------------------------------------------------</p>
            //     </div>
            //     """;
       
        
        /**html = html + """
            <div class = 'content-2'>
                <h4>Target Category Header</h4>
                <h5>Outcome name(s) - Cannot be hard-coded</h5>
                <h4>Target Category Header</h4>
                <h5>Outcome name(s) - Cannot be hard-coded</h5>
                <h4>Target Category Header</h4>
                <h5>Outcome name(s) - Cannot be hard-coded</h5>
                <h4>Target Category Header</h4>
                <h5>Outcome name(s) - Cannot be hard-coded</h5>
                <p>------------------------------------------------------------------------</p>
                </div>
                """;**/
                
               
                // Close Content div

        //Created another div class
        
        // html = html + """
        //     <div class='content-about'>
        //         <h1>About</h1>
        //         <p>Lorem ipsum dolor sit amet. Aut nihil maiores ab ipsam libero non neque voluptatem. 
        //         Sed obcaecati vero ea fugit delectus est asperiores perspiciatis quo deserunt temporibus et nulla libero aut harum laudantium qui dolores eveniet. 
        //         Eum assumenda error voluptatibus error ea voluptas laudantium quo delectus voluptas ut sint laborum quo eligendi atque.</p>
        //         <h2>***Insert image to the right of the 'About' content</h2>
        //         <p>------------------------------------------------------------------------</p>
                
        //         </div>
        //         """;
                        

                        
       
        // html = html + """
        // <div class='content-overall-targets'>
        //         <div class='content-targets'>
        //         <h1>Our targets</h1>
        //         <p>Lorem ipsum dolor sit amet. Aut nihil maiores ab ipsam libero non neque voluptatem. 
        //         Sed obcaecati vero ea fugit delectus est asperiores perspiciatis quo deserunt temporibus et nulla libero aut harum laudantium qui dolores eveniet. 
        //         Eum assumenda error voluptatibus error ea voluptas laudantium quo delectus voluptas ut sint laborum quo eligendi atque.</p>
        //         </div>

        //         <div class ='content-outcome-name 1'>
        //         <h2>Outcome name - pulled from database, cannot be hard-coded</h4>
        //         <p>Outcome brief overview</p>
        //         </div>
                
        //         <div class ='content-outcome-name 2'>
        //         <h2>Outcome name - pulled from database, cannot be hard-coded</h4>
        //         <p>Outcome brief overview</p>
        //         </div>
                
        //         <div class ='content-outcome-name 3'>
        //         <h2>Outcome name - pulled from database, cannot be hard-coded</h4>
        //         <p>Outcome brief overview</p>
        //         </div>
        //         <p>------------------------------------------------------------------------</p>

        // </div>
        //         """;
                

                // html = html + "<div class='content-pull'>";

                // Look up some information from JDBC
                // First we need to use your JDBCConnection class
                // JDBCOutcome jdbc = new JDBCOutcome();
        
                // // Next we will ask this *class* for the LGAs
                
                // ArrayList<Outcome> outcomes = jdbc.getOutcome();

        
                // // Add HTML for the LGA list
                // html = html + "<h1>All Outcomes</h1>" + "<ul>";
        
                // // Finally we can print out all of the LGAs
                // for (Outcome outcome : outcomes) {
                //     html = html + "<li>" + outcome.getid()
                //                 + " - " + outcome.getOutcomeDesc() + "</li>";
                // }
        
                // Finish the List HTML
                // html = html + "</ul>";
        
                // // Close Content div
                // html = html + "</div>";

        // Footer
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
