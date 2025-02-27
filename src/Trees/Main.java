package Trees;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        Scanner scanner = new Scanner(System.in);
//        binaryTree.insert(scanner);
//        binaryTree.display();
//        binaryTree.preOrder();


       AVL tree = new AVL();
       for (int i= 0 ; i < 10; i++){
           tree.insert(i);
       }
        System.out.println(tree.height());
    }


}