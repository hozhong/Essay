package controllor;

import com.alibaba.fastjson.JSON;
import dao.impl.seseltDaoImpl;
import dao.seseltDao;
import entity.CombinedResult;
import entity.Three_link_table;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/seseltControllor")
public class seseltControllor extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String doseselt = req.getParameter("doseselt");

        if ("emol_list".equals(doseselt)){
            String vv = req.getParameter("vv");
            seseltDao dao = new seseltDaoImpl();
            try {
                List<User> list = dao.seselt(vv);
                req.setAttribute("list",list);
//                PrintWriter out = resp.getWriter();
//                out.write( JSON.toJSONString(list));
                req.getRequestDispatcher("jsp/user/empl_list.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ("empl_list".equals(doseselt)){
            int id = Integer.parseInt(req.getParameter("id"));
            seseltDao dao = new seseltDaoImpl();
            if (dao.delete(id)>0){
                System.out.println("删除成功");
            }

        }
        if ("update1".equals(doseselt)){
            int id = Integer.parseInt(req.getParameter("id"));
            seseltDao dao = new seseltDaoImpl();
            try {
                req.setAttribute("three_link_table_inquire", dao.three_link_table_inquire(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("jsp/user/empl_modify.jsp").forward(req,resp);
        }
        if ("update2".equals(doseselt)){

        }
    }

}
