package java04thmay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLearn {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(4);
        listOfNumbers.add(342);
        listOfNumbers.add(543);
        listOfNumbers.add(74);
        int count = 0;
        for (Integer n : listOfNumbers) {

            if (n < 20) {
                count++;
            }
        }
        System.out.println("count of numbers are :" + count);

        System.out.println("==========using lamda==========");

        long countOf = listOfNumbers.stream().count();
        System.out.println("normal count: " + countOf);

        long countOfStream = listOfNumbers.stream().filter(n -> n < 20).count();
        System.out.println("using stream  :" + countOfStream);

        List<Integer> listOgEvenNos = listOfNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println("list of even numbers ONLY" + listOgEvenNos);

    }

}
