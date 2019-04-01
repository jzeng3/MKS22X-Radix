import java.util.*;

public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 10);
  }
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data, int digit){
    @SuppressWarnings("unchecked")
    List< MyLinkedList<Integer> > buckets = new ArrayList<>(20);

    for (int i = 0; i < 20; i++){
      buckets.add( new MyLinkedList<Integer>() );
    }
    System.out.println("bucket size:"+buckets.size());

    for (int i = 0; i < data.length; i++){
      if (data[i]%digit > 0){
        System.out.println(data[i]%digit);
        buckets.get(10 + data[i]%digit).add(data[i]);
      System.out.println(buckets.get( 10 + data[i]%digit));
      }
      else{
        System.out.println(data[i]%digit);
      }
    }



  }
}
