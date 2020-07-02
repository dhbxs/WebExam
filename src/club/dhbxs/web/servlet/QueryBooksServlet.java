package club.dhbxs.web.servlet;

import club.dhbxs.beans.Book;
import club.dhbxs.service.QueryBooks;
import club.dhbxs.service.impl.QueryBooksImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

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
@WebServlet(name = "QueryBooksServlet", urlPatterns = {"/QueryBooksServlet"})
public class QueryBooksServlet extends HttpServlet {
    private final QueryBooks queryBooks = new QueryBooksImpl();

    /**
     * 用户或管理员登录时加载全部图书馆藏书信息的servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = queryBooks.queryAllBooks();
        request.getSession().setAttribute("books", books);
        if (request.getSession().getAttribute("root") != null) {
            response.sendRedirect("page/admin/home.jsp");
        } else {
            response.sendRedirect("page/user/home.jsp");
        }
    }

    /**
     * 根据书名，模糊搜索
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void searchBooksByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Book> searchBookList = queryBooks.queryBooksByName(search);
        request.getSession().setAttribute("searchbook", searchBookList);
        response.sendRedirect("page/user/searchResult.jsp");
    }

    /**
     * 根据书籍Id，查找对应的书籍信息，后台修改书籍信息用
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void searchBooksById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = queryBooks.queryBookById(Integer.parseInt(request.getParameter("bId")));
        request.getSession().setAttribute("modifybook", book);
        response.sendRedirect("page/admin/modify.jsp");
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
