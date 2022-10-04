import vote.service.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/selectServlet")
public class selectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1?useUnicode=true&characterEncoding=gbk","root","123456");
            Statement statement = connection.createStatement();
            String id1 = req.getParameter("id");
            ResultSet resultSet = statement.executeQuery("select * from employee where id ='"+id1+"'");
            resultSet.next();
            String id=resultSet.getString(1);
            String name=resultSet.getString(2);
            String gender=resultSet.getString(3);
            String age=resultSet.getString(4);
            String address=resultSet.getString(5);
            String department=resultSet.getString(6);
            User user = new User(id,name,gender,age,address,department);
            HttpSession session = req.getSession();
            session.setAttribute("id",id1);
            req.setAttribute("user",user);
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
