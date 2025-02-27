package recursion;

import java.util.ArrayList;
import java.util.List;

public class numpad {

    public static void letterCombinations(String digits) {
        helper( " ", digits );
    }

    static void helper(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) ('a' + i);
            helper(p + ch, up.substring(1));
        }
    }

    public static List<String> letterCombinations2(String digits) {
        return   helper2("" , digits);
    }
    static List<String> helper2( String p , String  up){
        if ( up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll( helper2(p + ch, up.substring(1)));
        }
        return ans;
    }


    static List<String> letterCombinations3( String p , String  up){
        if ( up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll( helper2(p + ch, up.substring(1)));
        }
        return ans;
    }
}
