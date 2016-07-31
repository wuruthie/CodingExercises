public class LinkedList{
  public class Node{
    int data;
    Node next = null;
  }

  public Node(int d){
    this.data = d;
  }

  public Node deleteNode(int data, Node head){
    Node n = head;
    if(n.data == d){
      return head.next;
    }

    while(n.next != null){
      if(n.next.data == d){
        n.next = n.next.next;
        return head;
      }
      n = n.next; //iteratre
    }
    return head;
  }
  public void removeDupe(Node head){
    HashTable countDupes = new HashTable();
    while(head.next != null){
      if(countDupes.get(head.next.data) == 1){
        deleteNode(head);
      } else {
        countDupes.put(head.data, 1);
      }
      head = head.next; //iterate
    }
  }
}
