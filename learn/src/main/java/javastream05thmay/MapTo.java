package javastream05thmay;

import java.util.Arrays;
import java.util.List;

public class MapTo {
    public static void main(String[] args) {

        List<String> listOfString = Arrays.asList("3", "4");

        listOfString
                .stream()
                .mapToInt(value -> Integer.parseInt(value))
                .forEach(value -> System.out.println(value));

    }

}
