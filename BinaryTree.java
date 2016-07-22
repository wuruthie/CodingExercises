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

  public Node insertNode(Node node, int val){
    if(root == null){
       root = new Node(val);
       return root;

    if(root.value < val){
      root.left = insertNode(root.left,val);
    } else if(root.value > val){
      root.right = insertNode(root.right, val);
    }
    return root;
  }

  public void insert(int val){
    root = insertNode(root, val);
  }

  public boolean isLeaf(Node node){
    return(node.left == null && node.right == null);
  }

}
