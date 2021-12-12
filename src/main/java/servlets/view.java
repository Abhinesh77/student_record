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
@WebServlet(name="view", value="/view")


public class view extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter out=res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  out.println(user_password);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_new", "root", "Arvind@2000");
            PreparedStatement statement = connection.prepareStatement("select * from student");
            //statement.setString(1,user_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));

            }
        }
        catch(Exception e)
        {

        }
    }
}
