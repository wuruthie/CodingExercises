public class BinaryTree{
  class Node{
    private int data;
    Node left;
    Node right;
    public Node(int value){
      data = value;
      left = right = null;
    }
  }

  Node root;

  public BinaryTree(){
    root = null;
  }

  public Node addNode(Node node, int val){
    if(node == null){
       node = new Node(val);
     } else {
        if(node.data < val){
          node.right = addNode(node.right,val);
        } else if(node.data > val){
          node.left = addNode(node.left, val);
        }
      }
      return node;
    }

  public void add(int val){
    root = addNode(root, val);
  }

  public boolean isLeaf(Node node){
    return(node.left == null && node.right == null);
  }

  public void preOrderTraversal(Node node){
    if(node == null){
      return;
    }else{
      visit(node);
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public void inOrderTraversal(Node node){
    if(node == null){
      return;
    }else{
      preOrderTraversal(node.left);
      visit(node);
      preOrderTraversal(node.right);
    }

  public void postOrderTraversal(Node node){
    if(node == null){
      return;
    }else{
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
      visit(node);
    }
  }


  public void visit(Node node){
    System.out.print(node.data + " ");
  }



  public static void main(String[] args) {
    BinaryTree myTree = new BinaryTree();

    myTree.add(10);
    myTree.add(3);
    myTree.add(20);
    myTree.add(5);
    myTree.add(30);
    myTree.add(7);

    myTree.preOrderTraversal(myTree.root);
  }
}
