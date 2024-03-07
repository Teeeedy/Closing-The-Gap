package app;
public class LGA1 {
   private int code;

   private String name;

   private String lgaType;

   private double area;

   private double latitude;

   private double longitude;

   /**
    * Create an LGA and set the fields
    */
   public LGA1(int code, String name, String lgaType, double area, double latitude, double longitude) {
      this.code = code;
      this.name = name;
      this.lgaType = lgaType;
      this.area = area;
      this.latitude = latitude;
      this.longitude = longitude;
   }

   public LGA1(String name) {
      this.name = name;
   }

   public int getCode() {
      return code;
   }

   public String getName() {
      return name;
   }

   public String getLgaType() {
      return lgaType;
   }   

   public double getArea() {
      return area;
   }

   public double getLatitude() {
      return latitude;
   }

   public double getLongitude() {
      return longitude;
   }
   
}