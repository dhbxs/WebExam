package club.dhbxs.test;

import club.dhbxs.beans.Book;
import club.dhbxs.service.QueryBooks;
import club.dhbxs.service.impl.QueryBooksImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author 17235
 */
public class QueryBooksTest {

    @Test
    public void queryAllBooks() {
    }

    @Test
    public void queryBooksByName() {
        QueryBooks queryBooks = new QueryBooksImpl();
        List<Book> books = queryBooks.queryBooksByName("核心技术");
        for (Book book: books) {
            System.out.println(book);
        }
    }
}