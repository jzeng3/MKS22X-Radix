import java.util.*;

public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 1);
  }

  public static void radixsort(int[] data, int digit){
    // initialize array of linked lists to hold 20 digits (-9 to 9, inclusive)
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    // number of digits in the largest number of the array
    int maxDigits = 1;

    for (int i = 0; i < data.length; i++){
      if (String.valueOf( Math.abs(data[i]) ).length() > maxDigits){
        maxDigits = String.valueOf( Math.abs(data[i]) ).length();
      }
      if (data[i] >= 0){
        System.out.println("This element is non-negative");
        buckets[10 + data[i]%10].addEnd( data[i] );
        System.out.println(buckets[ 10 + data[i]%10 ]);
      }
      else{
          System.out.println("This element is negative");
    //    System.out.println(data[i]%10);
        buckets[9 + data[i]%10].addFront(data[i]);
        System.out.println(buckets[9 + data[i]%10]);
      }
    }
    // new merged linked list
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for (int i = 0; i < 20; i++){
      if (buckets[i].size() > 0){
        merged.extend( buckets[i] );
      //  System.out.println( buckets[i] );
      }
    }
    System.out.println("Merged, with digit 1: "+merged);
    maxDigits--;
    digit *= 10;
    while (maxDigits > 0){
      System.out.println("digit: "+digit);
      while (merged.size() > 0){
        int removed = merged.removeFront();
    //    System.out.println("removed element: "+removed);
        if (removed >= 0){
          System.out.println("This element is non-negative");
        //  System.out.println((removed / digit) % 10);
          buckets[10 + ( (removed / digit) % 10)].addEnd( removed );
      //    System.out.println(buckets[ 10 +((removed / digit) % 10)]);
        }
        else{
          int index = 9 + ( (removed / digit) % 10);
              System.out.println("This element is negative");


        //  System.out.println( (removed / digit) % 10);
          buckets[9 + ( (removed / digit) % 10)].addEnd(removed);
        //  System.out.println(buckets[9 + ( (removed / 10) % 10)]);
          System.out.println("bucket "+index+": "+buckets[index]);
        }

      }

      for (int i = 0; i < 20; i++){
        if (buckets[i].size() > 0){
          System.out.println("bucket "+i+": "+buckets[i]);
          merged.extend( buckets[i] );
      //    System.out.println( buckets[i] );
        }
      }
      System.out.println("merged, should be sorted by digit: "+merged);
      maxDigits--;
      digit *= 10;
    }
  }

}
