package club.dhbxs.web.servlet;

import club.dhbxs.beans.Book;
import club.dhbxs.beans.User;
import club.dhbxs.dao.BorrowDao;
import club.dhbxs.dao.impl.BorrowDaoImpl;
import club.dhbxs.service.BorrowBook;
import club.dhbxs.service.QueryBooks;
import club.dhbxs.service.impl.BorrowBookImpl;
import club.dhbxs.service.impl.QueryBooksImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 17235
 */
@WebServlet(name = "BorrowServlet", urlPatterns = {"/BorrowServlet"})
public class BorrowServlet extends HttpServlet {

    private final BorrowBook borrowBook = new BorrowBookImpl();

    /**
     * 续借
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void redecorate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer borrowId = Integer.parseInt(request.getParameter("borrowId"));
        borrowBook.redecorateBook(borrowId);
        response.sendRedirect("QueryHistryServlet");
    }

    /**
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void borrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bId = Integer.parseInt(request.getParameter("bId"));
        User user = (User) request.getSession().getAttribute("user");

        borrowBook.borrowBook(bId, user);

        QueryBooks queryBooks = new QueryBooksImpl();
        List<Book> books = queryBooks.queryAllBooks();
        request.getSession().setAttribute("books", books);

        response.sendRedirect("QueryHistryServlet");
    }

    /**
     * 还书服务
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer borrowId = Integer.parseInt(request.getParameter("borrowId"));
        User user = (User) request.getSession().getAttribute("user");
        borrowBook.returnBook(borrowId, user);
        QueryBooks queryBooks = new QueryBooksImpl();
        List<Book> books = queryBooks.queryAllBooks();
        request.getSession().setAttribute("books", books);
        response.sendRedirect("QueryHistryServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            //获取业务鉴别字符串，获取相应业务的方法，方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
