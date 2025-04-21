package dao;

import vo.Timesheets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AttendanceDao {
    void signIn(int a) throws IOException, SQLException;
    void signOut(int a) throws IOException, SQLException;
    List<Timesheets> Recording(String userName, String dateTimes, int page, int pageSize) throws SQLException;
    int getTotalRecordCount(String userName, String dateTimes) throws SQLException;
}
