import java.util.*;

public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 10);
  }

  public static void radixsort(int[] data, int digit){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];

    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    System.out.println("bucket size:"+buckets.length);

    for (int i = 0; i < data.length; i++){
      if (data[i]%digit > 0){
        System.out.println(data[i]%digit);
        buckets[10 + data[i]%digit].add(data[i]);
        System.out.println(buckets[ 10 + data[i]%digit ]);
      }
      else{
        System.out.println(data[i]%digit);
        buckets[9 - data[i]%digit].add(data[i]);
        System.out.println(buckets[9 - data[i]%digit]);
      }
    }
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for (int i = 0; i < 20; i++){
      if (buckets[i].size() > 0){
        merged.extend( buckets[i] );
      }
    }
    System.out.println( merged );
  }
}
