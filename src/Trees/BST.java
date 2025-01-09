package Trees;

public class BST {
    private class Node{
         int value;
        private Node right;
        private Node left ;
        private int height;

        public int getValue() {
            return value;
        }
        public Node(int value) {
            this.value = value;
        }
    }

    public BST() {

    }
    private Node root;


    public int height(Node node){
        if (node == null){
            return -1;
        }
      return node.height;
    }

    public void  insert (int value){
     root = insert(value , root);
    }
    private Node insert (int value , Node node){
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value){
            node.left =  insert(value , node.left);
        }

        if ( value > node.value){
          node.right = insert(value , node.right);
        }

        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node;
    }

    public void  populate(int [] nums){
        for(int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted( int [] arr) {
        populateSorted(arr, 0, arr.length);
    }

    private void populateSorted( int [] nums , int start , int end){
        if (start >= end){
            return;
        }
        int mid = (start + end ) /2;
        this.insert(mid);
        populateSorted(nums, 0 , mid);
        populateSorted(nums, mid+1, end);
    }

    private boolean balanced ( Node node){
        if ( node == null){
            return true;
        }
        return Math.abs( height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
    display(this.root , " root node ");
    }
    private void  display( Node node , String details ){
        if ( node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left , " left child of " + node.value + " : ");
        display(node.right , " right child of " + node.value + " : ");
    }
}
