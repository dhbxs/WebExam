package club.dhbxs.web.servlet;

import club.dhbxs.beans.Book;
import club.dhbxs.beans.Root;
import club.dhbxs.service.*;
import club.dhbxs.service.impl.*;
import org.apache.commons.mail.EmailException;

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
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    private final QueryBooks queryBooks = new QueryBooksImpl();

    /**
     * 出库servlet，将图书移出图书馆仓库
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void outStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeleteBook deleteBook = new DeleteBookImpl();
        deleteBook.deleteBook(Integer.parseInt(request.getParameter("bId")));
        List<Book> books = queryBooks.queryAllBooks();
        request.getSession().setAttribute("books", books);
        response.sendRedirect("page/admin/home.jsp");
    }

    /**
     * 管理员修改图书信息
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book modifybook = (Book) request.getSession().getAttribute("modifybook");
        Book book = new Book(modifybook.getbId(), request.getParameter("bName"), request.getParameter("bAuthor"), request.getParameter("bPress"), request.getParameter("bImg"), Integer.parseInt(request.getParameter("bNumber")), modifybook.getbBorrow());
        ModifyBook modifyBook1 = new ModifyBookImpl();
        modifyBook1.modifyBook(book);
        List<Book> books = queryBooks.queryAllBooks();
        request.getSession().setAttribute("books", books);
        response.sendRedirect("page/admin/home.jsp");
    }

    /**
     * 给管理员发送验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verifyEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EmailException {
        Root root = (Root) request.getSession().getAttribute("root");
        String email = root.getrEmail();
        EmailVerify emailVerify = new EmailVerifyImpl();
        String captcha = emailVerify.emailSend(email);
        request.getSession().setAttribute("captcha", captcha);
        response.sendRedirect("page/admin/captcha.jsp");
    }

    /**
     * 核对验证码是否一致
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verifyCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String captcha = request.getParameter("captcha");
        String  captcha01 = (String) request.getSession().getAttribute("captcha");
        if (captcha.equals(captcha01)) {
            response.sendRedirect("page/admin/modifyRoot.jsp");
        } else {
            response.sendRedirect("page/admin/home.jsp");
        }
    }

    /**
     * 修改管理员信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyRoot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Root root1 = (Root) request.getSession().getAttribute("root");
        Root root = new Root(root1.getrId(),request.getParameter("rName"),request.getParameter("rPassword"),request.getParameter("rEmail"));
        UpdateRoot updateRoot = new UpdateRootImpl();
        updateRoot.updateRoot(root);
        request.getSession().invalidate();
        response.sendRedirect("admin.jsp");
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
