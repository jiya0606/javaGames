/* Jiya Gupta 
 * Period 2 
 * September 25, 2021 
 * */

import java.util.*;

public class FryLau {
  public static void main(String[] args) {
    
    Scanner data = new Scanner(System.in);
    
    System.out.println("Enter in your data set"); 

      int firstNumber;
      System.out.println("first number:");
      firstNumber = data.nextInt();
      data.nextLine(); 
      
     int secondNumber;
     System.out.println("second number:");
     secondNumber = data.nextInt();
     data.nextLine(); 
      
     int thirdNumber;
     System.out.println("third number:");
     thirdNumber = data.nextInt();
     data.nextLine(); 
     
     int fourthNumber;
     System.out.println("fourth number:");
     fourthNumber = data.nextInt();
     data.nextLine(); 
     
     int fifthNumber;
     System.out.println("fifth number:");
     fifthNumber = data.nextInt();
     data.nextLine(); 
     
     int sixthNumber;
     System.out.println("sixth number:");
     sixthNumber = data.nextInt();
     data.nextLine(); 
     
     int seventhNumber;
     System.out.println("seventh number:");
     seventhNumber = data.nextInt();
     data.nextLine(); 
     
     mean (firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber, seventhNumber);
     
     median (firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber, seventhNumber);
     
     mode (firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber, seventhNumber);

  }
  
  
 //methods start here!
  

//method for calculating mean
  static void mean (int a1, int b1, int c1, int d1, int e1, int f1, int g1) {
    double a = (double)a1;
    double b = (double)b1;
    double c = (double)c1;
    double d = (double)d1;
    double e = (double)e1;
    double f = (double)f1;
    double g = (double)g1;   
      double sum = a + b + c + d + e + f + g;
      double meanCalculation = sum / 7;
      System.out.println("Mean: " + meanCalculation);
}
  
//method for calculating median 
  static void median (int a, int b, int c, int d, int e, int f, int g) {
    int temp;
    
    //first round of comparison 
    if (b < a) {
       temp = a; a = b; b = temp;
    }
    
    if (c < a) {
       temp = a; a = c; c = temp;
    }

    if (d < a) {
       temp = a; a = d; d = temp;
    }

    if (e < a) {
       temp = a; a = e; e = temp;
    }

    if (f < a) {
       temp = a; a = f; f = temp;
    }

    if (g < a) {
       temp = a; a = g; g = temp;
    }

    //second round of comparison 
    if (c < b) {
       temp = b; b = c; c = temp;
    }
    if (d < b) {
       temp = b; b = d; d = temp;
    }
    if (e < b) {
       temp = b; b = e; e = temp;
    }
    if (f < b) {
       temp = b; b = f; f = temp;
    }
    if (g < b) {
       temp = b; b = g; g = temp;
    }

    //third round of comparison 
    if (d < c) {
       temp = c; c = d; d = temp;
    }
    if (e < c) {
       temp = c; c = e; e = temp;
    }

    if (f < c) {
       temp = c; c = f; f = temp;
    }
    if (g < c) {
       temp = c; c = g; g = temp;
    }
    
     //fourth round of comparison    
    if (e < d) {
       temp = d; d = e; e = temp;
    }

    if (f < d) {
       temp = d; d = f; f = temp;
    }
    if (g < d) {
       temp = d; d = g; g = temp;
    }
    System.out.println("Median: " + d);

}

//method for calculating mode 
  static void mode (int a, int b, int c, int d, int e, int f, int g) { 
    
    int firstCount = 1; 
    if (a == b)  {
      firstCount++;
    }
    if (a == c)  {
      firstCount++;
    }
    if (a == d)  {
      firstCount++;
    }
    if (a == e)  {
      firstCount++;
    }
    if (a == f)  {
      firstCount++;
    }
    if (a == g)  {
      firstCount++;
    }
    
    int secondCount = 1; 
    if (b == c)  {
      secondCount++;
    }
    if (b == d)  {
      secondCount++;
    }
    if (b == e)  {
      secondCount++;
    }
    if (b == f)  {
      secondCount++;
    }
    if (b == g)  {
      secondCount++;
    }
    
    int thirdCount = 1; 
    if (c == d)  {
      thirdCount++;
    }
    if (c == e)  {
      thirdCount++;
    }
    if (c == f)  {
      thirdCount++;
    }
    if (c == g)  {
      thirdCount++;
    }
    
    int fourthCount = 1; 
    if (d == e)  {
      fourthCount++;
    }
    if (d == f)  {
      fourthCount++;
    }
    if (d == g)  {
      fourthCount++;
    }  
    
    int fifthCount = 1; 
    if (e == f)  {
      fifthCount++;
    }
    if (e == g)  {
      fifthCount++;
    } 
    
    int sixthCount = 1; 
    if (f == g)  {
      sixthCount++;
    }  
    
    if (firstCount >= secondCount && firstCount > thirdCount && firstCount >= fourthCount && firstCount >= fifthCount && firstCount >= sixthCount) {
      System.out.println("Mode: " + a);
    } 
    if (secondCount > firstCount && secondCount >= thirdCount && secondCount >= fourthCount && secondCount >= fifthCount && secondCount >= sixthCount) {
      System.out.println("Mode: " + b);
    }
    if (thirdCount >= firstCount && thirdCount > secondCount && thirdCount >= fourthCount && thirdCount >= fifthCount && thirdCount >= sixthCount) {
      System.out.println("Mode: " + c);  
    }
    if (fourthCount > firstCount && fourthCount > secondCount && fourthCount > thirdCount && fourthCount >= fifthCount && fourthCount >= sixthCount) {
      System.out.println("Mode: " + d); 
    }
    if (fifthCount > firstCount && fifthCount >secondCount && fifthCount > thirdCount && fifthCount > fourthCount && fifthCount >= fifthCount) {
      System.out.println("Mode: " + e);   
    }
    if (sixthCount > firstCount && sixthCount > secondCount && sixthCount > thirdCount && sixthCount > fourthCount && sixthCount > fifthCount){
      System.out.println("Mode: " + f);   
    }
    if (firstCount == secondCount && firstCount == thirdCount && firstCount == fourthCount && firstCount == fifthCount && firstCount == sixthCount) {
      System.out.println("No Mode:(");
    } 

  }
  
}