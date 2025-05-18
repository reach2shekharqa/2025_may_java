package javastream05thmay;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindDistinct {

    public static void main(String[] args) {

        // Supplier<Stream<String>> supplierList = ()->
        // Stream.of("shekhar","rahul","sss","shekhar");

        // System.out.println( supplierList.get()
        // .distinct()
        // .collect(Collectors.toList()));

        // System.out.println( supplierList.get()
        // .sorted()
        // .collect(Collectors.toList()));

        Integer[] arr = { 11, 4, 6, 8, 9 };

        System.out.println(Arrays.stream(arr)
                .sorted((a, b) -> b.compareTo(a))

                .collect(Collectors.toList()));

    }

}
