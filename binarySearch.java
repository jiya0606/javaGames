import java.util.*;
public class binarySearch {
  public static void main(String[]args) {
    int[] sampleArray =  {3, 6, 9, 11, 12, 15, 16, 20};
    
    System.out.println(bsearch(sampleArray, 12));

  }


  public static boolean bsearch(int [] a, int s) {
    ArrayList<Integer> x = new ArrayList<Integer>();
    boolean q = false;
    for (int i = 0; i < a.length; i++) {
      x.add(a[i]);
    }
    
    boolean run = true;

    while (run == true) {
      int low = 0;
      int middle = ((x.size()/2)-1);
      int high = (x.size()-1);
     
      if (x.size() <= 3) {
        for (int i = 0; i < x.size(); i++) {
          if (x.get(i) == s) {
            q = true;
            run = false;  
          }
          else {
            q = false;
            run = false;
          }
        }
      }
      else if (s < x.get(middle)) {
        for (int z = middle; z < (high+1); z ++) {
          x.remove(middle);
        }
      } 
      else if (s > x.get(middle)) {
        for (int z = low; z < (middle+1); z ++) {
          x.remove(low);
        }
      }
      else if (s == x.get(0)) {
        q = true;
        run = false;
      }
      else if (s == x.get(middle)) {
        q = true;
        run = false;
      }
    }
    return q;
  }
}