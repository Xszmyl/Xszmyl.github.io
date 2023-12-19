package Servlet;

import JDBC.JDBC;
import Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取注册信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //注册新用户
        try {
            String result=JDBC.Register(new User(username,password));
            if(result.equals("RegisterSuccess")){
                //跳转登入页面
                resp.sendRedirect("/ForumWeb/Login.html?type=RegisterSuccess");
            }else if(result.equals("UserHaveExisted")){
                //注册失败,跳转回注册页面
                resp.sendRedirect("/ForumWeb/Register.html?type=UserHaveExisted");
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

