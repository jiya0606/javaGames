/*Jiya Gupta
 * Period 2*/

import java.util.*;
import java.io.*;

public class compiler {
  public static ArrayList<Integer> intVar = new ArrayList<Integer>(); //list of integer variable values
  public static ArrayList<String> intName = new ArrayList<String>(); // list of integer variable names
  public static ArrayList<String> StringVar = new ArrayList<String>(); // list of string variable values
  public static ArrayList<String> StringName = new ArrayList<String>(); // list of string variable names
  public static Scanner pencil = new Scanner(System.in);
  
  public static void main(String[]args) {
    //reads the text files
    try { 
      File myObj = new File("compilerSampleCode.txt");
      Scanner myReader = new Scanner (myObj); 
      while (myReader.hasNextLine()) { 
        String data = myReader.nextLine();
        //runs each of the objects on each line in the text file
        illegalArgument(data);
        checkInt(data);
        checkString(data);
        getInt(data);
        getString(data);
        math(data);
        userInput(data);
        ifStatement(data);
        loop(data);
        print(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) { // if the file is not found
      System.out.println("an error occurred.");
      e.printStackTrace();
    }
  }
  
  //checks to see if each line has known command, otherwise throws an illegal argument exception error
  public static void illegalArgument(String a) {
    if (a.substring(0,15).equals("declare number:")) {
    }
    else if (a.substring(0,14).equals("declare words:")) {
    }
    else if (a.substring(0, 12).equals("get number: ")) {
    }
    else if (a.substring(0, 11).compareTo("get words: ") == 0) {
    }
    else if (a.substring(0, 5).compareTo("add: ") == 0) {
    }
    else if (a.substring(0, 10).compareTo("multiply: ") == 0) {
    }
    else if (a.substring(0, 8).compareTo("divide: ") == 0) {
    }
    else if (a.substring(0, 10).compareTo("subtract: ") == 0) {
    }
    else if (a.substring(0, 11).compareTo("remainder: ") == 0) {
    }
    else if (a.substring(0, 32).compareTo("user input: word, instructions: ") == 0) {
    } 
    else if (a.substring(0, 34).compareTo("user input: number, instructions: ") == 0) {
    }
    else if (a.substring(0, 2).compareTo("if") == 0) {
    }
    else if (a.substring(0, 7).compareTo("repeat ") == 0) {
    }
    else if (a.substring(0,7).compareTo("print: ") == 0) {
    }
    else {
      throw new IllegalArgumentException("error");
    }
   }
  
  //will check if an integer variable was created and saves it in the intVar and intName arraylist
  public static void checkInt(String a) {
    if (a.substring(0,15).equals("declare number:")) {
      System.out.println("checkInt: "+a);
      int counter = 0; 
      for (int i = 16; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      if (counter < 16 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      int returnnum = numberConversion(a, 16, counter);
      intVar.add(returnnum);
      intName.add(a.substring(17+counter, a.length()));
    }
  }
      
  //because lines are inputted as strings, this method converts them into numbers    
  public static int numberConversion(String a, int x, int counter) { 
    int returnnum = 0;      
      for (int i = x; i < counter; i++) {
        if (a.substring(i, i+1).equals("0")) {
          returnnum = (returnnum*10);
        }
        if (a.substring(i, i+1).equals("1")) {
          returnnum = (returnnum*10) + 1;
        }
        if (a.substring(i, i+1).equals("2")) {
          returnnum = (returnnum*10) + 2;
        }
        if (a.substring(i, i+1).equals("3")) {
          returnnum = (returnnum*10) + 3;
        }
        if (a.substring(i, i+1).equals("4")) {
          returnnum = (returnnum*10) + 4;
        }
        if (a.substring(i, i+1).equals("5")) {
          returnnum = (returnnum*10) + 5;
        }
        if (a.substring(i, i+1).equals("6")) {
          returnnum = (returnnum*10) + 6;
        }
        if (a.substring(i, i+1).equals("7")) {
          returnnum = (returnnum*10) + 7;
        }
        if (a.substring(i, i+1).equals("8")) {
          returnnum = (returnnum*10) + 8;
        }
        if (a.substring(i, i+1).equals("9")) {
          returnnum = (returnnum*10) + 9;
        }
      }
      return returnnum;
    }
    
  //checks if a string variable was declared and stores it in the StringVar and StringName Arraylist
  public static void checkString(String a) {
    int counter = 0; 
    if (a.substring(0,14).equals("declare words:")) {
      for (int i = 15; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      if (counter < 15 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      StringVar.add(a.substring(15, counter));
      StringName.add(a.substring(17+counter, a.length()));
    }
  }
  
  //returns value of the integer variable when the name is called
  public static int getInt(String a) {
    if (a.substring(0, 12).compareTo("get number: ") == 0) {
      for (int i = 0; i < intVar.size(); i++){
        if (a.substring(12, a.length()).compareTo(intName.get(i)) == 0) {
          return intVar.get(i);
        }
       }
     }
   return -1;
   }
  
  //returns value of the String variable when the name is called
  public static String getString(String a) {
    if (a.substring(0, 11).compareTo("get words: ") == 0) {
      for (int i = 0; i < StringVar.size(); i++){
        if (a.substring(11, a.length()).compareTo(StringName.get(i)) == 0) {
          return StringVar.get(i);
        }
      }
    }
    return "error: this variable does not exist";
  }
  
  //addition, subtraction, multiplication, division, modulus 
  public static int math(String a) {
    int counter = 0;
    if (a.substring(0, 5).compareTo("add: ") == 0) {
      for (int i = 6; i < a.length(); i++) {
        if (a.substring(i,  i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      if (counter < 6 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      int firstNum = numberConversion(a, 5, counter);
      int secondNum =  numberConversion(a, counter+2, a.length());
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(5, counter).compareTo(intName.get(i)) == 0) {
          firstNum = intVar.get(i);
        }
        if (a.substring(counter+2, a.length()).compareTo(intName.get(i)) == 0) {
          secondNum = intVar.get(i);
        }
      }
      return firstNum + secondNum;
    }
    if (a.substring(0, 10).compareTo("multiply: ") == 0) {
      for (int i = 11; i < a.length(); i++) {
        if (a.substring(i,  i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      int firstNum = numberConversion(a, 10, counter);
      int secondNum =  numberConversion(a, counter+2, a.length());
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(10, counter).compareTo(intName.get(i)) == 0) {
          firstNum = intVar.get(i);
        }
        if (a.substring(counter+2, a.length()).compareTo(intName.get(i)) == 0) {
          secondNum = intVar.get(i);
        }
      }
      return firstNum * secondNum;
    }
    if (a.substring(0, 10).compareTo("subtract: ") == 0) {
      for (int i = 11; i < a.length(); i++) {
        if (a.substring(i,  i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      int firstNum = numberConversion(a, 10, counter);
      int secondNum =  numberConversion(a, counter+2, a.length());
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(10, counter).compareTo(intName.get(i)) == 0) {
          firstNum = intVar.get(i);
        }
        if (a.substring(counter+2, a.length()).compareTo(intName.get(i)) == 0) {
          secondNum = intVar.get(i);
        }
      }
      return firstNum - secondNum;
    }
    if (a.substring(0, 8).compareTo("divide: ") == 0) {
      for (int i = 9; i < a.length(); i++) {
        if (a.substring(i,  i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      int firstNum = numberConversion(a, 8, counter);
      int secondNum =  numberConversion(a, counter+2, a.length());
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(8, counter).compareTo(intName.get(i)) == 0) {
          firstNum = intVar.get(i);
        }
        if (a.substring(counter+2, a.length()).compareTo(intName.get(i)) == 0) {
          secondNum = intVar.get(i);
        }
      }
      return firstNum / secondNum;
    }
    if (a.substring(0, 11).compareTo("remainder: ") == 0) {
      for (int i = 12; i < a.length(); i++) {
        if (a.substring(i,  i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      int firstNum = numberConversion(a, 11, counter);
      int secondNum =  numberConversion(a, counter+2, a.length());
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(11, counter).compareTo(intName.get(i)) == 0) {
          firstNum = intVar.get(i);
        }
        if (a.substring(counter+2, a.length()).compareTo(intName.get(i)) == 0) {
          secondNum = intVar.get(i);
        }
      }
      return firstNum % secondNum;
    }
    return -1;
  }
  
  //asks the user for input and stores the input as a varibale
  public static void userInput(String a) {
    int counter = 0;
    if (a.substring(0, 32).compareTo("user input: word, instructions: ") == 0){
      for (int i = 31; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      if (counter < 31 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      System.out.println(a.substring(32, counter));
      StringVar.add(pencil.next());
      StringName.add(a.substring(counter + 11, a.length()-1));
    }
    if (a.substring(0, 34).compareTo("user input: number, instructions: ") == 0){
      for (int i = 33; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(",") == 0) {
          counter = i;
        }
      }
      if (counter < 33 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      System.out.println(a.substring(34, counter));
      intVar.add(pencil.nextInt());
      intName.add(a.substring(counter + 11, a.length()));  
    }
  }
  
  //creates an if statment 
  public static void ifStatement(String a) {
    int counter = 0;
    int counter1 = 0;
    int counter2 = 0;
    if (a.substring(0, 27).compareTo("if statement with numbers (") == 0){
      for (int i = 27; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo("=") == 0) {
          counter = i;
        }
      }
      if (counter < 27 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      for (int i = counter+1; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(")") == 0) {
          counter1 = i;
        }
      }
      if (counter1 == 0) {
        throw new IllegalArgumentException("error");
      }
      int firstVarValue = numberConversion(a, 27,counter-1);
      int secondVarValue = numberConversion(a, counter+2,counter1);
      for (int i = 0; i < intVar.size(); i++) {
        if (a.substring(27,counter-1).compareTo(intName.get(i)) == 0) {
          firstVarValue = intVar.get(i);
        }
        if (a.substring(counter+2,counter1).compareTo(intName.get(i)) == 0) {
          secondVarValue = intVar.get(i);
        }
      }
      if (firstVarValue == secondVarValue) {
        if (a.substring(counter1+5, counter1+6).compareTo("a") == 0 || a.substring(counter1+5, counter1+6).compareTo("m") == 0 || a.substring(counter1+5, counter1+6).compareTo("d") == 0 || a.substring(counter1+5, counter1+6).compareTo("s") == 0 || a.substring(counter1+5, counter1+6).compareTo("r") == 0) {
          System.out.println(math(a.substring(counter1+5, a.length()-2))); 
        }
        print(a.substring(counter1+5, a.length()-2));
      } 
    }
    if (a.substring(0, 25).compareTo("if statement with words (") == 0){
      for (int i = 25; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo("=") == 0) {
          counter = i;
        }
      }
      if (counter < 25 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      for (int i = counter+1; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo(")") == 0) {
          counter1 = i;
        }
      }
      if (counter1 == 0) {
        throw new IllegalArgumentException("error");
      }
      String firstStringValue = a.substring(25,counter-1);
      String secondStringValue = a.substring(counter+2,counter1);
      for (int i = 0; i < StringVar.size(); i++) {
        if (a.substring(25,counter-1).compareTo(StringName.get(i)) == 0) {
          firstStringValue = StringVar.get(i);
        }
        if (a.substring(counter+2,counter1).compareTo(StringName.get(i)) == 0) {
          secondStringValue = StringVar.get(i);         
        }
      }
      if (firstStringValue.compareTo(secondStringValue) == 0) {
        if (a.substring(counter1+5, counter1+6).compareTo("a") == 0 || a.substring(counter1+5, counter1+6).compareTo("m") == 0 || a.substring(counter1+5, counter1+6).compareTo("d") == 0 || a.substring(counter1+5, counter1+6).compareTo("s") == 0 || a.substring(counter1+5, counter1+6).compareTo("r") == 0) {
          System.out.println(math(a.substring(counter1+5, a.length()-2))); 
        }
        print(a.substring(counter1+5, a.length()-2));
      } 
    }
  }

  //loop repeats a certain statement a given number of times (this can also be in the form of a variable)
  public static void loop(String a) {
    int counter = 0;
    int counter1 = 0;
    int repeat = numberConversion(a, 7, 8);
    if (a.substring(0, 7).compareTo("repeat ") == 0) {
      for (int i = 6; i < a.length(); i++){
        if (a.substring(i, i+1).compareTo("[") == 0) {
          counter = i;
        }
      }
      if (counter < 6 && counter > 0) {
        throw new IllegalArgumentException("error");
      }
      for (int i = 0; i < intName.size(); i++) {
        if (a.substring(7, counter-6).compareTo(intName.get(i)) == 0) {
          repeat = intVar.get(i);
        }
      }
        
      for (int i = 0; i < repeat; i ++){
        if (a.substring(counter+2, counter+3).compareTo("a") == 0 || a.substring(counter+2, counter+3).compareTo("m") == 0 || a.substring(counter+2, counter+3).compareTo("d") == 0 || a.substring(counter+2, counter+3).compareTo("s") == 0 || a.substring(counter+2, counter+3).compareTo("r") == 0) {
          System.out.println(math(a.substring(counter+2, a.length()-2)));
        }
        print(a.substring(counter+2, a.length()));
      }
    }
  }
  
  //prints anything (including variable values) 
  public static void print(String a) {
    int counter = 0;
    String printThis = a.substring(7, a.length());
    if (a.substring(0,7).compareTo("print: ") == 0) {
      for (int i = 0; i < StringVar.size(); i++){
        if (a.substring(7, a.length()).compareTo(StringName.get(i)) == 0) {
          counter = i;
        }
      }
      if (counter > 0) {
        printThis = StringVar.get(counter);
      }
      System.out.println(printThis);
    }
  }
}
