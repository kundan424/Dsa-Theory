package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetProblem {
    public static void main(String[] args) {
//        skip("" , "absaba");
//        System.out.println(skip("" , " aaab"));

//        subset(" " , "abc");
//        System.out.println(subsetRet2("" , "abc" , new ArrayList<>()));

//        System.out.println(subsetAscii("" , "abc" , new ArrayList<>()));
        int [] arr = { 2, 1, 2};
//
//        ArrayList<ArrayList<Integer>> ans =  subsetOfArray(arr , 0 , new ArrayList<>());
//        System.out.println(ans);


            List<List<Integer>> ans = subsetOfDuplicate(arr);
        for ( List<Integer> list : ans ){
            System.out.println(list);
        }
    }



    static String skip( String  p , String up){
        if (up.isEmpty()){
            return p ;
        }
        if (up.charAt(0) != 'a'){
            return  skip(p + up.charAt(0), up.substring(1));
        }else {
            return skip(p , up.substring(1));
        }
    }

    static String skip( String up){
        if (up.isEmpty()){
            return " ";
        }
        String ans = "";
        if (up.charAt(0) != 'a'){
             ans = up.charAt(0) + skip( up.substring(1));
        }else {
            return skip( up.substring(1));
        }
        return ans;

    }
    static String skipApple( String up){
        if (up.isEmpty()){
            return " ";
        }
        String ans = "";
        if (up.startsWith("apple")){
            ans = skipApple(up.substring(5));
        }else {
            return up.charAt(0) + skipApple( up.substring(1));
        }
        return ans;
    }

    static String skipAppNOtApple( String up){
        if (up.isEmpty()){
            return " ";
        }
        String ans = "";
        if (up.startsWith("app") && !up.startsWith("apple")){
            ans = skipAppNOtApple(up.substring(3));
        }else {
        return up.charAt(0) + skipAppNOtApple( up.substring(1));
        }
        return ans;
    }

    static void subset( String p , String up){
        if ( up.isEmpty()){
            System.out.print(p + ",");
            return;
        }
         subset(p+ up.charAt(0) , up.substring(1));
        subset(p , up.substring(1));

    }

    static ArrayList<String> subsetRet(String p , String up){

        if ( up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

       char ch = up.charAt(0);
        ArrayList<String> left =  subsetRet( p + ch , up.substring(1));
        ArrayList<String> right =  subsetRet(p , up.substring(1));

        left.addAll(right);
        return left;
    }


    static ArrayList<String> subsetAscii(String p , String up ,  ArrayList<String> list){

        if ( up.isEmpty()){
            list.add(p);
            return list;

        }

        char ch = up.charAt(0);

        subsetAscii( p + ch , up.substring(1) , list);
        subsetAscii(p , up.substring(1 ) ,list);
        subsetAscii( p + (ch + 0) , up.substring(1 ), list);
        return list;
    }


// iteration method :::
    static List<List<Integer>> subsetOfArray (int [] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr ){
            int n = outer.size();
            for ( int i = 0 ; i < n; i++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetOfDuplicate(int [] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0 ;
        int end = 0 ;
        for (int i = 0 ; i < arr.length; i++){
            if (i > 0 &&  arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outer.size()- 1;
            int n = outer.size();

            for (int j = start; j < n; j++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
