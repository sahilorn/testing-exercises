package java8functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysToList {

    public static void main(String[] args) {

        String[] str = {"A", "B", "C"};

        stringArrayToArrayList(str);
        stringArrayToList2(str);
        // if u want to collect to array list then
        ArrayList<String> list1 = Stream.of(str).collect(Collectors.toCollection(ArrayList::new));
        System.out.print("list1 -->" + list1);
        System.out.println();

        String[] arr = Stream.of(str).toArray(String[]::new);
        System.out.print(" arr -->"+arr);
        System.out.println();

        /*list1.stream().collect(
                Collectors.toMap(x -> x, countFrequencies(list1,x));
        )*/
        Map<String,Integer> frequency = new HashMap<>();
        frequency.put("sahil",1);
        frequency.put("sameer",2);

        frequency.forEach((k,v) ->{
            System.out.println("Key -->"+k+ " value -->"+v);
        });

        Iterator<Map.Entry<String,Integer>> itr = frequency.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    private static void stringArrayToList2(String[] str) {
        List<String> list2 = Stream.of(str).collect(Collectors.toList());
        System.out.print("list2 -->" + list2);
        System.out.println();
    }

    private static void stringArrayToArrayList(String[] str) {
        List<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.print("list -->" + list);
        System.out.println();
    }

}
