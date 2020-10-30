package clearwater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rotation {

    public static void main(String[] args) {
        int sum = 0;
        List<Integer> height = new ArrayList<Integer>();
        List<Integer> height2 = new ArrayList<Integer>();
        height.add(1);
        height.add(1);
        height.add(3);
        height.add(4);
        height.add(1);
        for (Integer i : height) {
            height2.add(i);
        }
        System.out.println(" original heith " + height.toString());
        Collections.sort(height2, Comparator.naturalOrder());
        System.out.println("  heith2 " + height2.toString());
//        for( int i = 0 ;i< height ;i++){
////            sum
////        }
    }


}
