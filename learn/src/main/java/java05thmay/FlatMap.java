package java05thmay;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        
        Supplier<Stream<List<String>>> streamOfListofListString = ()-> Stream.of(
            Arrays.asList("rtrtrt"),
            Arrays.asList("shekhar"), 
            Arrays.asList("uiyuiyuiy"));


            System.out.println(streamOfListofListString.get()
            .flatMap(n->n.stream())
            .collect(java.util.stream.Collectors.joining(", ")));
    }
    
}
