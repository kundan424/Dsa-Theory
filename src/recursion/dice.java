package recursion;

import java.util.ArrayList;
import java.util.List;

public class dice {
    public static void main(String[] args) {
//    dice("" , 4);
        System.out.println(diceFace("" , 8 , 6));
    }


    static void dice( String p , int target){
        if ( target == 0 ){
            System.out.println(p);
            return;
        }
        for ( int i = 1 ; i <= 6 && i <= target ; i++ ){
            dice(p + i , target - i);
        }
    }

    static List<String> diceArr(String p , int target){
        if ( target == 0 ){
        List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for ( int i = 1 ; i <= 6 && i <= target ; i++ ){
            ans.addAll(diceArr(p + i , target - i)) ;
        }

        return ans;
    }

    static List<String> diceFace(String p , int target , int face){
        if ( target == 0 ){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for ( int i = 1 ; i <= face && i <= target ; i++ ){
            ans.addAll(diceFace(p + i , target - i , face)) ;
        }
        return ans;
    }
}
