import java.util.*;
public class mergeSort {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(7);
        numbers.add(3);
        numbers.add(9);
        numbers.add(12);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);
        numbers.add(-1);
        numbers.add(5);

        System.out.println(sort(numbers));
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> a) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        if (a.size() == 1) {
            return a;
        }

        else {
            int half = a.size() / 2;
            for (int i = 0; i < half; i++) {
                b.add(a.get(i));
            }
            b = sort(b);
            for (int j = half; j < a.size(); j++) {
                c.add(a.get(j));

            }
            c = sort(c);
            int bSize = b.size();
            int cSize = c.size();

            while (d.size() < bSize+ cSize) {
                if(b.size()>0){
                    if(c.size()>0){
                        if (c.get(0) <b.get(0)){
                            d.add(c.get(0));
                            c.remove(0);
                        }
                        else{
                            d.add(b.get(0));
                            b.remove(0);
                        }
                    }
                    else{
                        for(int i = 0; i<b.size();i++){
                            d.add(b.get(0));
                            b.remove(0);
                        }
                    }
                }
                else{
                    for(int i = 0; i<c.size();i++){
                        d.add(c.get(0));
                        c.remove(0);
                    }
                }
            }
        }
        return d;
    }
}