package Trees;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        Scanner scanner = new Scanner(System.in);
//        binaryTree.insert(scanner);
//        binaryTree.display();
//        binaryTree.preOrder();


        BST bst = new BST();
        int [] nums = { 20 , 13 , 8 , 15, 22 };
        bst.populate(nums);
        bst.display();
    }


}