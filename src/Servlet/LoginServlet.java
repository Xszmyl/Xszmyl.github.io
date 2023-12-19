package Servlet;

import Entity.User;
import JDBC.JDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取登入表单信息,与数据库进行比较
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User(username,password);
        //创建用户实例
        //检查是否存在该用户，若是，则跳转登入成功页面
        try {
            String result=JDBC.Find(user);
            if(result.equals("LoginSuccess")){
                //登入成功,将User存入Session
                HttpSession session = req.getSession();
                session.setAttribute("Forum_username",user);
                //Cookie(SessionID)设定持久化
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(60*30);
                cookie.setPath("/");
                resp.addCookie(cookie);
                //跳转登入成功页面
                resp.sendRedirect("/ForumWeb/LoginSuccess.jsp");
            }else if(result.equals("UserNotExist")){
                //用户不存在
                resp.sendRedirect("/ForumWeb/Login.html?type=UserNotExist");
            }else{
                //密码错误
                resp.sendRedirect("/ForumWeb/Login.html?type=PasswordWrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
