package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;
import java.util.Map;

public class PageST21 {
    
    private String lgaCode;
    private String indigStatus;
    private String sex;
    private String condition;
    private int conditionCount;
    private double propValue;
    private double gap;


    public PageST21() {

    }

    public PageST21 (String lgaCode, String indigStatus, String sex, String condition, int conditionCount, double propValue, double gap) {
        this.lgaCode = lgaCode;
        this.indigStatus = indigStatus;
        this.sex = sex;
        this.condition = condition;
        this.conditionCount = conditionCount;
        this.propValue = propValue;
        this.gap = gap;
    }

    // Setters
    public void setLgaCode (String lgaCode) {
        this.lgaCode = lgaCode;
    }

    public void setIndigStatus (String indigStatus) {
        this.indigStatus = indigStatus;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setConditionCount (int conditionCount) {
        this.conditionCount = conditionCount;
    }

    public void setPropValue (double propValue) {
        this.propValue = propValue;
    }

    public void setGap (double gap) {
        this.gap = gap;
    }


    // Getters
    public String getLgaCode () {
        return lgaCode;
    }

    public String getIndigStatus () {
        return indigStatus;
    }

    public String getSex() {
        return sex;
    }

    public String getCondition() {
        return condition;
    }

    public int getConditionCount() {
        return conditionCount;
    }

    public double getPropValue() {
        return propValue;
    }

    public double getGap() {
        return gap;
    }  

    // public static void main(String args[]) {
    //     System.out.println("Hello");
    //     JDBCConnection jdbc = new JDBCConnection();

    //     ArrayList<PageST21> displayValues = new ArrayList<PageST21>();
    //     displayValues = jdbc.getValuesFromDataSet("DATASET2", "Cancer", "Male", "Indigenous", "Condition", "ASC");
    //     System.out.println(displayValues);

    //     for (PageST21 row: displayValues) {
    //         System.out.print(row.getLgaCode());
    //         System.out.print(row.getSex());
    //     }

        
    // }
}
