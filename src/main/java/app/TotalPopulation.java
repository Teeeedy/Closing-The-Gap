package app;
public class TotalPopulation {
    int totpop;

    int lga_year;

public TotalPopulation (int totpop, int lga_year) {
    this.totpop = totpop;
    this.lga_year = lga_year;
}

public int getTotpop (){
    return totpop;
}

public int getLga_year (){
    return lga_year;
}

}
