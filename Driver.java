public class Driver{
  public static void main(String[] args){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    for (int i = 0; i < 20; i++){
      test.add(i);
      System.out.println(test.size()+": ");
      System.out.println(test);
    }
  }
}