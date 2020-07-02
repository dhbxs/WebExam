package club.dhbxs.test;

import club.dhbxs.beans.Book;
import club.dhbxs.dao.BookDao;
import club.dhbxs.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "Java核心技术 卷1", "Cay S. Horstmann", "机械工业出版社", "https://i.loli.net/2020/06/27/UBi7jJQt5FDfY6s.png", 5, null);
        bookDao.addBook(book);
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(7);
    }

    @Test
    public void updateBook() {
        Book book = new Book(9, "Java核心技术 卷1", "0", "", "https://i.loli.net/2020/06/27/UBi7jJQt5FDfY6s.png", 5, null);
        bookDao.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}