import java.util.*;
import java.io.*;

public class MyLinkedList<E>{
  Node<E> start;
  Node<E> end;
  int length;

// makes an empty list
  public MyLinkedList(){
    length = 0;
    start = null;
    end = null;
  }
// size of list
  public int size(){
    return length;
  }
// set size to specified
  public void setSize(int num){
    length = num;
  }

  // reset list to empty state
  public void clear(){
    length = 0;
    start = null;
    end = null;
  }
// adding to the end of the list
  public boolean add(E value){
    // create new Node<E> with data as value
    Node<E> adding = new Node<E>(null, value, null);
    // if list is empty, start and end point to adding
      if (size() == 0){
        start = adding;
        end = adding;
      }
    else{
      // end points to adding, which becomes the end of the list
      // adding points to previous end
      adding.setPrev(end);
      end.setNext(adding);
      end = adding;
    }
    length++;
    //System.out.println("start: "+start);
    //System.out.println("end: "+end);
    return true;
  }

  // remove the first element from the list and return the element
  public E removeFront(){
    if (size() == 0){
      throw new IndexOutOfBoundsException("");
    }
    Node<E> current = start;
    E oldValue = current.getData();
      if (size() == 1){
        start = null;
        end = null;
      }
      else{
      start = current.next();
      //System.out.println("set start to "+start.debug());
      start.setPrev(null);
      }
    length--;
    return oldValue;
  }

  // connect the OTHER list to the end of THIS list, then reset other list size to 0
   public void extend (MyLinkedList<E> other){
     if (this.size() == 0){
       //System.out.println("You're in the first if statement");
       length += other.size();
       Node<E> temp = new Node<E>(null, null, null);
       //System.out.println(temp.debug());
       start = temp;
       end = temp;
       start.setNext(other.start);
       start = other.start;
       end.setNext(other.end);
       end = other.end;

     }
     else{
     this.end.setNext(other.start);
     length += other.size();
     this.end = other.end;
     }
     other.setSize(0);
     other.start = null;
     other.end = null;
   }

// loop through list and return Node<E> at specified index
  private Node<E> getNthNode(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index cannot be " + index);
    }
    else{
    Node<E> current = start;
    for (int i = 0; i < index; i++){
      current = current.next();
    }
    return current;
    }
  }

// print value of every Node<E> in the list
  public String toString(){
    String list = "";
    Node<E> current = start;
    list+= "[";
    for (int i = 0; i < size(); i++){
      list += current.toString();
      if (i != size()-1){
        list+= ", ";
      }
      current = current.next();
    }
    list+= "]";
    return list;
  }
// toString for elements in reverse, tests prev() linking
  public String toStringReverse(){
    String list = "";
    Node<E> current = end;
    list+= "[";
    for (int i = size()-1; i >= 0; i--){
      list += current.toString();
      if (i != 0){
        list+= ", ";
      }
      current = current.prev();
    }
    list+= "]";
    return list;
  }

// toString from left to right that shows previous node, current value, and next node, used for debugging
  public String toStringDebug(){
    String list = "";
    Node<E> current = start;
    list+= "[";
    for (int i = 0; i < size(); i++){
      list+= current.debug();
      if (i != size()-1){
        list+= ", ";
      }
      current = current.next();
    }
    list+= "]";
    return list;
  }

}

class Node<E>{
  E data;
  Node<E> prev;
  Node<E> next;

  public Node(Node<E> _prev, E _data, Node<E> _next){
    data = _data;
    setPrev(_prev);
    setNext(_next);
  }

  public Node<E> next(){
    return next;
  }

  public Node<E> prev(){
    return prev;
  }

  public void setPrev(Node<E> _prev){
    prev = _prev;
  }
  public void setNext(Node<E> _next){
    next = _next;
  }

  public E getData(){
    return data;
  }

  public void setData(E _data){
    data = _data;
  }
  public String toString(){
    return ""+data;
  }

  public String debug(){
    String NodeStr = "";
    if (prev() == null){
      NodeStr += "(" + "null" + ") ";
    }
    else{NodeStr += "(" + prev().getData() + ") ";}
    NodeStr += getData();
    if (next() == null){
      NodeStr += " (" + "null" + ")";
    }
    else{NodeStr += " (" + next().getData() + ")";
  }
  return NodeStr;
  }

}
