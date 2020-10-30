package luxoft;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "BB", "CCC");

        Map<String, Integer> hashMap = list.stream().collect(Collectors
                .toMap(Function.identity(), String::length));

        for (String key : hashMap.keySet()) {
            System.out.println(" Key --> " + key + " Value --> ");
        }

    }


}

