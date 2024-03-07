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
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST31 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page5.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='Page31.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='scope.html'>Scope</a>
                <a href='page3.html'>Sub Task 2.1</a>
                <a href='page4.html'>Sub Task 2.2</a>
                <a href='PageST23.html'>Sub Task 2.3</a>

            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>The Gap score between Indigenous and Non-Indigenous People</h1>
            </div>


        """;

        html = html + """
            <div class='dataset-dropdown'>
                <h3> Select one or more datasets to explore </h3>
                <form action='/page5.html' method='post' id='dataset_form'>  
                <b> Datasets: </b>  
                <p> <select id='dataset' name='dataset' >
                    <option>--Select a dataset--</option>
                    <option>Dataset 1 - Population of LGA</option>
                    <option>Dataset 2 - Long-term health conditions</option>
                    <option>Dataset 3 - Highest year of school completion</option>
                    <option>Dataset 4 - Total household weekly income</option>
                </select> 
                <button type='submit' class='btn dataset-btn'>Choose dataset</button>
                </p>
                <p> 
                <select id='dataset' name='dataset' >
                    <option>--Select a dataset--</option>
                    <option>Dataset 1 - Population of LGA</option>
                    <option>Dataset 2 - Long-term health conditions</option>
                    <option>Dataset 3 - Highest year of school completion</option>
                    <option>Dataset 4 - Total household weekly income</option>
                </select>
                <button type='submit' class='btn dataset-btn'>Choose dataset</button> 
                </p>
                <p>
                <select id='dataset' name='dataset' >
                    <option>--Select a dataset--</option>
                    <option>Dataset 1 - Population of LGA</option>
                    <option>Dataset 2 - Long-term health conditions</option>
                    <option>Dataset 3 - Highest year of school completion</option>
                    <option>Dataset 4 - Total household weekly income</option>
                </select>
                <button type='submit' class='btn dataset-btn'>Choose dataset</button> 
                </p>
                <p>
                <select id='dataset' name='dataset' >
                    <option>--Select a dataset--</option>
                    <option>Dataset 1 - Population of LGA</option>
                    <option>Dataset 2 - Long-term health conditions</option>
                    <option>Dataset 3 - Highest year of school completion</option>
                    <option>Dataset 4 - Total household weekly income</option>
                </select>
                <button type='submit' class='btn dataset-btn'>Choose dataset</button> 
                
                </p>
                </form>
            </div>
                """;

        html = html + """
                <div class='filter-dropdown'>
                <h3> Select one or more datasets to explore </h3>
                <form action='/page5.html' method='post' id='dataset_form' ;">  
                <b> Datasets: </b>  
                <p> <select id='dataset' name='dataset' >
                    <option>--Select a dataset--</option>
                    <option>Dataset 1 - Population of LGA</option>
                    <option>Dataset 2 - Long-term health conditions</option>
                    <option>Dataset 3 - Highest year of school completion</option>
                    <option>Dataset 4 - Total household weekly income</option>
                </select> 
                <button type='submit' class='btn dataset-btn'>Choose dataset</button>
                </p>
        
                """;



        // Add Div for page Content
        // html = html + "<div class='content'>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        // JDBCConnection jdbc = new JDBCConnection();

        // // Next we will ask this *class* for the LGAs
        // ArrayList<LGA> lgas = jdbc.getLGAs();

        // // Add HTML for the LGA list
        // html = html + "<h1>All LGAs</h1>" + "<ul>";

        // // Finally we can print out all of the LGAs
        // for (LGA lga : lgas) {
        //     html = html + "<li>" + lga.getCode16()
        //                 + " - " + lga.getName16() + "</li>";
        // }

        // // Finish the List HTML
        // html = html + "</ul>";

        // // Close Content div
        // html = html + "</div>";

        // // Footer
        // html = html + """
        //     <div class='footer'>
        //         <p>COSC2803 - Studio Project Starter Code (Sep22)</p>
        //     </div>
        // """;

        // // Finish the HTML webpage
        // html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
