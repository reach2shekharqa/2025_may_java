package functionalInterfacelearning.Consumer;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import java8learning.BookDao;
import java8learning.Books;

public class DisplayListItem {

    public static void main(String[] args) {

        BookDao obj = new BookDao();

        List<Books> listOfBooks = obj.getBooks();
        Supplier<Stream<Books>> booksSupplierStream = () -> listOfBooks.stream();

        booksSupplierStream.get()
                .sorted((obj1,obj2)-> obj2.getPageCount().compareTo(obj1.getPageCount()))
                .forEach(a->System.out.println(a));
                
                
                
                

        // System.out.println(booksSupplierStream);

        // List<Books> listOfFiltered = booksSupplierStream.get()
        // .filter(b -> b.getPageCount() < 123)
        // .collect(Collectors.toList());

        // listOfFiltered.forEach(b -> System.out.println(b));

        // System.out.println(listOfFiltered.isEmpty() ? "true" : "no books found with
        // page count less than 222");

        booksSupplierStream.get().forEach(a -> System.out.println(a));

        System.out.println("=========second time used fresh stream");
        booksSupplierStream.get().filter(b -> b.getPageCount() < 222).forEach(a ->
        System.out.println(a));
        System.out.println("=========third time used fresh stream");
        booksSupplierStream.get()
        .filter(b -> b.getPageCount() < 222)
        .forEach(a -> System.out.println(a));
        System.out.println("=========third time used fresh stream");

        System.out.println("============comparator example==============");

        // Sorting the list of books in ascending order based on their page count
        // using a lambda expression.
        // Collections.sort(listOfBooks, (obj1, obj2) ->
        // obj1.getPageCount().compareTo(obj2.getPageCount()));
        // System.out.println("after sorting(asc order)...." + listOfBooks);

        System.out.println("============consumer example==============");

        // Using a Consumer functional interface to iterate through the list of books
        // and print each book's details to the console.
        listOfBooks.forEach(item -> System.out.println(item));//accept

        // Filtering books with a page count greater than or equal to 222 using a
        // predicate
        listOfBooks.stream().filter(book -> book.getPageCount() >= 222).forEach(b ->
        System.out.println(b));//predicate --return boolean filter

        // Stream<Books> stream = listOfBooks.stream();

    }
}
