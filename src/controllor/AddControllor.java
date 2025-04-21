package controllor;

import dao.addDao;
import dao.impl.addDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/AddControllor")
@MultipartConfig
public class AddControllor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addDao a = new addDaoImpl();
        String add = req.getParameter("add");
        if ("empl_add".equals(add)){
            String name = req.getParameter("name");
            String No = req.getParameter("employeeNo");
            String email = req.getParameter("email");
            String entryTime = req.getParameter("entryTime");
            int depid = Integer.parseInt(req.getParameter("department"));
            int pid = Integer.parseInt(req.getParameter("position"));
            String ph = req.getParameter("fileField");
            addDao dao = new addDaoImpl();
            try {
                dao.add(name,No,email,depid,entryTime,pid,ph);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            dao.add(name,No,email,entryTime,);
        }else if ("op".equals(add)){
            String eid = req.getParameter("employeeNo");
            String msg = "";
            try {
                boolean f = a.IsUnique(eid);
                PrintWriter out =resp.getWriter();
                if (f){
                    out.write("1");
                }else {
                    out.write("2");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
