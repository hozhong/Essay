package controllor;

import entity.User;
import serivce.impl.logserivceImpl;
import serivce.logserivce;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/logservlet")
public class LoginControllor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("log");
        if ("login".equals(log)) {
            String employeeNoStr = req.getParameter("employeeNo");
            String passwordStr = req.getParameter("password");
            HttpSession session = req.getSession(true);

            logserivce l = new logserivceImpl();
            try {
                User u = l.logs(Integer.parseInt(employeeNoStr),Integer.parseInt(passwordStr));
                session.setAttribute("user",u);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}