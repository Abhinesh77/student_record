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
@WebServlet(name="login", value="/login")
public class login extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
        String user_name=req.getParameter("username");
        //String name=req.getParameter("name");
        String user_password=req.getParameter("password");
        PrintWriter out=res.getWriter();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
          //  out.println(user_password);
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Arvind@2000");
            PreparedStatement statement=connection.prepareStatement("select * from user where username=?");
            statement.setString(1,user_name);
            ResultSet resultSet=statement.executeQuery();

            int flag=0;

            while(resultSet.next())
            {
                if(user_password.equals(resultSet.getString(3)));
                {
                    out.println("welcome "+user_name);
                    flag=1;
                    req.getRequestDispatcher("/view.jsp").forward(req, res);
                    //RequestDispatcher requestDispatcher=req.getRequestDispatcher("view");
                    //requestDispatcher.forward(req,res);
                }

            }
            if(flag==0)
            out.println("invalid");


        }
        catch(Exception e)
        {
            //PrintWriter out=res.getWriter();
            out.println(e.getMessage());
            out.println("exception");
        }
    }
}
