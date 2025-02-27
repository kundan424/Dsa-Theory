package recursion;// sorting by recursion

import java.util.Arrays;

//
public class Recursion {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        inPlaceMergeSort(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
//        First("", "absbNANS");pt
//        System.out.println(reverse("abc"));
//        System.out.println(invert("101"));
//        invert("" , "101");
//        System.out.println(invert("" , "101"));
//        System.out.println(findKthBit(4, ));
//        System.out.println(isParenthesisBalanced("[{()
//        }]"));
///        printTriangle(arr);
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//       int [] ans = mergeSort(arr);
//        System.out.println(Arrays.toString(ans));
//        bubble(arr);
//        System.out.println(Arrays.toString(arr));

//        revTriangle(5 , 0 );
//       bubbleSort(arr, arr.length-1 , 0 );
//        System.out.println(Arrays.toString(arr));
//
//        selection(arr, arr.length, 0 , 0);
//        System.out.println(Arrays.toString(arr));
//        Triangle(3 , 0 );
//        System.out.println('A');
    }

    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void revTriangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (r > c) {
            System.out.print("*");
            revTriangle(r, c + 1);
        } else {
            System.out.println();
            revTriangle(r - 1, 0);
        }
    }

    static void Triangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (r > c) {
            Triangle(r, c + 1);
            System.out.print("*");
        } else {
            Triangle(r - 1, 0);
            System.out.println();
        }
    }


    static void bubbleSort(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }

        if (r > c) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c + 1];
                arr[c + 1] = arr[c];
                arr[c] = temp;
            }
            bubbleSort(arr, r, c + 1);

        } else {
            bubbleSort(arr, r - 1, 0);
        }
    }

    static void selection(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }

        if (r > c) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c + 1, c);
            } else {
                selection(arr, r, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            selection(arr, r - 1, 0, 0);
        }
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);

    }

    static int[] merge(int[] first, int[] second) {

        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
//         copy the remaining array

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }


    static void inPlaceMergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (e + s) / 2;
        inPlaceMergeSort(arr, s, mid);
        inPlaceMergeSort(arr, mid, e);

        merge(arr, s, mid, e);

    }

    static void merge(int[] arr, int s, int m, int e) {

        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
//         copy the remaining array

        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }

    static void quickSort(int[] arr, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int start = low;
        int end = hi;
        int mid = (start + end) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, hi);
    }

    //     po
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        return helperFun(n, 4);
    }

    static boolean helperFun(int num, double product) {
        if (num < 1 || num < product) {
            return false;
        }
        if (num > product) {
            return helperFun(num, product * 4);
        }
        return true;
    }

    static void printTriangle(int[] x) {
        helper(x, x.length - 1);
    }

    static void helper(int[] arr, int r) {
        if (r == 0) {
            return;
        }

        for (int i = 0; i < r; i++) {
            arr[i] = arr[i] + arr[i + 1];
        }
        helper(arr, r - 1);
        System.out.println(Arrays.toString(Arrays.copyOf(arr, r)));
    }

    static void First(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch >= 65 && ch <= 90) {
            System.out.println(p + ch);
            return;
        } else {
            First(p, up.substring(1));
        }
    }

    static boolean isParenthesisBalanced(String s) {
        // code here
        return helper("", s);
    }

    static boolean helper(String p, String up) {
        if (p.isEmpty() && up.isEmpty()) {
            return true;
        }
        char ch1 = up.charAt(0);

        if (ch1 == '[' || ch1 == '{' || ch1 == '(') {
            return helper(p + ch1, up.substring(1));
        }

        if (!p.isEmpty()) {
            char ch2 = p.charAt(p.length() - 1);
            if ((ch2 == '(' && ch1 == ')' || ch2 == '{' && ch1 == '}' || ch2 == '[' && ch1 == ']'))
                return helper(p.substring(0, p.length() - 1), up.substring(1));
        }
        return false;
    }

    class Solution {
        // Function to check if brackets are balanced or not.
        static boolean isParenthesisBalanced(String s) {
            // code here
            return helper("", s);
        }

        static boolean helper(String p, String up) {
            if (p.isEmpty() && up.isEmpty()) {
                return true;
            }

            if (up.isEmpty()) {
                return false; // Input string is empty but stack (p) is not
            }

            char ch1 = up.charAt(0);

            if (ch1 == '[' || ch1 == '{' || ch1 == '(') {
                return helper(p + ch1, up.substring(1));
            }

            if (!p.isEmpty()) {
                char ch2 = p.charAt(p.length() - 1);
                if ((ch2 == '(' && ch1 == ')' || ch2 == '{' && ch1 == '}' || ch2 == '[' && ch1 == ']'))
                    return helper(p.substring(0, p.length() - 1), up.substring(1));
            }
            return false;
        }
    }

    public char findKthBit(int n, int k) {
        return helper(4 , 11);
    }

    static char helper(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int length = (1 << n) - 1;
        int m = length / 2 + 1;
        if (k == m) {
            return '1';
        } else if (k < m) {
            return helper(n - 1, k);
        } else {
            int mirroredIndex = length - k + 1;
            char mirroredBit = helper(n - 1, mirroredIndex);
            if (mirroredBit == '0') {
                return '1';
            } else {
                return '0';
            }
        }
    }
}