package club.dhbxs.web.servlet;

import club.dhbxs.beans.Root;
import club.dhbxs.service.SearchRoot;
import club.dhbxs.service.impl.SearchRootImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 17235
 */
@WebServlet(name = "AccountServlet",urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {

    protected void searchRootById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Root root = (Root) request.getSession().getAttribute("root");
        

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
