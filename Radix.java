import java.util.*;

public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 1);
  }

  public static void radixsort(int[] data, int digit){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int maxDigits = 1;

    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

  //  System.out.println("bucket size: "+buckets.length);

    for (int i = 0; i < data.length; i++){
      if (String.valueOf( Math.abs(data[i]) ).length() > maxDigits){
        maxDigits = String.valueOf( Math.abs(data[i]) ).length();
      }
      if (data[i] >= 0){
      //  System.out.println(data[i]%10);
        buckets[10 + data[i]%10].addEnd( data[i] );
      //  System.out.println(buckets[ 10 + data[i]%10 ]);
      }
      else{
    //    System.out.println(data[i]%10);
        buckets[9 + data[i]%10].addFront(data[i]);
    //    System.out.println(buckets[9 + data[i]%10]);
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
    maxDigits--;
    digit *= 10;
    while (maxDigits > 0){
      System.out.println("digit: "+digit);
      while (merged.size() > 0){
        int removed = merged.removeFront();
    //    System.out.println("removed element: "+removed);
        if (removed >= 0){
        //  System.out.println((removed / digit) % 10);
          buckets[10 + ( (removed / digit) % 10)].addEnd( removed );
      //    System.out.println(buckets[ 10 +((removed / digit) % 10)]);
        }
        else{
        //  System.out.println( (removed / digit) % 10);
          buckets[9 + ( (removed / digit) % 10)].addFront(removed);
        //  System.out.println(buckets[9 + ( (removed / 10) % 10)]);
        }

      }

      for (int i = 0; i < 20; i++){
        if (buckets[i].size() > 0){
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
