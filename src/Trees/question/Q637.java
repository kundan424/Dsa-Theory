package Trees.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637 {

    public  class TreeNode {
    int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if ( root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int sum = 0 ;
            for ( int i = 0 ; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
            }
            result.add((double) sum);
        }

        return result;
    }


}
