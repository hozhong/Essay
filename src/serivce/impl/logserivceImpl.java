package serivce.impl;

import dao.BaseDao;
import entity.User;
import serivce.logserivce;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logserivceImpl extends BaseDao implements logserivce {
    @Override
    public User logs(int e, int p) throws SQLException {
        // 将工号和密码转换为字符串以检查长度
        String employeeNoStr = String.valueOf(e);
        String passwordStr = String.valueOf(p);

        // 验证工号和密码长度
        if (employeeNoStr.length() > 10 || passwordStr.length() > 10) {
            System.out.println("工号或密码长度不能超过 10 位，请重新输入。");

        }

        User u = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        try {
            // 获取数据库连接
            BaseDao.getConnection();
            String sql = "SELECT * FROM employee where employeeNo = ? and password = ?";
            pt = conn.prepareStatement(sql);
            pt.setInt(1, e);
            pt.setInt(2, p);
            rs = pt.executeQuery();
            if (rs.next()) {
                u = new User();
                int id = rs.getInt("id");
                String em = rs.getString("employeeNo");
                int pwd = rs.getInt("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int deptid = rs.getInt("deptid");
                String entryTime = rs.getString("entryTime");
                int positionid = rs.getInt("positionid");
                String photo = rs.getString("photo");
                u.setId(id);
                u.setE(em);
                u.setP(pwd);
                u.setName(name);
                u.setEmail(email);
                u.setDeptid(deptid);
                u.setEntryTime(entryTime);
                u.setPositionid(positionid);
                u.setPhoto(photo);
            }
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pt != null) pt.close();
                if (conn != null) conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return u;
    }
}
