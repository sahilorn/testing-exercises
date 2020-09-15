import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUpdate {

    public static void main(String[] args) {
        final int[] integerArray = new int[]{1, 2};
        System.out.println(Arrays.toString(integerArray));
        integerArray[0] = 5;
        System.out.println(Arrays.toString(integerArray));

        List<List<String>> names = Arrays.asList(Arrays.asList("Sahil", "Bhatia"), Arrays.asList("Sameer", "Lala"),
                Arrays.asList("Poonam", "Baan"));

        int value = 0;
        List<String> s1 = names.stream().filter(name -> {
            System.out.println("name -->" + name.toString());
            return !name.get(0).startsWith("S");
        }).map(s -> s.get(0)).collect(Collectors.toList());
        System.out.println(s1.toString());
    }


}
