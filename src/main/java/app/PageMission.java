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
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = """
            <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='mission.css' />
    <link rel='stylesheet' type='text/css' href='carousel.css' />
    <script src="carousel.js" defer></script>
    <title></title>
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

    <div class = 'challenge-heading-content'>
        <h1>
        Addressing The Social Challenge
        </h1>
        <img src="https://cdn2.picryl.com/photo/2015/04/22/australian-natives-known-as-aborigines-play-traditional-f2b998-1024.jpg">
    </div>

    <div class = 'challenge-content'>
        <p>
            The purpose of the website is to convey information regarding several of the common issues that Aboriginal communities are suffering from, 
            showcasing where changes should be made, what targets to reach in order to address the Closing the Gap campaign, and how to help. Our goal
            is to provide reliable, updated and relevant data on the challenge hoping that with our information people are able to develop a better
            understanding of the current situation of the Aboriginal community.   
        </p>
        <p>
            With the data we have gathered, we have preprocessed the data for the use of better comparison, allowing people to see the differences between the
            indigenous and non-indigenous community clearly. Our data focuses on a few of the 17 socioeconomic outcomes mainly centered around health, education
            and finances. We will further elaborate on the things that you can do to support this challenge below and show a few of the people that our website is 
            targeting.
        </p>
    </div>
    
   
    <h1 class="content-header">What We Can Do</h1>
    

    <div class="solutions-content">
        <div>
            <img src="donate.png">
            <p>
             Your donations towards the challege will allow us to fund the essentials we need in order to work towards closing the gap faster. All your the donations
             will go towards helping the Aboriginal communities.
            </p>
        </div>
        <div>
            <img src="fundraise.png">
            <p>
            If you're eager to make an impact yourself, you can start a fundraiser yourself where you'll be able to collect your own funds through any ideas or events
            that you might have in mind.
            </p>
        </div>
        <div>
            <img src="share.png">
            <p>
            Help spread the word and increase awareness by sharing the word around either through mean online or just by word of mouth. The more people that are aware
            about the social challenge, the more help we'll be able to get.
            </p>
        </div>
    </div>

    <h1 class="content-header">Who We Target</h1>

    <div class="carousel">
    <button class="carousel_button carousel_button--left is--hidden">
        <img src="left.svg" alt="">
    </button>
    <div class="carousel_track-container">
        <ul class="carousel_track">
                """;

      

        
        
        // Add Carousel
        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the LGAs
        ArrayList<Persona> personas = jdbc.getPersonas();

        // PERSONA 1

        html += """
            <li class="carousel_slide current-slide">

            <div class="personas-content">
                <div class="personas-description">
                    <img src="
                """;

       
        html += personas.get(0).getImgPath();
        html += """
            ">
                            <div>
                                <h3>
                
                """;

        html += personas.get(0).getPersonaName();
        html += """
            </h3>
                                <p class="description">
                """;
        html += personas.get(0).getDescription();
        html += """
            </p>
            </div>
        </div>
        <div class="personas-wants">
            <div class="needs">
                <h3>Needs</h3>
            <p>
                """;
        html += personas.get(0).getNeeds();
        html += """
            </p>
            </div>
            <div class="goals">
                <h3>Goals</h3>
            <p>
                """;
        html += personas.get(0).getGoals();
        html += """
            </p>
            </div>
            <div class="skills-experience">
                <h3>Skills & Experience</h3>
            <p>
                """;
        html += personas.get(0).getSkillsExp();
        html += """
            </p>
            </div>
        </div>
    </div> 
</li>
                """;

// Persona 2


html += """
    <li class="carousel_slide">

    <div class="personas-content">
        <div class="personas-description">
            <img src="
        """;


html += personas.get(1).getImgPath();
html += """
    ">
                    <div>
                        <h3>
        
        """;

html += personas.get(1).getPersonaName();
html += """
    </h3>
                        <p class="description">
        """;
html += personas.get(1).getDescription();
html += """
    </p>
    </div>
</div>
<div class="personas-wants">
    <div class="needs">
        <h3>Needs</h3>
    <p>
        """;
html += personas.get(1).getNeeds();
html += """
    </p>
    </div>
    <div class="goals">
        <h3>Goals</h3>
    <p>
        """;
html += personas.get(1).getGoals();
html += """
    </p>
    </div>
    <div class="skills-experience">
        <h3>Skills & Experience</h3>
    <p>
        """;
html += personas.get(1).getSkillsExp();
html += """
    </p>
    </div>
</div>
</div> 
</li>
        """;

// Persona 3

html += """
    <li class="carousel_slide">

    <div class="personas-content">
        <div class="personas-description">
            <img src="
        """;


html += personas.get(2).getImgPath();
html += """
    ">
                    <div>
                        <h3>
        
        """;

html += personas.get(2).getPersonaName();
html += """
    </h3>
                        <p class="description">
        """;
html += personas.get(2).getDescription();
html += """
    </p>
    </div>
</div>
<div class="personas-wants">
    <div class="needs">
        <h3>Needs</h3>
    <p>
        """;
html += personas.get(2).getNeeds();
html += """
    </p>
    </div>
    <div class="goals">
        <h3>Goals</h3>
    <p>
        """;
html += personas.get(2).getGoals();
html += """
    </p>
    </div>
    <div class="skills-experience">
        <h3>Skills & Experience</h3>
    <p>
        """;
html += personas.get(2).getSkillsExp();
html += """
    </p>
    </div>
</div>
</div> 
</li>
        """;


        

        html += """
            </ul>
            </div>
            <button class="carousel_button carousel_button--right">
                <img src="right.svg" alt="">
            </button>
    
            <div class="carousel_nav">
                <button class="carousel_indicator current-slide"></button>
                <button class="carousel_indicator"></button>
                <button class="carousel_indicator"></button>
            </div>
        </div>
    
        <h1 class="content-header our-team-header">Our Team</h1>
        <div class="team-content">
            <div>
                <img src="Henry.png" class='picture'>
                <h3>Henry (s3849054)</h3>
                <p>
                    Hello! My name's Henry and I'm currently a first year student at RMIT. In my years of living in Australia I've read a lot about the Aboriginal communities 
                    in the past and I understand their needs. So in this project I hope to make a website that will be helpful to the social challenge.
                </p>
            </div>
            <div>
                <img src="Nick.png" class='picture'>
                <h3>Nicholas (s3946683)</h3>
                <p>
                    Hello everyone, my name's Nick. Like Henry I've heard a lot about the Aborignal community in my time living in Australia
                    and I've seen that there are still inequalities between the non-indigenous and inigenous people of Australia. So with this website I hope to assist in closing the gap.
            
                </p>
            </div>
            <div>
                <img src="eddy.png" class='picture'>
                <h3>Wai (s3963096)</h3>
                <p>
                    Hey guys, my name's Eddy and I'm an international student so I'm pretty new to Australia. I first heard about the indigenous communities through RMIT and
                    after learning more about the history behind the people, I want to do what I can to help.
            </div>
        </div>
                
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
    



































        // Add HTML for the LGA list
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
