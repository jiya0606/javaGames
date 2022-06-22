import java.util.*;

public class deck extends cards{
  private ArrayList<cards> allCards; //arrayList for deck of cards
  
  //constructors 
  public deck() {
    allCards = new ArrayList<cards>();
  }
  
  public deck(ArrayList<cards> c) {
    allCards = c;
  }
  
  //Getters 
  public String getName(int a) {
    return allCards.get(a).getName(); 
  } 
  
  public String getSuit(int a) {
    return allCards.get(a).getSuit(); 
  }
  
  public int getSize() {
    return allCards.size(); 
  }
  
  public cards getCard(int a) {
    return allCards.get(a);
  }
  
  //Setters 
  public void setCards (int a, cards c) {
    allCards.set(a, c);
  }
  
  public void removeCard (int a) {
    allCards.remove(a);
  }
  
  public void addCards(cards c) {
    allCards.add(c);
  }
}