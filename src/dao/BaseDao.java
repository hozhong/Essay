package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static Connection conn;

    static {
        try {
            P();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void P() throws IOException {
        Properties p =new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dierop.properties");
        p.load(in);
        a=p.getProperty("dirver");
        b=p.getProperty("url");
        c=p.getProperty("user");
        d=p.getProperty("password");

    }
//
//    public static void C() throws SQLException, ClassNotFoundException, NamingException {
//        Context ctx = new InitialContext();
//        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/microblog");
//        conn = ds.getConnection();
//    }

    public static  void getConnection(){
        try {
            Class.forName(a);
            try {
                conn= DriverManager.getConnection(b,c,d);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
