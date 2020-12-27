import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testtt {

    public static void main(String[] args) {

        String[] str = {"7","4","5","6"};

        final Integer reduce = Arrays.stream(str).map(Integer::valueOf).reduce(0, Integer::sum);


        String[] strings= {"ab","bc","cd"};

        List<String> strList = List.of("ab","bc","cd").stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(strList.toString());
    }
}
