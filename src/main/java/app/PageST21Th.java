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
public class PageST21Th implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/st21.html";


     // Name of the Thymeleaf HTML template page in the resources folder
     private static final String TEMPLATE = ("st21.html");


    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String

        Map<String, Object> model = new HashMap<String, Object>();
        JDBCConnection jdbc = new JDBCConnection();

        // Putting the values inside the dataset dropdown box
        model.put("dataset_one", "DATASET1");
        model.put("dataset_two", "DATASET2");
        model.put("dataset_three", "DATASET3");
        model.put("dataset_four", "DATASET4");

        // Creating Arraylists that we might need for later
        ArrayList<String> conditionColumns = new ArrayList<String>();
        ArrayList<String> indigColumns = new ArrayList<String>();

        // This is the sex ArrayList that we'll need for the dropdown
        ArrayList<String> sex = new ArrayList<String>();
        sex.add("Male");
        sex.add("Female");
        sex.add("Total");

         // This is the order ArrayList that will be ASC or DESC
         ArrayList<String> order = new ArrayList<String>();
         order.add("ASC");
         order.add("DESC");
         
        
        ArrayList<String> datasetColumns = new ArrayList<String>();
        ArrayList<PageST21> displayValues = new ArrayList<PageST21>(); 
        
        
        
        
       

        // Obtain values from the dataset dropdown and put it inside a variable
        String dataset_drop = context.formParam("dataset_drop");
        //Send this variable back to html thymeleaf so tht it'll be callable in the html
        model.put("dataset_drop", dataset_drop);


        // This just takes one of the values in the second dropdown to see if it is null or not
        String condition_chosen = context.formParam("condition-drop");
        // Sends it back to html
        model.put("condition_drop", condition_chosen);

        // These are the values obtained from the second drop box condition is already obtained above
        String dataset_drop_two = context.formParam("dataset-drop-two");
        String sex_chosen = context.formParam("sex-drop");
        String indig_status_chosen = context.formParam("indig-status-drop");
        String order_category_chosen = context.formParam("order-category");
        String order_drop_chosen = context.formParam("order-drop");
        
        model.put("dataset_drop_two", dataset_drop_two);
        model.put("sex_drop", sex_chosen);
        model.put("indig_status_drop", indig_status_chosen);
        model.put("order_category", order_category_chosen);
        model.put("order_drop", order_drop_chosen);


        // CHECK IF THE FIRST DATASET DROP DOWN IS NULL AND THE SECOND DROP DOWN IS ALSO NULL OR IF THE FIRST DROP DOWN IS NOT NULL
        if (dataset_drop == null & condition_chosen == null) {
            
        } else if(dataset_drop == null & condition_chosen != null) {


        } else if (dataset_drop.equals("DATASET1")) {
            // Setting dropdown label
            model.put("condition_name", "Age range:");

            // Obtaining dropdown values from database
           
           
            // Setting the columns of the displayed table
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Age Range");
            datasetColumns.add("Number of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
           
         
            // Setting dropdown values 
            model.put("sex", sex);
            setDropDownDetails(jdbc, model, conditionColumns, indigColumns, order, dataset_drop);

            // These will be the columns on the table
            

        } else if (dataset_drop.equals("DATASET2")){
            model.put("condition_name", "Health condition:");
            model.put("sex", sex);
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Health Condition");
            datasetColumns.add("Number Of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
           
           
    
            setDropDownDetails(jdbc, model, conditionColumns, indigColumns, order, dataset_drop);

        } else if (dataset_drop.equals("DATASET3")) {
            model.put("condition_name", "Highest year of school completed:");
            model.put("sex", sex);
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Highest Year Of School Completed");
            datasetColumns.add("Number Of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");

           
         
            setDropDownDetails(jdbc, model, conditionColumns, indigColumns, order, dataset_drop);

        } else if (dataset_drop.equals("DATASET4")) {
            model.put("condition_name", "Income range:");
            model.put("sex", "Not Available");
            datasetColumns.add("LGA Code");
            datasetColumns.add("Household Indigenous Status");
            datasetColumns.add("Income Bracket");
            datasetColumns.add("Number Of Households");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");

           
           
            setDropDownDetails(jdbc, model, conditionColumns, indigColumns, order, dataset_drop);

        }



        if (dataset_drop_two == null) {
            
        } else if (dataset_drop_two.equals("DATASET1")) {
            model.put("condition_name", "Age range:");
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Age Range");
            datasetColumns.add("Number of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
            model.put("header_column", datasetColumns);
           
            displayValues = jdbc.getValuesFromDataSet(dataset_drop_two, condition_chosen, sex_chosen, indig_status_chosen, order_category_chosen, order_drop_chosen, "2021");
           
            model.put("display_values", displayValues);

        } else if (dataset_drop_two.equals("DATASET2")) {
            model.put("condition_name", "Health condition:");
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Health Condition");
            datasetColumns.add("Number Of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
            model.put("header_column", datasetColumns);
            displayValues = jdbc.getValuesFromDataSet(dataset_drop_two, condition_chosen, sex_chosen, indig_status_chosen, order_category_chosen, order_drop_chosen, "2021");
   
            model.put("display_values", displayValues);
           
           
        } else if (dataset_drop_two.equals("DATASET3")) {
            model.put("condition_name", "Highest year of school completed:");
            datasetColumns.add("LGA Code");
            datasetColumns.add("Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Highest Year Of School Completed");
            datasetColumns.add("Number Of People");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
            displayValues = jdbc.getValuesFromDataSet(dataset_drop_two, condition_chosen, sex_chosen, indig_status_chosen, order_category_chosen, order_drop_chosen, "2021");
            model.put("header_column", datasetColumns);
            model.put("display_values", displayValues);
           
            
        } else if (dataset_drop_two.equals("DATASET4")) {
            model.put("condition_name", "Income range:");
            displayValues = jdbc.getValuesFromDataSet(dataset_drop_two, condition_chosen, sex_chosen, indig_status_chosen, order_category_chosen, order_drop_chosen, "2021");
            datasetColumns.add("LGA Code");
            datasetColumns.add("Household Indigenous Status");
            datasetColumns.add("Sex");
            datasetColumns.add("Income Bracket");
            datasetColumns.add("Number Of Households");
            datasetColumns.add("Proportional Data");
            datasetColumns.add("GAP");
            model.put("display_values", displayValues);
            model.put("header_column", datasetColumns);
            
        }

        

































        context.render(TEMPLATE, model);
    }

    // public static void obtainDropDownDetails(JDBCConnection jdbc, Map<String, Object> model, ArrayList<String> conditionColumns, ArrayList<String> indigColumns, String dataset_drop, ArrayList<String> datasetColumns ) {
    //     conditionColumns = jdbc.getDatasetConditionColumns(dataset_drop);
       
        
    //     indigColumns = jdbc.getIndigStatusColumns(dataset_drop);
    //     model.put("header_column", datasetColumns);
        
    // }

    public static void setDropDownDetails(JDBCConnection jdbc, Map<String, Object> model, ArrayList<String> columns, ArrayList<String> indigColumns, ArrayList<String> order, String dataset_drop) {
            columns = jdbc.getDatasetConditionColumns(dataset_drop);
            columns.add("All");
            indigColumns = jdbc.getIndigStatusColumns(dataset_drop);
            indigColumns.add("All");
            model.put("columns", columns);
            model.put("indig_status", indigColumns);
            model.put("orders", order);
            model.put("header_column", columns);
    }

    

}
