package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    public static void main(String[] args) {
//        permutations("" , "abc");
//        System.out.println(permutationsInList("" , "abc"));
//        System.out.println(permutationsCount("" , "abc"));
//        letterCombinations("23")

    }

    static void permutations ( String p , String up){
        if ( up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for ( int i = 0 ; i < p.length()+ 1; i++){
            String f = p.substring(0 , i );
            String s = p.substring(i , p.length());
            permutations(f + ch +s , up.substring(1));
        }

    }


    static ArrayList<String> permutationsInList(String p , String up ){

        if ( up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for ( int i = 0 ; i < p.length()+ 1; i++){
            String f = p.substring(0 , i );
            String s = p.substring(i);
        ans.addAll(permutationsInList(f + ch +s , up.substring(1)));
        }
    return ans;
    }

    static int  permutationsCount ( String p , String up){
        int count = 0 ;
        if ( up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        for ( int i = 0 ; i < p.length()+ 1; i++){
            String f = p.substring(0 , i );
            String s = p.substring(i , p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

}

