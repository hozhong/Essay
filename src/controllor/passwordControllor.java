package controllor;

import dao.impl.passwordDaoImpl;
import dao.passwordDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/passwordControllor")
public class passwordControllor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      passwordDao dao = new passwordDaoImpl();
        Integer id= Integer.valueOf(req.getParameter("id"));
        int pwd = Integer.parseInt(req.getParameter("pwd"));
        int newPwd1=req.getIntHeader("newPwd1");
        int oldPwd = req.getIntHeader("oldPwd");
        int newPwd2 = req.getIntHeader("newPwd2");
        if (oldPwd==pwd) {
            try {
                dao.reset(newPwd1, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else if (newPwd1!=newPwd2){
            System.out.println("密码不匹配");
        } else {
            System.out.println("原密码错误");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
