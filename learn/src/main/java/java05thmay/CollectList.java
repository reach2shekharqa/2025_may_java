package java05thmay;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectList {

    public static void main(String[] args) {



        Supplier<Stream<String>> streamSupplier = ()-> Stream.of("hello", "shekhar", "water", "he");

        System.out.println(streamSupplier.get()
        .filter(n -> n.length() >= 9)
        .collect(Collectors.toList()));

        //transform each element

        System.out.println(streamSupplier.get()
        .map(s->s.toUpperCase())
        .collect(Collectors.toList()));



    }

}
