package java8learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object class for Books
 */
public class BookDao {
    
    /**
     * Returns a list of sample books
     * @return List of books
     */
    public List<Books> getBooks() {
        // Create a list of books with sample data
        List<Books> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Books(222, "My java"));
        listOfBooks.add(new Books(5657, "My java1"));
        listOfBooks.add(new Books(123, "My java2"));
        listOfBooks.add(new Books(12389, "My java3"));
        return listOfBooks;
    }
}
