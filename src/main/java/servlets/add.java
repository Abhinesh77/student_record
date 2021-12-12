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
@WebServlet(name="add", value="/add")

public class add extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        String student_id = req.getParameter("studentid");
        String student_name = req.getParameter("studentname");
        String student_age = req.getParameter("studentage");
        String student_dept= req.getParameter("studentdept");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  out.println(user_password);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_new", "root", "Arvind@2000");
            PreparedStatement statement=connection.prepareStatement("insert into student values(?,?,?,?)");
            statement.setString(1,student_id);
            statement.setString(2,student_name);
            statement.setString(3,student_age);
            statement.setString(4,student_dept);
            statement.executeUpdate();
            out.println("record inserted");
            req.getRequestDispatcher("/view.jsp").forward(req, res);
        }
        catch(Exception e)
        {

        }
    }
}
