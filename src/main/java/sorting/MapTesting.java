package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTesting {

    public static void main(String[] args) {
        List<String> collect = Stream.of(Arrays.asList(new ArrayList()), 2, 3).map(String::valueOf).collect(
                Collectors.toList());

        System.out.println(collect);

    }


}
