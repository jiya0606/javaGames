/* JIYA GUPTA */

/*To Do:  
 * method with input
 * 1D array ->2D array when printing
 * ask dad abt sequencing AND Program Code Segment
 * */
import java.util.*;
public class Connect4 { 
  public static void main (String []args) {
    
    Scanner input = new Scanner (System.in);
    
    // 7 row, 6 down 
    String [] a = {" ", " ", " ", " ", " ", " "}; //1
    String [] b = {" ", " ", " ", " ", " ", " "}; //2
    String [] c = {" ", " ", " ", " ", " ", " "}; //3
    String [] d = {" ", " ", " ", " ", " ", " "}; //4
    String [] e = {" ", " ", " ", " ", " ", " "}; //5
    String [] f = {" ", " ", " ", " ", " ", " "}; //6
    String [] g = {" ", " ", " ", " ", " ", " "}; //7
    
    int na = 5;
    int nb = 5; 
    int nc = 5;
    int nd = 5;
    int ne = 5; 
    int nf = 5;
    int ng = 5;
    
    int run = 1;
    
    System.out.println("   A    B    C    D    E    F    G");
      System.out.println("1: " + a[0] + " || " + b[0] + " || " + c[0] + " || " + d[0] + " || " + e[0] + " || " + f[0] + " || " + g[0]);
      System.out.println("-----------------------------------");
      System.out.println("2: " +  a[1] + " || " + b[1] + " || " + c[1] + " || " + d[1] + " || " + e[1] + " || " + f[1] + " || " + g[1]);
      System.out.println("-----------------------------------");
      System.out.println("3: " +  a[2] + " || " + b[2] + " || " + c[2] + " || " + d[2] + " || " + e[2] + " || " + f[2] + " || " + g[2]);
      System.out.println("-----------------------------------");
      System.out.println("4: " +  a[3] + " || " + b[3] + " || " + c[3] + " || " + d[3] + " || " + e[3] + " || " + f[3] + " || " + g[3]);
      System.out.println("-----------------------------------");
      System.out.println("5: " +  a[4] + " || " + b[4] + " || " + c[4] + " || " + d[4] + " || " + e[4] + " || " + f[4] + " || " + g[4]);
      System.out.println("-----------------------------------");
      System.out.println("6: " +  a[5] + " || " + b[5] + " || " + c[5] + " || " + d[5] + " || " + e[5] + " || " + f[5] + " || " + g[5]);
      System.out.println();
    
    while (run == 1) {
      System.out.println("Player 1 (X): Enter a row letter (use capital letters)");
      String l; 
      l = input.nextLine();
      
      if (l.compareTo("A") == 0) {
        a[na] = "X";
        na--;
      }
      if (l.compareTo("B") == 0) {
        b[nb] = "X";
        nb--;
      }
      if (l.compareTo("C") == 0) {
        c[nc] = "X";
        nc--;
      }
      if (l.compareTo("D") == 0) {
        d[nd] = "X";
        nd--;
      }
      if (l.compareTo("E") == 0) {
        e[ne] = "X";
        ne--;
      }
      if (l.compareTo("F") == 0) {
        f[nf] = "X";
        nf--;
      }
      if (l.compareTo("G") == 0) {
        g[ng] = "X";
        ng--;
      }
       if (na < 0 && nb < 0 && nc < 0 && nd < 0 && ne < 0 && nf < 0 && ng < 0) {
         System.out.println("Its a tie!");
         break;
       }
      
      if (na < 0 || nb < 0 || nc < 0 || nd < 0 || ne < 0 || nf < 0 || ng < 0) {
        System.out.println("Please enter in a valid number. Player 1 has lost their turn");
      }
      
            
      System.out.println("   A    B    C    D    E    F    G");
      System.out.println("1: " + a[0] + " || " + b[0] + " || " + c[0] + " || " + d[0] + " || " + e[0] + " || " + f[0] + " || " + g[0]);
      System.out.println("-----------------------------------");
      System.out.println("2: " +  a[1] + " || " + b[1] + " || " + c[1] + " || " + d[1] + " || " + e[1] + " || " + f[1] + " || " + g[1]);
      System.out.println("-----------------------------------");
      System.out.println("3: " +  a[2] + " || " + b[2] + " || " + c[2] + " || " + d[2] + " || " + e[2] + " || " + f[2] + " || " + g[2]);
      System.out.println("-----------------------------------");
      System.out.println("4: " +  a[3] + " || " + b[3] + " || " + c[3] + " || " + d[3] + " || " + e[3] + " || " + f[3] + " || " + g[3]);
      System.out.println("-----------------------------------");
      System.out.println("5: " +  a[4] + " || " + b[4] + " || " + c[4] + " || " + d[4] + " || " + e[4] + " || " + f[4] + " || " + g[4]);
      System.out.println("-----------------------------------");
      System.out.println("6: " +  a[5] + " || " + b[5] + " || " + c[5] + " || " + d[5] + " || " + e[5] + " || " + f[5] + " || " + g[5]);
      System.out.println();
      
      int run1 = 1;
      //check for win 
      for (int i = 0; i <= 5; i++) {
        if (a[i].compareTo("X") == 0 && b[i].compareTo("X") == 0 && c[i].compareTo("X") == 0 && d[i].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (b[i].compareTo("X") == 0 && c[i].compareTo("X") == 0 && d[i].compareTo("X") == 0 && e[i].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
          
        if (c[i].compareTo("X") == 0 && d[i].compareTo("X") == 0 && e[i].compareTo("X") == 0 && f[i].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (d[i].compareTo("X") == 0 && e[i].compareTo("X") == 0 && f[i].compareTo("X") == 0 && g[i].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
      }

      for (int j = 0; j <= 2; j++) {
        if (a[j].compareTo("X") == 0 && a[j+1].compareTo("X") ==0 && a[j+2].compareTo("X") == 0 && a[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (b[j].compareTo("X") == 0 && b[j+1].compareTo("X") ==0 && b[j+2].compareTo("X") == 0 && b[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (c[j].compareTo("X") == 0 && c[j+1].compareTo("X") ==0 && c[j+2].compareTo("X") == 0 && c[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (d[j].compareTo("X") == 0 && d[j+1].compareTo("X") ==0 && d[j+2].compareTo("X") == 0 && d[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (e[j].compareTo("X") == 0 && e[j+1].compareTo("X") ==0 && e[j+2].compareTo("X") == 0 && e[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (f[j].compareTo("X") == 0 && f[j+1].compareTo("X") ==0 && f[j+2].compareTo("X") == 0 && f[j+3].compareTo("X") == 0) {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
      }
      //diagnols 
      for (int q = 0; q <= 2; q++) {
        if (c[q] == "X" && d[q+1] == "X" && e[q+2] == "X" && f[q+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (b[q] == "X" && c[q+1] == "X" && d[q+2] == "X" && e[q+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (a[q] == "X" && b[q+1] == "X" && c[q+2] == "X" && d[q+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (d[q] == "X" && e[q+1] == "X" && f[q+2] == "X" && g[q+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
      }
      
      for (int k = 0; k <= 2; k++) {  
         if (g[k] == "X" && f[k+1] == "X" && e[k+2] == "X" && d[k+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (f[k] == "X" && e[k+1] == "X" && d[k+2] == "X" && c[k+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
        if (e[k] == "X" && d[k+1] == "X" && c[k+2] == "X" && b[k+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
         if (d[k] == "X" && c[k+1] == "X" && b[k+2] == "X" && a[k+3] == "X") {
          System.out.println("Player 1 Wins!!");
          run = 2;
          run1++;
        }
      }
      
      if (run1 == 2) {
        break;
      }
      
      
      System.out.println("Player 2 (O): Enter a row letter (use capital letters)");
      String l1; 
      l1 = input.nextLine();
      
      if (l1.compareTo("A") == 0) {
        a[na] = "O";
        na--;
      }
      if (l1.compareTo("B") == 0) {
        b[nb] = "O";
        nb--;
      }
      if (l1.compareTo("C") == 0) {
        c[nc] = "O";
        nc--;
      }
      if (l1.compareTo("D") == 0) {
        d[nd] = "O";
        nd--;
      }
      if (l1.compareTo("E") == 0) {
        e[ne] = "O";
        ne--;
      }
      if (l1.compareTo("F") == 0) {
        f[nf] = "O";
        nf--;
      }
      if (l1.compareTo("G") == 0) {
        g[ng] = "O";
        ng--;
      }
      
       if (na < 0 && nb < 0 && nc < 0 && nd < 0 && ne < 0 && nf < 0 && ng < 0) {
         System.out.println("Its a tie!");
         break;
       }
      
      if (na < 0 || nb < 0 || nc < 0 || nd < 0 || ne < 0 || nf < 0 || ng < 0) {
        System.out.println("Please enter in a valid number. Player 2 has lost their turn");
      }
      
      
      System.out.println("   A    B    C    D    E    F    G");
      System.out.println("1: " + a[0] + " || " + b[0] + " || " + c[0] + " || " + d[0] + " || " + e[0] + " || " + f[0] + " || " + g[0]);
      System.out.println("-----------------------------------");
      System.out.println("2: " +  a[1] + " || " + b[1] + " || " + c[1] + " || " + d[1] + " || " + e[1] + " || " + f[1] + " || " + g[1]);
      System.out.println("-----------------------------------");
      System.out.println("3: " +  a[2] + " || " + b[2] + " || " + c[2] + " || " + d[2] + " || " + e[2] + " || " + f[2] + " || " + g[2]);
      System.out.println("-----------------------------------");
      System.out.println("4: " +  a[3] + " || " + b[3] + " || " + c[3] + " || " + d[3] + " || " + e[3] + " || " + f[3] + " || " + g[3]);
      System.out.println("-----------------------------------");
      System.out.println("5: " +  a[4] + " || " + b[4] + " || " + c[4] + " || " + d[4] + " || " + e[4] + " || " + f[4] + " || " + g[4]);
      System.out.println("-----------------------------------");
      System.out.println("6: " +  a[5] + " || " + b[5] + " || " + c[5] + " || " + d[5] + " || " + e[5] + " || " + f[5] + " || " + g[5]);
      System.out.println();
      
        //check for win 
      for (int i = 0; i <= 5; i++) {
        if (a[i].compareTo("O") == 0 && b[i].compareTo("O") == 0 && c[i].compareTo("O") == 0 && d[i].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (b[i].compareTo("O") == 0 && c[i].compareTo("O") == 0 && d[i].compareTo("O") == 0 && e[i].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
          
        if (c[i].compareTo("O") == 0 && d[i].compareTo("O") == 0 && e[i].compareTo("O") == 0 && f[i].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (d[i].compareTo("O") == 0 && e[i].compareTo("O") == 0 && f[i].compareTo("O") == 0 && g[i].compareTo("v") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
      }

      for (int j = 0; j <= 2; j++) {
        if (a[j].compareTo("O") == 0 && a[j+1].compareTo("O") ==0 && a[j+2].compareTo("O") == 0 && a[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (b[j].compareTo("O") == 0 && b[j+1].compareTo("O") ==0 && b[j+2].compareTo("O") == 0 && b[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (c[j].compareTo("O") == 0 && c[j+1].compareTo("O") ==0 && c[j+2].compareTo("O") == 0 && c[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (d[j].compareTo("O") == 0 && d[j+1].compareTo("O") ==0 && d[j+2].compareTo("O") == 0 && d[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (e[j].compareTo("O") == 0 && e[j+1].compareTo("O") ==0 && e[j+2].compareTo("O") == 0 && e[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (f[j].compareTo("O") == 0 && f[j+1].compareTo("O") ==0 && f[j+2].compareTo("O") == 0 && f[j+3].compareTo("O") == 0) {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
      }
      //diagnols 
      for (int q = 0; q <= 2; q++) {
        if (c[q] == "O" && d[q+1] == "O" && e[q+2] == "O" && f[q+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (b[q] == "O" && c[q+1] == "O" && d[q+2] == "O" && e[q+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (a[q] == "O" && b[q+1] == "O" && c[q+2] == "O" && d[q+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (d[q] == "O" && e[q+1] == "O" && f[q+2] == "O" && g[q+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
      }
      
      for (int k = 0; k <= 2; k++) {  
         if (g[k] == "O" && f[k+1] == "O" && e[k+2] == "O" && d[k+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (f[k] == "O" && e[k+1] == "O" && d[k+2] == "O" && c[k+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
        if (e[k] == "O" && d[k+1] == "O" && c[k+2] == "O" && b[k+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
         if (d[k] == "O" && c[k+1] == "O" && b[k+2] == "O" && a[k+3] == "O") {
          System.out.println("Player 2 Wins!!");
          run = 2;
        }
      }
    }


  }
  
}