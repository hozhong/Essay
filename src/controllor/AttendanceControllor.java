package controllor;

import dao.AttendanceDao;
import dao.impl.AttendanceDaoImpl;
import vo.PageInfo;
import vo.Timesheets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AttendanceControllor")
public class AttendanceControllor extends HttpServlet {
    private static final int PAGE_SIZE = 10;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 关键：设置请求编码为 UTF-8（必须在获取参数前调用）
        req.setCharacterEncoding("UTF-8");
        String in = req.getParameter("in");
        String out = req.getParameter("out");
        String ro = req.getParameter("ro");
        if ("attendance_record".equals(in)){
            AttendanceDao dao = new AttendanceDaoImpl();
            Integer id= Integer.valueOf(req.getParameter("id"));
            try {
                dao.signIn(id);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else  if ("attendance_record".equals(out)){
            AttendanceDao dao = new AttendanceDaoImpl();
            Integer id= Integer.valueOf(req.getParameter("id"));
            try {
                dao.signOut(id);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if ("b-list".equals(ro)) {
            // 分页查询逻辑（从 JSP 迁移至此）
            String empName = req.getParameter("empName"); // 姓名查询条件
            String searchDate = req.getParameter("searchDate"); // 日期查询条件
            int currentPage = 1; // 默认第 1 页

            // 获取请求中的页码参数（防空处理）
            if (req.getParameter("page") != null && !req.getParameter("page").isEmpty()) {
                currentPage = Integer.parseInt(req.getParameter("page"));
            }

            AttendanceDaoImpl dao = new AttendanceDaoImpl();
            List<Timesheets> timesheetsList;
            int totalRecord;

            try {
                // 调用带分页参数的查询方法（需确保 DAO 方法支持 page 和 pageSize）
                timesheetsList = dao.Recording(empName, searchDate, currentPage, PAGE_SIZE);
                totalRecord = dao.getTotalRecordCount(empName, searchDate);

                // 封装分页信息（需新增 PageInfo 类，见第二步）
                PageInfo<Timesheets> pageInfo = new PageInfo<>(
                        currentPage,
                        PAGE_SIZE,
                        totalRecord,
                        timesheetsList
                );

                // 将分页信息存入请求域
                req.setAttribute("pageInfo", pageInfo);
                req.setAttribute("searchName", empName); // 回显查询条件
                req.setAttribute("searchDate", searchDate); // 回显查询条件

                // 转发到 JSP 页面（路径需与实际项目一致）
                req.getRequestDispatcher("/jsp/attendance/attendance_list.jsp").forward(req, resp);

            } catch (SQLException e) {
                e.printStackTrace();
                req.setAttribute("errorMsg", "查询失败，请联系管理员");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
