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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1?useUnicode=true&characterEncoding=gbk","root","123456");
            Statement statement = connection.createStatement();
            String id=req.getParameter("id");
            String name=req.getParameter("name");
            String gender=req.getParameter("gender");
            String age=req.getParameter("age");
            String address=req.getParameter("address");
            String department=req.getParameter("department");
            HttpSession session = req.getSession();
            String id1 = (String) session.getAttribute("id");
            statement.executeUpdate("update employee set id='"+id+"',name='"+name+"',gender='"+gender+"',age='"+age+"',address='"+address+"',department='"+department+"'where id='"+id1+"'");
            resp.sendRedirect("/untitled_war_exploded/userServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
