package clearwater;

import java.util.Arrays;
import java.util.Comparator;

public class Compares {

    public static void main(String[] args) {
        String[] cities = {"Bangalore","Pune","San Francisco","New York"};
        MySort ms = new MySort();
        Arrays.sort(cities,ms);
        for(String city :cities){
            System.out.println("cities " + city);
        }

        System.out.println(Arrays.binarySearch(cities, "New York"));
    }

    static class MySort implements Comparator<String>{

//        @Override
//        public int compare(String o1, String o2) {
//            return o2.compareTo(o1);
//        }

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

}

