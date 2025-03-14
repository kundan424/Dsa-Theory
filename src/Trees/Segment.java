package Trees;

public class Segment {
    public static void main(String[] args) {
        int [] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        Segment tree = new Segment(arr);
//        tree.display(new Node(0 , arr.length));
//        tree.display();
        System.out.println(tree.query(2 , 4));
    }
    private static class Node {

        int data;
        int startInterval;
        int endInterval;
        int value;
        Node right;
        Node left;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    private  Node root;

    public  Segment (int [] arr){
        this.root = constructTree( arr , 0 , arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end){
        if ( start == end){
            Node leaf = new Node(start ,end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start , end);
        int mid = start + ( end - start)/ 2;

        node.left = constructTree(arr , start , mid);
        node.right = constructTree(arr , mid+1 , end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public  void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";
        if ( node.left != null){
            str = str + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval +  "] and data: " + node.left.data + " => ";

        }else {
            str = str + " no left child ," ;
        }
//         for current node
        str = str + "Interval = [" + node.startInterval + "-" + node.endInterval +  "] and data: " + node.data + " <=";

        if ( node.right != null){
            str = str + "Interval = [" + node.right.startInterval + "-" + node.right.endInterval +  "] and data: " + node.right.data + "\n";

        }else {
            str = str + " no right child";
        }

        if( node.left != null){
            display(node.left);
        }

        if ( node.right != null){
            display(node.right);
        }
        System.out.println(str);
    }

    public int query( int qsi , int qei){
        return query( this.root , qsi , qei);
    }

   private int query(Node node , int qsi , int qei){
        if (node.startInterval <= qsi && node.endInterval >= qei){
            return node.data;
        }else if ( node.startInterval > qei || node.endInterval < qsi){
//             completely outside
            return 0;
        }else {
            return this.query(node.left , qsi , qei ) + this.query(node.right , qsi , qei);
        }
   }

//    update
    public  void  update(int index , int value){
        this.root.data = update(this.root , index , value);
    }

    private  int update(Node node , int index ,int value){
    if ( index >= node.startInterval && index <= node.endInterval){
        if (index == node.startInterval && index == node.endInterval){
            node.data = value;
            return node.data;
        }else {
            int leftAns = update(node.left , index , value);
            int rightAns = update(node.right ,index , value);
            node.data = leftAns + rightAns;
            return node.data;
        }
    }
    return node.data;
    }
}
