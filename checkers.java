/*Jiya Gupta
 * Period 2
 * 01/06/22
 * */

import java.util.*;
public class checkers {
  public static Scanner input = new Scanner(System.in);
  public static pieces board[] [] = new pieces [8][8];
  public static boolean gameOver = false; 
  public static boolean availableKill1 = false;
  public static boolean availableKill2 = false;
  public static String columns = "ABCDEFGH";
  
  public static int player1Kills = 0; //how many of player 2's pieces player 1 has killed
  public static int player2Kills = 0; //how many of player 1's pieces player 2 has killed
  
  public static int mr1 = 0;
  public static int pr1 = 0;
  public static int mc1N = 0;
  public static int pc1N = 0;
  public static int mr2 = 0; 
  public static int pr2 = 0;
  public static int mc2N = 0;
  public static int pc2N = 0;
  public static String mc1L = "";
  public static String mc2L = ""; 
  public static String pc2L = "";
  public static String pc1L = "";
  public static boolean player1turn = true;
  public static boolean player2turn = true; 
  public static String [] testSeqStr = {"E","D","F","E","D","F","G","E","G","F","B","A","E","G","H","F","H","G","F","H","H","G","C","D","E","F","F","E","F","E","H","F","D","E","F","D","D","F","F","E","D","F","B","C","F","G","C","D","E","C","D","E","F","D","D","B","A"};
  public static int [] testSeqInt =    {6,  5,  3,  4,   5,  3,  2,  4,  6,  5,  3,  4,  4,  6,  7,  5,  3,  4,  5,  3,  1,  2,  6,  5,  2,  3,  7,  6,  1,  2,  3,  1,  3,  4,  1,  3,  3,  5,  3,  4,  5,  3,  3,  4,  5,  4,  4,  5,  6,  4,  1,  2,  3,  1,  1,  3,  2 };
  public static int index1 = 0;
  public static int index2 = 0;
  public static String recordLetters = "";
  public static String recordNumbers = "";
  public static boolean test = false;
  public static boolean debugOn = false;
  public static boolean validMove = false;

  public static void main (String[]args) {
    System.out.println("Hi! Welcome to checkers!");
    instructions();
    System.out.println();
    populateBoard();
    printBoard();
    debug("Start");
   
    while (gameOver == false) {
      checkPlayer1Kills();
      //kingAvailableKillsP1();
      validMove = false;
      while (player1turn == true) {
        debug("beginning of player 1 while loop");
        player1Turn();
        checkKingOfP1(); 
        if (validMove == true) {
          checkIfGameEnded();
          printBoard();
        }
        debug("end of player 1 while loop: ");
      }
      
      if(debugOn){System.out.println("king status: " + board[pr1][pc1N].kingStatus());};

      //System.out.println("Recorded Letters: {" + recordLetters + "}");
      //System.out.println("Recorded Numbers: { " + recordNumbers + "}");

      checkPlayer2Kills();
      //kingAvailableKillsP2();
      validMove = false;
      while (player2turn == true) {
        debug("beginning of player 2 while loop: ");
        player2Turn();
        checkKingOfP2();
       if (validMove == true) { 
         checkIfGameEnded();
         printBoard();
       }
        debug("end of player 2 while loop: ");
      }
      
      //System.out.println("Recorded Letters: {" + recordLetters + "}");
     // System.out.println("Recorded Numbers: { " + recordNumbers + "}");
      
      debug("end of program: ");
    }
  }
    
//methods

  public static void instructions() {
    System.out.println("Here are some basic instructions:");
    System.out.println("X represents white checkers and O represents black checkers");
    System.out.println("A player can move diagnolly forwards or backwards.");
    System.out.println("A player can jump over their opponents player to make a kill. If a kill opportunity is available, a player has to take it");
    System.out.println("A player is allowed to continue kills in one turn until they run out of available kills");
    System.out.println("A king is created when a player reaches the end of the other board. A king can move fowards or backwards on the board.");
    System.out.println("Player 1's king is represeted by x' and Player 2's king is represented by o'");
    
  }
  public static void checkPlayer1Kills() {
    if (debugOn) System.out.println("Player1: Checking available kills"); 
    availableKill1 = false;
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j].getPlayer() == 1) { 
          if (debugOn) System.out.println("Player1: Checking piece at " + i + " and " + j);
          if (i-2>=0 && j-2>=0) {
            if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 2) {
              if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
              availableKill1 = true; 
            }
          }
          if (i-2>=0 && j+2<8) {
            if (board[i-2][j+2].getPlayer() == 0 && board[i-1][j+1].getPlayer() == 2) {
              if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
              availableKill1 = true;
            }
          }
          if (board[i][j].kingStatus() == true) {
            if (i+2<8 && j-2>=0) {
              if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 2) {
                if (debugOn) System.out.println("Valid king kill move on the left for player 1. i = " + i + "j = " + j);
                availableKill1 = true; 
              }
            }
            if (i+2<8 && j+2<8) {
              if (board[i+2][j+2].getPlayer() == 0 && board[i+1][j+1].getPlayer() == 2) {
                if (debugOn) System.out.println("Valid king kill move on the right for player 1. i = " + i + "j = " + j);
                availableKill1 = true;
              }
            }
          }
        }
        
      }
    }
  }
 
  public static void checkPlayer2Kills() {
    if (debugOn) System.out.println("Player2: Checking available kills"); 
    availableKill2 = false;
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j].getPlayer() == 2) { 
          if (debugOn) System.out.println("Player2: Checking piece at " + i + " and " + j);
          if (i+2<8 && j-2>=0) {
            if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 1) {
              if (debugOn) System.out.println("Valid kill move on the left for player 2. i = " + i + "j = " + j);
              availableKill2 = true;
            }
          }
          if (i+2<8 && j+2<8) {
            if (board[i+2][j+2].getPlayer() == 0  && board[i+1][j+1].getPlayer() == 1) {
              if (debugOn) System.out.println("Valid kill move on the right for player 2. i = " + i + "j = " + j);
              availableKill2 = true;
            }
          }
          if (board[i][j].kingStatus() == true) {
            if (i-2>=0 && j-2>=0) {
              if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 1) {
                if (debugOn) System.out.println("Valid king kill move on the left for player 2. i = " + i + "j = " + j);
                availableKill2 = true;
              }
            }
            if (i-2>=0 && j+2<8) {
              if (board[i-2][j+2].getPlayer() == 0  && board[i-1][j+1].getPlayer() == 1) {
                if (debugOn) System.out.println("Valid king kill move on the right for player 2. i = " + i + "j = " + j);
                availableKill2 = true;
              }
            }
          }
        }
      }
    }
  }

  public static void player1Turn() {
    System.out.println("Player X's turn. Please enter the coordinates of the cell you would like to move to.");
    
    if (test && index1 < testSeqStr.length) {
      mc1L = testSeqStr[index1];
      index1++; 
      mr1 = testSeqInt[index2];
      index2++;
      if(debugOn) {System.out.println("Player 1 - Test Sequence From: Column: " + mc1L + " Row: " + mr1);}
      mr1--;
      pc1L = testSeqStr[index1];
      index1++;
      pr1 = testSeqInt[index2];
      index2++; 
      if(debugOn){System.out.println("Player 1 - Test Sequence To: Column: " + pc1L + " Row: " + pr1);}
      pr1--;
    } 
    else {
      System.out.println();
      System.out.println("Checker being moved:");
      System.out.println("Column Letter (capital letter and no extra characters):");
      mc1L = input.nextLine();
      //recordLetters += "\""+mc1L+"\""+",";
      System.out.println("Row number:");
      mr1 = input.nextInt();
      recordNumbers += mr1+",  ";
      input.nextLine();
      mr1--;
      System.out.println("Position you would like to move to");
      System.out.println("Column Letter (capital letter and no extra characters):");
      pc1L = input.nextLine();
     // recordLetters += "\""+pc1L+"\""+",";
      System.out.println("Row number:");
      pr1 = input.nextInt();
      recordNumbers += pr1+",  ";
      input.nextLine();
      pr1--;
    }
    
    //converting columnn letter to index
    
    mc1N = columns.indexOf(mc1L);
    pc1N = columns.indexOf(pc1L);
    
    //rules
    if (mc1N == -1 || pc1N == -1) {
      System.out.println("letter entered is out of bounds");
      System.out.println("Please try again. Enter a capital letter.");
    }
    else {
      if (board[pr1][pc1N].getPlayer() == 0) {
        if (mr1 < 0 || mr1 > 7) {
          System.out.println("number entered is out of bounds");
          System.out.println("Please try again.");
        }
        else if (pr1 < 0 || pr1 > 7) {
          System.out.println("number entered is out of bounds");
          System.out.println("Please try again.");
        }
        else if (board[mr1][mc1N].getPlayer() != 1) {
          System.out.println("please move player 1's checker");
          System.out.println("Please try again.");
        }
        else if ((-1 < (mr1 - 2)) && ( (mr1 - 2) < 8) && (-1 < (mc1N + 2)) && ((mc1N + 2) < 8) && (board[(mr1 - 1)][(mc1N + 1)].getPlayer() == 2) && (board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 - 2)) && (pc1N == (mc1N + 2))) {
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1-1][mc1N+1].setPlayer(0);
          if (board[mr1][mc1N].kingStatus() == true) {
            board[pr1][pc1N].makeKing(true);
            board[mr1][mc1N].makeKing(false);
          }
          System.out.println("Player 2's piece has been killed.");
          player1Kills++;
          checkPlayer1Kills();
          if (availableKill1 == false) {
            if (debugOn) System.out.println("No more kills available for Player 1. It is now Player 2's turn.");
            validMove = true;
            player1turn = false; player2turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }         
        else if ((-1 < (mr1 - 2)) && ( (mr1 - 2) < 8) && (-1 < (mc1N - 2)) && ((mc1N - 2) < 8) && (board[(mr1 - 1)][(mc1N - 1)].getPlayer() == 2 && board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 - 2)) && (pc1N == (mc1N - 2))) {
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1-1][mc1N-1].setPlayer(0);
          if (board[mr1][mc1N].kingStatus() == true) {
            board[pr1][pc1N].makeKing(true);
            board[mr1][mc1N].makeKing(false);
          }
          System.out.println("Player 2's piece has been killed.");
          player1Kills++;
          checkPlayer1Kills();
          if (availableKill1 == false) {
            if (debugOn) System.out.println("No more kills available for Player 1. It is now Player 2's turn.");
            validMove = true;
            player1turn = false; player2turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (board[mr1][mc1N].kingStatus() == true && (-1 < (mr1 + 1)) && ( (mr1 + 1) < 8) && (-1 < (mc1N + 1)) && ((mc1N + 1) < 8) && (board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 + 1)) && (pc1N == (mc1N + 1))) {  
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1][mc1N].makeKing(false);
          board[pr1][pc1N].makeKing(true);
          System.out.println("Player 1 made a valid move. It is now Player 2's turn");
          validMove = true;
          player1turn = false; player2turn = true;
        }
        else if (board[mr1][mc1N].kingStatus() == true && (-1 < (mr1 + 1)) && ( (mr1 + 1) < 8) && (-1 < (mc1N - 1)) && ((mc1N - 1) < 8) && (board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 + 1)) && (pc1N == (mc1N - 1))) {  
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1][mc1N].makeKing(false);
          board[pr1][pc1N].makeKing(true);
          System.out.println("Player 1 made a valid move. It is now Player 2's turn");
          validMove = true;
          player1turn = false; player2turn = true;
        }
        else if (board[mr1][mc1N].kingStatus() == true && (-1 < (mr1 + 2)) && ( (mr1 + 2) < 8) && (-1 < (mc1N + 2)) && ((mc1N + 2) < 8) && (board[(mr1 + 1)][(mc1N + 1)].getPlayer() == 2) && (board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 + 2)) && (pc1N == (mc1N + 2))) {  
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1+1][mc1N+1].setPlayer(0);
          board[mr1][mc1N].makeKing(false);
          board[pr1][pc1N].makeKing(true);
          System.out.println("Player 2's piece has been killed.");
          player1Kills++; 
          checkPlayer1Kills();
          //kingAvailableKillsP1();
          if (availableKill1 == false) {
            if (debugOn) System.out.println("No more kills available for Player 1. It is now Player 2's turn.");
            validMove = true;
            player1turn = false; player2turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (board[mr1][mc1N].kingStatus() == true && (-1 < (mr1 + 2)) && ( (mr1 + 2) < 8) && (-1 < (mc1N - 2)) && ((mc1N - 2) < 8) && (board[(mr1 + 1)][(mc1N - 1)].getPlayer() == 2 && board[pr1][pc1N].getPlayer() == 0) && (pr1 == (mr1 + 2)) && (pc1N == (mc1N - 2))) {
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          board[mr1+1][mc1N-1].setPlayer(0);
          board[mr1][mc1N].makeKing(false);
          board[pr1][pc1N].makeKing(true);
          System.out.println("Player 2's piece has been killed.");
          player1Kills++;
          checkPlayer1Kills();
          //kingAvailableKillsP1();

          if (availableKill1 == false) {
            if (debugOn) System.out.println("No more kills available for Player 1. It is now Player 2's turn.");
            validMove = true;
            player1turn = false; player2turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (availableKill1 == true) {
          System.out.println("kill opportunity is available. Please try again.");
        }
        else if (!((pc1N == (mc1N - 1) || pc1N == (mc1N + 1)) && pr1 == (mr1 - 1))){
          System.out.println("Invalid move. Players can only move diagnolly ahead.");
          System.out.println("Please try again.");
        }
        else {
          // Valid non-kill move
          board[pr1][pc1N].setPlayer(1);
          board[mr1][mc1N].setPlayer(0);
          if (board[mr1][mc1N].kingStatus() == true) {
            board[pr1][pc1N].makeKing(true);
            board[mr1][mc1N].makeKing(false);
          }
          System.out.println("Player 1 made a valid move. It is now Player 2's turn");
          validMove = true;
          player1turn = false; player2turn = true;
          checkPlayer1Kills();
        }
      }
      else {
        System.out.println("Please move to an empty spot."); 
        System.out.println("Please try again.");
      }
    }
  }
  
  public static void player2Turn() {
    System.out.println("Player O's turn. Please enter the coordinates of the cell you would like to move to.");
    
    if (test && index1 < testSeqStr.length) {
      mc2L = testSeqStr[index1]; 
      index1++;
    } else {
      System.out.println();
      System.out.println("Checker being moved:");
      System.out.println("Column Letter (capital letter and no extra characters):");
      mc2L = input.nextLine();
      //recordLetters += "\""+mc2L+"\""+",";
    }
    if (test && index1 < testSeqStr.length) {
      mr2 = testSeqInt[index2];
      index2++;
    } else {
      System.out.println("Row number:");
      mr2 = input.nextInt();
      recordNumbers += mr2+",  ";
    }
    if(debugOn){System.out.println("Player 2 - Test Sequence From: Column: " + mc2L + " Row: " + mr2);}
    mr2--;
    
    if (test && index1 < testSeqStr.length) {
      pc2L = testSeqStr[index1];
      index1++;
    } else {
      input.nextLine();
      System.out.println("Position you would like to move to");
      System.out.println("Column Letter (capital letter and no extra characters):");
      pc2L = input.nextLine();
      //recordLetters += "\""+pc2L+"\""+",";
    }
    if (test && index1 < testSeqStr.length) {
      if(debugOn){System.out.println("Player 2 - Test Sequence To: Column: " + pc2L + " Row: " + pr2);}
      pr2 = testSeqInt[index2];
      index2++;
    } else {
      System.out.println("Row number:");
      pr2 = input.nextInt();
      input.nextLine();
      recordNumbers += pr2+",  ";
    }
    pr2--;
    
    //converting columnn letter to index
    mc2N = columns.indexOf(mc2L);
    pc2N = columns.indexOf(pc2L);
    
    //rules
    if (mc2N == -1 || pc2N == -1) {
      System.out.println("letter entered is out of bounds");
      System.out.println("Please try again. Enter a capital letter.");
    }
    else {
      if (board[pr2][pc2N].getPlayer() == 0) {
        if (mr2 < 0 || mr2 > 7 || pr2 < 0 || pr2 > 7) {
          System.out.println("number entered is out of bounds");
          System.out.println("Please try again.");
        }
        else if (board[mr2][mc2N].getPlayer() != 2) {
          System.out.println("please move player 2's checker");
          System.out.println("Please try again.");
        }
        else if ((-1 < (mr2 + 2)) && ( (mr2 + 2) < 8) && (-1 < (mc2N + 2)) && ((mc2N + 2) < 8) && (board[(mr2 + 1)][(mc2N + 1)].getPlayer() == 1) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 + 2)) && (pc2N == (mc2N + 2))) {    
          board[pr2][pc2N].setPlayer(2);
          board[mr2][mc2N].setPlayer(0);
          board[mr2+1][mc2N+1].setPlayer(0);
          if (board[mr2][mc2N].kingStatus() == true) {
            board[pr2][pc2N].makeKing(true);
            board[mr2][mc2N].makeKing(false);
          }
          System.out.println("Player 1's piece has been killed.");
          player2Kills++;
          checkPlayer2Kills();
          if (availableKill2 == false) {
            if (debugOn) System.out.println("No more kills available for Player 2. It is now Player 1's turn.");
            validMove = true;
            player2turn = false; player1turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }   
        else if ((-1 < (mr2 + 2)) && ( (mr2 + 2) < 8) && (-1 < (mc2N - 2)) && ((mc2N - 2) < 8) && (board[(mr2 + 1)][(mc2N - 1)].getPlayer() == 1) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 + 2)) && (pc2N == (mc2N - 2))) {
          board[pr2][pc2N].setPlayer(2);
          board[mr2][mc2N].setPlayer(0);
          board[mr2+1][mc2N-1].setPlayer(0);
          if (board[mr2][mc2N].kingStatus() == true) {
            board[pr2][pc2N].makeKing(true);
            board[mr2][mc2N].makeKing(false);
          }
          System.out.println("Player 1's piece has been killed.");
          player2Kills++;
          checkPlayer2Kills();
          if (availableKill2 == false) {
            if (debugOn) System.out.println("No more kills available for Player 2. It is now Player 1's turn.");
            validMove = true;
            player2turn = false; player1turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (board[mr2][mc2N].kingStatus() == true && (-1 < (mr2 - 1)) && ( (mr2 - 1) < 8) && (-1 < (mc2N + 1)) && ((mc2N + 1) < 8) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 - 1)) && (pc2N == (mc2N + 1))) {    
          board[pr2][pc2N].setPlayer(2);
          board[pr2][pc2N].makeKing(true);
          board[mr2][mc2N].setPlayer(0);
          board[mr2][mc2N].makeKing(false);
          System.out.println("Player 2 made a valid move. It is now Player 1's turn");
          validMove = true;
          player2turn = false; player1turn = true;
        }
         else if (board[mr2][mc2N].kingStatus() == true && (-1 < (mr2 - 1)) && ( (mr2 - 1) < 8) && (-1 < (mc2N - 1)) && ((mc2N - 1) < 8) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 - 1)) && (pc2N == (mc2N - 1))) {    
          board[pr2][pc2N].setPlayer(2);
          board[pr2][pc2N].makeKing(true);
          board[mr2][mc2N].setPlayer(0);
          board[mr2][mc2N].makeKing(false);
          System.out.println("Player 2 made a valid move. It is now Player 1's turn");
          validMove = true;
          player2turn = false; player1turn = true;
        }
        else if (board[mr2][mc2N].kingStatus() == true && (-1 < (mr2 - 2)) && ( (mr2 - 2) < 8) && (-1 < (mc2N + 2)) && ((mc2N + 2) < 8) && (board[(mr2 - 1)][(mc2N + 1)].getPlayer() == 1) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 - 2)) && (pc2N == (mc2N + 2))) {    
          board[pr2][pc2N].setPlayer(2);
          board[mr2][mc2N].setPlayer(0);
          board[mr2-1][mc2N+1].setPlayer(0);
          board[pr2][pc2N].makeKing(true);
          board[mr2][mc2N].makeKing(false);
          System.out.println("Player 1's piece has been killed.");
          player2Kills++;
          checkPlayer2Kills();
          //kingAvailableKillsP2();
          if (availableKill2 == false) {
            if (debugOn) System.out.println("No more kills available for Player 2. It is now Player 1's turn.");
            validMove = true;
            player2turn = false; player1turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (board[mr2][mc2N].kingStatus() == true && (-1 < (mr2 - 2)) && ( (mr2 - 2) < 8) && (-1 < (mc2N - 2)) && ((mc2N - 2) < 8) && (board[(mr2 - 1)][(mc2N - 1)].getPlayer() == 1) && (board[pr2][pc2N].getPlayer() == 0) && (pr2 == (mr2 - 2)) && (pc2N == (mc2N - 2))) {
          board[pr2][pc2N].setPlayer(2);
          board[mr2][mc2N].setPlayer(0);
          board[mr2-1][mc2N-1].setPlayer(0);
          board[pr2][pc2N].makeKing(true);
          board[mr2][mc2N].makeKing(false);
          System.out.println("Player 1's piece has been killed.");
          player2Kills++;
          checkPlayer2Kills();
          //kingAvailableKillsP2();
          if (availableKill2 == false) {
            if (debugOn) System.out.println("No more kills available for Player 2. It is now Player 1's turn.");
            validMove = true;
            player2turn = false; player1turn = true;
          }
          if (validMove == false) {
            printBoard();
          }
        }
        else if (availableKill2 == true) {
          System.out.println("kill opportunity is available. Please try again.");
        }
        else if (!(/*mr2 <= 2 && */(pc2N == (mc2N - 1) || pc2N == (mc2N + 1)) && pr2 == (mr2 + 1))){
          System.out.println("Invalid move. Players can only move diagnolly ahead."); 
          System.out.println("Please try again.");
        }
        else {
          // Valid non-kill move
          board[pr2][pc2N].setPlayer(2);
          board[mr2][mc2N].setPlayer(0);
          if (board[mr2][mc2N].kingStatus() == true) {
            board[pr2][pc2N].makeKing(true);
            board[mr2][mc2N].makeKing(false);
          }
          System.out.println("Player 2 made a valid move. It is now Player 1's turn");
          validMove = true;
          player2turn = false; player1turn = true;
          checkPlayer2Kills();
        }
      }
      else {
        System.out.println("Please move to an empty spot."); 
        System.out.println("Please try again.");
      }
    }
  }
  
  public static void printBoard() {
    System.out.println("      A    B    C    D    E    F    G    H");
    System.out.println("   -----------------------------------------");
    for (int i = 0; i < 8; i ++) {
      System.out.print((i+1) + "  || ");
      for (int j = 0; j < 8; j++) {
        if (board[i][j].getPlayer() == 0) {
          System.out.print(" ");
        }
        else if (board[i][j].getPlayer() == 1 && board[i][j].kingStatus() == false){
          System.out.print("X");
        }
        else if (board[i][j].getPlayer() == 1 && board[i][j].kingStatus() == true){
          System.out.print("x'");
        }
        else if (board[i][j].getPlayer() == 2 && board[i][j].kingStatus() == false) {
          System.out.print("O");
        }
        else if (board[i][j].getPlayer() == 2 && board[i][j].kingStatus() == true){
          System.out.print("o'");
        }
        System.out.print(" || ");
      }
      System.out.println();
      System.out.println("   -----------------------------------------");
    }
  }
  
  public static void debug(String a) {
    if (debugOn) {
    System.out.println(a);
    System.out.println("availableKill1: " + availableKill1 + " pr1: " + pr1 + " pc1N: " + pc1N + " mr1: " + mr1 + " mc1N: " + mc1N);
    System.out.println("availableKill2: " + availableKill2 + " pr2: " + pr2 + " pc2N: " + pc2N + " mr2: " + mr2 + " mc2N: " + mc2N);
    System.out.println("available kills: " + availableKill1 + " " + availableKill2);
    System.out.println("kills: " + player1Kills + " " + player2Kills);
    }
  }
  
  public static void populateBoard() {
    //first and third row 
    for (int i = 0; i < 3; i=i+2) {
      for (int j = 1; j < 8; j=j+2) {
        board[i][j] = new pieces (j, i, false, 2);
      }
    }
    for (int i = 0; i < 3; i=i+2) {
      for (int j = 0; j < 8; j=j+2) {
        board[i][j] = new pieces (j, i, false, 0);
      }
    }
    
    //second row
    for (int j = 0; j < 8; j=j+2) {
      board[1][j] = new pieces (j, 1, false, 2);
    }
    
    for (int j = 1; j < 8; j=j+2) {
      board[1][j] = new pieces (j, 1, false, 0);
    }
    
    //fourth and fifth row
    for (int i = 3; i < 5; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = new pieces (j, i, false, 0);
      }
    }
    
    //sixth and eight row
    for (int i = 5; i < 8; i=i+2) {
      for (int j = 0; j < 8; j=j+2) {
        board[i][j] = new pieces (j, i, false, 1);
      }
    }
    
    for (int i = 5; i < 8; i=i+2) {
      for (int j = 1; j < 8; j=j+2) {
        board[i][j] = new pieces (j, i, false, 0);
      }
    }
    
    //seventh row 
    for (int j = 1; j < 8; j=j+2) {
      board[6][j] = new pieces (j, 6, false, 1);
    }
    
    for (int j = 0; j < 8; j=j+2) {
      board[6][j] = new pieces (j, 6, false, 0);
    }
  }
  
  public static void checkKingOfP1() {
    for (int i = 0; i < 8; i++) {
      if (board[0][i].getX() == board[pr1][pc1N].getX() && board[0][i].getY() == board[pr1][pc1N].getY()) {
        board[0][i].makeKing(true);
        System.out.println("Player 1 has made a king");
      }
    }
  }
  
   public static void checkKingOfP2() {
     for (int i = 0; i < 8; i++) {
      if (board[7][i].getX() == board[pr2][pc2N].getX() && board[7][i].getY() == board[pr2][pc2N].getY()) {
        board[7][i].makeKing(true);
        System.out.println("Player 2 has made a king");
      }
    }
   }
  /*
  public static void kingAvailableKillsP1() {
    if (board[pr1][pc1N].kingStatus() == true) {
      if (debugOn) System.out.println("kingAvailableKillsP1: checking piece at " + pr1 + " and " + pc1N);
      if ((-1 < (pr1 - 2)) && ((pr1 - 2) < 8) && (-1 < (pc1N + 2)) && ((pc1N + 2) < 8) && (board[(pr1 - 1)][(pc1N + 1)].getPlayer() == 2) && (board[pr1 - 2][pc1N + 2].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 1: true1");
        availableKill1 = true;
      }
      else if ((-1 < (pr1 - 2)) && ( (pr1 - 2) < 8) && (-1 < (pc1N - 2)) && ((pc1N - 2) < 8) && (board[(pr1 - 1)][(pc1N - 1)].getPlayer() == 2 && board[pr1 - 2][pc1N - 2].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 1: true2");
        availableKill1 = true;
      }
      else if ((-1 < (pr1 + 2)) && ((pr1 + 2) < 8) && (-1 < (pc1N + 2)) && ((pc1N + 2) < 8) && (board[(pr1 + 1)][(pc1N + 1)].getPlayer() == 2) && (board[pr1 + 2][pc1N + 2].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 1: true3");
        availableKill1 = true;
      }
      else if ((-1 < (pr1 + 2)) && ( (pr1 + 2) < 8) && (-1 < (pc1N - 2)) && ((pc1N - 2) < 8) && (board[(pr1 + 1)][(pc1N - 1)].getPlayer() == 2 && board[pr1 + 2][pc1N - 2].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 1: true4");
        availableKill1 = true;
      }
    }
  }
  
  public static void kingAvailableKillsP2() {
    if (board[pr2][pc2N].kingStatus() == true) {
      if (debugOn) System.out.println("kingAvailableKillsP2: checking piece at " + pr2 + " and " + pc2N);
      if ((-1 < (pr2 + 2)) && ( (pr2 + 2) < 8) && (-1 < (pc2N + 2)) && ((pc2N + 2) < 8) && (board[(pr2 + 1)][(pc2N + 1)].getPlayer() == 1) && (board[pr2 + 2][pc2N + 2].getPlayer() == 0)) {    
        if (debugOn) System.out.println("Available kill for Player 2: true1");
        availableKill2 = true;
      }
      else if ((-1 < (pr2 + 2)) && ( (pr2 + 2) < 8) && (-1 < (pc2N - 2)) && ((pc2N - 2) < 8) && (board[(pr2 + 1)][(pc2N - 1)].getPlayer() == 1) && (board[(pr2 + 2)][(pc2N - 2)].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 2: true2");
        availableKill2 = true;
      }
      else if ((-1 < (pr2 - 2)) && ( (pr2 - 2) < 8) && (-1 < (pc2N + 2)) && ((pc2N + 2) < 8) && (board[(pr2 - 1)][(pc2N + 1)].getPlayer() == 1) && (board[pr2 - 2][pc2N + 2].getPlayer() == 0)) {    
        if (debugOn) System.out.println("Available kill for Player 2: true3");
        availableKill2 = true;
      }
      else if ((-1 < (pr2 - 2)) && ( (pr2 - 2) < 8) && (-1 < (pc2N - 2)) && ((pc2N - 2) < 8) && (board[(pr2 - 1)][(pc2N - 1)].getPlayer() == 1) && (board[(pr2 - 2)][(pc2N - 2)].getPlayer() == 0)) {
        if (debugOn) System.out.println("Available kill for Player 2: true4");
        availableKill2 = true;
      }
    }
  }
  */
  //checking if game is over (add AFTER both while loops!)
  
  public static void noPiecesLeftofP1() {
    int counter = 0;
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j].getPlayer() == 1) {
          counter++;
        }
      }
    }
    if (counter == 0) {
      System.out.println("Player 2 Wins!!!");
      player1turn = false;
      player2turn = false;
      gameOver = true;
    }
    if (debugOn == true) {
      System.out.println("passed noPiecesLeftofP1");
    }
  }
  
  public static void noPiecesLeftofP2() {
    int counter = 0;
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j].getPlayer() == 2) {
          counter++;
        }
      }
    }
    if (counter == 0) {
      System.out.println("Player 1 Wins!!!");
      player1turn = false;
      player2turn = false;
      gameOver = true;
    }
    if (debugOn == true) {
      System.out.println("passed noPiecesLeftofP2");
    }
  }
  
  public static void player1Stuck() {
   boolean stuck = true;
   for (int i = 0; i < 8; i ++) {
     for (int j = 0; j < 8; j++) {
       //if (debugOn) System.out.println("Checking piece at i = " + i + "j = " + j);
       if (board[i][j].getPlayer() == 1) { 
         //if (debugOn) System.out.println("Piece belongs to player 1. i = " + i + "j = " + j);
         
         // valid non-kill move on left & right
         if (i-1>=0 && j-1>=0) {
           //if (debugOn) System.out.println("Line before crash");
           if (board[i-1][j-1].getPlayer() == 0) {
             //if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
             stuck = false;
           }
         } if (i-1>=0 && j+1<8) {
             if (board[i-1][j+1].getPlayer() == 0) {
             //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
             stuck = false;
           }
         } if (i-2>=0 && j-2>=0) {
             if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 2) {
               // valid kill move on left
               //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
               stuck = false;
           }
         }
         if (i-2>=0 && j+2<8) {
           if (board[i-2][j+2].getPlayer() == 0  && board[i-1][j+1].getPlayer() == 2) {
             //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
             stuck = false;
           }
         }
         
         // valid non-kill move on left & right - FOR KING
         if (board[i][j].kingStatus() == true) {
           if (debugOn) System.out.println("It's a King Piece. Checking for king moves");
           if (i+1<8 && j-1>=0) {
             //if (debugOn) System.out.println("Line before crash");
             if (board[i+1][j-1].getPlayer() == 0) {
               //if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
               stuck = false;
             }
           } if (i+1<8 && j+1<8) {
             if (board[i+1][j+1].getPlayer() == 0) {
               //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
               stuck = false;
             }
           } if (i+2<8 && j-2>=0) {
             if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 2) {
               // valid kill move on left
               //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
               stuck = false;
             }
           } 
           if (i+2<8 && j+2<8) {
             if (board[i+2][j+2].getPlayer() == 0  && board[i+1][j+1].getPlayer() == 2) {
               //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
               stuck = false;
             }
           }
         }
       }
     }
   }
   if (stuck == true) {
     System.out.println("Player 2 wins!!!");
     player1turn = false;
     player2turn = false;
     gameOver = true;
   }
   if (debugOn) System.out.println("passed player1Stuck");
  }

  public static void player2Stuck() {
    boolean stuck = true;
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j++) {
        //if (debugOn) System.out.println("Checking piece at i = " + i + "j = " + j);
        if (board[i][j].getPlayer() == 2) { 
          //if (debugOn) System.out.println("Piece belongs to player 1. i = " + i + "j = " + j);
          
          // valid non-kill move on left & right
          if (i+1<8 && j-1>=0) {
            //if (debugOn) System.out.println("Line before crash");
            if (board[i+1][j-1].getPlayer() == 0) {
              // if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
              stuck = false;
            }
          } if (i+1<8 && j+1<8) {
            if (board[i+1][j+1].getPlayer() == 0) {
              //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
              stuck = false;
            }
          } if (i+2<8 && j-2>=0) {
            if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 1) {
              // valid kill move on left
              //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
              stuck = false;
            }
          } if (i+2<8 && j+2<8) {
            if (board[i+2][j+2].getPlayer() == 0  && board[i+1][j+1].getPlayer() == 1) {
              //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
              stuck = false;
            }
          }
          
          // valid non-kill move on left & right - FOR KING
          if (board[i][j].kingStatus() == true) {
            if (i-1>=0 && j-1>=0) {
              //if (debugOn) System.out.println("Line before crash");
              if (board[i-1][j-1].getPlayer() == 0) {
                //if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
                stuck = false;
              }
            } if (i-1>=0 && j+1<8) {
              if (board[i-1][j+1].getPlayer() == 0) {
                //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
                stuck = false;
              }
            } if (i-2>=0 && j-2>=0) {
              if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 1) {
                // valid kill move on left
                //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
                stuck = false;
              } 
            } if (i-2>=0 && j+2<8) {
              if (board[i-2][j+2].getPlayer() == 0  && board[i-1][j+1].getPlayer() == 1) {
                //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
                stuck = false;
              }
            }
          }
        }
      }
    }
    if (stuck == true) {
      System.out.println("Player 1 wins!!!");
      player1turn = false;
      player2turn = false;
      gameOver = true;
    }
    if (debugOn) System.out.println("passed player1Stuck");
  }
  
  public static void checkDraw() {
   boolean stuck1 = true;
   boolean stuck2 = true;
   for (int i = 0; i < 8; i ++) {
     for (int j = 0; j < 8; j++) {
       //if (debugOn) System.out.println("Checking piece at i = " + i + "j = " + j);
       if (board[i][j].getPlayer() == 1) { 
         //if (debugOn) System.out.println("Piece belongs to player 1. i = " + i + "j = " + j);
         
         // valid non-kill move on left & right
         if (i-1>=0 && j-1>=0) {
           //if (debugOn) System.out.println("Line before crash");
           if (board[i-1][j-1].getPlayer() == 0) {
             //if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
             stuck1 = false;
           }
         } if (i-1>=0 && j+1<8) {
           if (board[i-1][j+1].getPlayer() == 0) {
             //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
             stuck1 = false;
           }
         } if (i-2>=0 && j-2>=0) {
           if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 2) {
             // valid kill move on left
             //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
             stuck1 = false;
           }
         } if (i-2>=0 && j+2<8) {
           if (board[i-2][j+2].getPlayer() == 0  && board[i-1][j+1].getPlayer() == 2) {
             //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
             stuck1 = false;
           }
         }
         
         // valid non-kill move on left & right - FOR KING
         if (board[i][j].kingStatus() == true) {
           if (i+1<8 && j-1>=0) {
             //if (debugOn) System.out.println("Line before crash");
             if (board[i+1][j-1].getPlayer() == 0) {
               //if (debugOn) System.out.println("Valid non-kill move on the left for player 1. i = " + i + "j = " + j);
               stuck1 = false;
             }
           } if (i+1<8 && j+1<8) {
             if (board[i+1][j+1].getPlayer() == 0) {
               //if (debugOn) System.out.println("Valid non-kill move on the right for player 1. i = " + i + "j = " + j);
               stuck1 = false;
             }
           } if (i+2<8 && j-2>=0) {
             if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 2) {
               // valid kill move on left
               //if (debugOn) System.out.println("Valid kill move on the left for player 1. i = " + i + "j = " + j);
               stuck1 = false;
             }
           } if (i+2<8 && j+2<8) {
             if (board[i+2][j+2].getPlayer() == 0  && board[i+1][j+1].getPlayer() == 2) {
               //if (debugOn) System.out.println("Valid kill move on the right for player 1. i = " + i + "j = " + j);
               stuck1 = false;
             }
           }
         }
       }
       
       if (board[i][j].getPlayer() == 2) { 
         if (debugOn) System.out.println("Piece belongs to player 2. i = " + i + "j = " + j);
         
         // valid non-kill move on left & right
         if (i+1<8 && j-1>=0) {
           if (board[i+1][j-1].getPlayer() == 0) {
             if (debugOn) System.out.println("Valid non-kill move on the left for player 2. i = " + i + "j = " + j);
             stuck2 = false;
           }
         } if (i+1<8 && j+1<8) {
           if (board[i+1][j+1].getPlayer() == 0) {
             if (debugOn) System.out.println("Valid non-kill move on the right for player 2. i = " + i + "j = " + j);
             stuck2 = false;
           }
         } if (i+2<8 && j-2>=0) {
           if (board[i+2][j-2].getPlayer() == 0  && board[i+1][j-1].getPlayer() == 1) {
             // valid kill move on left
             if (debugOn) System.out.println("Valid kill move on the left for player 2. i = " + i + "j = " + j);
             stuck2 = false;
           }
         } if (i+2<8 && j+2<8) {
           if (board[i+2][j+2].getPlayer() == 0  && board[i+1][j+1].getPlayer() == 1) {
             if (debugOn) System.out.println("Valid kill move on the right for player 2. i = " + i + "j = " + j);
             stuck2 = false;
           }
         }
         
         // valid non-kill move on left & right - FOR KING
         if (board[i][j].kingStatus() == true) {
           if (debugOn) System.out.println("It's a King Piece. Checking for king moves");
           if (i-1>=0 && j-1>=0) {
             if (board[i-1][j-1].getPlayer() == 0) {
               if (debugOn) System.out.println("Valid non-kill move on the left for player 2. i = " + i + "j = " + j);
               stuck2 = false;
             }
           }if (i-1>=0 && j+1<8) {
             if (board[i-1][j+1].getPlayer() == 0) {
               if (debugOn) System.out.println("Valid non-kill move on the right for player 2. i = " + i + "j = " + j);
               stuck2 = false;
             }
           } if (i-2>=0 && j-2>=0) {
             if (board[i-2][j-2].getPlayer() == 0  && board[i-1][j-1].getPlayer() == 1) {
               // valid kill move on left
               if (debugOn) System.out.println("Valid kill move on the left for player 2. i = " + i + "j = " + j);
               stuck2 = false;
             }
           } if (i-2>=0 && j+2<8) {
             if (board[i-2][j+2].getPlayer() == 0  && board[i-1][j+1].getPlayer() == 1) {
               if (debugOn) System.out.println("Valid kill move on the right for player 2. i = " + i + "j = " + j);
               stuck2 = false;
             }
           }
         }
       }
     }
   }
   if (stuck1 == true && stuck2 == true) {
     System.out.println("It's a draw!!");
     player1turn = false;
     player2turn = false;
     gameOver = true;
   }
  }
  
  public static void checkIfGameEnded() {
    noPiecesLeftofP1();
    noPiecesLeftofP2();
    checkDraw();
    player1Stuck();
    player2Stuck();
  }
  
}

    
 