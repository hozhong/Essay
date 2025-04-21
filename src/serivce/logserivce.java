package serivce;

import entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface logserivce {
     User logs(int e, int p) throws SQLException, NamingException, ClassNotFoundException;
}
