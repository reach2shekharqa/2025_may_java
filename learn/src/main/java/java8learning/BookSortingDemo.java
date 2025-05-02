package java8learning;

import java.util.Collections;
import java.util.List;

/**
 * Main class demonstrating books sorting functionality
 */
public class BookSortingDemo {
    
    /**
     * Main method to demonstrate sorting of books by page count and title
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Get the list of books
        List<Books> books = new BookDao().getBooks();
        System.out.println("Original books: " + books);



        // Sort by page count in descending order
        Collections.sort(books, (book1, book2) -> 
            book2.getPageCount().compareTo(book1.getPageCount())); // Compare page counts in reverse order
        System.out.println("Sorted by page count (desc): " + books);

        // Sort by title in ascending order
        Collections.sort(books, (book1, book2) -> 
            book1.getBookName().compareTo(book2.getBookName())); // Compare book names alphabetically
        System.out.println("Sorted by title (asc): " + books);
    }
}
