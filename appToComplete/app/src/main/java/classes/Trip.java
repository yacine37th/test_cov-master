package classes;

public class Trip {
   private String idDriver ;
   private String idTrip;
   private String fromWhere;
   private String toWhere ;
   private int price;
   private String conditions;


   public Trip() {
   }

   public Trip(String idDriver, String idTrip, String fromWhere, String toWhere, int price, String conditions) {
      this.idDriver = idDriver;
      this.idTrip = idTrip;
      this.fromWhere = fromWhere;
      this.toWhere = toWhere;
      this.price = price;
      this.conditions = conditions;
   }

   public String getIdDriver() {
      return idDriver;
   }

   public void setIdDriver(String idDriver) {
      this.idDriver = idDriver;
   }

   public String getIdTrip() {
      return idTrip;
   }

   public void setIdTrip(String idTrip) {
      this.idTrip = idTrip;
   }

   public String getFromWhere() {
      return fromWhere;
   }

   public void setFromWhere(String fromWhere) {
      this.fromWhere = fromWhere;
   }

   public String getToWhere() {
      return toWhere;
   }

   public void setToWhere(String toWhere) {
      this.toWhere = toWhere;
   }

   public String getConditions() {
      return conditions;
   }

   public void setConditions(String conditions) {
      this.conditions = conditions;
   }
   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }
}
