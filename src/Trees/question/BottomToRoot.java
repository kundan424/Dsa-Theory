package Trees.question;

import java.util.*;

public class BottomToRoot extends test {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.pollFirst();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.addFirst(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.addFirst(currentNode.right);
                }

            }
            result.add( 0 , currentLevel);
        }
        return result;
    }
}
