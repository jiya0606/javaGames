public class cards {
  private String name; 
  private String suit;
  
  //constructors 
  public cards() {
    name = "A";
    suit = "red heart"; 
  }
  
  public cards(String n, String s) {
    name = n;
    suit = s; 
  }
  
  //Getters 
  public String getName() {
    return name; 
  }
  
  public String getSuit() {
    return suit; 
  }
  
  //Setters
  public void setName (String n) {
    name = n;
  }
  
  public void setSuit (String s) {
    suit = s;
  }
}