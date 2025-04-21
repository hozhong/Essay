package dao.impl;

import dao.BaseDao;
import dao.addDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addDaoImpl extends BaseDao implements addDao {
    @Override
    public void add(String a, String b ,String c, int d , String e, int f,String g) throws SQLException {
        getConnection();
        String sql = "INSERT INTO employee (`id`, `employeeNo`, `password`, `name`, `email`, `deptId`, `entryTime`, `positionId`, `photo`)" +
                " VALUES (NULL, ?, '1235', ?, ?, ?, ?, ?,?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,a);
        pstmt.setString(2,b);
        pstmt.setString(3,c);
        pstmt.setInt(4,d);
        pstmt.setString(5,e);
        pstmt.setInt(6,f);
        pstmt.setString(7,g);
        pstmt.executeUpdate();
        System.out.println("添加成功");
    }

    @Override
    public Boolean IsUnique(String x) throws SQLException {
        getConnection();
        String sql = "SELECT COUNT(*) FROM employee WHERE employeeNo = ?";
        PreparedStatement pt = conn.prepareStatement(sql);
        pt.setString(1,x);
        ResultSet rs= pt.executeQuery();
        if (rs.next()){
            return rs.getInt(1)>0?true:false;
        }
        return false;
    }
}
