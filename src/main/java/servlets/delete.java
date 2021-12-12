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
@WebServlet(name="delete", value="/delete")

public class delete extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String student_id = req.getParameter("studentid");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  out.println(user_password);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_new", "root", "Arvind@2000");
            Statement statement = connection.createStatement();
            String s1 = "DELETE FROM student " + "WHERE student_idt =" + student_id;
            statement.executeUpdate(s1);
            out.println("record deleted");
            req.getRequestDispatcher("/view.jsp").forward(req, res);
        } catch (Exception e) {

        }
    }
}