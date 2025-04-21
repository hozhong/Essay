package controllor;

import entity.CombinedResult;
import serivce.impl.idserivceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        idserivceImpl service = new idserivceImpl();
        try {
            CombinedResult result = service.idadd();
            List<Map<String, Object>> departmentList = result.getDepartmentList();
            List<Map<String, Object>> positionList = result.getPositionList();

            // 将数据存储到 request 中
            request.setAttribute("departmentList", departmentList);
            request.setAttribute("positionList", positionList);

            // 转发到 JSP 页面
            request.getRequestDispatcher("/jsp/user/empl_add.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // 可以返回错误页面
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "数据库查询出错");
        }

    }
}
