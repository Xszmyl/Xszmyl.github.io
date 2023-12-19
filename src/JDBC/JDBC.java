package JDBC;

import Entity.User;
import java.sql.*;

public class JDBC {
    //数据库连接对象
    private static Connection conn;

    //静态代码块调用SQLConnect类方法连接数据库,一次链接,多次查询
    static{
        try {
            JDBC.SQLConnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //数据库连接方法，返回conn对象
    public static void SQLConnect() throws ClassNotFoundException, SQLException {
        //1.连接数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/users?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String username="root";
        String password="XSZclm295419";
        conn= DriverManager.getConnection(url,username,password);
    }

    //数据库结束连接方法
    public static void SQLOver() throws SQLException {
        conn.close();
    }

    //查询登入方法
    public static String Find(User user) throws SQLException {
        //定义sql
        String sql = "select password from users where username= ?";
        //获取sql对象ps
        PreparedStatement ps=conn.prepareStatement(sql);
        //设置？的值
        ps.setString(1,user.getUsername());
        //执行sql
        ResultSet rs = ps.executeQuery();
        //返回结果
        String SQLpassword;
        while (rs.next()){
            SQLpassword=rs.getString("password");
            if(SQLpassword.equals(user.getPassword())){
                rs.close();
                ps.close();
                return "LoginSuccess";
            }else{
                rs.close();
                ps.close();
                return "PasswordWrong";
            }
        }
        //释放资源
        rs.close();
        ps.close();
        return "UserNotExist";
    }

    //用户注册方法
    public static String Register(User user) throws SQLException {
        //定义sql
        String sql = "insert into users (username,password) values (?,?)";
        //获取sql对象ps
        PreparedStatement ps = conn.prepareStatement(sql);
        //设置？的值
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        //执行sql
        if(!Find(user).equals("UserNotExist")){
            //已存在用户,释放资源
            ps.close();
            return "UserHaveExisted";
        }else{
            //执行sql
            ps.executeUpdate();
            ps.close();
            return "RegisterSuccess";
        }
    }
}
