package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name="register", value="/register")
public class register extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        String user_name = req.getParameter("username");
        String name_user = req.getParameter("name");
        String user_password = req.getParameter("password");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  out.println(user_password);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Arvind@2000");
            PreparedStatement statement=connection.prepareStatement("insert into user values(?,?,?)");
            statement.setString(1,user_name);
            statement.setString(2,name_user);
            statement.setString(3,user_password);
            statement.executeUpdate();
            out.println("registered");
            req.getRequestDispatcher("/login.jsp").forward(req, res);

        }
        catch(Exception e)
        {

        }
    }
}