package java8learning;

/**
 * Entity class representing Books with its properties
 */
public class Books {
    private Integer pageCount;
    private String bookName;

    public Books(Integer pageCount, String bookName) {
        this.pageCount = pageCount;
        this.bookName = bookName;
    }

    // Getters and setters
    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Books [pageCount=" + pageCount + ", bookName=" + bookName + "]";
    }
}
