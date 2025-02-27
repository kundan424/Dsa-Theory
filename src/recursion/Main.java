package recursion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(rev(123));
//        System.out.println(NoOfZero(1040502));
    int [] arr = {1, 2, 3, 6 ,7 , 8};

        System.out.println(rotatedBinarySearch(arr , 0 , arr.length-1 , 2));
//        System.out.println(sorted(arr));
//
//        System.out.println(linearSearch(arr, 0 ,3 ));
//        System.out.println(linearSearchFromLast(arr, arr.length-1, 3 ));

//       linearSearchAllIndex(arr , 0 , 3);
//        System.out.println(List);
//        ArrayList<Integer> list = findAllIndex(arr , 0 , 3);
//        System.out.println(list);

//        System.out.println(binarySearch(arr , 0 , arr.length-1 , 2));
    }


    //    1
    static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n);
        print(n - 1);
    }

    //    2
    static void printRev(int n) {
        if (n == 0) {
            return;
        }
        printRev(n - 1);
        System.out.print(n + " ");

    }

// 3

    static int product(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * product(n - 1);
    }

// Q : 4

    static int sum(int num) {
        if (num == 0) {
            return 0;
        }
        int reminder = num % 10;
        return reminder + sum(num / 10);
    }

//     Q : 5
static int ProDigits(int num) {
    if (num%10 == num) {
        return num;
    }
    int reminder = num % 10;
    return reminder * ProDigits(num / 10);
}

// Q:5

    static int rev( int n){
        int digits = (int) (Math.log10(n))+ 1;
       return rev(n, digits);
    }

    static int rev(int num , int digits){
        if ( num % 10 == num){
            return num;
        }
        int rem = num % 10 ;
        return  rem* (int) (Math.pow(10, digits -1)) + rev(num/10 , digits -1);
    }

//     Q : 6

    static boolean pallin (int n ){
        return n == rev(n);
    }

//     Q:7

    static int NoOfZero(int n){
       return helper( n , 0 );
    }

    static int helper( int n , int count){
        if ( n == 0 ){
            return count;
        }
        if ( n % 10 == 0 ){
            count += 1;
        }
        return helper(n/10 , count );
    }
//     this function will not return while coming out of the stack because at the end of base execution we are returning
//    the count value;

//     Q : 8
    static boolean sorted ( int [] arr){
      return helper2(arr, 0);
    }

    static boolean helper2(int [] arr , int index){
        if (index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && helper2(arr , index+1);
    }

//  Q : 9

static int linearSearch(int [] arr , int index , int target){
        if (index == arr.length){
            return -1;
        }
        if ( target == arr[index]){
            return index;
        }
        return linearSearch(arr, index+ 1 , target);
}

    static int linearSearchFromLast(int [] arr , int index , int target){
        if (index == -1){
            return -1;
        }
        if ( target == arr[index]){
            return index;
        }
        return linearSearchFromLast(arr, index - 1 , target);
    }

     static ArrayList<Integer> List = new ArrayList<>();
    static void linearSearchAllIndex(int [] arr , int index , int target){
        if (index == arr.length){
            return;
        }
        if ( target == arr[index]){
            List.add(index);
        }
         linearSearchAllIndex(arr, index + 1 , target);
    }

    static ArrayList<Integer> findAllIndex(int [] arr , int index , int target , ArrayList<Integer> list){
        if (index == arr.length){
            return list;
        }
        if ( target == arr[index]){
            list.add(index);
        }
        return findAllIndex(arr, index + 1 , target , list);
    }

    static ArrayList<Integer> findAllIndex( int [] arr , int index , int target ){
        ArrayList<Integer> list = new ArrayList<>();

        if ( index == arr.length){
            return list;
        }
        if ( target == arr[index]){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr , index+1 , target);

        list.addAll(ansFromBelowCalls);

        return list;
    }

//     binary search

    static int binarySearch( int [] arr , int start  , int end , int target){
        if (start > end){
            return -1;
        }
        int mid = start + ( end - start)/2;

        if (  target == arr[mid]){
            return mid;
       }

        if ( target > arr[mid]){
            return binarySearch(arr , mid+1  , end , target);
        }else {
            return binarySearch(arr , start , mid-1, target);
        }
    }

//     rotated binary search

    static int rotatedBinarySearch( int [] arr , int start , int end , int target){
        if ( start > end){
         return -1;
     }
        int mid = start + ( end - start)/2;

        if ( arr[mid] == target){
         return mid;
     }

     if ( arr[start] <= arr[mid]){
         if ( arr[start] <= target && arr[mid] > target ){
           return   rotatedBinarySearch(arr , start , mid-1 , target);
         }else {
            return rotatedBinarySearch(arr , mid+1 , end , target);
         }
     }else {
     if ( target >= arr[mid] && target < arr[end]){
          return    rotatedBinarySearch(arr , mid+1 , end , target);
         }
     }
        return   rotatedBinarySearch(arr , start , mid-1 , target);
    }



}