package javastream05thmay;

import java.util.stream.Stream;

public class lazy {

    public static void main(String[] args) {

        Stream<Integer> streamofInt = Stream.of(5, 6, 7, 8, 99);

        streamofInt
                .filter(n -> n > 6)
                .peek(n-> System.out.println(n))  
                .count();

                
                

      
    }

}
