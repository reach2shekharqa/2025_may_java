package javastream05thmay;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierA {

    public static void main(String[] args) {
        
        Supplier<Stream<String>> supplierStream = () -> Stream.of("Java", "Python", "JavaScript", "C++", "C#", "PHP", "Ruby", "Swift", "Go", "Kotlin");

        supplierStream.get();
    }
    
}
