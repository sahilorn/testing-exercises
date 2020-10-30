package java8functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("sahil");
        list.add("bhatia");

        List<List<String>> collect = list.stream().map(s -> {
            List<String> ss = new ArrayList<String>();
            ss.add(s);
            return ss;
        }).collect(Collectors.toList());
        for (List<String> s : collect) {
            System.out.println("values ->" + s.toString());
        }
        System.out.println(collect.toString());
        List<String> collect1 = collect.stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(collect1.toString());
    }

}
