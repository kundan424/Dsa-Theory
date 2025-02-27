package Trees.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelSuccessor extends test {


    public TreeNode findSuccessor(TreeNode root , int key){
        if ( root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();

            if ( currentNode.left != null){
                queue.offer(currentNode.left);
            }

            if ( currentNode.right != null){
                queue.offer(currentNode.right);
            }

            if ( key == currentNode.val){
                break;
        }
    }
        return queue.peek();
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
        int levelSize =  queue.size();

        for ( int i = 0 ; i < levelSize; i++){
            TreeNode currentNode = queue.poll();
            if (i ==  levelSize-1){
                result.add(currentNode.val);
            }
            if (currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null){
                queue.offer(currentNode.right);
            }
            }
        }
        return result;
    }
}
