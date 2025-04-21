package dao.impl;

import dao.BaseDao;
import dao.seseltDao;
import entity.CombinedResult;
import entity.Three_link_table;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class seseltDaoImpl extends BaseDao implements seseltDao {
    @Override
    public List<User> seselt(String a) throws SQLException {
        getConnection();
        String sql = "SELECT * FROM employee WHERE name LIKE ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> employees = new ArrayList<>();
        try {
            String searchValue = "%" + a + "%";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, searchValue);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId( rs.getInt("id"));
                u.setName( rs.getString("name"));
                u.setE(rs.getString("employeeNo"));
                u.setP(rs.getInt("password"));
                u.setEmail(rs.getString("email"));
                u.setDeptid(rs.getInt("deptid"));
                u.setPositionid(rs.getInt("positionid"));
                u.setPhoto(rs.getString("photo"));
                employees.add(u);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
return  employees;
        }

    }

    @Override
    public int delete(int id) {
        getConnection();
        String sql = "DELETE FROM employee WHERE id = ?;";
        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rowsAffected = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int update(int id, String no, String name, String email, String depid, String time, int pid) {
        getConnection();
        String sql = "UPDATE employee " +
                "SET employeeNo = ?, " +
                "    `name` = ?, " +
                "    email = ?, " +
                "    deptId = ?, " +
                "    entryTime = ?, " +
                "    positionId = ? " +
                "WHERE id = ?;";
        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, no);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, depid);
            pstmt.setString(5, time);
            pstmt.setInt(6, pid);
            pstmt.setInt(7, id);
            rowsAffected = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public List<CombinedResult> tabulation() {

        return null;
    }

    @Override
    public Three_link_table three_link_table_inquire(int id) throws SQLException {
        Three_link_table t =null;
        getConnection();
        try {
            String sql1 = "SELECT * FROM employee WHERE id=?";
            String sql2 = "SELECT * FROM department";
            String sql3 = "SELECT * FROM position";

            try (PreparedStatement pt1 = conn.prepareStatement(sql1);
                 PreparedStatement pt2 = conn.prepareStatement(sql2);
                 PreparedStatement pt3 = conn.prepareStatement(sql3)) {
                pt1.setInt(1, id);

                // 执行查询
                try (ResultSet rs1 = pt1.executeQuery();
                     ResultSet rs2 = pt2.executeQuery();
                     ResultSet rs3 = pt3.executeQuery()) {

//                    User
                    List<User> u1 = new ArrayList<>();

                    while (rs1.next()) {
                        int id1=rs1.getInt("id");
                        String em=rs1.getString("employeeNo");
                        int pwd=rs1.getInt("password");
                        String name = rs1.getString("name");
                        String email = rs1.getString("email");
                        int deptid = rs1.getInt("deptid");
                        String entryTime = rs1.getString("entryTime");
                        int positionid = rs1.getInt("positionid");
                        String photo = rs1.getString("photo");
                        User u=new User();
                        u.setId(id1);
                        u.setE(em);
                        u.setP(pwd);
                        u.setName(name);
                        u.setEmail(email);
                        u.setDeptid(deptid);
                        u.setEntryTime(entryTime);
                        u.setPositionid(positionid);
                        u.setPhoto(photo);
                        u1.add(u);
                    }
                    List<Map<String, Object>> departmentList = new ArrayList<>();
                    List<Map<String, Object>> positionList = new ArrayList<>();
//                    departmentList

                    while (rs2.next()) {
                        Map<String, Object> department = new HashMap<>();
                        department.put("id", rs2.getInt("id"));
                        department.put("deptName", rs2.getString("deptName"));
                        departmentList.add(department);
                    }

//                    positionList
                    while (rs3.next()) {
                        Map<String, Object> position = new HashMap<>();
                        position.put("id", rs3.getInt("id"));
                        position.put("posName", rs3.getString("posName"));
                        positionList.add(position);
                    }




                    t = new Three_link_table(departmentList,positionList,u1);

//                    // 先将 rs2 和 rs3 的数据存储到 map 中，方便后续查找
//                    java.util.Map<Integer, String> departmentMap = new java.util.HashMap<>();
//                    while (rs2.next()) {
//                        int departmentId = rs2.getInt("id");
//                        String departmentName = rs2.getString("name");
//                        departmentMap.put(departmentId, departmentName);
//                    }
//
//                    java.util.Map<Integer, String> positionMap = new java.util.HashMap<>();
//                    while (rs3.next()) {
//                        int positionId = rs3.getInt("id");
//                        String positionName = rs3.getString("name");
//                        positionMap.put(positionId, positionName);
//                    }
//
//                    // 处理 employee 表的查询结果
//                    while (rs1.next()) {
//                        int employeeId = rs1.getInt("id");
//                        int departmentId = rs1.getInt("department_id");
//                        int positionId = rs1.getInt("position_id");
//
//                        String departmentName = departmentMap.get(departmentId);
//                        String positionName = positionMap.get(positionId);
//
////                        Three_link_table threeLinkTable = new Three_link_table();
////                        resultList.add(threeLinkTable);
//                    }
                }
            }
        } finally {

        }
        return t;
    }

}
