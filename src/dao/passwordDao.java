package dao;

import java.sql.SQLException;

public interface passwordDao {
    void reset(int a,int b) throws SQLException;
}
