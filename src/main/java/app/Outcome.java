package app;
public class Outcome {

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */

   // Outcome id
   private String OutcomeName;

   // outcome name
   private String OutcomeDescription;

   /**
    * Create an LGA and set the fields
    */
   public Outcome(String OutcomeName, String OutcomeDescription) {
      this.OutcomeName = OutcomeName;
      this.OutcomeDescription = OutcomeDescription;
   }

   public String getid() {
      return OutcomeName;
   }

   public String getOutcomeDesc() {
      return OutcomeDescription;
   }
}


