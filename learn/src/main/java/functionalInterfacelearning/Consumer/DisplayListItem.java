package functionalInterfacelearning.Consumer;

import java.util.List;

import java8learning.BookDao;
import java8learning.Books;

public class DisplayListItem {

    public static void main(String[] args) {

        BookDao obj = new BookDao();
        
        List<Books> list= obj.getBooks();

        list.forEach(item->System.out.println(item));
    }

}
