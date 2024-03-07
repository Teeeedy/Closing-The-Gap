package app;
public class weeklyincome {

    int lgacode;

    String lga_name;

    String lga_state;

    String Indigenous_status;

    
    int Count;

    int lga_year;

    String Income_bracket;

    // LGA 2016 Name

    /**
     * Create an LGA and set the fields
     */
    public weeklyincome(int lgacode, String lga_name, String lga_state, String Indigenous_status, String Income_bracket, int Count, int lga_year) {
       this.lgacode = lgacode;
       this.lga_name = lga_name;
       this.lga_state = lga_state;
       this.Indigenous_status = Indigenous_status;
       this.Count = Count;
       this.lga_year = lga_year;
       this.Income_bracket = Income_bracket;
       
    }
 
    public int getLgacode() {
        return lgacode;
    }
    public String getLga_name() {
        return lga_name;
    }
    public String getLga_state() {
        return lga_state;
    }
    public String getIndigenous_Status() {
        return Indigenous_status;
    }
    public int getcount() {
        return Count;
    }
    public int getLga_year() {
        return lga_year;
    }
    public String getincome_bracket() {
        return Income_bracket;
    }

}
