import java.util.*;

public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 10);
  }

  public static void radixsort(int[] data, int digit){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    maxDigits(data);
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    System.out.println("bucket size: "+buckets.length);

    for (int i = 0; i < data.length; i++){
      if (data[i]%digit > 0){
        System.out.println(data[i]%digit);
        buckets[10 + data[i]%digit].addEnd( data[i] );
        System.out.println(buckets[ 10 + data[i]%digit ]);
      }
      else{
        System.out.println(data[i]%digit);
        buckets[9 + data[i]%digit].addFront(data[i]);
        System.out.println(buckets[9 - data[i]%digit]);
      }
    }
    // new merged linked list
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for (int i = 0; i < 20; i++){
      if (buckets[i].size() > 0){
        merged.extend( buckets[i] );
        System.out.println( buckets[i] );
      }
    }

  }

  public static int maxDigits(int[] data){
    int[] copy = new int[data.length];
    for (int i = 0; i < data.length; i++){
      copy[i] = data[i];
    }
    int max = 0;
    Arrays.sort(copy);
    max = Math.max( Math.abs(copy[0]), Math.abs(copy[copy.length - 1]));
    int digits = String.valueOf( max ).length();
    System.out.println("digits: "+digits);
    return digits;
  }
}
