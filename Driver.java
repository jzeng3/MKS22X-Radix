import java.util.*;
public class Driver{
  public static void main(String[] args){
/*    int[] testing = {0,-17,5,8,-332,4,-12,-32,-15,-25,-167,-1000};
    int[] testing1 = {0,-17,5,8,-332,4,-12,-32,-15,-25,-167,-1000};
    System.out.println(Arrays.toString(testing));
    Radix.radixsort(testing);
    System.out.println(Arrays.toString(testing));
    Arrays.sort(testing1);
    System.out.println(Arrays.toString(testing1));
    System.out.println(Arrays.toString(testing).equals(Arrays.toString(testing1)));*/
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for (int i = 0; i < 20; i++){
      merged.addFront(i);
      System.out.println(merged);
    }

    for(Iterator<Integer> iter = merged.iterator(); iter.hasNext() ; ){
        Integer number = iter.next();
        System.out.println(number);
        /* check if the removed element is positive or negative, then add to the end of the appropriate bucket
        for the value of the current digits place of the element*/
    }

  /*  // testing add
    for (int i = 0; i < 20; i++){
      test.add(i);
      System.out.println(test.size()+": ");
      System.out.println(test);
    }

    // testing remove and exception
    for (int i = 0; i < 20; i++){
      test.removeFront();
      System.out.println(test.size()+": ");
      System.out.println(test);
    }
    try{
      test.removeFront();
      System.out.println(test.size()+": ");
      System.out.println(test);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("index out of bounds exception caught");
    }

    // testing clear
    test.clear();
    System.out.println(test.size()+": ");
    System.out.println(test);
    for (int i = 0; i < 20; i++){
      test.add(i);
      System.out.println(test.size()+": ");
      System.out.println(test);
    }
    test.clear();
    System.out.println(test.size()+": ");
    System.out.println(test);

    // testing extend
   MyLinkedList<Integer> listA = new MyLinkedList<Integer>();
   for (int i = 0; i < 15; i++){
     listA.add(i);
   }
   System.out.println(listA);
   MyLinkedList<Integer> listB = new MyLinkedList<Integer>();
   for (int i = 0; i <= 15; i++){
     listB.add(15+i);
   }
   System.out.println(listB);

   listA.extend(listB);
   System.out.println(listA);
   System.out.println(listB);

   listB.extend(listA);
   System.out.println(listA);
   System.out.println(listB);*/
  }
}
