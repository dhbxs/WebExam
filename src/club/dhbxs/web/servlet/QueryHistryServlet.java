package club.dhbxs.web.servlet;

import club.dhbxs.beans.Borrow;
import club.dhbxs.beans.User;
import club.dhbxs.service.QueryHistory;
import club.dhbxs.service.impl.QueryHistoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 17235
 */
@WebServlet(name = "QueryHistryServlet",urlPatterns = {"/QueryHistryServlet"})
public class QueryHistryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        QueryHistory queryHistory = new QueryHistoryImpl();
        List<Borrow> borrowList = queryHistory.queryHistoryByuId(user.getuId());
        request.getSession().setAttribute("history",borrowList);
        response.sendRedirect("page/user/borrowHistory.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
