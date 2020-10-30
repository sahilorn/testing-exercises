package java8functions.streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCollectionOperations {

    public static void main(String[] args) {

        Person person1 = new Person(Sex.MALE, "sahil", "bhatia");
        Person person2 = new Person(Sex.FEMALE, "pr", "bhatia");
        Person person3 = new Person(Sex.FEMALE, "pnm", "bhatia");

        List<Person> personList = List.of(person1, person2, person3);

        final List<Person> collect = personList.stream().filter(person -> person.getGender() == Sex.FEMALE)
                .collect(Collectors.toList());
        System.out.println("Collect -->" + collect);
        Map<Sex, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getGender));

        for (Sex sexName : collect1.keySet()) {
            System.out.println(sexName.toString() + collect1.get(sexName).toString());
        }
        Map<Sex, List<String>> collect2 = personList.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getfName, Collectors.toList())));

        for (Sex sexName : collect2.keySet()) {
            System.out.println(sexName.toString() + collect2.get(sexName).toString());
        }

        List<Integer> collect3 = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).boxed()
                .collect(Collectors.toList());

        int sum = Stream.of(25, 35).mapToInt(Integer::intValue).sum();

        IntStream.rangeClosed(1,10).boxed().forEachOrdered(System.out::println);

    }
}
