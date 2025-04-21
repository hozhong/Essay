package serivce.impl;

import dao.BaseDao;
import entity.CombinedResult;
import serivce.idserivce;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class idserivceImpl extends BaseDao implements idserivce {
    @Override
    public CombinedResult idadd() throws SQLException {
        getConnection();
        String sql = "SELECT * FROM department";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Map<String, Object>> departmentList = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> department = new HashMap<>();
            department.put("id", rs.getInt("id"));
            department.put("deptName", rs.getString("deptName"));
            // 可以根据实际表结构添加更多字段
            departmentList.add(department);
        }
        String sql1 = "SELECT * FROM position";
        PreparedStatement pt = conn.prepareStatement(sql1);
        ResultSet rs1 = pt.executeQuery();
        List<Map<String, Object>> positionList = new ArrayList<>();
        while (rs1.next()) {
            Map<String, Object> position = new HashMap<>();
            position.put("id", rs1.getInt("id"));
            // 假设 position 表中有 posName 字段
            position.put("posName", rs1.getString("posName"));
            // 可以根据实际表结构添加更多字段
            positionList.add(position);
        }
        return new CombinedResult(departmentList, positionList);
    }
}
