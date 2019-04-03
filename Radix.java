import java.util.*;

public class Radix{
  // sort array in increasing order
  public static void radixsort(int[]data){
    // call helper method on array to sort elements, starting at the ones digit
    radixsort(data, 1);
  }

  // helper method takes in array and starting digits place
  public static void radixsort(int[] data, int digit){
    // initialize array of linked lists to hold 20 digits (-9 to 9, inclusive)
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    // number of digits in the largest number of the array
    // determines how many passes to sort the digits in the array
    int maxDigits = 1;

    // For the ones digit, loop through the array
    for (int i = 0; i < data.length; i++){
      // Find the number of digits in the element with the largest magnitude
      if (String.valueOf( Math.abs(data[i]) ).length() > maxDigits){
        maxDigits = String.valueOf( Math.abs(data[i]) ).length();
      }

      // If the current element is non-negative, add to the end of the appropriate bucket for the ones digit
      if (data[i] >= 0){

        buckets[10 + data[i]%10].addEnd( data[i] );

      }
      // If the current element is negative, add to the front of the appropriate bucket for the ones digit
      else{

        buckets[9 + data[i]%10].addFront(data[i]);

      }
    }

    // new merged linked list
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    // loop through buckets and merge non-empty lists in buckets to the merged list
    for (int i = 0; i < 20; i++){
      if (buckets[i].size() > 0){
        merged.extend( buckets[i] );
      }
    }

    // Subtract from the number of passes (digits) and update the digits place to check
    maxDigits--;
    digit *= 10;

    // While there are still digits to sort
    while (maxDigits > 0){
      for(Iterator<Integer> iter = merged.iterator(); iter.hasNext() ; ){
          Integer number = iter.next();
          System.out.println(number);
          /* check if the removed element is positive or negative, then add to the end of the appropriate bucket
          for the value of the current digits place of the element*/
          if (number >= 0){
            buckets[10 + ( (number / digit) % 10)].addEnd( number );
          }
          else{
            buckets[9 + ( (number / digit) % 10)].addEnd(number);
          }
      }
      merged.clear();

      // Loop through buckets and merge non-empty lists to the merged linked list
      for (int i = 0; i < 20; i++){
        if (buckets[i].size() > 0){
          merged.extend( buckets[i] );
        }
      }

      // update digit counter and digits place variable
      maxDigits--;
      digit *= 10;
    }
    // At the end, copy values over from merged linked list to the original array
    for (int i = 0; i < data.length; i++){
      data[i] = merged.removeFront();
    }
  }

}
