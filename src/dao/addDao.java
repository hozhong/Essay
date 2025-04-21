package dao;

import java.sql.SQLException;

public interface addDao {
    void add(String a, String b ,String c, int d , String e, int f,String g) throws SQLException;
    Boolean IsUnique(String x) throws SQLException;
}
