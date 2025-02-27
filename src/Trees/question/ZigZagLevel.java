package Trees.question;

import Trees.question.test;

import java.util.*;

class Solution extends test {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (flag) {
                    currentLevel.add(0, currentNode.val);
                } else {
                    currentLevel.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            flag = !flag;
            result.add(currentLevel);
        }
        return result;
    }

//     using Deque
public List<List<Integer>> Zigzag(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean  reverse = false;
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>(levelSize);
        for (int i = 0; i < levelSize; i++) {
            if (!reverse){
                TreeNode currentNode = queue.pollFirst();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
            }else {
                TreeNode currentNode = queue.pollLast();
                currentLevel.add(currentNode.val);

                if (currentNode.right != null) {
                    queue.addFirst(currentNode.right);
                }

                if (currentNode.left != null) {
                    queue.addFirst(currentNode.left);
                }
            }

        }
        reverse = !reverse;
        result.add(currentLevel);
    }
    return result;
}

}