package Trees.question;

import com.sun.source.tree.Tree;

import java.util.*;

public class test {
    public test() {
    }
  public class TreeNode {
      TreeNode left;
      TreeNode right;
      int val;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    public TreeNode root;

    public  List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize =  queue.size();
            List<Integer> currentLevel= new ArrayList<>(levelSize);
            for ( int i = 0 ; i < levelSize; i++){
              TreeNode currentNode = queue.poll();
              currentLevel.add(currentNode.val);

              if ( currentNode.left != null){
                  queue.offer(currentNode.left);
              }

              if ( currentNode.right != null){
                  queue.offer(currentNode.right);
              }
            }
            result.add(currentLevel);
        }
    return result;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return  true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){

            TreeNode left =  queue.poll();
            TreeNode right =  queue.poll();

            if ( right == null && left == null){
                continue;
            }
            if ( left == null || right == null ){
                return false;
            }

            if (right.val  == left.val){
                return true;
            }
           queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    int diameter = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    int height(TreeNode node){
        if (node == null){
            return 0 ;
        }
        int leftheight = height(node.left);
        int rightheight = height(node.right);

        int dia  =  leftheight + rightheight + 1 ;
             diameter = Math.max(dia , diameter);

             return Math.max(leftheight , rightheight) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
        }
    }
