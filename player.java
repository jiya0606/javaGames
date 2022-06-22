public class player {
  private String name; 
  private int bankroll;
  
  //constructors 
  public player() {
    name = "A";
    bankroll = 500; 
  }
  
  public player(String n, int b) {
    name = n;
    bankroll = b; 
  }
  
  //Getters
  public String getName() {
    return name; 
  }
  
  public int getBankroll() {
    return bankroll; 
  }
  
  //Setters
  public void setName (String n) {
    name = n;
  }
  
  public void setBankroll (int b) {
    bankroll = b;
  }
}