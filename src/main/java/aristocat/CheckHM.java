package aristocat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckHM {

    private static class A {


        @Override
        public int hashCode() {
            return super.hashCode();
            //return 1;
        }

        @Override
        public boolean equals(Object obj) {
            //return super.equals(obj);
            return true;
        }
    }

    public static void main(String[] args){
        Map<A,Integer> hm = new HashMap<>();
        A a1 = new A();
        hm.put(a1,1);
        hm.put(new A(),2);
        int i = 12345;
        List<Integer> collect = Arrays.stream(String.valueOf(i).split("")).map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(a1.hashCode());
        System.out.println(new A().hashCode());
        System.out.println(hm.size());
        System.out.println(hm.get(new A()));
    }

}
