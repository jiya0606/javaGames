/*
 * Jiya Gupta
 * September 2, 2021
 * Period 2 
 * NEW VERSION 
 * */


import java.util.*;

public class TicTacToe {
public static void main(String[] args) {
 
Scanner game = new Scanner(System.in);

  System.out.println("Welcome to TicTacToe! Player 1 (X) will go first. Please enter the number corresponding to which spot you would like to claim.");

  String n1 = "1"; 
  String n2 = "2"; 
  String n3 = "3"; 
  String n4 = "4"; 
  String n5 = "5";
  String n6 = "6";
  String n7 = "7";
  String n8 = "8";
  String n9 = "9";
  
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");

  int numberEntered;
  numberEntered = game.nextInt();
  game.nextLine(); 

  if (numberEntered == 1 ) {
      n1 = "X";
    }
    
    else if (numberEntered == 2 ) {
      n2 = "X";
    }
    
    else if (numberEntered == 3 ) {
      n3 = "X";
    }
    
    else if (numberEntered == 4 ) {
      n4 = "X";
    }
    
    else if (numberEntered == 5 ) {
      n5 = "X";
    }
    
    else if (numberEntered == 6 ) {
      n6 = "X"; 
    }
    
    else if (numberEntered == 7 ) {
      n7 = "X"; 
    }
    
    else if (numberEntered == 8 ) {
      n8 = "X"; 
    }
    
    else if (numberEntered == 9 ) {
      n9 = "X";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");
   
  System.out.println("\nGreat! Player 2, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered2;
  numberEntered2 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered2 == 1 ) {
      n1 = "O";
    }
    
    else if (numberEntered2 == 2 ) {
      n2 = "O";
    }
    
    else if (numberEntered2 == 3 ) {
      n3 = "O";
    }
    
    else if (numberEntered2 == 4 ) {
      n4 = "O";
    }
    
    else if (numberEntered2 == 5 ) {
      n5 = "O";
    }
    
    else if (numberEntered2 == 6 ) {
      n6 = "O"; 
    }
    
    else if (numberEntered2 == 7 ) {
      n7 = "O"; 
    }
    
    else if (numberEntered2 == 8 ) {
      n8 = "O"; 
    }
    
    else if (numberEntered2 == 9 ) {
      n9 = "O";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");
  
  
  System.out.println("\nGreat! Player 1, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered3;
  numberEntered3 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered3 == 1 ) {
      n1 = "X";
    }
    
    else if (numberEntered3 == 2 ) {
      n2 = "X";
    }
    
    else if (numberEntered3 == 3 ) {
      n3 = "X";
    }
    
    else if (numberEntered3 == 4 ) {
      n4 = "X";
    }
    
    else if (numberEntered3 == 5 ) {
      n5 = "X";
    }
    
    else if (numberEntered3 == 6 ) {
      n6 = "X"; 
    }
    
    else if (numberEntered3 == 7 ) {
      n7 = "X"; 
    }
    
    else if (numberEntered3 == 8 ) {
      n8 = "X"; 
    }
    
    else if (numberEntered3 == 9 ) {
      n9 = "X";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");
  
  System.out.println("\nGreat! Player 2, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
  
  int numberEntered4;
  numberEntered4 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered4 == 1 ) {
      n1 = "O";
    }
    
    else if (numberEntered4 == 2 ) {
      n2 = "O";
    }
    
    else if (numberEntered4 == 3 ) {
      n3 = "O";
    }
    
    else if (numberEntered4 == 4 ) {
      n4 = "O";
    }
    
    else if (numberEntered4 == 5 ) {
      n5 = "O";
    }
    
    else if (numberEntered4 == 6 ) {
      n6 = "O"; 
    }
    
    else if (numberEntered4 == 7 ) {
      n7 = "O"; 
    }
    
    else if (numberEntered4 == 8 ) {
      n8 = "O"; 
    }
    
    else if (numberEntered4 == 9 ) {
      n9 = "O";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");
  
  
  System.out.println("\nGreat! Player 1, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered5;
  numberEntered5 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered5 == 1 ) {
      n1 = "X";
    }
    
    else if (numberEntered5 == 2 ) {
      n2 = "X";
    }
    
    else if (numberEntered5 == 3 ) {
      n3 = "X";
    }
    
    else if (numberEntered5 == 4 ) {
      n4 = "X";
    }
    
    else if (numberEntered5 == 5 ) {
      n5 = "X";
    }
    
    else if (numberEntered5 == 6 ) {
      n6 = "X"; 
    }
    
    else if (numberEntered5 == 7 ) {
      n7 = "X"; 
    }
    
    else if (numberEntered5 == 8 ) {
      n8 = "X"; 
    }
    
    else if (numberEntered5 == 9 ) {
      n9 = "X";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |");
  
  if (n1 == "X" && n4 == "X" && n7 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n2 == "X"  && n5 == "X" && n8 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n3 == "X" && n6 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n1 == "X" && n5 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
     else if (n7 == "X" && n5 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
     
    else if (n1 == "X" && n2 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n4 == "X" && n5 == "X" && n6 =="X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n7 == "X" && n8 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    
    else {
     System.out.println("\nGreat! Player 2, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered6;
  numberEntered6 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered6 == 1 ) {
      n1 = "O";
    }
    
    else if (numberEntered6 == 2 ) {
      n2 = "O";
    }
    
    else if (numberEntered6 == 3 ) {
      n3 = "O";
    }
    
    else if (numberEntered6 == 4 ) {
      n4 = "O";
    }
    
    else if (numberEntered6 == 5 ) {
      n5 = "O";
    }
    
    else if (numberEntered6 == 6 ) {
      n6 = "O"; 
    }
    
    else if (numberEntered6 == 7 ) {
      n7 = "O"; 
    }
    
    else if (numberEntered6 == 8 ) {
      n8 = "O"; 
    }
    
    else if (numberEntered6 == 9 ) {
      n9 = "O";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |"); 
    
     if (n1 == "O" && n4 == "O" && n7 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n2 == "O"  && n5 == "O" && n8 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n3 == "O" && n6 == "O" && n9 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n1 == "O" && n5 == "O" && n9 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
     else if (n7 == "O" && n5 == "O" && n3 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
     
    else if (n1 == "O" && n2 == "O" && n3 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n4 == "O" && n5 == "O" && n6 =="O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n7 == "O" && n8 == "O" && n9 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    
    else {
     System.out.println("\nGreat! Player 1, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered7;
  numberEntered7 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered7 == 1 ) {
      n1 = "X";
    }
    
    else if (numberEntered7 == 2 ) {
      n2 = "X";
    }
    
    else if (numberEntered7 == 3 ) {
      n3 = "X";
    }
    
    else if (numberEntered7 == 4 ) {
      n4 = "X";
    }
    
    else if (numberEntered7 == 5 ) {
      n5 = "X";
    }
    
    else if (numberEntered7 == 6 ) {
      n6 = "X"; 
    }
    
    else if (numberEntered7 == 7 ) {
      n7 = "X"; 
    }
    
    else if (numberEntered7 == 8 ) {
      n8 = "X"; 
    }
    
    else if (numberEntered7 == 9 ) {
      n9 = "X";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |"); 
  
   if (n1 == "X" && n4 == "X" && n7 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n2 == "X"  && n5 == "X" && n8 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n3 == "X" && n6 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n1 == "X" && n5 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
     else if (n7 == "X" && n5 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
     
    else if (n1 == "X" && n2 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n4 == "X" && n5 == "X" && n6 =="X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n7 == "X" && n8 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
     else {
     System.out.println("\nGreat! Player 2, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered8;
  numberEntered8 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered8 == 1 ) {
      n1 = "O";
    }
    
    else if (numberEntered8 == 2 ) {
      n2 = "O";
    }
    
    else if (numberEntered8 == 3 ) {
      n3 = "O";
    }
    
    else if (numberEntered8 == 4 ) {
      n4 = "O";
    }
    
    else if (numberEntered8 == 5 ) {
      n5 = "O";
    }
    
    else if (numberEntered8 == 6 ) {
      n6 = "O"; 
    }
    
    else if (numberEntered8 == 7 ) {
      n7 = "O"; 
    }
    
    else if (numberEntered8 == 8 ) {
      n8 = "O"; 
    }
    
    else if (numberEntered8 == 9 ) {
      n9 = "O";
    }
    
  System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |"); 
  
   if (n1 == "O" && n4 == "O" && n7 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n2 == "O"  && n5 == "O" && n8 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n3 == "X" && n6 == "X" && n9 == "X" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n1 == "O" && n5 == "O" && n9 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
     else if (n7 == "O" && n5 == "O" && n3 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
     
    else if (n1 == "O" && n2 == "O" && n3 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n4 == "O" && n5 == "O" && n6 =="O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else if (n7 == "O" && n8 == "O" && n9 == "O" ) {
      System.out.println("Player 2 wins!!");
    }
    
    else {
     System.out.println("\nGreat! Player 1, it's your turn. Please enter the number corresponding to which spot you would like to claim.");
   
  int numberEntered9;
  numberEntered9 = game.nextInt();
  game.nextLine(); 
  
  if (numberEntered9 == 1 ) {
      n1 = "X";
    }
    
    else if (numberEntered9 == 2 ) {
      n2 = "X";
    }
    
    else if (numberEntered9 == 3 ) {
      n3 = "X";
    }
    
    else if (numberEntered9 == 4 ) {
      n4 = "X";
    }
    
    else if (numberEntered9 == 5 ) {
      n5 = "X";
    }
    
    else if (numberEntered9 == 6 ) {
      n6 = "X"; 
    }
    
    else if (numberEntered9 == 7 ) {
      n7 = "X"; 
    }
    
    else if (numberEntered9 == 8 ) {
      n8 = "X"; 
    }
    
    else if (numberEntered9 == 9 ) {
      n9 = "X";
    }
    System.out.println("  " + n1 + " | " + n2 + " | " + n3 + " |");
  System.out.println("----------------");
  System.out.println("  " + n4 + " | " + n5 + " | " + n6 + " |");
  System.out.println("----------------");
  System.out.println("  " + n7 + " | " + n8 + " | " + n9 + " |"); 
  
   if (n1 == "X" && n4 == "X" && n7 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n2 == "X"  && n5 == "X" && n8 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n3 == "X" && n6 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n1 == "X" && n5 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
     else if (n7 == "X" && n5 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
     
    else if (n1 == "X" && n2 == "X" && n3 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n4 == "X" && n5 == "X" && n6 =="X" ) {
      System.out.println("Player 1 wins!!");
    }
    
    else if (n7 == "X" && n8 == "X" && n9 == "X" ) {
      System.out.println("Player 1 wins!!");
    }
    
     else {
       System.out.println("It's a stalemate!");
    
    }
     }
    
    }
    
}

    }
 
}
}
