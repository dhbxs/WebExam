package club.dhbxs.web.servlet;

import club.dhbxs.beans.Root;
import club.dhbxs.beans.User;
import club.dhbxs.service.RootSignIn;
import club.dhbxs.service.UserSignIn;
import club.dhbxs.service.impl.RootSignInImpl;
import club.dhbxs.service.impl.UserSignInImpl;
import club.dhbxs.utils.ResultInfo;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 17235
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

    /**
     * user登陆验证
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException
     */
    protected void userVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uName = request.getParameter("inputUserName");
        String uPassword = request.getParameter("inputPassword");
        UserSignIn userSignIn = new UserSignInImpl();
        User user = userSignIn.userVerify(uName, uPassword);
        Gson gs = new Gson();
        ResultInfo res = new ResultInfo();
        if (user != null) {
            request.getSession().setAttribute("user", user);
            res.setCode(0);
            res.setMessage("登陆成功！");
        } else {
            res.setCode(-1);
            res.setMessage("用户名或密码错误！");
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(gs.toJson(res));

    }

    /**
     * 管理员账户验证
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException
     */
    protected void rootVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rName = request.getParameter("inputUserName");
        String rPassword = request.getParameter("inputPassword");
        RootSignIn rootSignIn = new RootSignInImpl();
        Root root = rootSignIn.rootSignIn(rName, rPassword);
        Gson gs = new Gson();
        ResultInfo res = new ResultInfo();
        if (root != null) {
            request.getSession().setAttribute("root", root);
            res.setCode(0);
            res.setMessage("登陆成功！");
        } else {
            res.setCode(-1);
            res.setMessage("用户名或密码错误！");
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(gs.toJson(res));
    }

    /**
     * 退出登录
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException
     */
    protected void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }
}
