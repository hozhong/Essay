package dao;

import entity.CombinedResult;
import entity.Three_link_table;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface seseltDao {
    List<User> seselt(String a) throws SQLException;
    int delete(int id);
    int update(int id,String no,String name,String email,String depid,String time,int pid);
    List<CombinedResult> tabulation();
    Three_link_table three_link_table_inquire(int id) throws SQLException;
}
