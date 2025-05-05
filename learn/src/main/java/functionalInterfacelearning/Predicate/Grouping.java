package functionalInterfacelearning.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grouping {

    // Using Java Streams, group the list of strings by their lengths and collect
    // the result in a Map<Integer, List<String>>.

    // java
    // Copy
    // Edit
    // List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Butch");

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Butch");

        System.out.println(names.stream().collect(Collectors.groupingBy(s->s.length())));

    }

}
