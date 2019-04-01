public class Radix{
  public static void radixsort(int[]data){
    radixsort(data, 10);
  }

  public static void radixsort(int[] data, int digit){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = (MyLinkedList<Integer>[])new Object[20];

    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    for (int i = 0; i < data.length; i++){
      if (data[i]%digit > 0){
        buckets[10 + data[i]%digit].add(data[i]%digit);
        System.out.println(buckets[10 + data[i]%digit]);
      }
    }


  }
}
