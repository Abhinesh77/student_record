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
@WebServlet(name="update", value="/update")

public class update extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String student_id = req.getParameter("studentid");
        String student_name = req.getParameter("studentname");
        String student_age = req.getParameter("studentage");
        String student_dept = req.getParameter("studentdept");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  out.println(user_password);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_new", "root", "Arvind@2000");
            Statement statement=connection.createStatement();
            String s2="UPDATE student " +"SET student_name ='"+student_name+"' WHERE student_idt="+student_id;
            statement.executeUpdate(s2);
            s2="UPDATE student " +"SET student_age ='"+student_age+"' WHERE student_idt="+student_id;
            statement.executeUpdate(s2);
            s2="UPDATE student " +"SET student_department ='"+student_dept+"' WHERE student_idt="+student_id;
            statement.executeUpdate(s2);
            out.println("Record updated");
            req.getRequestDispatcher("/view.jsp").forward(req, res);
        }
        catch (Exception e) {
        }
    }
}