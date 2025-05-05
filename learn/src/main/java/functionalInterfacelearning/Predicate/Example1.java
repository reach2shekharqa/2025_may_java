package functionalInterfacelearning.Predicate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {

    // Question:
    // Given a list of integers, write a one-liner using streams to return a list of
    // the squares of only the even numbers, sorted in descending order.
    // java
    // Copy
    // Edit
    // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {

        List<Integer> lisOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> modifiedList = lisOfIntegers
                .stream()
                .filter(a -> a % 2 == 0)
                .map(a -> a * a)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

                

        // Collections.sort(modifiedList, (a,b)->a.compareTo(b));
        System.out.println(modifiedList);

    }

}
 