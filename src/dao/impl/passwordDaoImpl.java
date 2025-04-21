package dao.impl;

import dao.BaseDao;
import dao.passwordDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class passwordDaoImpl extends BaseDao implements passwordDao {
    @Override
    public void reset(int a,int b) throws SQLException {
        getConnection();
        String sql="UPDATE employee SET `password` = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,a);
        pstmt.setInt(2,b);
        pstmt.executeUpdate();
        System.out.println("修改成功");
    }
}
