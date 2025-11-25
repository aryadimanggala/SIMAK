package dao;

import util.DBConnection;
import java.sql.Connection;

public class BaseDao {
    
    public static Connection getCon() {
        return DBConnection.getConnection();
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}