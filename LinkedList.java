import java.util.HashMap;
public class LinkedList{
  public class Node{
    int data;
    Node next = null;

    public Node(int d){
      this.data = d;
    }
  }

  public Node deleteNode(int data, Node head){
    Node n = head;
    if(n.data == data){
      return head.next;
    }

    while(n.next != null){
      if(n.next.data == data){
        n.next = n.next.next;
        return head;
      }
      n = n.next; //iteratre
    }
    return head;
  }
  public void removeDupe(Node head){
    HashMap countDupes = new HashMap();
    while(head.next != null){
      if(countDupes.get(head.next.data) != null){
        deleteNode(head.next.data,head);
      } else {
        countDupes.put(head.data, 1);
      }
      head = head.next; //iterate
    }
  }

  //implement removing duplicates without a buffer
  public void removeDupeNoBuffer(Node head){
    if(head == null){
      return;
    }
    Node p1 = head;
    Node p2 = head.next;

    while(p1.next != null){
      while(p2.next != null){
        if(p2.next.data == p1.data){
          deleteNode(p2.next.data, p2);
        }
        p2 = p2.next;
      }
      p1 = p1.next;
    }

  }

  //Implement an algorithm to find the Kth to last element of a singly linked List
  public Node findKth(Node head, int k){
    if(k <= 0){ return null;}

    Node p1 = head;
    Node p2 = head;

    //move second pointer to the kth elem of the list.
    for(int i = 0; i < k-1; i++){
      if(p2 == null){
        return null;
      }
      p2 = p2.next;
    }
    //iterate the both pointers at same pace until the second one reaches the end of the list
    while(p2.next != null){
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
}

public void findKthResursive(Node head, int k){
  if(head == null){ return; }
  int i = findKthRecursive(head.next, k) + 1;
  if(i == k){
    System.out.println(head.data);
  }
}

//Write code to partition a linked list around a value x,
//such that all nodes less than x come before alt nodes greater than or equal to x.
public Node partitionLinkedList(Node head, int x){
Node startLess = null;
Node endLess = null;
Node startGreater = null;
Node endGreater = null;

while(head != null){
  if(head.data < x){
    if(startLess == null){
      startLess = head;
      endLess = startLess;
    } else {
      endLess.next = head;
      endLess = head;
    }
  } else {
    if(startGreater == null){
      startGreater = head;
      endGreater = startGreater;
    } else {
      endGreater.next = head;
      endGreater = head;
    }
  }
  head = head.next; //ierate
}
 //catch in case there are no elements that are less
 if(startLess == null){
   return startGreater;
 }
//merge the two lists
endLess.next = startGreater;
return startLess;
}

//Implement an algorithm to
//delete a node in the middle of a singly linked list,
//given only access to that node.
public boolean deleteMiddleNode(Node delete){
  if(delete == null || delete.next == null){
    return false;
  }
  Node next = delete.next;
  delete.data = next.data;
  delete.next = next.next;
  return true;
}

//You have two numbers represented by a linked list, where each node contains a singledigit.
//Thedigitsarestoredinreverseorder,suchthatthe 1'sdigitisat thehead of the list.
//Write a function that adds the two numbers and returns the sum as a linked list.



}
