package dao.impl;

import dao.AttendanceDao;
import dao.BaseDao;
import entity.Attendance;
import entity.User;
import vo.Timesheets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl extends BaseDao implements AttendanceDao {
    @Override
    public void signIn(int a) throws IOException, SQLException {
        getConnection();
        String sql = "INSERT INTO attendance (employeeId, signInTime) VALUES (?, NOW())";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, a);

        pstmt.executeUpdate();
        System.out.println("上班打卡成功，打卡时间：" + java.time.LocalDateTime.now());
    }

    @Override
    public void signOut(int a) throws IOException, SQLException {
        getConnection();
        String sql = "UPDATE attendance SET signOutTime = NOW() WHERE employeeId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, a);

        pstmt.executeUpdate();
        System.out.println("下班打卡成功，打卡时间：" + java.time.LocalDateTime.now());
    }

    @Override
    public List<Timesheets> Recording(String userName, String dateTimes, int page, int pageSize) throws SQLException {
        getConnection();
        List<Timesheets> t = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT e.id, e.employeeNo, e.`name`, a.signInTime, a.signOutTime, a.id " +
                "FROM employee e JOIN attendance a ON e.id = a.employeeId");
        boolean hasWhere = false;
        if (userName != null && !userName.isEmpty()) {
            if (!hasWhere) {
                sql.append(" WHERE");
                hasWhere = true;
            } else {
                sql.append(" AND");
            }
            sql.append(" e.`name` LIKE ?");
        }
        if (dateTimes != null && !dateTimes.isEmpty()) {
            if (!hasWhere) {
                sql.append(" WHERE");
                hasWhere = true;
            } else {
                sql.append(" AND");
            }
            sql.append(" a.signInTime LIKE ?");
        }
        sql.append(" LIMIT ? OFFSET ?");

        PreparedStatement pt = conn.prepareStatement(sql.toString());
        int paramIndex = 1;
        if (userName != null && !userName.isEmpty()) {
            pt.setString(paramIndex++, "%" + userName + "%");
        }
        if (dateTimes != null && !dateTimes.isEmpty()) {
            pt.setString(paramIndex++, "%" + dateTimes + "%");
        }
        pt.setInt(paramIndex++, pageSize);
        pt.setInt(paramIndex, (page - 1) * pageSize);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Timesheets ti = new Timesheets();
            ti.setId(rs.getInt("e.id"));
            ti.setEmployeeNo(rs.getString("e.employeeNo"));
            ti.setName(rs.getString("e.name"));
            ti.setAid(rs.getInt("a.id"));
            ti.setSignInTime(rs.getString("a.signInTime"));
            ti.setSignOutTime(rs.getString("a.signOutTime"));
            t.add(ti);
        }
        return t;
    }

    public int getTotalRecordCount(String userName, String dateTimes) throws SQLException {
        getConnection();
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) " +
                "FROM employee e JOIN attendance a ON e.id = a.employeeId");
        boolean hasWhere = false;
        if (userName != null && !userName.isEmpty()) {
            if (!hasWhere) {
                sql.append(" WHERE");
                hasWhere = true;
            } else {
                sql.append(" AND");
            }
            sql.append(" e.`name` LIKE ?");
        }
        if (dateTimes != null && !dateTimes.isEmpty()) {
            if (!hasWhere) {
                sql.append(" WHERE");
                hasWhere = true;
            } else {
                sql.append(" AND");
            }
            sql.append(" a.signInTime LIKE ?");
        }

        PreparedStatement pt = conn.prepareStatement(sql.toString());
        int paramIndex = 1;
        if (userName != null && !userName.isEmpty()) {
            pt.setString(paramIndex++, "%" + userName + "%");
        }
        if (dateTimes != null && !dateTimes.isEmpty()) {
            pt.setString(paramIndex, "%" + dateTimes + "%");
        }

        ResultSet rs = pt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}