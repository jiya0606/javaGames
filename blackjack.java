/*Jiya Gupta
 * Period 2
 * Jan 17th
 */

import java.util.*;
public class blackjack { 
  public static deck y = new deck();
  public static ArrayList<cards> playerArray = new ArrayList<cards>();
  public static ArrayList<cards> dealer = new ArrayList<cards>();
  public static player x = new player();
  public static int dealerBalance = 500;
  public static Scanner input = new Scanner(System.in);
  public static int bet = 0;
  public static boolean game = true;
  public static boolean turn = true;
  
  public static void main (String[]args) {
    System.out.println("Please enter in a name you would like to go by");
    String name = input.nextLine();
    x.setName(name);
    System.out.println("Welcome to Blackjack " + x.getName() + "!!");
    System.out.println("Cards will be displayed with the number followed by the suit. For example: 9 RH");
    System.out.println("RH = red heart, D = diamond, S = sp ade, C = clover");
    System.out.println("The deck will be reshuffled and redistributed when it is less than 15.");
    System.out.println("An Ace will automatically be counted as an 11 until the player's sum reaches above a 21, then the ace will be considered a 1");
    populateCards();
    shuffleCards();
    
    while (game == true) {
      turn = true;
      while (turn == true) {
        deckRestart();
        
        System.out.println("How much would you like to bet?");
        bet = input.nextInt();
        input.nextLine();
        x.setBankroll((x.getBankroll() - bet));
        dealerBalance = dealerBalance - bet;
        System.out.println("You just bet " + bet + " dollars. Your remaining balance is " + x.getBankroll() + " dollars.");
        System.out.println("Let's start the game!");
        System.out.println();
        
        //2 cards are dealt to the player
        playerArray.add(y.getCard(0));
        y.removeCard(0);
        System.out.println("Player's First Card: " + playerArray.get(0).getName() + " " + playerArray.get(0).getSuit());
        playerArray.add(y.getCard(0));
        y.removeCard(0);
        System.out.println("Player's Second Card: " + playerArray.get(1).getName() + " " + playerArray.get(1).getSuit());
        
        //2 cards are dealt to the dealer
        dealer.add(y.getCard(0));
        y.removeCard(0);
        System.out.println("Dealer's First card: " + dealer.get(0).getName() + " " + dealer.get(0).getSuit());
         dealer.add(y.getCard(0));
        y.removeCard(0);
        System.out.println("The dealer's second card will stay hidden");
        
        boolean playerturn = true;
        playerCheckRules(); 
        dealerCheckRules();
        while (playerturn == true) {
          System.out.println();
          System.out.println("It is the player's turn.");
          System.out.println("Player: Do you chose to stand or hit? Enter 1 for stand and 2 for hit.");
          int playerTurn = input.nextInt();
          input.nextLine();
          
          if (playerTurn == 1) { //dealers turn
            playerturn = false;
          }
          else if (playerTurn == 2) { //player draws cards
            playerturn = true;
            playerArray.add(y.getCard(0));
            y.removeCard(0);
            System.out.print("Player's Cards (with new card): ");
            for (int i=0; i<playerArray.size(); i++) {
              System.out.print(" " + playerArray.get(i).getName() + " " + playerArray.get(i).getSuit() + " ; ");
            }
            System.out.println("Player total: " + sumOfArray(playerArray));
            playerCheckRules();
            if (turn == false) {
              playerturn = false;
            }
          }
          else {
            System.out.println("Please enter the number correctly");
          }
        }
        if (turn == true) {
          dealerTurn();
        }
      }
      checkIfGameEnds();
      System.out.println("Would you like to end the game? Press 1 for yes and any other number for no");
      int continueGame = input.nextInt();
      input.nextLine();
      if (continueGame == 1) {
        System.out.println("the game has ended");
        game = false;
        turn = false;
      }
      reshuffle();
    }
  }
  
  public static void deckRestart() {
    while (playerArray.size() > 0) {
      playerArray.remove(0);
    }
    
    while (dealer.size() > 0) {
      dealer.remove(0);
    }
  }
  
  
  public static int valueConverter(String a) {
    int returnedNumber = 0;
    if (a.compareTo("A") == 0) {
      returnedNumber = 11;
    }
    if (a.compareTo("2") == 0) {
      returnedNumber = 2;
    }
    if (a.compareTo("3") == 0) {
      returnedNumber = 3;
    }
    if (a.compareTo("4") == 0) {
      returnedNumber = 4;
    }
    if (a.compareTo("5") == 0) {
      returnedNumber = 5;
    }
    if (a.compareTo("6") == 0) {
      returnedNumber = 6;
    }
    if (a.compareTo("7") == 0) {
      returnedNumber = 7;
    }
    if (a.compareTo("8") == 0) {
      returnedNumber = 8;
    }
    if (a.compareTo("9") == 0) {
      returnedNumber = 9;
    }
    if (a.compareTo("10") == 0) {
      returnedNumber = 10;
    }
    if (a.compareTo("J") == 0) {
      returnedNumber = 10;
    }
    if (a.compareTo("Q") == 0) {
      returnedNumber = 10;
    }
    if (a.compareTo("K") == 0) {
      returnedNumber = 10;
    }
    return returnedNumber;
  }

 
  public static void populateCards() {
    String naming = "A23456789TJQK";

    for (int i = 0; i < 13; i++) {
      if (i == 9) {
        y.addCards(new cards("10","RH"));
      }
      else {
        y.addCards(new cards (naming.substring(i,(i+1)),"RH"));
      }
    }
    
    for (int i = 0; i < 13; i++) {
      if (i == 9) {
        y.addCards(new cards("10","D"));
      }
      else {
        y.addCards(new cards (naming.substring(i,(i+1)),"BH"));
      }
    }
    
    for (int i = 0; i < 13; i++) {
      if (i == 9) {
        y.addCards(new cards("10","S"));
      }
      else {
        y.addCards(new cards (naming.substring(i,(i+1)),"S"));
      }
    }
    
    for (int i = 0; i < 13; i++) {
      if (i == 9) {
        y.addCards(new cards("10","C"));
      }
      else {
        y.addCards(new cards (naming.substring(i,(i+1)),"C"));
      }
    }
  }
  
  public static void shuffleCards() {
    int a = 0;
    int b = 0;
    cards placeholder = new cards();
    int size = y.getSize();
    for (int i = 0; i < 100; i++) {
      a = (int)(Math.random()*size);
      b = (int)(Math.random()*size);
      placeholder = y.getCard(a);
      y.setCards(a, y.getCard(b));
      y.setCards(b, placeholder);
    }
  }
  
  public static void printDeck() {
    for (int i = 0; i < y.getSize(); i++) {
      System.out.println(y.getName(i) + " " + y.getSuit(i));
    }
  }
  
  public static int sumOfArray(ArrayList<cards> a) {
    int sum = 0;
    for (int i = 0; i < a.size(); i++) {
      sum = sum + (valueConverter(a.get(i).getName()));
    }
    
    if (sum > 21) {
      for (int i = 0; i < a.size(); i++) {
        if (a.get(i).getName().compareTo("A") == 0) {  /* Check for Ace */
          sum = sum - 10;
        }    
      }
    }
    return sum;
  }

  
   public static void dealerTurn() {
     int sum = sumOfArray(dealer);
     boolean soft17 = false;
     boolean ace = false;
     for (int i = 0; i < dealer.size(); i++) {
       if (dealer.get(i).getName().compareTo("A") == 0) {
         ace = true;
       } 
     }
     if (ace == true && sumOfArray(dealer) == 17) {
       soft17 = true;
     }
     while (sum < 17 || soft17 == true) {
       System.out.println("The dealer's total is less than 17, so they will draw a card");
       dealer.add(y.getCard(0));
       y.removeCard(0);
       soft17 = false;
       for (int i = 0; i < dealer.size(); i++) {
         if (dealer.get(i).getName().compareTo("A") == 0) {
           ace = true;
         } 
       }
       if (ace == true && sumOfArray(dealer) == 17) {
         soft17 = true;
       }
       System.out.print("Dealer's Cards (with new card): ");
       for (int i=0; i<dealer.size(); i++) {
         System.out.print(" " + dealer.get(i).getName() + " " +dealer.get(i).getSuit() + " ; ");
       }
       sum = sumOfArray(dealer);
       System.out.println("Dealer total: " + sum);
       dealerCheckRules();
     }
     System.out.println("The dealer's sum value is 17 or greater");
     if (turn == true) {
       seeWhoWon();
     }
   }
  
  public static void seeWhoWon() {
    int playerSum = sumOfArray(playerArray);
    int dealerSum = sumOfArray(dealer);
    
    if (playerSum > dealerSum) {
      System.out.println("The player has won!");
      x.setBankroll((x.getBankroll() + (bet * 2)));
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
    else if (dealerSum > playerSum) {
      System.out.println("The dealer has won!");
      dealerBalance = dealerBalance + (bet * 2);
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
    else if (playerSum == dealerSum) {
      System.out.println("It's a draw");
      x.setBankroll((x.getBankroll() + bet));
      dealerBalance = dealerBalance + bet;
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
    else {
      System.out.println("An error has occured");
    }
  }
  
  public static void playerCheckRules() {
    if (sumOfArray(playerArray) > 21) {
      System.out.println("The player is BUSTED. Player loses.");
      dealerBalance = dealerBalance + (bet * 2);
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
    else if (playerArray.size() == 2 && sumOfArray(playerArray) == 21) {
      System.out.println("Player has a blackjack!");
      x.setBankroll((x.getBankroll() + (bet * 2) + (bet/2)));
      dealerBalance = dealerBalance - (bet/2);
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
  }
  
  public static void dealerCheckRules() {
    if (sumOfArray(dealer) > 21) {
      System.out.println("The Dealer is BUSTED. Dealer loses.");
      x.setBankroll((x.getBankroll() + (bet*2)));
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
    else if (dealer.size() == 2 && sumOfArray(dealer) == 21) {
      System.out.println("Dealer has a blackjack!");
      dealerBalance = dealerBalance + (bet * 2) + (bet/2);
      x.setBankroll((x.getBankroll() - (bet/2)));
      System.out.println("player balance: " + x.getBankroll());
      System.out.println("dealer balance: " + dealerBalance);
      turn = false;
    }
  }
  
  public static void checkIfGameEnds() {
    if (x.getBankroll() <= 0) {
      game = false;
      turn = false;
      System.out.println("Player ran out of money so the game has ended.");
    }
  }
  
  public static void reshuffle() {
    if (y.getSize() < 15) {
      while (y.getSize() > 0) {
        y.removeCard(0);
      }
      populateCards();
      shuffleCards();
    }  
  }
}