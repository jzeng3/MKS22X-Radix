public class Driver{
  public static void main(String[] args){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    // testing add
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
   System.out.println(listB);
  }
}
