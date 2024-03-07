package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;
import java.util.Map;


/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST32Th implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/st32.html";
    private static final String TEMPLATE = ("st32.html");

    @Override
    public void handle(Context context) throws Exception {
        
        Map<String, Object> model = new HashMap<String, Object>();
        JDBCConnection jdbc = new JDBCConnection();

        
        
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.render(TEMPLATE, model);
    }

}
