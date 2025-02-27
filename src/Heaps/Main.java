package Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(43);
        heap.insert(1);
        heap.insert(10);
        heap.insert(2);
        heap.insert(5);

        System.out.println(heap.remove());
//
//        ArrayList<Integer> list = new ArrayList<>();  **  No need to manually initialize a new ArrayList<> before calling heapSort().
        ArrayList list = heap.heapSort();
        System.out.println(list);

//        list = heap.heapSort();
//        System.out.println(list);


    }
}
