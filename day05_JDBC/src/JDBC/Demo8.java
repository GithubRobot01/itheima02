package JDBC;

import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//事务操作
public class Demo8 {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            String sql1="update account set balance = balance - ? where name = ?";
            String sql2="update account set balance = balance + ? where name = ?";
            ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1,500);
            ps1.setString(2,"zs");
            ps1.executeUpdate();

            ps2 = conn.prepareStatement(sql2);
            ps2.setDouble(1,500);
            ps2.setString(2,"ls");
            ps2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            //事务回滚
            try {
                if (conn!=null){
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps1,conn);
            JDBCUtils.close(ps2,null);
        }
    }
}
