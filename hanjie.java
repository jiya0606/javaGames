/*Jiya Gupta */
public class hanjie {
  public static int[][] x = new int [3][10];
  public static int[][] y = new int [3][10];
  public static boolean[] xComplete = new boolean [10];
  public static boolean[] yComplete = new boolean [10];
  public static String[] board =  new String[100];
  
  public static void main (String[]args) {
    for (int i = 0; i < 100; i++) {
      board[i] = " . ";
    }

    
    
    
    test();
    validate();
    firstStepY();
    firstStepX();
    validate();
    secondStep();
    validate();
    thirdStep();
    validate();
    fillInTheBlank();
    validate();
    lastStep();
    validate();
    printBoard(board);
    
    
    
  }
  
  public static void test() {
    /*
    x[0][0] = 1;  y[0][0] = 9;
    x[1][0] = 1;  y[1][0] = 0;
    x[2][0] = 1;  y[2][0] = 0;
    
    x[0][1] = 2;  y[0][1] = 1;
    x[1][1] = 1;  y[1][1] = 4;
    x[2][1] = 2;  y[2][1] = 1;
    
    x[0][2] = 1;  y[0][2] = 3;
    x[1][2] = 1;  y[1][2] = 0;
    x[2][2] = 0;  y[2][2] = 0;
    
    x[0][3] = 3;  y[0][3] = 3;
    x[1][3] = 0;  y[1][3] = 2;
    x[2][3] = 0;  y[2][3] = 0;
    
    x[0][4] = 1;  y[0][4] = 3;
    x[1][4] = 6;  y[1][4] = 0;
    x[2][4] = 0;  y[2][4] = 0;
    
    x[0][5] = 1;  y[0][5] = 3;
    x[1][5] = 6;  y[1][5] = 0;
    x[2][5] = 0;  y[2][5] = 0;
    
    x[0][6] = 1;  y[0][6] = 0;
    x[1][6] = 3;  y[1][6] = 0;
    x[2][6] = 2;  y[2][6] = 0;
    
    x[0][7] = 2;  y[0][7] = 2;
    x[1][7] = 1;  y[1][7] = 2;
    x[2][7] = 0;  y[2][7] = 2;
    
    x[0][8] = 1;  y[0][8] = 1;
    x[1][8] = 2;  y[1][8] = 0;
    x[2][8] = 0;  y[2][8] = 0;
    
    x[0][9] = 0;  y[0][9] = 1;
    x[1][9] = 0;  y[1][9] = 0;
    x[2][9] = 0;  y[2][9] = 0;
    */
   
    x[0][0] = 1;  y[0][0] = 1;
    x[1][0] = 3;  y[1][0] = 4;
    x[2][0] = 0;  y[2][0] = 1;
    
    x[0][1] = 2;  y[0][1] = 1;
    x[1][1] = 0;  y[1][1] = 4;
    x[2][1] = 0;  y[2][1] = 1;
    
    x[0][2] = 3;  y[0][2] = 1;
    x[1][2] = 0;  y[1][2] = 2;
    x[2][2] = 0;  y[2][2] = 1;
    
    x[0][3] = 4;  y[0][3] = 2;
    x[1][3] = 2;  y[1][3] = 0;
    x[2][3] = 0;  y[2][3] = 0;
    
    x[0][4] = 4;  y[0][4] = 2;
    x[1][4] = 5;  y[1][4] = 0;
    x[2][4] = 0;  y[2][4] = 0;
    
    x[0][5] = 4;  y[0][5] = 0;
    x[1][5] = 5;  y[1][5] = 0;
    x[2][5] = 0;  y[2][5] = 0;
    
    x[0][6] = 4;  y[0][6] = 4;
    x[1][6] = 2;  y[1][6] = 0;
    x[2][6] = 0;  y[2][6] = 0;
    
    x[0][7] = 3;  y[0][7] = 1;
    x[1][7] = 0;  y[1][7] = 6;
    x[2][7] = 0;  y[2][7] = 0;
    
    x[0][8] = 2;  y[0][8] = 8;
    x[1][8] = 0;  y[1][8] = 0;
    x[2][8] = 0;  y[2][8] = 0;
    
    x[0][9] = 1;  y[0][9] = 10;
    x[1][9] = 1;  y[1][9] = 0;
    x[2][9] = 3;  y[2][9] = 0;
  }
  
  public static void populateTest() {
    for (int i = 0; i < 10; i++) {
      xComplete[i] = false;
      yComplete[i] = false;
    }
  }
  
  public static void printBoard(String[] a) {
    for (int i = 2; i > -1; i--) {
      System.out.println();
      System.out.print("         ");
      for (int j = 0; j < 10; j++) {
        System.out.print(" " + x[i][j] + " ");
      }
    }
    /*printing T or F ---------
    System.out.println();
    System.out.print("            ");
    for (int i = 0; i < 10; i++) {
      if (xComplete[i] == true) {
        System.out.print(" T ");
      }
      else {
        System.out.print(" F ");
      }
    }
    ----------*/
    System.out.println();
    
    for (int i = 0; i < 100; i=i+10) {
      for (int j = 2; j > -1; j--) {
        System.out.print(y[j][i/10] + "  ");
      }
      /*printing T and F ------
      if (yComplete[(i/10)] == true) {
        System.out.print(" T ");
      }
      else {
        System.out.print(" F ");
      }
       -------*/
      for (int z = 0; z < 10; z++) {
        System.out.print(a[i+z]);
      }
      System.out.println();
    }
  }
  
    public static void firstStepX() {
    for (int i = 0; i < 10; i++) {
      if (x[0][i] == 10) {
        for (int j = i; j < 100; j = j+10) {
          board[j] = " X ";
        }
        xComplete[i] = true;
      }
      if (x[0][i] == 9) {
        for (int j = (i+10); j < 90; j = j+10) {
          board[j] = " X ";
        }
      }
      if (x[0][i] == 8) {
        for (int j = (i+20); j < 80; j = j+10) {
          board[j] = " X ";
        }
      }
      if (x[0][i] == 7) {
        for (int j = (i+30); j < 70; j = j+10) {
          board[j] = " X "; 
        }
      }
      if (x[0][i] == 6) {
        for (int j = (i+40); j < 60; j = j+10) {
          board[j] = " X ";
        }
      }
    }
  }
    
  public static void firstStepY() {
    for (int i = 0; i < 10; i++) {
      if (y[0][i] == 10) {
        for (int j = (i*10); j < (i*10) + 10; j++) {
          board[j] = " X ";   
        }
        yComplete[i] = true;
      }
      if (y[0][i] == 9) {
        for (int j = (i*10)+1; j < (i*10) + 9; j++) {
          board[j] = " X ";  
        }
      }
      if (y[0][i] == 8) {
        for (int j = (i*10)+2; j < (i*10) + 8; j++) {
          board[j] = " X ";
        }
      }
      if (y[0][i] == 7) {
        for (int j = (i*10)+3; j < (i*10) + 7; j++) {
          board[j] = " X ";
        }
      }
      if (y[0][i] == 6) {
        for (int j = (i*10)+4; j < (i*10) + 6; j++) {
          board[j] = " X ";
        }
      }
    }
  }
  
  public static void secondStep() {
    for (int i = 0; i < 10; i++) {
      if (x[0][i] > 0 && board[90 + i].compareTo(" X ") == 0) {
        int a = 90 + i;
        for (int j = 0; j < x[0][i]; j++) {
          board[a] = " X ";
          a = a-10;
        }
      }   
      if (x[0][i] > 0 && board[i].compareTo(" X ") == 0) {
        int a = i;
        for (int j = 0; j < x[0][i]; j++) {
          board[a] = " X ";
          a = a+10;
        }
      }
    }
  }
  
  public static void thirdStep() {
    for (int i = 0; i < 10; i++) {
      if (x[0][i] > 0 && x[1][i] > 0 && (x[0][i]+x[1][i]) == 9) { 
        for (int j = 0; j < 90; j=j+10) {
          if (board[i+j].compareTo(" X ") == 0 && board[i+j+10].compareTo(" . ") == 0) {
            int a = i+j+20;
            for (int z = 0; z < x[1][i]; z++) {
              board[a] = " X ";
              xComplete[i] = true;
              a = a + 10;
            }
          } 
          if (board[i+j].compareTo(" X ") == 0 && board[i+j-10].compareTo(" . ") == 0) {
            int a = i+j-20;
            for (int z = 0; z < x[1][i]; z++) {
              board[a] = " X ";
              xComplete[i] = true;
              a = a - 10;
            }
          }
        }
      }
    }
    
    
  }
  
  public static void validate() {
    //rows
    for (int i = 0; i < 10; i++) {
      int count = 0;
      for (int j = 0; j < 10; j++) {
        if (board[(i*10)+j].compareTo(" X ") == 0) {
          count++;
        }
      }
      if (count == (y[0][i] + y[1][i] + y[2][i])) {
        yComplete[i] = true;
      }
    }
    for (int i = 0; i < 10; i++) {
      int count = 0;
      for (int j = 0; j < 100; j=j+10) {
        if (board[i+j].compareTo(" X ") == 0) {
          count++;
        }
      }
      if (count == (x[0][i] + x[1][i] + x[2][i])) {
        xComplete[i] = true;
      }
    }
  }
  
  public static int[] sort (int x, int y, int z) {
    int [] a = new int [3];
    a[0] = x; a[0] = y; a[0] = z;
    int placeHolder = 0;
    for (int j = 0; j < (a.length-1); j++) {
      for (int i = 0; i < (a.length-1); i++) {
        if (a[i+1] < a[i]) {
          placeHolder = a[i];
          a[i] = a[i+1];
          a[i+1] = placeHolder;
        }
      }
    }
    return a;
  }
  
  public static void fillInTheBlank() { 
    boolean [][] columnCount = new boolean [3][10];  
    for (int i = 0; i < 10; i++) {
      if (yComplete[i] == true) {
        for (int j = 0; j < 3; j++) {
          columnCount[j][i] = true;
        }
      }
      else {
        for (int j = 0; j < 3; j++) {
          columnCount[j][i] = false;
        }
      } 
    }
    
    for (int q = 0; q < 10; q++){
      if (xComplete[q] == false) {
        for (int i = 0; i < 9; i++) {
          if (yComplete[i] == false && yComplete[i+1] == true) {
            int z = i;
            int count = 0;
            while (yComplete[z] == false && z > 0) {
              count++;
              z--;
            }
            count++;
            if (count == x[0][q] && columnCount[0][i] == false) {
              for (int j = (count-1); j > -1 ; j--) {
                board[q+ (j*10)] = " X ";
                columnCount[0][j] = true;
              }
            }
            else if (count == x[1][q] && columnCount[1][i] == false) {
              for (int j = (count-1); j > -1 ; j--) {
                board[q+ (j*10)] = " X ";
                columnCount[1][j] = true;
              }
            }
            else if (count == x[2][q] && columnCount[2][i] == false) {
              for (int j = (count-1); j > -1 ; j--) {
                board[q+ (j*10)] = " X ";
                columnCount[2][j] = true;
              }
            }
          }
        }
      }
    }
  }
  
  public static void lastStep() { 
    for (int i = 0; i < 10; i++) { //x
      for (int j = 0; j < 9; j++) { //y
        if (yComplete[j] == false) {
          if (board[(i*10)+j].compareTo(" . ") == 0 && board[(i*10)+j+1].compareTo(" X ") == 0) {
            int placeHolder = j;
            int count = 0;
            while (board[(i*10)+placeHolder].compareTo(" . ") == 0 && placeHolder > 0 && placeHolder < 10) {
              count ++;
              placeHolder --;
            }
            if (count == (y[2][j]+1) && count != 0) {
              for (int q = (j-1); q > -1; q--) {
                board[(i*10)+q] = " X ";
              }
            }
          }
          else if (board[(i*10)+j].compareTo(" X ") == 0 && board[(i*10)+j+1].compareTo(" . ") == 0) {
            int placeHolder = j+1;
            int count = 0;
            while (board[(i*10)+placeHolder].compareTo(" . ") == 0 && placeHolder > -1 && placeHolder < 10) {
              count ++;
              placeHolder ++;
            }
            if (count == (y[0][j]+1) && count != 0) {
              for (int q = (j+2); q < 10; q++) {
                board[(i*10)+q] = " X ";
              }
            }
          } 
        }
      }
    }
  }
}