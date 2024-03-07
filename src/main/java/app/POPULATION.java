package app;
public class POPULATION {
    int lga_code;

    // LGA 2016 Name
    String lga_name;
 
    String lga_state;
 
    String lga_type;
 
    double area_sqkm;
 
    int total_population;

    int lga_year;

    int TotalPopulation2021;

    int TotalPopulation2016;
 
    /**
     * Create an LGA and set the fields
     */
    public POPULATION(int lga_code, String lga_name, String lga_state, String lga_type, double area_sqkm, int total_population, int lga_year) {
       this.lga_code = lga_code;
       this.lga_name = lga_name;
       this.lga_state = lga_state;
       this.lga_type = lga_type;
       this.area_sqkm = area_sqkm;
       this.total_population = total_population;
       this.lga_year = lga_year;
    }
 
 
    public POPULATION() {
    }


    public POPULATION(String disp) {
    }


    public int getLga_code() {
       return lga_code;
    }
 
    public String getLga_name() {
       return lga_name;
    }
 
    public String getLga_state() {
       return lga_state;
    }
 
    public String getLga_type() {
       return lga_type;
    }
 
    public double getArea_sqkm() {
     return area_sqkm;
  }
 
   public int getTotal_population() {
     return total_population;
   }

   public int getlga_year() {
      return lga_year;
   }

}
