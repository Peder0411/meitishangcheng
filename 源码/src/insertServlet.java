import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
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
            statement.execute("insert into employee values ('"+id+"','"+name+"','"+gender+"','"+age+"','"+address+"','"+department+"')");
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
