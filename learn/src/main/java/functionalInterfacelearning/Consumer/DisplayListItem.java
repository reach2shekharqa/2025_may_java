package functionalInterfacelearning.Consumer;

import java.util.Collections;
import java.util.List;

import java8learning.BookDao;
import java8learning.Books;

public class DisplayListItem {

    public static void main(String[] args) {

        BookDao obj = new BookDao();

        List<Books> listOfBooks = obj.getBooks();

        System.out.println("============comparator example==============");

        // Sorting the list of books in ascending order based on their page count using a lambda expression.
        Collections.sort(listOfBooks, (obj1, obj2) -> obj1.getPageCount().compareTo(obj2.getPageCount()));
        System.out.println("after sorting(asc order)...." + listOfBooks);

        System.out.println("============consumer example==============");

        // Using a Consumer functional interface to iterate through the list of books
        // and print each book's details to the console.
        listOfBooks.forEach(item -> System.out.println(item));

        // Filtering books with a page count greater than or equal to 222 using a predicate
        listOfBooks.stream().filter(book -> book.getPageCount() >= 222).forEach(b -> System.out.println(b));

        listOfBooks.stream().filter(book -> book.getPageCount() >= 222).forEach(b -> System.out.println(b)); // predicate

    }
}
