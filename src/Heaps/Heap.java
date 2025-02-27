package Heaps;

import java.util.ArrayList;

public class Heap <T extends Comparable<T>>{

    private ArrayList<T> list;

    public  Heap(){
        list = new ArrayList<>();
    }
    private void  swap (int first , int second){
        T temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }

    private int parent (int index){
        return (index - 1) / 2;
    }

    private  int left (int index){
        return index * 2 + 1;
    }

    private int right (int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap (int index){
        if ( index == 0 ){
            return;
        }
        int p = parent(index);
        if ( list.get(index).compareTo(list.get(p)) < 0 ){
            swap(index , p);
            upHeap(p);
        }
    }

    public T remove () throws  Exception {
         if (list.isEmpty()){
             throw  new Exception("can't remove items from an empty heap");
         }
         T temp = list.getFirst();
         T last = list.removeLast();
         if ( !list.isEmpty()){
             list.set(0 , last);
             downHeap(0);
         }
         return  temp;
    }

    private void downHeap( int index){
        if ( index == list.size()-1){
            return;
        }

        int min = index;
        int left = left(index);
        int right = right(index);
        if ( left < list.size() && list.get(min).compareTo(list.get(left)) > 0 ){
//            swap(min , left);
            min = left;

        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0 ){
//            swap(min , right);
            min = right;
        }

        if (min != index){
            swap(min ,index);
            downHeap(min);
        }
    }

    public  ArrayList<T> heapSort() throws  Exception {
        if (list.isEmpty()){
            throw new Exception("can't remove from empty heap");
        }
        ArrayList<T> data = new ArrayList<>();
        while ( !list.isEmpty()){
            data.add(this.remove()); // Ensures 'remove()' of Heap class is called
//            🎯 Why Use this.remove()?
//this.remove() explicitly refers to the remove() method of the current instance (the heap class).
        }
        return data;
    }
}

