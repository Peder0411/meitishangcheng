import vote.service.User;
import com.mysql.cj.jdbc.Driver;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1?useUnicode=true&characterEncoding=gbk","root","123456");
            Statement statement = connection.createStatement();
            String sql="select * from employee";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(resultSet.next()){
                String id= resultSet.getString(1);
                String name= resultSet.getString(2);
                String gender= resultSet.getString(3);
                String age= resultSet.getString(4);
                String address= resultSet.getString(5);
                String department= resultSet.getString(6);
                User user = new User(id,name,gender,age,address,department);
                users.add(user);
            }
            req.setAttribute("user",users);
            req.getRequestDispatcher("show.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
