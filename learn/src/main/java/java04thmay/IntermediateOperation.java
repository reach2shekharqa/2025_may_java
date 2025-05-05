package java04thmay;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperation {

    public static void main(String[] args) {

        Stream<Integer> streamOfIntegers = Stream.of(1001, 2300, 4400);

        Stream<Integer> streamOfEven = streamOfIntegers.filter(n -> n % 2 == 0);// Predicate

        System.out.println(streamOfEven.count());

        System.out.println(streamOfEven.collect(Collectors.toList()));//we can not operate internediate operarion on alredy used/closed stream.
    }

}
